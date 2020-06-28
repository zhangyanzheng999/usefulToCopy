package cn.neu.his.bean;

public class Medrecord {
    private Integer medrecordId;

    private Integer medrecordCode;

    private Integer registerId;

    private String chiefComplaint;

    private String nowIllness;

    private String nowMedicalStatus;

    private String pastIllness;

    private String allergyHistory;

    private String physicalExamination;

    public Medrecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medrecord(Integer medrecordId, Integer medrecordCode, Integer registerId, String chiefComplaint,
			String nowIllness, String nowMedicalStatus, String pastIllness, String allergyHistory,
			String physicalExamination, String inspectionRecommendation, String attention, String examResult,
			String diagnosticResult, String opinionRecommendation, Integer medrecordState) {
		super();
		this.medrecordId = medrecordId;
		this.medrecordCode = medrecordCode;
		this.registerId = registerId;
		this.chiefComplaint = chiefComplaint;
		this.nowIllness = nowIllness;
		this.nowMedicalStatus = nowMedicalStatus;
		this.pastIllness = pastIllness;
		this.allergyHistory = allergyHistory;
		this.physicalExamination = physicalExamination;
		this.inspectionRecommendation = inspectionRecommendation;
		this.attention = attention;
		this.examResult = examResult;
		this.diagnosticResult = diagnosticResult;
		this.opinionRecommendation = opinionRecommendation;
		this.medrecordState = medrecordState;
	}

	private String inspectionRecommendation;

    private String attention;

    private String examResult;

    private String diagnosticResult;

    private String opinionRecommendation;

    private Integer medrecordState;

    public Integer getMedrecordId() {
        return medrecordId;
    }

    public void setMedrecordId(Integer medrecordId) {
        this.medrecordId = medrecordId;
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

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint == null ? null : chiefComplaint.trim();
    }

    public String getNowIllness() {
        return nowIllness;
    }

    public void setNowIllness(String nowIllness) {
        this.nowIllness = nowIllness == null ? null : nowIllness.trim();
    }

    public String getNowMedicalStatus() {
        return nowMedicalStatus;
    }

    public void setNowMedicalStatus(String nowMedicalStatus) {
        this.nowMedicalStatus = nowMedicalStatus == null ? null : nowMedicalStatus.trim();
    }

    public String getPastIllness() {
        return pastIllness;
    }

    public void setPastIllness(String pastIllness) {
        this.pastIllness = pastIllness == null ? null : pastIllness.trim();
    }

    public String getAllergyHistory() {
        return allergyHistory;
    }

    public void setAllergyHistory(String allergyHistory) {
        this.allergyHistory = allergyHistory == null ? null : allergyHistory.trim();
    }

    public String getPhysicalExamination() {
        return physicalExamination;
    }

    public void setPhysicalExamination(String physicalExamination) {
        this.physicalExamination = physicalExamination == null ? null : physicalExamination.trim();
    }

    public String getInspectionRecommendation() {
        return inspectionRecommendation;
    }

    public void setInspectionRecommendation(String inspectionRecommendation) {
        this.inspectionRecommendation = inspectionRecommendation == null ? null : inspectionRecommendation.trim();
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention == null ? null : attention.trim();
    }

    public String getExamResult() {
        return examResult;
    }

    public void setExamResult(String examResult) {
        this.examResult = examResult == null ? null : examResult.trim();
    }

    public String getDiagnosticResult() {
        return diagnosticResult;
    }

    public void setDiagnosticResult(String diagnosticResult) {
        this.diagnosticResult = diagnosticResult == null ? null : diagnosticResult.trim();
    }

    public String getOpinionRecommendation() {
        return opinionRecommendation;
    }

    public void setOpinionRecommendation(String opinionRecommendation) {
        this.opinionRecommendation = opinionRecommendation == null ? null : opinionRecommendation.trim();
    }

    public Integer getMedrecordState() {
        return medrecordState;
    }

    public void setMedrecordState(Integer medrecordState) {
        this.medrecordState = medrecordState;
    }
}