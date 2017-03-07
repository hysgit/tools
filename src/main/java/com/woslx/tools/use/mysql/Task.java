package com.woslx.tools.use.mysql;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by hy on 3/7/17.
 */
public class Task  extends RecursiveAction {

    private static final long serialVersionUID = 1L;
    private int first;
    private int last;
    List<PatientMsgHistory> list;
    private Connection connection;

    public Task(Connection connection, int first, int last, List<PatientMsgHistory> list) {
        System.out.println("开始任务!");
        this.first = first;
        this.last = last;
        this.list = list;
        this.connection = connection;
    }

    @Override
    protected void compute() {
        if (last - first < 100) {
            try {
                syncstart();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            int middle = (last + first) / 2;
            System.out.printf("Task: Pending tasks: %s\n", getQueuedTaskCount());
            Task t1 = new Task(connection, first, middle + 1, list);
            Task t2 = new Task(connection, middle + 1, last, list);
            invokeAll(t1, t2);
        }

    }

    private void syncstart() throws SQLException {
        QueryRunner qr = new QueryRunner();
        for(;first< last; first++)
        {
            Integer id = list.get(first).getId();
            String sql = "select * from patient_data where heart_exce_id=?";
            List<PatientData> patientDatas = qr.query(connection, sql, id, new BeanListHandler<PatientData>(PatientData.class));
            if (patientDatas.size() > 0) {
                sql = "update patient_msg_history set heart_rate=? where id=?";
                Object[] paramgs = new Object[2];
                paramgs[0] = patientDatas.get(0).getValue();
                paramgs[1] = id;
                int update = qr.update(connection, sql, paramgs);
                System.out.println("id: " + id + " value: " + patientDatas.get(0).getValue() + " update: " + update);
            }
        }

    }
}
