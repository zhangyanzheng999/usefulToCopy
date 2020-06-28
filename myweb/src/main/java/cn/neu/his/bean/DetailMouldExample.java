package cn.neu.his.bean;

import java.util.ArrayList;
import java.util.List;

public class DetailMouldExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DetailMouldExample() {
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

        public Criteria andReadyMouldDetailIdIsNull() {
            addCriterion("Ready_Mould_Detail_ID is null");
            return (Criteria) this;
        }

        public Criteria andReadyMouldDetailIdIsNotNull() {
            addCriterion("Ready_Mould_Detail_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReadyMouldDetailIdEqualTo(Integer value) {
            addCriterion("Ready_Mould_Detail_ID =", value, "readyMouldDetailId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldDetailIdNotEqualTo(Integer value) {
            addCriterion("Ready_Mould_Detail_ID <>", value, "readyMouldDetailId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldDetailIdGreaterThan(Integer value) {
            addCriterion("Ready_Mould_Detail_ID >", value, "readyMouldDetailId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Ready_Mould_Detail_ID >=", value, "readyMouldDetailId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldDetailIdLessThan(Integer value) {
            addCriterion("Ready_Mould_Detail_ID <", value, "readyMouldDetailId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("Ready_Mould_Detail_ID <=", value, "readyMouldDetailId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldDetailIdIn(List<Integer> values) {
            addCriterion("Ready_Mould_Detail_ID in", values, "readyMouldDetailId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldDetailIdNotIn(List<Integer> values) {
            addCriterion("Ready_Mould_Detail_ID not in", values, "readyMouldDetailId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("Ready_Mould_Detail_ID between", value1, value2, "readyMouldDetailId");
            return (Criteria) this;
        }

        public Criteria andReadyMouldDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Ready_Mould_Detail_ID not between", value1, value2, "readyMouldDetailId");
            return (Criteria) this;
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

        public Criteria andDrugIdIsNull() {
            addCriterion("Drug_ID is null");
            return (Criteria) this;
        }

        public Criteria andDrugIdIsNotNull() {
            addCriterion("Drug_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDrugIdEqualTo(Integer value) {
            addCriterion("Drug_ID =", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotEqualTo(Integer value) {
            addCriterion("Drug_ID <>", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdGreaterThan(Integer value) {
            addCriterion("Drug_ID >", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Drug_ID >=", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdLessThan(Integer value) {
            addCriterion("Drug_ID <", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdLessThanOrEqualTo(Integer value) {
            addCriterion("Drug_ID <=", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdIn(List<Integer> values) {
            addCriterion("Drug_ID in", values, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotIn(List<Integer> values) {
            addCriterion("Drug_ID not in", values, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdBetween(Integer value1, Integer value2) {
            addCriterion("Drug_ID between", value1, value2, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Drug_ID not between", value1, value2, "drugId");
            return (Criteria) this;
        }

        public Criteria andHowUseIsNull() {
            addCriterion("How_Use is null");
            return (Criteria) this;
        }

        public Criteria andHowUseIsNotNull() {
            addCriterion("How_Use is not null");
            return (Criteria) this;
        }

        public Criteria andHowUseEqualTo(String value) {
            addCriterion("How_Use =", value, "howUse");
            return (Criteria) this;
        }

        public Criteria andHowUseNotEqualTo(String value) {
            addCriterion("How_Use <>", value, "howUse");
            return (Criteria) this;
        }

        public Criteria andHowUseGreaterThan(String value) {
            addCriterion("How_Use >", value, "howUse");
            return (Criteria) this;
        }

        public Criteria andHowUseGreaterThanOrEqualTo(String value) {
            addCriterion("How_Use >=", value, "howUse");
            return (Criteria) this;
        }

        public Criteria andHowUseLessThan(String value) {
            addCriterion("How_Use <", value, "howUse");
            return (Criteria) this;
        }

        public Criteria andHowUseLessThanOrEqualTo(String value) {
            addCriterion("How_Use <=", value, "howUse");
            return (Criteria) this;
        }

        public Criteria andHowUseLike(String value) {
            addCriterion("How_Use like", value, "howUse");
            return (Criteria) this;
        }

        public Criteria andHowUseNotLike(String value) {
            addCriterion("How_Use not like", value, "howUse");
            return (Criteria) this;
        }

        public Criteria andHowUseIn(List<String> values) {
            addCriterion("How_Use in", values, "howUse");
            return (Criteria) this;
        }

        public Criteria andHowUseNotIn(List<String> values) {
            addCriterion("How_Use not in", values, "howUse");
            return (Criteria) this;
        }

        public Criteria andHowUseBetween(String value1, String value2) {
            addCriterion("How_Use between", value1, value2, "howUse");
            return (Criteria) this;
        }

        public Criteria andHowUseNotBetween(String value1, String value2) {
            addCriterion("How_Use not between", value1, value2, "howUse");
            return (Criteria) this;
        }

        public Criteria andHowMuchUseIsNull() {
            addCriterion("How_Much_Use is null");
            return (Criteria) this;
        }

        public Criteria andHowMuchUseIsNotNull() {
            addCriterion("How_Much_Use is not null");
            return (Criteria) this;
        }

        public Criteria andHowMuchUseEqualTo(String value) {
            addCriterion("How_Much_Use =", value, "howMuchUse");
            return (Criteria) this;
        }

        public Criteria andHowMuchUseNotEqualTo(String value) {
            addCriterion("How_Much_Use <>", value, "howMuchUse");
            return (Criteria) this;
        }

        public Criteria andHowMuchUseGreaterThan(String value) {
            addCriterion("How_Much_Use >", value, "howMuchUse");
            return (Criteria) this;
        }

        public Criteria andHowMuchUseGreaterThanOrEqualTo(String value) {
            addCriterion("How_Much_Use >=", value, "howMuchUse");
            return (Criteria) this;
        }

        public Criteria andHowMuchUseLessThan(String value) {
            addCriterion("How_Much_Use <", value, "howMuchUse");
            return (Criteria) this;
        }

        public Criteria andHowMuchUseLessThanOrEqualTo(String value) {
            addCriterion("How_Much_Use <=", value, "howMuchUse");
            return (Criteria) this;
        }

        public Criteria andHowMuchUseLike(String value) {
            addCriterion("How_Much_Use like", value, "howMuchUse");
            return (Criteria) this;
        }

        public Criteria andHowMuchUseNotLike(String value) {
            addCriterion("How_Much_Use not like", value, "howMuchUse");
            return (Criteria) this;
        }

        public Criteria andHowMuchUseIn(List<String> values) {
            addCriterion("How_Much_Use in", values, "howMuchUse");
            return (Criteria) this;
        }

        public Criteria andHowMuchUseNotIn(List<String> values) {
            addCriterion("How_Much_Use not in", values, "howMuchUse");
            return (Criteria) this;
        }

        public Criteria andHowMuchUseBetween(String value1, String value2) {
            addCriterion("How_Much_Use between", value1, value2, "howMuchUse");
            return (Criteria) this;
        }

        public Criteria andHowMuchUseNotBetween(String value1, String value2) {
            addCriterion("How_Much_Use not between", value1, value2, "howMuchUse");
            return (Criteria) this;
        }

        public Criteria andHowOfenUseIsNull() {
            addCriterion("How_Ofen_Use is null");
            return (Criteria) this;
        }

        public Criteria andHowOfenUseIsNotNull() {
            addCriterion("How_Ofen_Use is not null");
            return (Criteria) this;
        }

        public Criteria andHowOfenUseEqualTo(String value) {
            addCriterion("How_Ofen_Use =", value, "howOfenUse");
            return (Criteria) this;
        }

        public Criteria andHowOfenUseNotEqualTo(String value) {
            addCriterion("How_Ofen_Use <>", value, "howOfenUse");
            return (Criteria) this;
        }

        public Criteria andHowOfenUseGreaterThan(String value) {
            addCriterion("How_Ofen_Use >", value, "howOfenUse");
            return (Criteria) this;
        }

        public Criteria andHowOfenUseGreaterThanOrEqualTo(String value) {
            addCriterion("How_Ofen_Use >=", value, "howOfenUse");
            return (Criteria) this;
        }

        public Criteria andHowOfenUseLessThan(String value) {
            addCriterion("How_Ofen_Use <", value, "howOfenUse");
            return (Criteria) this;
        }

        public Criteria andHowOfenUseLessThanOrEqualTo(String value) {
            addCriterion("How_Ofen_Use <=", value, "howOfenUse");
            return (Criteria) this;
        }

        public Criteria andHowOfenUseLike(String value) {
            addCriterion("How_Ofen_Use like", value, "howOfenUse");
            return (Criteria) this;
        }

        public Criteria andHowOfenUseNotLike(String value) {
            addCriterion("How_Ofen_Use not like", value, "howOfenUse");
            return (Criteria) this;
        }

        public Criteria andHowOfenUseIn(List<String> values) {
            addCriterion("How_Ofen_Use in", values, "howOfenUse");
            return (Criteria) this;
        }

        public Criteria andHowOfenUseNotIn(List<String> values) {
            addCriterion("How_Ofen_Use not in", values, "howOfenUse");
            return (Criteria) this;
        }

        public Criteria andHowOfenUseBetween(String value1, String value2) {
            addCriterion("How_Ofen_Use between", value1, value2, "howOfenUse");
            return (Criteria) this;
        }

        public Criteria andHowOfenUseNotBetween(String value1, String value2) {
            addCriterion("How_Ofen_Use not between", value1, value2, "howOfenUse");
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