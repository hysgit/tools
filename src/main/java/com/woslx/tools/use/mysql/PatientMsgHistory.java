package com.woslx.tools.use.mysql;

public class PatientMsgHistory {
    private Integer id;

    private Long patient_id;

    private Integer event_type;

    private Integer event_detail_type;

    private Integer heart_rate;

    private Long starttime;

    private Long end_time;

    private String create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    public Integer getEvent_type() {
        return event_type;
    }

    public void setEvent_type(Integer event_type) {
        this.event_type = event_type;
    }

    public Integer getEvent_detail_type() {
        return event_detail_type;
    }

    public void setEvent_detail_type(Integer event_detail_type) {
        this.event_detail_type = event_detail_type;
    }

    public Integer getHeart_rate() {
        return heart_rate;
    }

    public void setHeart_rate(Integer heart_rate) {
        this.heart_rate = heart_rate;
    }

    public Long getStarttime() {
        return starttime;
    }

    public void setStarttime(Long starttime) {
        this.starttime = starttime;
    }

    public Long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Long end_time) {
        this.end_time = end_time;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}