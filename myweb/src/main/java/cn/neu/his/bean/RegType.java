package cn.neu.his.bean;

public class RegType {
    private Integer regTypeId;

    private String regTypeCode;

    private String regTypeName;

    private Integer regShunxu;

    private Float regCost;

    private Integer regLimitnum;

    private Integer reomveSign;

    public Integer getRegTypeId() {
        return regTypeId;
    }

    public void setRegTypeId(Integer regTypeId) {
        this.regTypeId = regTypeId;
    }

    public String getRegTypeCode() {
        return regTypeCode;
    }

    public void setRegTypeCode(String regTypeCode) {
        this.regTypeCode = regTypeCode == null ? null : regTypeCode.trim();
    }

    public String getRegTypeName() {
        return regTypeName;
    }

    public void setRegTypeName(String regTypeName) {
        this.regTypeName = regTypeName == null ? null : regTypeName.trim();
    }

    public Integer getRegShunxu() {
        return regShunxu;
    }

    public void setRegShunxu(Integer regShunxu) {
        this.regShunxu = regShunxu;
    }

    public Float getRegCost() {
        return regCost;
    }

    public void setRegCost(Float regCost) {
        this.regCost = regCost;
    }

    public Integer getRegLimitnum() {
        return regLimitnum;
    }

    public void setRegLimitnum(Integer regLimitnum) {
        this.regLimitnum = regLimitnum;
    }

    public Integer getReomveSign() {
        return reomveSign;
    }

    public void setReomveSign(Integer reomveSign) {
        this.reomveSign = reomveSign;
    }
}