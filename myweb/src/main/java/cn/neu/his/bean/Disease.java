package cn.neu.his.bean;

public class Disease {
    private Integer diseaseId;

    private String diseaseCode;

    private String diseaseName;

    private String diseaseIcd;

    private Integer disecategoryId;

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode == null ? null : diseaseCode.trim();
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName == null ? null : diseaseName.trim();
    }

    public String getDiseaseIcd() {
        return diseaseIcd;
    }

    public void setDiseaseIcd(String diseaseIcd) {
        this.diseaseIcd = diseaseIcd == null ? null : diseaseIcd.trim();
    }

    public Integer getDisecategoryId() {
        return disecategoryId;
    }

    public void setDisecategoryId(Integer disecategoryId) {
        this.disecategoryId = disecategoryId;
    }
}