package cn.neu.his.bean;

import java.util.ArrayList;
import java.util.List;

public class DetailpreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DetailpreExample() {
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

        public Criteria andDetialpreIdIsNull() {
            addCriterion("DetialPre_ID is null");
            return (Criteria) this;
        }

        public Criteria andDetialpreIdIsNotNull() {
            addCriterion("DetialPre_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDetialpreIdEqualTo(Integer value) {
            addCriterion("DetialPre_ID =", value, "detialpreId");
            return (Criteria) this;
        }

        public Criteria andDetialpreIdNotEqualTo(Integer value) {
            addCriterion("DetialPre_ID <>", value, "detialpreId");
            return (Criteria) this;
        }

        public Criteria andDetialpreIdGreaterThan(Integer value) {
            addCriterion("DetialPre_ID >", value, "detialpreId");
            return (Criteria) this;
        }

        public Criteria andDetialpreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DetialPre_ID >=", value, "detialpreId");
            return (Criteria) this;
        }

        public Criteria andDetialpreIdLessThan(Integer value) {
            addCriterion("DetialPre_ID <", value, "detialpreId");
            return (Criteria) this;
        }

        public Criteria andDetialpreIdLessThanOrEqualTo(Integer value) {
            addCriterion("DetialPre_ID <=", value, "detialpreId");
            return (Criteria) this;
        }

        public Criteria andDetialpreIdIn(List<Integer> values) {
            addCriterion("DetialPre_ID in", values, "detialpreId");
            return (Criteria) this;
        }

        public Criteria andDetialpreIdNotIn(List<Integer> values) {
            addCriterion("DetialPre_ID not in", values, "detialpreId");
            return (Criteria) this;
        }

        public Criteria andDetialpreIdBetween(Integer value1, Integer value2) {
            addCriterion("DetialPre_ID between", value1, value2, "detialpreId");
            return (Criteria) this;
        }

        public Criteria andDetialpreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DetialPre_ID not between", value1, value2, "detialpreId");
            return (Criteria) this;
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

        public Criteria andDrugsIdIsNull() {
            addCriterion("Drugs_ID is null");
            return (Criteria) this;
        }

        public Criteria andDrugsIdIsNotNull() {
            addCriterion("Drugs_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDrugsIdEqualTo(Integer value) {
            addCriterion("Drugs_ID =", value, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdNotEqualTo(Integer value) {
            addCriterion("Drugs_ID <>", value, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdGreaterThan(Integer value) {
            addCriterion("Drugs_ID >", value, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Drugs_ID >=", value, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdLessThan(Integer value) {
            addCriterion("Drugs_ID <", value, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdLessThanOrEqualTo(Integer value) {
            addCriterion("Drugs_ID <=", value, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdIn(List<Integer> values) {
            addCriterion("Drugs_ID in", values, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdNotIn(List<Integer> values) {
            addCriterion("Drugs_ID not in", values, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdBetween(Integer value1, Integer value2) {
            addCriterion("Drugs_ID between", value1, value2, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Drugs_ID not between", value1, value2, "drugsId");
            return (Criteria) this;
        }

        public Criteria andYongFaIsNull() {
            addCriterion("Yong_Fa is null");
            return (Criteria) this;
        }

        public Criteria andYongFaIsNotNull() {
            addCriterion("Yong_Fa is not null");
            return (Criteria) this;
        }

        public Criteria andYongFaEqualTo(String value) {
            addCriterion("Yong_Fa =", value, "yongFa");
            return (Criteria) this;
        }

        public Criteria andYongFaNotEqualTo(String value) {
            addCriterion("Yong_Fa <>", value, "yongFa");
            return (Criteria) this;
        }

        public Criteria andYongFaGreaterThan(String value) {
            addCriterion("Yong_Fa >", value, "yongFa");
            return (Criteria) this;
        }

        public Criteria andYongFaGreaterThanOrEqualTo(String value) {
            addCriterion("Yong_Fa >=", value, "yongFa");
            return (Criteria) this;
        }

        public Criteria andYongFaLessThan(String value) {
            addCriterion("Yong_Fa <", value, "yongFa");
            return (Criteria) this;
        }

        public Criteria andYongFaLessThanOrEqualTo(String value) {
            addCriterion("Yong_Fa <=", value, "yongFa");
            return (Criteria) this;
        }

        public Criteria andYongFaLike(String value) {
            addCriterion("Yong_Fa like", value, "yongFa");
            return (Criteria) this;
        }

        public Criteria andYongFaNotLike(String value) {
            addCriterion("Yong_Fa not like", value, "yongFa");
            return (Criteria) this;
        }

        public Criteria andYongFaIn(List<String> values) {
            addCriterion("Yong_Fa in", values, "yongFa");
            return (Criteria) this;
        }

        public Criteria andYongFaNotIn(List<String> values) {
            addCriterion("Yong_Fa not in", values, "yongFa");
            return (Criteria) this;
        }

        public Criteria andYongFaBetween(String value1, String value2) {
            addCriterion("Yong_Fa between", value1, value2, "yongFa");
            return (Criteria) this;
        }

        public Criteria andYongFaNotBetween(String value1, String value2) {
            addCriterion("Yong_Fa not between", value1, value2, "yongFa");
            return (Criteria) this;
        }

        public Criteria andYongLiangIsNull() {
            addCriterion("Yong_Liang is null");
            return (Criteria) this;
        }

        public Criteria andYongLiangIsNotNull() {
            addCriterion("Yong_Liang is not null");
            return (Criteria) this;
        }

        public Criteria andYongLiangEqualTo(String value) {
            addCriterion("Yong_Liang =", value, "yongLiang");
            return (Criteria) this;
        }

        public Criteria andYongLiangNotEqualTo(String value) {
            addCriterion("Yong_Liang <>", value, "yongLiang");
            return (Criteria) this;
        }

        public Criteria andYongLiangGreaterThan(String value) {
            addCriterion("Yong_Liang >", value, "yongLiang");
            return (Criteria) this;
        }

        public Criteria andYongLiangGreaterThanOrEqualTo(String value) {
            addCriterion("Yong_Liang >=", value, "yongLiang");
            return (Criteria) this;
        }

        public Criteria andYongLiangLessThan(String value) {
            addCriterion("Yong_Liang <", value, "yongLiang");
            return (Criteria) this;
        }

        public Criteria andYongLiangLessThanOrEqualTo(String value) {
            addCriterion("Yong_Liang <=", value, "yongLiang");
            return (Criteria) this;
        }

        public Criteria andYongLiangLike(String value) {
            addCriterion("Yong_Liang like", value, "yongLiang");
            return (Criteria) this;
        }

        public Criteria andYongLiangNotLike(String value) {
            addCriterion("Yong_Liang not like", value, "yongLiang");
            return (Criteria) this;
        }

        public Criteria andYongLiangIn(List<String> values) {
            addCriterion("Yong_Liang in", values, "yongLiang");
            return (Criteria) this;
        }

        public Criteria andYongLiangNotIn(List<String> values) {
            addCriterion("Yong_Liang not in", values, "yongLiang");
            return (Criteria) this;
        }

        public Criteria andYongLiangBetween(String value1, String value2) {
            addCriterion("Yong_Liang between", value1, value2, "yongLiang");
            return (Criteria) this;
        }

        public Criteria andYongLiangNotBetween(String value1, String value2) {
            addCriterion("Yong_Liang not between", value1, value2, "yongLiang");
            return (Criteria) this;
        }

        public Criteria andPinLvIsNull() {
            addCriterion("Pin_Lv is null");
            return (Criteria) this;
        }

        public Criteria andPinLvIsNotNull() {
            addCriterion("Pin_Lv is not null");
            return (Criteria) this;
        }

        public Criteria andPinLvEqualTo(String value) {
            addCriterion("Pin_Lv =", value, "pinLv");
            return (Criteria) this;
        }

        public Criteria andPinLvNotEqualTo(String value) {
            addCriterion("Pin_Lv <>", value, "pinLv");
            return (Criteria) this;
        }

        public Criteria andPinLvGreaterThan(String value) {
            addCriterion("Pin_Lv >", value, "pinLv");
            return (Criteria) this;
        }

        public Criteria andPinLvGreaterThanOrEqualTo(String value) {
            addCriterion("Pin_Lv >=", value, "pinLv");
            return (Criteria) this;
        }

        public Criteria andPinLvLessThan(String value) {
            addCriterion("Pin_Lv <", value, "pinLv");
            return (Criteria) this;
        }

        public Criteria andPinLvLessThanOrEqualTo(String value) {
            addCriterion("Pin_Lv <=", value, "pinLv");
            return (Criteria) this;
        }

        public Criteria andPinLvLike(String value) {
            addCriterion("Pin_Lv like", value, "pinLv");
            return (Criteria) this;
        }

        public Criteria andPinLvNotLike(String value) {
            addCriterion("Pin_Lv not like", value, "pinLv");
            return (Criteria) this;
        }

        public Criteria andPinLvIn(List<String> values) {
            addCriterion("Pin_Lv in", values, "pinLv");
            return (Criteria) this;
        }

        public Criteria andPinLvNotIn(List<String> values) {
            addCriterion("Pin_Lv not in", values, "pinLv");
            return (Criteria) this;
        }

        public Criteria andPinLvBetween(String value1, String value2) {
            addCriterion("Pin_Lv between", value1, value2, "pinLv");
            return (Criteria) this;
        }

        public Criteria andPinLvNotBetween(String value1, String value2) {
            addCriterion("Pin_Lv not between", value1, value2, "pinLv");
            return (Criteria) this;
        }

        public Criteria andDrugsNumIsNull() {
            addCriterion("Drugs_Num is null");
            return (Criteria) this;
        }

        public Criteria andDrugsNumIsNotNull() {
            addCriterion("Drugs_Num is not null");
            return (Criteria) this;
        }

        public Criteria andDrugsNumEqualTo(Integer value) {
            addCriterion("Drugs_Num =", value, "drugsNum");
            return (Criteria) this;
        }

        public Criteria andDrugsNumNotEqualTo(Integer value) {
            addCriterion("Drugs_Num <>", value, "drugsNum");
            return (Criteria) this;
        }

        public Criteria andDrugsNumGreaterThan(Integer value) {
            addCriterion("Drugs_Num >", value, "drugsNum");
            return (Criteria) this;
        }

        public Criteria andDrugsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("Drugs_Num >=", value, "drugsNum");
            return (Criteria) this;
        }

        public Criteria andDrugsNumLessThan(Integer value) {
            addCriterion("Drugs_Num <", value, "drugsNum");
            return (Criteria) this;
        }

        public Criteria andDrugsNumLessThanOrEqualTo(Integer value) {
            addCriterion("Drugs_Num <=", value, "drugsNum");
            return (Criteria) this;
        }

        public Criteria andDrugsNumIn(List<Integer> values) {
            addCriterion("Drugs_Num in", values, "drugsNum");
            return (Criteria) this;
        }

        public Criteria andDrugsNumNotIn(List<Integer> values) {
            addCriterion("Drugs_Num not in", values, "drugsNum");
            return (Criteria) this;
        }

        public Criteria andDrugsNumBetween(Integer value1, Integer value2) {
            addCriterion("Drugs_Num between", value1, value2, "drugsNum");
            return (Criteria) this;
        }

        public Criteria andDrugsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("Drugs_Num not between", value1, value2, "drugsNum");
            return (Criteria) this;
        }

        public Criteria andDetailpreStateIsNull() {
            addCriterion("DetailPre_State is null");
            return (Criteria) this;
        }

        public Criteria andDetailpreStateIsNotNull() {
            addCriterion("DetailPre_State is not null");
            return (Criteria) this;
        }

        public Criteria andDetailpreStateEqualTo(Integer value) {
            addCriterion("DetailPre_State =", value, "detailpreState");
            return (Criteria) this;
        }

        public Criteria andDetailpreStateNotEqualTo(Integer value) {
            addCriterion("DetailPre_State <>", value, "detailpreState");
            return (Criteria) this;
        }

        public Criteria andDetailpreStateGreaterThan(Integer value) {
            addCriterion("DetailPre_State >", value, "detailpreState");
            return (Criteria) this;
        }

        public Criteria andDetailpreStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("DetailPre_State >=", value, "detailpreState");
            return (Criteria) this;
        }

        public Criteria andDetailpreStateLessThan(Integer value) {
            addCriterion("DetailPre_State <", value, "detailpreState");
            return (Criteria) this;
        }

        public Criteria andDetailpreStateLessThanOrEqualTo(Integer value) {
            addCriterion("DetailPre_State <=", value, "detailpreState");
            return (Criteria) this;
        }

        public Criteria andDetailpreStateIn(List<Integer> values) {
            addCriterion("DetailPre_State in", values, "detailpreState");
            return (Criteria) this;
        }

        public Criteria andDetailpreStateNotIn(List<Integer> values) {
            addCriterion("DetailPre_State not in", values, "detailpreState");
            return (Criteria) this;
        }

        public Criteria andDetailpreStateBetween(Integer value1, Integer value2) {
            addCriterion("DetailPre_State between", value1, value2, "detailpreState");
            return (Criteria) this;
        }

        public Criteria andDetailpreStateNotBetween(Integer value1, Integer value2) {
            addCriterion("DetailPre_State not between", value1, value2, "detailpreState");
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