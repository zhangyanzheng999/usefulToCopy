package cn.neu.his.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MouldExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MouldExample() {
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

        public Criteria andReadyMouldIdIsNull() {
            addCriterion("Ready_Mould_ID is null");
            return (Criteria) this;
        }

        public Criteria andReadyMouldIdIsNotNull() {
            addCriterion("Ready_Mould_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReadyMouldIdEqualTo(Integer value) {
            addCriterion("Ready_Mould_ID =", value, "readyMouldId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldIdNotEqualTo(Integer value) {
            addCriterion("Ready_Mould_ID <>", value, "readyMouldId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldIdGreaterThan(Integer value) {
            addCriterion("Ready_Mould_ID >", value, "readyMouldId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Ready_Mould_ID >=", value, "readyMouldId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldIdLessThan(Integer value) {
            addCriterion("Ready_Mould_ID <", value, "readyMouldId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldIdLessThanOrEqualTo(Integer value) {
            addCriterion("Ready_Mould_ID <=", value, "readyMouldId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldIdIn(List<Integer> values) {
            addCriterion("Ready_Mould_ID in", values, "readyMouldId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldIdNotIn(List<Integer> values) {
            addCriterion("Ready_Mould_ID not in", values, "readyMouldId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldIdBetween(Integer value1, Integer value2) {
            addCriterion("Ready_Mould_ID between", value1, value2, "readyMouldId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Ready_Mould_ID not between", value1, value2, "readyMouldId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldNameIsNull() {
            addCriterion("Ready_Mould_Name is null");
            return (Criteria) this;
        }

        public Criteria andReadyMouldNameIsNotNull() {
            addCriterion("Ready_Mould_Name is not null");
            return (Criteria) this;
        }

        public Criteria andReadyMouldNameEqualTo(String value) {
            addCriterion("Ready_Mould_Name =", value, "readyMouldName");
            return (Criteria) this;
        }

        public Criteria andReadyMouldNameNotEqualTo(String value) {
            addCriterion("Ready_Mould_Name <>", value, "readyMouldName");
            return (Criteria) this;
        }

        public Criteria andReadyMouldNameGreaterThan(String value) {
            addCriterion("Ready_Mould_Name >", value, "readyMouldName");
            return (Criteria) this;
        }

        public Criteria andReadyMouldNameGreaterThanOrEqualTo(String value) {
            addCriterion("Ready_Mould_Name >=", value, "readyMouldName");
            return (Criteria) this;
        }

        public Criteria andReadyMouldNameLessThan(String value) {
            addCriterion("Ready_Mould_Name <", value, "readyMouldName");
            return (Criteria) this;
        }

        public Criteria andReadyMouldNameLessThanOrEqualTo(String value) {
            addCriterion("Ready_Mould_Name <=", value, "readyMouldName");
            return (Criteria) this;
        }

        public Criteria andReadyMouldNameLike(String value) {
            addCriterion("Ready_Mould_Name like", value, "readyMouldName");
            return (Criteria) this;
        }

        public Criteria andReadyMouldNameNotLike(String value) {
            addCriterion("Ready_Mould_Name not like", value, "readyMouldName");
            return (Criteria) this;
        }

        public Criteria andReadyMouldNameIn(List<String> values) {
            addCriterion("Ready_Mould_Name in", values, "readyMouldName");
            return (Criteria) this;
        }

        public Criteria andReadyMouldNameNotIn(List<String> values) {
            addCriterion("Ready_Mould_Name not in", values, "readyMouldName");
            return (Criteria) this;
        }

        public Criteria andReadyMouldNameBetween(String value1, String value2) {
            addCriterion("Ready_Mould_Name between", value1, value2, "readyMouldName");
            return (Criteria) this;
        }

        public Criteria andReadyMouldNameNotBetween(String value1, String value2) {
            addCriterion("Ready_Mould_Name not between", value1, value2, "readyMouldName");
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

        public Criteria andCreatTimeIsNull() {
            addCriterion("Creat_Time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("Creat_Time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("Creat_Time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("Creat_Time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("Creat_Time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Creat_Time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("Creat_Time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("Creat_Time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("Creat_Time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("Creat_Time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("Creat_Time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("Creat_Time not between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andUseRangeIsNull() {
            addCriterion("Use_Range is null");
            return (Criteria) this;
        }

        public Criteria andUseRangeIsNotNull() {
            addCriterion("Use_Range is not null");
            return (Criteria) this;
        }

        public Criteria andUseRangeEqualTo(Integer value) {
            addCriterion("Use_Range =", value, "useRange");
            return (Criteria) this;
        }

        public Criteria andUseRangeNotEqualTo(Integer value) {
            addCriterion("Use_Range <>", value, "useRange");
            return (Criteria) this;
        }

        public Criteria andUseRangeGreaterThan(Integer value) {
            addCriterion("Use_Range >", value, "useRange");
            return (Criteria) this;
        }

        public Criteria andUseRangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Use_Range >=", value, "useRange");
            return (Criteria) this;
        }

        public Criteria andUseRangeLessThan(Integer value) {
            addCriterion("Use_Range <", value, "useRange");
            return (Criteria) this;
        }

        public Criteria andUseRangeLessThanOrEqualTo(Integer value) {
            addCriterion("Use_Range <=", value, "useRange");
            return (Criteria) this;
        }

        public Criteria andUseRangeIn(List<Integer> values) {
            addCriterion("Use_Range in", values, "useRange");
            return (Criteria) this;
        }

        public Criteria andUseRangeNotIn(List<Integer> values) {
            addCriterion("Use_Range not in", values, "useRange");
            return (Criteria) this;
        }

        public Criteria andUseRangeBetween(Integer value1, Integer value2) {
            addCriterion("Use_Range between", value1, value2, "useRange");
            return (Criteria) this;
        }

        public Criteria andUseRangeNotBetween(Integer value1, Integer value2) {
            addCriterion("Use_Range not between", value1, value2, "useRange");
            return (Criteria) this;
        }

        public Criteria andRemoveSignIsNull() {
            addCriterion("Remove_Sign is null");
            return (Criteria) this;
        }

        public Criteria andRemoveSignIsNotNull() {
            addCriterion("Remove_Sign is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveSignEqualTo(Integer value) {
            addCriterion("Remove_Sign =", value, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignNotEqualTo(Integer value) {
            addCriterion("Remove_Sign <>", value, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignGreaterThan(Integer value) {
            addCriterion("Remove_Sign >", value, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignGreaterThanOrEqualTo(Integer value) {
            addCriterion("Remove_Sign >=", value, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignLessThan(Integer value) {
            addCriterion("Remove_Sign <", value, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignLessThanOrEqualTo(Integer value) {
            addCriterion("Remove_Sign <=", value, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignIn(List<Integer> values) {
            addCriterion("Remove_Sign in", values, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignNotIn(List<Integer> values) {
            addCriterion("Remove_Sign not in", values, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignBetween(Integer value1, Integer value2) {
            addCriterion("Remove_Sign between", value1, value2, "removeSign");
            return (Criteria) this;
        }

        public Criteria andRemoveSignNotBetween(Integer value1, Integer value2) {
            addCriterion("Remove_Sign not between", value1, value2, "removeSign");
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