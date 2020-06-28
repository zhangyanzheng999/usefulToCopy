package cn.neu.his.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Register {
    private Integer registerId;

    private Integer medrecordCode;

    private String patientName;

    private String patientSex;

    private String patientIdcard;
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    private Date patientBirth;

    private Integer patientYear;

    private String patientYearType;

    private String patientAddress;
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    private Date thisVisitDate;

    private String noonBreak;

    private Integer registerDeptId;

    private Integer registerDoctorId;

    private Integer registerType;

    private Integer finalTypeId;

    private Integer medrecordBook;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registerTime;

    private Integer registerPersonId;

    private Integer thisVisitState;

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public Integer getMedrecordCode() {
        return medrecordCode;
    }

    public void setMedrecordCode(Integer medrecordCode) {
        this.medrecordCode = medrecordCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex == null ? null : patientSex.trim();
    }

    public String getPatientIdcard() {
        return patientIdcard;
    }

    public void setPatientIdcard(String patientIdcard) {
        this.patientIdcard = patientIdcard == null ? null : patientIdcard.trim();
    }

    public Date getPatientBirth() {
        return patientBirth;
    }

    public void setPatientBirth(Date patientBirth) {
        this.patientBirth = patientBirth;
    }

    public Integer getPatientYear() {
        return patientYear;
    }

    public void setPatientYear(Integer patientYear) {
        this.patientYear = patientYear;
    }

    public String getPatientYearType() {
        return patientYearType;
    }

    public void setPatientYearType(String patientYearType) {
        this.patientYearType = patientYearType == null ? null : patientYearType.trim();
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress == null ? null : patientAddress.trim();
    }

    public Date getThisVisitDate() {
        return thisVisitDate;
    }

    public void setThisVisitDate(Date thisVisitDate) {
        this.thisVisitDate = thisVisitDate;
    }

    public String getNoonBreak() {
        return noonBreak;
    }

    public void setNoonBreak(String noonBreak) {
        this.noonBreak = noonBreak == null ? null : noonBreak.trim();
    }

    public Integer getRegisterDeptId() {
        return registerDeptId;
    }

    public void setRegisterDeptId(Integer registerDeptId) {
        this.registerDeptId = registerDeptId;
    }

    public Integer getRegisterDoctorId() {
        return registerDoctorId;
    }

    public void setRegisterDoctorId(Integer registerDoctorId) {
        this.registerDoctorId = registerDoctorId;
    }

    public Integer getRegisterType() {
        return registerType;
    }

    public void setRegisterType(Integer registerType) {
        this.registerType = registerType;
    }

    public Integer getFinalTypeId() {
        return finalTypeId;
    }

    public void setFinalTypeId(Integer finalTypeId) {
        this.finalTypeId = finalTypeId;
    }

    public Integer getMedrecordBook() {
        return medrecordBook;
    }

    public void setMedrecordBook(Integer medrecordBook) {
        this.medrecordBook = medrecordBook;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getRegisterPersonId() {
        return registerPersonId;
    }

    public void setRegisterPersonId(Integer registerPersonId) {
        this.registerPersonId = registerPersonId;
    }

    public Integer getThisVisitState() {
        return thisVisitState;
    }

    public void setThisVisitState(Integer thisVisitState) {
        this.thisVisitState = thisVisitState;
    }

	public Register(Integer registerId, Integer medrecordCode, String patientName, String patientSex,
			String patientIdcard, Date patientBirth, Integer patientYear, String patientYearType, String patientAddress,
			Date thisVisitDate, String noonBreak, Integer registerDeptId, Integer registerDoctorId,
			Integer registerType, Integer finalTypeId, Integer medrecordBook, Date registerTime,
			Integer registerPersonId, Integer thisVisitState) {
		super();
		this.registerId = registerId;
		this.medrecordCode = medrecordCode;
		this.patientName = patientName;
		this.patientSex = patientSex;
		this.patientIdcard = patientIdcard;
		this.patientBirth = patientBirth;
		this.patientYear = patientYear;
		this.patientYearType = patientYearType;
		this.patientAddress = patientAddress;
		this.thisVisitDate = thisVisitDate;
		this.noonBreak = noonBreak;
		this.registerDeptId = registerDeptId;
		this.registerDoctorId = registerDoctorId;
		this.registerType = registerType;
		this.finalTypeId = finalTypeId;
		this.medrecordBook = medrecordBook;
		this.registerTime = registerTime;
		this.registerPersonId = registerPersonId;
		this.thisVisitState = thisVisitState;
	}

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}