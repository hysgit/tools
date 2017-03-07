package com.woslx.tools.use.mysql;

import com.woslx.tools.mysql.DbUtilsTool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by hy on 3/7/17.
 */
public class SyncData {

    public static void main(String[] args) throws SQLException {
        Connection connection = DbUtilsTool.openConn("MySQL", "10.248.248.28", "3306", "bbkjnurs", "root", "root");

        String sql = "select * from patient_msg_history where event_type=1 and starttime > 1488345650007";
        QueryRunner qr = new QueryRunner();
        List<PatientMsgHistory> query = qr.query(connection, sql, new BeanListHandler<PatientMsgHistory>(PatientMsgHistory.class));

        Task task = new Task(connection,0,query.size(),query);
        ForkJoinPool pool = new ForkJoinPool(20);
        pool.execute(task);
        do {
//            System.out.printf("Main: Thread Count: %d\n", pool.getActiveThreadCount());
//            System.out.printf("Main: Thread Steal: %d\n", pool.getStealCount());
//            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (!task.isDone());
        pool.shutdown();

//        for (PatientMsgHistory patientMsgHistory : query) {
//            Integer id = patientMsgHistory.getId();
//            sql = "select * from patient_data where heart_exce_id=?";
//            List<PatientData> patientDatas = qr.query(connection, sql, id, new BeanListHandler<PatientData>(PatientData.class));
//            if (patientDatas.size() > 0) {
//                sql = "update patient_msg_history set heart_rate=? where id=?";
//                Object[] paramgs = new Object[2];
//                paramgs[0] = patientDatas.get(0).getValue();
//                paramgs[1] = id;
//                int update = qr.update(connection, sql, paramgs);
//                System.out.println("id: " + id + " value: " + patientDatas.get(0).getValue() + " update: " + update);
//            }
//        }
    }
}
