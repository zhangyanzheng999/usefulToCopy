package cn.neu.his.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Prescription {
    private Integer preId;

    private Integer medrecordId;

    private Integer registerId;

    private Integer doctorId;

    private String preName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date preOpenTime;

    private Integer preState;

    public Integer getPreId() {
        return preId;
    }

    public void setPreId(Integer preId) {
        this.preId = preId;
    }

    public Integer getMedrecordId() {
        return medrecordId;
    }

    public void setMedrecordId(Integer medrecordId) {
        this.medrecordId = medrecordId;
    }

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getPreName() {
        return preName;
    }

    public void setPreName(String preName) {
        this.preName = preName == null ? null : preName.trim();
    }

    public Date getPreOpenTime() {
        return preOpenTime;
    }

    public void setPreOpenTime(Date preOpenTime) {
        this.preOpenTime = preOpenTime;
    }

    public Integer getPreState() {
        return preState;
    }

    public void setPreState(Integer preState) {
        this.preState = preState;
    }

	public Prescription(Integer preId, Integer medrecordId, Integer registerId, Integer doctorId, String preName,
			Date preOpenTime, Integer preState) {
		super();
		this.preId = preId;
		this.medrecordId = medrecordId;
		this.registerId = registerId;
		this.doctorId = doctorId;
		this.preName = preName;
		this.preOpenTime = preOpenTime;
		this.preState = preState;
	}

	public Prescription() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}