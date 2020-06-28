package cn.neu.his.bean;

import java.util.Date;

public class Drug {
    private Integer drugsId;

    private String drugsCode;

    private String drugsName;

    private String drugsFormat;

    private String drugsUnit;

    private String manufacturer;

    private Integer drugsDosageId;

    private Integer drugsTypeId;

    private Float drugsPrice;

    private String mnemoniccode;

    private Date creationdate;

    public Integer getDrugsId() {
        return drugsId;
    }

    public void setDrugsId(Integer drugsId) {
        this.drugsId = drugsId;
    }

    public String getDrugsCode() {
        return drugsCode;
    }

    public void setDrugsCode(String drugsCode) {
        this.drugsCode = drugsCode == null ? null : drugsCode.trim();
    }

    public String getDrugsName() {
        return drugsName;
    }

    public void setDrugsName(String drugsName) {
        this.drugsName = drugsName == null ? null : drugsName.trim();
    }

    public String getDrugsFormat() {
        return drugsFormat;
    }

    public void setDrugsFormat(String drugsFormat) {
        this.drugsFormat = drugsFormat == null ? null : drugsFormat.trim();
    }

    public String getDrugsUnit() {
        return drugsUnit;
    }

    public void setDrugsUnit(String drugsUnit) {
        this.drugsUnit = drugsUnit == null ? null : drugsUnit.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Integer getDrugsDosageId() {
        return drugsDosageId;
    }

    public void setDrugsDosageId(Integer drugsDosageId) {
        this.drugsDosageId = drugsDosageId;
    }

    public Integer getDrugsTypeId() {
        return drugsTypeId;
    }

    public void setDrugsTypeId(Integer drugsTypeId) {
        this.drugsTypeId = drugsTypeId;
    }

    public Float getDrugsPrice() {
        return drugsPrice;
    }

    public void setDrugsPrice(Float drugsPrice) {
        this.drugsPrice = drugsPrice;
    }

    public String getMnemoniccode() {
        return mnemoniccode;
    }

    public void setMnemoniccode(String mnemoniccode) {
        this.mnemoniccode = mnemoniccode == null ? null : mnemoniccode.trim();
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }
}