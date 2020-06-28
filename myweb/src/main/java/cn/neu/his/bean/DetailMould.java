package cn.neu.his.bean;

public class DetailMould {
    private Integer readyMouldDetailId;

    private Integer readyMouldId;

    private Integer drugId;

    private String howUse;

    private String howMuchUse;

    private String howOfenUse;

    public Integer getReadyMouldDetailId() {
        return readyMouldDetailId;
    }

    public void setReadyMouldDetailId(Integer readyMouldDetailId) {
        this.readyMouldDetailId = readyMouldDetailId;
    }

    public Integer getReadyMouldId() {
        return readyMouldId;
    }

    public void setReadyMouldId(Integer readyMouldId) {
        this.readyMouldId = readyMouldId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getHowUse() {
        return howUse;
    }

    public void setHowUse(String howUse) {
        this.howUse = howUse == null ? null : howUse.trim();
    }

    public String getHowMuchUse() {
        return howMuchUse;
    }

    public void setHowMuchUse(String howMuchUse) {
        this.howMuchUse = howMuchUse == null ? null : howMuchUse.trim();
    }

    public String getHowOfenUse() {
        return howOfenUse;
    }

    public void setHowOfenUse(String howOfenUse) {
        this.howOfenUse = howOfenUse == null ? null : howOfenUse.trim();
    }
}