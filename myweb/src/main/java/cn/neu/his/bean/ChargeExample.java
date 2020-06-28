package cn.neu.his.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChargeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChargeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andChargeIdIsNull() {
            addCriterion("Charge_ID is null");
            return (Criteria) this;
        }

        public Criteria andChargeIdIsNotNull() {
            addCriterion("Charge_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChargeIdEqualTo(Integer value) {
            addCriterion("Charge_ID =", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdNotEqualTo(Integer value) {
            addCriterion("Charge_ID <>", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdGreaterThan(Integer value) {
            addCriterion("Charge_ID >", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Charge_ID >=", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdLessThan(Integer value) {
            addCriterion("Charge_ID <", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdLessThanOrEqualTo(Integer value) {
            addCriterion("Charge_ID <=", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdIn(List<Integer> values) {
            addCriterion("Charge_ID in", values, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdNotIn(List<Integer> values) {
            addCriterion("Charge_ID not in", values, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdBetween(Integer value1, Integer value2) {
            addCriterion("Charge_ID between", value1, value2, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Charge_ID not between", value1, value2, "chargeId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdIsNull() {
            addCriterion("Register_ID is null");
            return (Criteria) this;
        }

        public Criteria andRegisterIdIsNotNull() {
            addCriterion("Register_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterIdEqualTo(Integer value) {
            addCriterion("Register_ID =", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdNotEqualTo(Integer value) {
            addCriterion("Register_ID <>", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdGreaterThan(Integer value) {
            addCriterion("Register_ID >", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Register_ID >=", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdLessThan(Integer value) {
            addCriterion("Register_ID <", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdLessThanOrEqualTo(Integer value) {
            addCriterion("Register_ID <=", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdIn(List<Integer> values) {
            addCriterion("Register_ID in", values, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdNotIn(List<Integer> values) {
            addCriterion("Register_ID not in", values, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdBetween(Integer value1, Integer value2) {
            addCriterion("Register_ID between", value1, value2, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Register_ID not between", value1, value2, "registerId");
            return (Criteria) this;
        }

        public Criteria andBillCodeIsNull() {
            addCriterion("Bill_Code is null");
            return (Criteria) this;
        }

        public Criteria andBillCodeIsNotNull() {
            addCriterion("Bill_Code is not null");
            return (Criteria) this;
        }

        public Criteria andBillCodeEqualTo(Integer value) {
            addCriterion("Bill_Code =", value, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeNotEqualTo(Integer value) {
            addCriterion("Bill_Code <>", value, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeGreaterThan(Integer value) {
            addCriterion("Bill_Code >", value, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Bill_Code >=", value, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeLessThan(Integer value) {
            addCriterion("Bill_Code <", value, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeLessThanOrEqualTo(Integer value) {
            addCriterion("Bill_Code <=", value, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeIn(List<Integer> values) {
            addCriterion("Bill_Code in", values, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeNotIn(List<Integer> values) {
            addCriterion("Bill_Code not in", values, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeBetween(Integer value1, Integer value2) {
            addCriterion("Bill_Code between", value1, value2, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("Bill_Code not between", value1, value2, "billCode");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("Item_ID is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("Item_ID is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Integer value) {
            addCriterion("Item_ID =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Integer value) {
            addCriterion("Item_ID <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Integer value) {
            addCriterion("Item_ID >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Item_ID >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Integer value) {
            addCriterion("Item_ID <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("Item_ID <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Integer> values) {
            addCriterion("Item_ID in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Integer> values) {
            addCriterion("Item_ID not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Integer value1, Integer value2) {
            addCriterion("Item_ID between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Item_ID not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("Item_Type is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("Item_Type is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(Integer value) {
            addCriterion("Item_Type =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(Integer value) {
            addCriterion("Item_Type <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(Integer value) {
            addCriterion("Item_Type >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Item_Type >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(Integer value) {
            addCriterion("Item_Type <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Item_Type <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<Integer> values) {
            addCriterion("Item_Type in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<Integer> values) {
            addCriterion("Item_Type not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(Integer value1, Integer value2) {
            addCriterion("Item_Type between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Item_Type not between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("Item_Name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("Item_Name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("Item_Name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("Item_Name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("Item_Name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("Item_Name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("Item_Name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("Item_Name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("Item_Name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("Item_Name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("Item_Name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("Item_Name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("Item_Name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("Item_Name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNull() {
            addCriterion("Item_Price is null");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNotNull() {
            addCriterion("Item_Price is not null");
            return (Criteria) this;
        }

        public Criteria andItemPriceEqualTo(Float value) {
            addCriterion("Item_Price =", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotEqualTo(Float value) {
            addCriterion("Item_Price <>", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThan(Float value) {
            addCriterion("Item_Price >", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("Item_Price >=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThan(Float value) {
            addCriterion("Item_Price <", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThanOrEqualTo(Float value) {
            addCriterion("Item_Price <=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceIn(List<Float> values) {
            addCriterion("Item_Price in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotIn(List<Float> values) {
            addCriterion("Item_Price not in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceBetween(Float value1, Float value2) {
            addCriterion("Item_Price between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotBetween(Float value1, Float value2) {
            addCriterion("Item_Price not between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemNumIsNull() {
            addCriterion("Item_Num is null");
            return (Criteria) this;
        }

        public Criteria andItemNumIsNotNull() {
            addCriterion("Item_Num is not null");
            return (Criteria) this;
        }

        public Criteria andItemNumEqualTo(Integer value) {
            addCriterion("Item_Num =", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumNotEqualTo(Integer value) {
            addCriterion("Item_Num <>", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumGreaterThan(Integer value) {
            addCriterion("Item_Num >", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("Item_Num >=", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumLessThan(Integer value) {
            addCriterion("Item_Num <", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumLessThanOrEqualTo(Integer value) {
            addCriterion("Item_Num <=", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumIn(List<Integer> values) {
            addCriterion("Item_Num in", values, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumNotIn(List<Integer> values) {
            addCriterion("Item_Num not in", values, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumBetween(Integer value1, Integer value2) {
            addCriterion("Item_Num between", value1, value2, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumNotBetween(Integer value1, Integer value2) {
            addCriterion("Item_Num not between", value1, value2, "itemNum");
            return (Criteria) this;
        }

        public Criteria andImpleDeptIdIsNull() {
            addCriterion("Imple_Dept_ID is null");
            return (Criteria) this;
        }

        public Criteria andImpleDeptIdIsNotNull() {
            addCriterion("Imple_Dept_ID is not null");
            return (Criteria) this;
        }

        public Criteria andImpleDeptIdEqualTo(Integer value) {
            addCriterion("Imple_Dept_ID =", value, "impleDeptId");
            return (Criteria) this;
        }

        public Criteria andImpleDeptIdNotEqualTo(Integer value) {
            addCriterion("Imple_Dept_ID <>", value, "impleDeptId");
            return (Criteria) this;
        }

        public Criteria andImpleDeptIdGreaterThan(Integer value) {
            addCriterion("Imple_Dept_ID >", value, "impleDeptId");
            return (Criteria) this;
        }

        public Criteria andImpleDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Imple_Dept_ID >=", value, "impleDeptId");
            return (Criteria) this;
        }

        public Criteria andImpleDeptIdLessThan(Integer value) {
            addCriterion("Imple_Dept_ID <", value, "impleDeptId");
            return (Criteria) this;
        }

        public Criteria andImpleDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("Imple_Dept_ID <=", value, "impleDeptId");
            return (Criteria) this;
        }

        public Criteria andImpleDeptIdIn(List<Integer> values) {
            addCriterion("Imple_Dept_ID in", values, "impleDeptId");
            return (Criteria) this;
        }

        public Criteria andImpleDeptIdNotIn(List<Integer> values) {
            addCriterion("Imple_Dept_ID not in", values, "impleDeptId");
            return (Criteria) this;
        }

        public Criteria andImpleDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("Imple_Dept_ID between", value1, value2, "impleDeptId");
            return (Criteria) this;
        }

        public Criteria andImpleDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Imple_Dept_ID not between", value1, value2, "impleDeptId");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNull() {
            addCriterion("Open_Time is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("Open_Time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(Date value) {
            addCriterion("Open_Time =", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(Date value) {
            addCriterion("Open_Time <>", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(Date value) {
            addCriterion("Open_Time >", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Open_Time >=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(Date value) {
            addCriterion("Open_Time <", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(Date value) {
            addCriterion("Open_Time <=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(List<Date> values) {
            addCriterion("Open_Time in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(List<Date> values) {
            addCriterion("Open_Time not in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(Date value1, Date value2) {
            addCriterion("Open_Time between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(Date value1, Date value2) {
            addCriterion("Open_Time not between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenDoctorIdIsNull() {
            addCriterion("Open_Doctor_ID is null");
            return (Criteria) this;
        }

        public Criteria andOpenDoctorIdIsNotNull() {
            addCriterion("Open_Doctor_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDoctorIdEqualTo(Integer value) {
            addCriterion("Open_Doctor_ID =", value, "openDoctorId");
            return (Criteria) this;
        }

        public Criteria andOpenDoctorIdNotEqualTo(Integer value) {
            addCriterion("Open_Doctor_ID <>", value, "openDoctorId");
            return (Criteria) this;
        }

        public Criteria andOpenDoctorIdGreaterThan(Integer value) {
            addCriterion("Open_Doctor_ID >", value, "openDoctorId");
            return (Criteria) this;
        }

        public Criteria andOpenDoctorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Open_Doctor_ID >=", value, "openDoctorId");
            return (Criteria) this;
        }

        public Criteria andOpenDoctorIdLessThan(Integer value) {
            addCriterion("Open_Doctor_ID <", value, "openDoctorId");
            return (Criteria) this;
        }

        public Criteria andOpenDoctorIdLessThanOrEqualTo(Integer value) {
            addCriterion("Open_Doctor_ID <=", value, "openDoctorId");
            return (Criteria) this;
        }

        public Criteria andOpenDoctorIdIn(List<Integer> values) {
            addCriterion("Open_Doctor_ID in", values, "openDoctorId");
            return (Criteria) this;
        }

        public Criteria andOpenDoctorIdNotIn(List<Integer> values) {
            addCriterion("Open_Doctor_ID not in", values, "openDoctorId");
            return (Criteria) this;
        }

        public Criteria andOpenDoctorIdBetween(Integer value1, Integer value2) {
            addCriterion("Open_Doctor_ID between", value1, value2, "openDoctorId");
            return (Criteria) this;
        }

        public Criteria andOpenDoctorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Open_Doctor_ID not between", value1, value2, "openDoctorId");
            return (Criteria) this;
        }

        public Criteria andRetreatTimeIsNull() {
            addCriterion("Retreat_Time is null");
            return (Criteria) this;
        }

        public Criteria andRetreatTimeIsNotNull() {
            addCriterion("Retreat_Time is not null");
            return (Criteria) this;
        }

        public Criteria andRetreatTimeEqualTo(Date value) {
            addCriterion("Retreat_Time =", value, "retreatTime");
            return (Criteria) this;
        }

        public Criteria andRetreatTimeNotEqualTo(Date value) {
            addCriterion("Retreat_Time <>", value, "retreatTime");
            return (Criteria) this;
        }

        public Criteria andRetreatTimeGreaterThan(Date value) {
            addCriterion("Retreat_Time >", value, "retreatTime");
            return (Criteria) this;
        }

        public Criteria andRetreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Retreat_Time >=", value, "retreatTime");
            return (Criteria) this;
        }

        public Criteria andRetreatTimeLessThan(Date value) {
            addCriterion("Retreat_Time <", value, "retreatTime");
            return (Criteria) this;
        }

        public Criteria andRetreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("Retreat_Time <=", value, "retreatTime");
            return (Criteria) this;
        }

        public Criteria andRetreatTimeIn(List<Date> values) {
            addCriterion("Retreat_Time in", values, "retreatTime");
            return (Criteria) this;
        }

        public Criteria andRetreatTimeNotIn(List<Date> values) {
            addCriterion("Retreat_Time not in", values, "retreatTime");
            return (Criteria) this;
        }

        public Criteria andRetreatTimeBetween(Date value1, Date value2) {
            addCriterion("Retreat_Time between", value1, value2, "retreatTime");
            return (Criteria) this;
        }

        public Criteria andRetreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("Retreat_Time not between", value1, value2, "retreatTime");
            return (Criteria) this;
        }

        public Criteria andRetreatPersonIdIsNull() {
            addCriterion("Retreat_Person_ID is null");
            return (Criteria) this;
        }

        public Criteria andRetreatPersonIdIsNotNull() {
            addCriterion("Retreat_Person_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRetreatPersonIdEqualTo(Integer value) {
            addCriterion("Retreat_Person_ID =", value, "retreatPersonId");
            return (Criteria) this;
        }

        public Criteria andRetreatPersonIdNotEqualTo(Integer value) {
            addCriterion("Retreat_Person_ID <>", value, "retreatPersonId");
            return (Criteria) this;
        }

        public Criteria andRetreatPersonIdGreaterThan(Integer value) {
            addCriterion("Retreat_Person_ID >", value, "retreatPersonId");
            return (Criteria) this;
        }

        public Criteria andRetreatPersonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Retreat_Person_ID >=", value, "retreatPersonId");
            return (Criteria) this;
        }

        public Criteria andRetreatPersonIdLessThan(Integer value) {
            addCriterion("Retreat_Person_ID <", value, "retreatPersonId");
            return (Criteria) this;
        }

        public Criteria andRetreatPersonIdLessThanOrEqualTo(Integer value) {
            addCriterion("Retreat_Person_ID <=", value, "retreatPersonId");
            return (Criteria) this;
        }

        public Criteria andRetreatPersonIdIn(List<Integer> values) {
            addCriterion("Retreat_Person_ID in", values, "retreatPersonId");
            return (Criteria) this;
        }

        public Criteria andRetreatPersonIdNotIn(List<Integer> values) {
            addCriterion("Retreat_Person_ID not in", values, "retreatPersonId");
            return (Criteria) this;
        }

        public Criteria andRetreatPersonIdBetween(Integer value1, Integer value2) {
            addCriterion("Retreat_Person_ID between", value1, value2, "retreatPersonId");
            return (Criteria) this;
        }

        public Criteria andRetreatPersonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Retreat_Person_ID not between", value1, value2, "retreatPersonId");
            return (Criteria) this;
        }

        public Criteria andRetreatWayIsNull() {
            addCriterion("Retreat_Way is null");
            return (Criteria) this;
        }

        public Criteria andRetreatWayIsNotNull() {
            addCriterion("Retreat_Way is not null");
            return (Criteria) this;
        }

        public Criteria andRetreatWayEqualTo(Integer value) {
            addCriterion("Retreat_Way =", value, "retreatWay");
            return (Criteria) this;
        }

        public Criteria andRetreatWayNotEqualTo(Integer value) {
            addCriterion("Retreat_Way <>", value, "retreatWay");
            return (Criteria) this;
        }

        public Criteria andRetreatWayGreaterThan(Integer value) {
            addCriterion("Retreat_Way >", value, "retreatWay");
            return (Criteria) this;
        }

        public Criteria andRetreatWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("Retreat_Way >=", value, "retreatWay");
            return (Criteria) this;
        }

        public Criteria andRetreatWayLessThan(Integer value) {
            addCriterion("Retreat_Way <", value, "retreatWay");
            return (Criteria) this;
        }

        public Criteria andRetreatWayLessThanOrEqualTo(Integer value) {
            addCriterion("Retreat_Way <=", value, "retreatWay");
            return (Criteria) this;
        }

        public Criteria andRetreatWayIn(List<Integer> values) {
            addCriterion("Retreat_Way in", values, "retreatWay");
            return (Criteria) this;
        }

        public Criteria andRetreatWayNotIn(List<Integer> values) {
            addCriterion("Retreat_Way not in", values, "retreatWay");
            return (Criteria) this;
        }

        public Criteria andRetreatWayBetween(Integer value1, Integer value2) {
            addCriterion("Retreat_Way between", value1, value2, "retreatWay");
            return (Criteria) this;
        }

        public Criteria andRetreatWayNotBetween(Integer value1, Integer value2) {
            addCriterion("Retreat_Way not between", value1, value2, "retreatWay");
            return (Criteria) this;
        }

        public Criteria andChargeRecordIdIsNull() {
            addCriterion("Charge_Record_ID is null");
            return (Criteria) this;
        }

        public Criteria andChargeRecordIdIsNotNull() {
            addCriterion("Charge_Record_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChargeRecordIdEqualTo(Integer value) {
            addCriterion("Charge_Record_ID =", value, "chargeRecordId");
            return (Criteria) this;
        }

        public Criteria andChargeRecordIdNotEqualTo(Integer value) {
            addCriterion("Charge_Record_ID <>", value, "chargeRecordId");
            return (Criteria) this;
        }

        public Criteria andChargeRecordIdGreaterThan(Integer value) {
            addCriterion("Charge_Record_ID >", value, "chargeRecordId");
            return (Criteria) this;
        }

        public Criteria andChargeRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Charge_Record_ID >=", value, "chargeRecordId");
            return (Criteria) this;
        }

        public Criteria andChargeRecordIdLessThan(Integer value) {
            addCriterion("Charge_Record_ID <", value, "chargeRecordId");
            return (Criteria) this;
        }

        public Criteria andChargeRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("Charge_Record_ID <=", value, "chargeRecordId");
            return (Criteria) this;
        }

        public Criteria andChargeRecordIdIn(List<Integer> values) {
            addCriterion("Charge_Record_ID in", values, "chargeRecordId");
            return (Criteria) this;
        }

        public Criteria andChargeRecordIdNotIn(List<Integer> values) {
            addCriterion("Charge_Record_ID not in", values, "chargeRecordId");
            return (Criteria) this;
        }

        public Criteria andChargeRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("Charge_Record_ID between", value1, value2, "chargeRecordId");
            return (Criteria) this;
        }

        public Criteria andChargeRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Charge_Record_ID not between", value1, value2, "chargeRecordId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}