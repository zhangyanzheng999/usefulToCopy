package cn.neu.his.bean;

import java.util.Date;

public class Bill {
    private Integer billId;

    private Integer billCode;

    private Float billAmount;

    private Integer billState;

    private Date retreatTime;

    private Integer retreatPersonId;

    private Integer registerId;

    private Integer retreatWay;

    public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(Integer billId, Integer billCode, Float billAmount, Integer billState, Date retreatTime,
			Integer retreatPersonId, Integer registerId, Integer retreatWay, Integer redBillCode,
			Integer redBillState) {
		super();
		this.billId = billId;
		this.billCode = billCode;
		this.billAmount = billAmount;
		this.billState = billState;
		this.retreatTime = retreatTime;
		this.retreatPersonId = retreatPersonId;
		this.registerId = registerId;
		this.retreatWay = retreatWay;
		this.redBillCode = redBillCode;
		this.redBillState = redBillState;
	}

	private Integer redBillCode;

    private Integer redBillState;

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getBillCode() {
        return billCode;
    }

    public void setBillCode(Integer billCode) {
        this.billCode = billCode;
    }

    public Float getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Float billAmount) {
        this.billAmount = billAmount;
    }

    public Integer getBillState() {
        return billState;
    }

    public void setBillState(Integer billState) {
        this.billState = billState;
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

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public Integer getRetreatWay() {
        return retreatWay;
    }

    public void setRetreatWay(Integer retreatWay) {
        this.retreatWay = retreatWay;
    }

    public Integer getRedBillCode() {
        return redBillCode;
    }

    public void setRedBillCode(Integer redBillCode) {
        this.redBillCode = redBillCode;
    }

    public Integer getRedBillState() {
        return redBillState;
    }

    public void setRedBillState(Integer redBillState) {
        this.redBillState = redBillState;
    }
}