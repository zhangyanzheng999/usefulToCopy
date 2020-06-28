package cn.neu.his.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Diag {
    private Integer diagId;

    private Integer medrecordCode;

    private Integer registerId;

    private Integer diseaseId;

    private Integer diagType;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date onsetTime;

    private Integer chuZhong;

    public Integer getDiagId() {
        return diagId;
    }

    public void setDiagId(Integer diagId) {
        this.diagId = diagId;
    }

    public Integer getMedrecordCode() {
        return medrecordCode;
    }

    public void setMedrecordCode(Integer medrecordCode) {
        this.medrecordCode = medrecordCode;
    }

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Integer getDiagType() {
        return diagType;
    }

    public void setDiagType(Integer diagType) {
        this.diagType = diagType;
    }

    public Date getOnsetTime() {
        return onsetTime;
    }

    public void setOnsetTime(Date onsetTime) {
        this.onsetTime = onsetTime;
    }

    public Integer getChuZhong() {
        return chuZhong;
    }

    public void setChuZhong(Integer chuZhong) {
        this.chuZhong = chuZhong;
    }

	public Diag(Integer diagId, Integer medrecordCode, Integer registerId, Integer diseaseId, Integer diagType,
			Date onsetTime, Integer chuZhong) {
		super();
		this.diagId = diagId;
		this.medrecordCode = medrecordCode;
		this.registerId = registerId;
		this.diseaseId = diseaseId;
		this.diagType = diagType;
		this.onsetTime = onsetTime;
		this.chuZhong = chuZhong;
	}

	public Diag() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}