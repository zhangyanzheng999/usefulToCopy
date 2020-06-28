package cn.neu.his.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Mould {
    private Integer readyMouldId;

    private String readyMouldName;

    private Integer doctorId;
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    private Date creatTime;

    private Integer useRange;

    private Integer removeSign;

    public Integer getReadyMouldId() {
        return readyMouldId;
    }

    public void setReadyMouldId(Integer readyMouldId) {
        this.readyMouldId = readyMouldId;
    }

    public String getReadyMouldName() {
        return readyMouldName;
    }

    public void setReadyMouldName(String readyMouldName) {
        this.readyMouldName = readyMouldName == null ? null : readyMouldName.trim();
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getUseRange() {
        return useRange;
    }

    public void setUseRange(Integer useRange) {
        this.useRange = useRange;
    }

    public Integer getRemoveSign() {
        return removeSign;
    }

    public void setRemoveSign(Integer removeSign) {
        this.removeSign = removeSign;
    }
}