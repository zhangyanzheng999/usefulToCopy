package cn.neu.his.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Charge {
    private Integer chargeId;

    private Integer registerId;

    private Integer billCode;

    private Integer itemId;

    private Integer itemType;

    private String itemName;

    private Float itemPrice;

    private Integer itemNum;

    private Integer impleDeptId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date openTime;

    private Integer openDoctorId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date retreatTime;

    private Integer retreatPersonId;

    private Integer retreatWay;

    private Integer chargeRecordId;

    public Integer getChargeId() {
        return chargeId;
    }

    public void setChargeId(Integer chargeId) {
        this.chargeId = chargeId;
    }

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public Integer getBillCode() {
        return billCode;
    }

    public void setBillCode(Integer billCode) {
        this.billCode = billCode;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public Integer getImpleDeptId() {
        return impleDeptId;
    }

    public void setImpleDeptId(Integer impleDeptId) {
        this.impleDeptId = impleDeptId;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Integer getOpenDoctorId() {
        return openDoctorId;
    }

    public void setOpenDoctorId(Integer openDoctorId) {
        this.openDoctorId = openDoctorId;
    }

    public Date getRetreatTime() {
        return retreatTime;
    }

    public void setRetreatTime(Date retreatTime) {
        this.retreatTime = retreatTime;
    }

    public Integer getRetreatPersonId() {
        return retreatPersonId;
    }

    public void setRetreatPersonId(Integer retreatPersonId) {
        this.retreatPersonId = retreatPersonId;
    }

    public Integer getRetreatWay() {
        return retreatWay;
    }

    public void setRetreatWay(Integer retreatWay) {
        this.retreatWay = retreatWay;
    }

    public Integer getChargeRecordId() {
        return chargeRecordId;
    }

    public void setChargeRecordId(Integer chargeRecordId) {
        this.chargeRecordId = chargeRecordId;
    }

	public Charge(Integer chargeId, Integer registerId, Integer billCode, Integer itemId, Integer itemType,
			String itemName, Float itemPrice, Integer itemNum, Integer impleDeptId, Date openTime, Integer openDoctorId,
			Date retreatTime, Integer retreatPersonId, Integer retreatWay, Integer chargeRecordId) {
		super();
		this.chargeId = chargeId;
		this.registerId = registerId;
		this.billCode = billCode;
		this.itemId = itemId;
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemNum = itemNum;
		this.impleDeptId = impleDeptId;
		this.openTime = openTime;
		this.openDoctorId = openDoctorId;
		this.retreatTime = retreatTime;
		this.retreatPersonId = retreatPersonId;
		this.retreatWay = retreatWay;
		this.chargeRecordId = chargeRecordId;
	}

	public Charge() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}