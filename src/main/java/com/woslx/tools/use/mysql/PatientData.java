package com.woslx.tools.use.mysql;

import java.util.Date;

public class PatientData {
    private Long id;

    private Long patient_id;

    private Long heart_exce_id;

    private String data_belong;

    private Integer data_type;

    private Long flag;

    private Integer value;

    private Long time;

    private Date create_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    public Long getHeart_exce_id() {
        return heart_exce_id;
    }

    public void setHeart_exce_id(Long heart_exce_id) {
        this.heart_exce_id = heart_exce_id;
    }

    public String getData_belong() {
        return data_belong;
    }

    public void setData_belong(String data_belong) {
        this.data_belong = data_belong;
    }

    public Integer getData_type() {
        return data_type;
    }

    public void setData_type(Integer data_type) {
        this.data_type = data_type;
    }

    public Long getFlag() {
        return flag;
    }

    public void setFlag(Long flag) {
        this.flag = flag;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}