package cn.neu.his.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrescriptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrescriptionExample() {
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

        public Criteria andPreIdIsNull() {
            addCriterion("Pre_ID is null");
            return (Criteria) this;
        }

        public Criteria andPreIdIsNotNull() {
            addCriterion("Pre_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPreIdEqualTo(Integer value) {
            addCriterion("Pre_ID =", value, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdNotEqualTo(Integer value) {
            addCriterion("Pre_ID <>", value, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdGreaterThan(Integer value) {
            addCriterion("Pre_ID >", value, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Pre_ID >=", value, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdLessThan(Integer value) {
            addCriterion("Pre_ID <", value, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdLessThanOrEqualTo(Integer value) {
            addCriterion("Pre_ID <=", value, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdIn(List<Integer> values) {
            addCriterion("Pre_ID in", values, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdNotIn(List<Integer> values) {
            addCriterion("Pre_ID not in", values, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdBetween(Integer value1, Integer value2) {
            addCriterion("Pre_ID between", value1, value2, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Pre_ID not between", value1, value2, "preId");
            return (Criteria) this;
        }

        public Criteria andMedrecordIdIsNull() {
            addCriterion("MedRecord_ID is null");
            return (Criteria) this;
        }

        public Criteria andMedrecordIdIsNotNull() {
            addCriterion("MedRecord_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMedrecordIdEqualTo(Integer value) {
            addCriterion("MedRecord_ID =", value, "medrecordId");
            return (Criteria) this;
        }

        public Criteria andMedrecordIdNotEqualTo(Integer value) {
            addCriterion("MedRecord_ID <>", value, "medrecordId");
            return (Criteria) this;
        }

        public Criteria andMedrecordIdGreaterThan(Integer value) {
            addCriterion("MedRecord_ID >", value, "medrecordId");
            return (Criteria) this;
        }

        public Criteria andMedrecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MedRecord_ID >=", value, "medrecordId");
            return (Criteria) this;
        }

        public Criteria andMedrecordIdLessThan(Integer value) {
            addCriterion("MedRecord_ID <", value, "medrecordId");
            return (Criteria) this;
        }

        public Criteria andMedrecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("MedRecord_ID <=", value, "medrecordId");
            return (Criteria) this;
        }

        public Criteria andMedrecordIdIn(List<Integer> values) {
            addCriterion("MedRecord_ID in", values, "medrecordId");
            return (Criteria) this;
        }

        public Criteria andMedrecordIdNotIn(List<Integer> values) {
            addCriterion("MedRecord_ID not in", values, "medrecordId");
            return (Criteria) this;
        }

        public Criteria andMedrecordIdBetween(Integer value1, Integer value2) {
            addCriterion("MedRecord_ID between", value1, value2, "medrecordId");
            return (Criteria) this;
        }

        public Criteria andMedrecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MedRecord_ID not between", value1, value2, "medrecordId");
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

        public Criteria andDoctorIdIsNull() {
            addCriterion("Doctor_ID is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNotNull() {
            addCriterion("Doctor_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdEqualTo(Integer value) {
            addCriterion("Doctor_ID =", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotEqualTo(Integer value) {
            addCriterion("Doctor_ID <>", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThan(Integer value) {
            addCriterion("Doctor_ID >", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Doctor_ID >=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThan(Integer value) {
            addCriterion("Doctor_ID <", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThanOrEqualTo(Integer value) {
            addCriterion("Doctor_ID <=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIn(List<Integer> values) {
            addCriterion("Doctor_ID in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotIn(List<Integer> values) {
            addCriterion("Doctor_ID not in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdBetween(Integer value1, Integer value2) {
            addCriterion("Doctor_ID between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Doctor_ID not between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andPreNameIsNull() {
            addCriterion("Pre_Name is null");
            return (Criteria) this;
        }

        public Criteria andPreNameIsNotNull() {
            addCriterion("Pre_Name is not null");
            return (Criteria) this;
        }

        public Criteria andPreNameEqualTo(String value) {
            addCriterion("Pre_Name =", value, "preName");
            return (Criteria) this;
        }

        public Criteria andPreNameNotEqualTo(String value) {
            addCriterion("Pre_Name <>", value, "preName");
            return (Criteria) this;
        }

        public Criteria andPreNameGreaterThan(String value) {
            addCriterion("Pre_Name >", value, "preName");
            return (Criteria) this;
        }

        public Criteria andPreNameGreaterThanOrEqualTo(String value) {
            addCriterion("Pre_Name >=", value, "preName");
            return (Criteria) this;
        }

        public Criteria andPreNameLessThan(String value) {
            addCriterion("Pre_Name <", value, "preName");
            return (Criteria) this;
        }

        public Criteria andPreNameLessThanOrEqualTo(String value) {
            addCriterion("Pre_Name <=", value, "preName");
            return (Criteria) this;
        }

        public Criteria andPreNameLike(String value) {
            addCriterion("Pre_Name like", value, "preName");
            return (Criteria) this;
        }

        public Criteria andPreNameNotLike(String value) {
            addCriterion("Pre_Name not like", value, "preName");
            return (Criteria) this;
        }

        public Criteria andPreNameIn(List<String> values) {
            addCriterion("Pre_Name in", values, "preName");
            return (Criteria) this;
        }

        public Criteria andPreNameNotIn(List<String> values) {
            addCriterion("Pre_Name not in", values, "preName");
            return (Criteria) this;
        }

        public Criteria andPreNameBetween(String value1, String value2) {
            addCriterion("Pre_Name between", value1, value2, "preName");
            return (Criteria) this;
        }

        public Criteria andPreNameNotBetween(String value1, String value2) {
            addCriterion("Pre_Name not between", value1, value2, "preName");
            return (Criteria) this;
        }

        public Criteria andPreOpenTimeIsNull() {
            addCriterion("Pre_Open_time is null");
            return (Criteria) this;
        }

        public Criteria andPreOpenTimeIsNotNull() {
            addCriterion("Pre_Open_time is not null");
            return (Criteria) this;
        }

        public Criteria andPreOpenTimeEqualTo(Date value) {
            addCriterion("Pre_Open_time =", value, "preOpenTime");
            return (Criteria) this;
        }

        public Criteria andPreOpenTimeNotEqualTo(Date value) {
            addCriterion("Pre_Open_time <>", value, "preOpenTime");
            return (Criteria) this;
        }

        public Criteria andPreOpenTimeGreaterThan(Date value) {
            addCriterion("Pre_Open_time >", value, "preOpenTime");
            return (Criteria) this;
        }

        public Criteria andPreOpenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Pre_Open_time >=", value, "preOpenTime");
            return (Criteria) this;
        }

        public Criteria andPreOpenTimeLessThan(Date value) {
            addCriterion("Pre_Open_time <", value, "preOpenTime");
            return (Criteria) this;
        }

        public Criteria andPreOpenTimeLessThanOrEqualTo(Date value) {
            addCriterion("Pre_Open_time <=", value, "preOpenTime");
            return (Criteria) this;
        }

        public Criteria andPreOpenTimeIn(List<Date> values) {
            addCriterion("Pre_Open_time in", values, "preOpenTime");
            return (Criteria) this;
        }

        public Criteria andPreOpenTimeNotIn(List<Date> values) {
            addCriterion("Pre_Open_time not in", values, "preOpenTime");
            return (Criteria) this;
        }

        public Criteria andPreOpenTimeBetween(Date value1, Date value2) {
            addCriterion("Pre_Open_time between", value1, value2, "preOpenTime");
            return (Criteria) this;
        }

        public Criteria andPreOpenTimeNotBetween(Date value1, Date value2) {
            addCriterion("Pre_Open_time not between", value1, value2, "preOpenTime");
            return (Criteria) this;
        }

        public Criteria andPreStateIsNull() {
            addCriterion("Pre_State is null");
            return (Criteria) this;
        }

        public Criteria andPreStateIsNotNull() {
            addCriterion("Pre_State is not null");
            return (Criteria) this;
        }

        public Criteria andPreStateEqualTo(Integer value) {
            addCriterion("Pre_State =", value, "preState");
            return (Criteria) this;
        }

        public Criteria andPreStateNotEqualTo(Integer value) {
            addCriterion("Pre_State <>", value, "preState");
            return (Criteria) this;
        }

        public Criteria andPreStateGreaterThan(Integer value) {
            addCriterion("Pre_State >", value, "preState");
            return (Criteria) this;
        }

        public Criteria andPreStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("Pre_State >=", value, "preState");
            return (Criteria) this;
        }

        public Criteria andPreStateLessThan(Integer value) {
            addCriterion("Pre_State <", value, "preState");
            return (Criteria) this;
        }

        public Criteria andPreStateLessThanOrEqualTo(Integer value) {
            addCriterion("Pre_State <=", value, "preState");
            return (Criteria) this;
        }

        public Criteria andPreStateIn(List<Integer> values) {
            addCriterion("Pre_State in", values, "preState");
            return (Criteria) this;
        }

        public Criteria andPreStateNotIn(List<Integer> values) {
            addCriterion("Pre_State not in", values, "preState");
            return (Criteria) this;
        }

        public Criteria andPreStateBetween(Integer value1, Integer value2) {
            addCriterion("Pre_State between", value1, value2, "preState");
            return (Criteria) this;
        }

        public Criteria andPreStateNotBetween(Integer value1, Integer value2) {
            addCriterion("Pre_State not between", value1, value2, "preState");
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