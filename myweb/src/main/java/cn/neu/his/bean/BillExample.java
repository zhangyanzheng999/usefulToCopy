package cn.neu.his.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillExample() {
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

        public Criteria andBillIdIsNull() {
            addCriterion("Bill_ID is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("Bill_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(Integer value) {
            addCriterion("Bill_ID =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(Integer value) {
            addCriterion("Bill_ID <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(Integer value) {
            addCriterion("Bill_ID >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Bill_ID >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(Integer value) {
            addCriterion("Bill_ID <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(Integer value) {
            addCriterion("Bill_ID <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<Integer> values) {
            addCriterion("Bill_ID in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<Integer> values) {
            addCriterion("Bill_ID not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(Integer value1, Integer value2) {
            addCriterion("Bill_ID between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Bill_ID not between", value1, value2, "billId");
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

        public Criteria andBillAmountIsNull() {
            addCriterion("Bill_Amount is null");
            return (Criteria) this;
        }

        public Criteria andBillAmountIsNotNull() {
            addCriterion("Bill_Amount is not null");
            return (Criteria) this;
        }

        public Criteria andBillAmountEqualTo(Float value) {
            addCriterion("Bill_Amount =", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountNotEqualTo(Float value) {
            addCriterion("Bill_Amount <>", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountGreaterThan(Float value) {
            addCriterion("Bill_Amount >", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountGreaterThanOrEqualTo(Float value) {
            addCriterion("Bill_Amount >=", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountLessThan(Float value) {
            addCriterion("Bill_Amount <", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountLessThanOrEqualTo(Float value) {
            addCriterion("Bill_Amount <=", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountIn(List<Float> values) {
            addCriterion("Bill_Amount in", values, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountNotIn(List<Float> values) {
            addCriterion("Bill_Amount not in", values, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountBetween(Float value1, Float value2) {
            addCriterion("Bill_Amount between", value1, value2, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountNotBetween(Float value1, Float value2) {
            addCriterion("Bill_Amount not between", value1, value2, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillStateIsNull() {
            addCriterion("Bill_State is null");
            return (Criteria) this;
        }

        public Criteria andBillStateIsNotNull() {
            addCriterion("Bill_State is not null");
            return (Criteria) this;
        }

        public Criteria andBillStateEqualTo(Integer value) {
            addCriterion("Bill_State =", value, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateNotEqualTo(Integer value) {
            addCriterion("Bill_State <>", value, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateGreaterThan(Integer value) {
            addCriterion("Bill_State >", value, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("Bill_State >=", value, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateLessThan(Integer value) {
            addCriterion("Bill_State <", value, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateLessThanOrEqualTo(Integer value) {
            addCriterion("Bill_State <=", value, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateIn(List<Integer> values) {
            addCriterion("Bill_State in", values, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateNotIn(List<Integer> values) {
            addCriterion("Bill_State not in", values, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateBetween(Integer value1, Integer value2) {
            addCriterion("Bill_State between", value1, value2, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateNotBetween(Integer value1, Integer value2) {
            addCriterion("Bill_State not between", value1, value2, "billState");
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

        public Criteria andRedBillCodeIsNull() {
            addCriterion("Red_Bill_Code is null");
            return (Criteria) this;
        }

        public Criteria andRedBillCodeIsNotNull() {
            addCriterion("Red_Bill_Code is not null");
            return (Criteria) this;
        }

        public Criteria andRedBillCodeEqualTo(Integer value) {
            addCriterion("Red_Bill_Code =", value, "redBillCode");
            return (Criteria) this;
        }

        public Criteria andRedBillCodeNotEqualTo(Integer value) {
            addCriterion("Red_Bill_Code <>", value, "redBillCode");
            return (Criteria) this;
        }

        public Criteria andRedBillCodeGreaterThan(Integer value) {
            addCriterion("Red_Bill_Code >", value, "redBillCode");
            return (Criteria) this;
        }

        public Criteria andRedBillCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Red_Bill_Code >=", value, "redBillCode");
            return (Criteria) this;
        }

        public Criteria andRedBillCodeLessThan(Integer value) {
            addCriterion("Red_Bill_Code <", value, "redBillCode");
            return (Criteria) this;
        }

        public Criteria andRedBillCodeLessThanOrEqualTo(Integer value) {
            addCriterion("Red_Bill_Code <=", value, "redBillCode");
            return (Criteria) this;
        }

        public Criteria andRedBillCodeIn(List<Integer> values) {
            addCriterion("Red_Bill_Code in", values, "redBillCode");
            return (Criteria) this;
        }

        public Criteria andRedBillCodeNotIn(List<Integer> values) {
            addCriterion("Red_Bill_Code not in", values, "redBillCode");
            return (Criteria) this;
        }

        public Criteria andRedBillCodeBetween(Integer value1, Integer value2) {
            addCriterion("Red_Bill_Code between", value1, value2, "redBillCode");
            return (Criteria) this;
        }

        public Criteria andRedBillCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("Red_Bill_Code not between", value1, value2, "redBillCode");
            return (Criteria) this;
        }

        public Criteria andRedBillStateIsNull() {
            addCriterion("Red_Bill_State is null");
            return (Criteria) this;
        }

        public Criteria andRedBillStateIsNotNull() {
            addCriterion("Red_Bill_State is not null");
            return (Criteria) this;
        }

        public Criteria andRedBillStateEqualTo(Integer value) {
            addCriterion("Red_Bill_State =", value, "redBillState");
            return (Criteria) this;
        }

        public Criteria andRedBillStateNotEqualTo(Integer value) {
            addCriterion("Red_Bill_State <>", value, "redBillState");
            return (Criteria) this;
        }

        public Criteria andRedBillStateGreaterThan(Integer value) {
            addCriterion("Red_Bill_State >", value, "redBillState");
            return (Criteria) this;
        }

        public Criteria andRedBillStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("Red_Bill_State >=", value, "redBillState");
            return (Criteria) this;
        }

        public Criteria andRedBillStateLessThan(Integer value) {
            addCriterion("Red_Bill_State <", value, "redBillState");
            return (Criteria) this;
        }

        public Criteria andRedBillStateLessThanOrEqualTo(Integer value) {
            addCriterion("Red_Bill_State <=", value, "redBillState");
            return (Criteria) this;
        }

        public Criteria andRedBillStateIn(List<Integer> values) {
            addCriterion("Red_Bill_State in", values, "redBillState");
            return (Criteria) this;
        }

        public Criteria andRedBillStateNotIn(List<Integer> values) {
            addCriterion("Red_Bill_State not in", values, "redBillState");
            return (Criteria) this;
        }

        public Criteria andRedBillStateBetween(Integer value1, Integer value2) {
            addCriterion("Red_Bill_State between", value1, value2, "redBillState");
            return (Criteria) this;
        }

        public Criteria andRedBillStateNotBetween(Integer value1, Integer value2) {
            addCriterion("Red_Bill_State not between", value1, value2, "redBillState");
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