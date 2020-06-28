package cn.neu.his.bean;

import java.util.ArrayList;
import java.util.List;

public class RegTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegTypeExample() {
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

        public Criteria andRegTypeIdIsNull() {
            addCriterion("Reg_Type_ID is null");
            return (Criteria) this;
        }

        public Criteria andRegTypeIdIsNotNull() {
            addCriterion("Reg_Type_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRegTypeIdEqualTo(Integer value) {
            addCriterion("Reg_Type_ID =", value, "regTypeId");
            return (Criteria) this;
        }

        public Criteria andRegTypeIdNotEqualTo(Integer value) {
            addCriterion("Reg_Type_ID <>", value, "regTypeId");
            return (Criteria) this;
        }

        public Criteria andRegTypeIdGreaterThan(Integer value) {
            addCriterion("Reg_Type_ID >", value, "regTypeId");
            return (Criteria) this;
        }

        public Criteria andRegTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Reg_Type_ID >=", value, "regTypeId");
            return (Criteria) this;
        }

        public Criteria andRegTypeIdLessThan(Integer value) {
            addCriterion("Reg_Type_ID <", value, "regTypeId");
            return (Criteria) this;
        }

        public Criteria andRegTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("Reg_Type_ID <=", value, "regTypeId");
            return (Criteria) this;
        }

        public Criteria andRegTypeIdIn(List<Integer> values) {
            addCriterion("Reg_Type_ID in", values, "regTypeId");
            return (Criteria) this;
        }

        public Criteria andRegTypeIdNotIn(List<Integer> values) {
            addCriterion("Reg_Type_ID not in", values, "regTypeId");
            return (Criteria) this;
        }

        public Criteria andRegTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("Reg_Type_ID between", value1, value2, "regTypeId");
            return (Criteria) this;
        }

        public Criteria andRegTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Reg_Type_ID not between", value1, value2, "regTypeId");
            return (Criteria) this;
        }

        public Criteria andRegTypeCodeIsNull() {
            addCriterion("Reg_Type_Code is null");
            return (Criteria) this;
        }

        public Criteria andRegTypeCodeIsNotNull() {
            addCriterion("Reg_Type_Code is not null");
            return (Criteria) this;
        }

        public Criteria andRegTypeCodeEqualTo(String value) {
            addCriterion("Reg_Type_Code =", value, "regTypeCode");
            return (Criteria) this;
        }

        public Criteria andRegTypeCodeNotEqualTo(String value) {
            addCriterion("Reg_Type_Code <>", value, "regTypeCode");
            return (Criteria) this;
        }

        public Criteria andRegTypeCodeGreaterThan(String value) {
            addCriterion("Reg_Type_Code >", value, "regTypeCode");
            return (Criteria) this;
        }

        public Criteria andRegTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Reg_Type_Code >=", value, "regTypeCode");
            return (Criteria) this;
        }

        public Criteria andRegTypeCodeLessThan(String value) {
            addCriterion("Reg_Type_Code <", value, "regTypeCode");
            return (Criteria) this;
        }

        public Criteria andRegTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("Reg_Type_Code <=", value, "regTypeCode");
            return (Criteria) this;
        }

        public Criteria andRegTypeCodeLike(String value) {
            addCriterion("Reg_Type_Code like", value, "regTypeCode");
            return (Criteria) this;
        }

        public Criteria andRegTypeCodeNotLike(String value) {
            addCriterion("Reg_Type_Code not like", value, "regTypeCode");
            return (Criteria) this;
        }

        public Criteria andRegTypeCodeIn(List<String> values) {
            addCriterion("Reg_Type_Code in", values, "regTypeCode");
            return (Criteria) this;
        }

        public Criteria andRegTypeCodeNotIn(List<String> values) {
            addCriterion("Reg_Type_Code not in", values, "regTypeCode");
            return (Criteria) this;
        }

        public Criteria andRegTypeCodeBetween(String value1, String value2) {
            addCriterion("Reg_Type_Code between", value1, value2, "regTypeCode");
            return (Criteria) this;
        }

        public Criteria andRegTypeCodeNotBetween(String value1, String value2) {
            addCriterion("Reg_Type_Code not between", value1, value2, "regTypeCode");
            return (Criteria) this;
        }

        public Criteria andRegTypeNameIsNull() {
            addCriterion("Reg_Type_Name is null");
            return (Criteria) this;
        }

        public Criteria andRegTypeNameIsNotNull() {
            addCriterion("Reg_Type_Name is not null");
            return (Criteria) this;
        }

        public Criteria andRegTypeNameEqualTo(String value) {
            addCriterion("Reg_Type_Name =", value, "regTypeName");
            return (Criteria) this;
        }

        public Criteria andRegTypeNameNotEqualTo(String value) {
            addCriterion("Reg_Type_Name <>", value, "regTypeName");
            return (Criteria) this;
        }

        public Criteria andRegTypeNameGreaterThan(String value) {
            addCriterion("Reg_Type_Name >", value, "regTypeName");
            return (Criteria) this;
        }

        public Criteria andRegTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("Reg_Type_Name >=", value, "regTypeName");
            return (Criteria) this;
        }

        public Criteria andRegTypeNameLessThan(String value) {
            addCriterion("Reg_Type_Name <", value, "regTypeName");
            return (Criteria) this;
        }

        public Criteria andRegTypeNameLessThanOrEqualTo(String value) {
            addCriterion("Reg_Type_Name <=", value, "regTypeName");
            return (Criteria) this;
        }

        public Criteria andRegTypeNameLike(String value) {
            addCriterion("Reg_Type_Name like", value, "regTypeName");
            return (Criteria) this;
        }

        public Criteria andRegTypeNameNotLike(String value) {
            addCriterion("Reg_Type_Name not like", value, "regTypeName");
            return (Criteria) this;
        }

        public Criteria andRegTypeNameIn(List<String> values) {
            addCriterion("Reg_Type_Name in", values, "regTypeName");
            return (Criteria) this;
        }

        public Criteria andRegTypeNameNotIn(List<String> values) {
            addCriterion("Reg_Type_Name not in", values, "regTypeName");
            return (Criteria) this;
        }

        public Criteria andRegTypeNameBetween(String value1, String value2) {
            addCriterion("Reg_Type_Name between", value1, value2, "regTypeName");
            return (Criteria) this;
        }

        public Criteria andRegTypeNameNotBetween(String value1, String value2) {
            addCriterion("Reg_Type_Name not between", value1, value2, "regTypeName");
            return (Criteria) this;
        }

        public Criteria andRegShunxuIsNull() {
            addCriterion("Reg_Shunxu is null");
            return (Criteria) this;
        }

        public Criteria andRegShunxuIsNotNull() {
            addCriterion("Reg_Shunxu is not null");
            return (Criteria) this;
        }

        public Criteria andRegShunxuEqualTo(Integer value) {
            addCriterion("Reg_Shunxu =", value, "regShunxu");
            return (Criteria) this;
        }

        public Criteria andRegShunxuNotEqualTo(Integer value) {
            addCriterion("Reg_Shunxu <>", value, "regShunxu");
            return (Criteria) this;
        }

        public Criteria andRegShunxuGreaterThan(Integer value) {
            addCriterion("Reg_Shunxu >", value, "regShunxu");
            return (Criteria) this;
        }

        public Criteria andRegShunxuGreaterThanOrEqualTo(Integer value) {
            addCriterion("Reg_Shunxu >=", value, "regShunxu");
            return (Criteria) this;
        }

        public Criteria andRegShunxuLessThan(Integer value) {
            addCriterion("Reg_Shunxu <", value, "regShunxu");
            return (Criteria) this;
        }

        public Criteria andRegShunxuLessThanOrEqualTo(Integer value) {
            addCriterion("Reg_Shunxu <=", value, "regShunxu");
            return (Criteria) this;
        }

        public Criteria andRegShunxuIn(List<Integer> values) {
            addCriterion("Reg_Shunxu in", values, "regShunxu");
            return (Criteria) this;
        }

        public Criteria andRegShunxuNotIn(List<Integer> values) {
            addCriterion("Reg_Shunxu not in", values, "regShunxu");
            return (Criteria) this;
        }

        public Criteria andRegShunxuBetween(Integer value1, Integer value2) {
            addCriterion("Reg_Shunxu between", value1, value2, "regShunxu");
            return (Criteria) this;
        }

        public Criteria andRegShunxuNotBetween(Integer value1, Integer value2) {
            addCriterion("Reg_Shunxu not between", value1, value2, "regShunxu");
            return (Criteria) this;
        }

        public Criteria andRegCostIsNull() {
            addCriterion("Reg_Cost is null");
            return (Criteria) this;
        }

        public Criteria andRegCostIsNotNull() {
            addCriterion("Reg_Cost is not null");
            return (Criteria) this;
        }

        public Criteria andRegCostEqualTo(Float value) {
            addCriterion("Reg_Cost =", value, "regCost");
            return (Criteria) this;
        }

        public Criteria andRegCostNotEqualTo(Float value) {
            addCriterion("Reg_Cost <>", value, "regCost");
            return (Criteria) this;
        }

        public Criteria andRegCostGreaterThan(Float value) {
            addCriterion("Reg_Cost >", value, "regCost");
            return (Criteria) this;
        }

        public Criteria andRegCostGreaterThanOrEqualTo(Float value) {
            addCriterion("Reg_Cost >=", value, "regCost");
            return (Criteria) this;
        }

        public Criteria andRegCostLessThan(Float value) {
            addCriterion("Reg_Cost <", value, "regCost");
            return (Criteria) this;
        }

        public Criteria andRegCostLessThanOrEqualTo(Float value) {
            addCriterion("Reg_Cost <=", value, "regCost");
            return (Criteria) this;
        }

        public Criteria andRegCostIn(List<Float> values) {
            addCriterion("Reg_Cost in", values, "regCost");
            return (Criteria) this;
        }

        public Criteria andRegCostNotIn(List<Float> values) {
            addCriterion("Reg_Cost not in", values, "regCost");
            return (Criteria) this;
        }

        public Criteria andRegCostBetween(Float value1, Float value2) {
            addCriterion("Reg_Cost between", value1, value2, "regCost");
            return (Criteria) this;
        }

        public Criteria andRegCostNotBetween(Float value1, Float value2) {
            addCriterion("Reg_Cost not between", value1, value2, "regCost");
            return (Criteria) this;
        }

        public Criteria andRegLimitnumIsNull() {
            addCriterion("Reg_LimitNum is null");
            return (Criteria) this;
        }

        public Criteria andRegLimitnumIsNotNull() {
            addCriterion("Reg_LimitNum is not null");
            return (Criteria) this;
        }

        public Criteria andRegLimitnumEqualTo(Integer value) {
            addCriterion("Reg_LimitNum =", value, "regLimitnum");
            return (Criteria) this;
        }

        public Criteria andRegLimitnumNotEqualTo(Integer value) {
            addCriterion("Reg_LimitNum <>", value, "regLimitnum");
            return (Criteria) this;
        }

        public Criteria andRegLimitnumGreaterThan(Integer value) {
            addCriterion("Reg_LimitNum >", value, "regLimitnum");
            return (Criteria) this;
        }

        public Criteria andRegLimitnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("Reg_LimitNum >=", value, "regLimitnum");
            return (Criteria) this;
        }

        public Criteria andRegLimitnumLessThan(Integer value) {
            addCriterion("Reg_LimitNum <", value, "regLimitnum");
            return (Criteria) this;
        }

        public Criteria andRegLimitnumLessThanOrEqualTo(Integer value) {
            addCriterion("Reg_LimitNum <=", value, "regLimitnum");
            return (Criteria) this;
        }

        public Criteria andRegLimitnumIn(List<Integer> values) {
            addCriterion("Reg_LimitNum in", values, "regLimitnum");
            return (Criteria) this;
        }

        public Criteria andRegLimitnumNotIn(List<Integer> values) {
            addCriterion("Reg_LimitNum not in", values, "regLimitnum");
            return (Criteria) this;
        }

        public Criteria andRegLimitnumBetween(Integer value1, Integer value2) {
            addCriterion("Reg_LimitNum between", value1, value2, "regLimitnum");
            return (Criteria) this;
        }

        public Criteria andRegLimitnumNotBetween(Integer value1, Integer value2) {
            addCriterion("Reg_LimitNum not between", value1, value2, "regLimitnum");
            return (Criteria) this;
        }

        public Criteria andReomveSignIsNull() {
            addCriterion("Reomve_Sign is null");
            return (Criteria) this;
        }

        public Criteria andReomveSignIsNotNull() {
            addCriterion("Reomve_Sign is not null");
            return (Criteria) this;
        }

        public Criteria andReomveSignEqualTo(Integer value) {
            addCriterion("Reomve_Sign =", value, "reomveSign");
            return (Criteria) this;
        }

        public Criteria andReomveSignNotEqualTo(Integer value) {
            addCriterion("Reomve_Sign <>", value, "reomveSign");
            return (Criteria) this;
        }

        public Criteria andReomveSignGreaterThan(Integer value) {
            addCriterion("Reomve_Sign >", value, "reomveSign");
            return (Criteria) this;
        }

        public Criteria andReomveSignGreaterThanOrEqualTo(Integer value) {
            addCriterion("Reomve_Sign >=", value, "reomveSign");
            return (Criteria) this;
        }

        public Criteria andReomveSignLessThan(Integer value) {
            addCriterion("Reomve_Sign <", value, "reomveSign");
            return (Criteria) this;
        }

        public Criteria andReomveSignLessThanOrEqualTo(Integer value) {
            addCriterion("Reomve_Sign <=", value, "reomveSign");
            return (Criteria) this;
        }

        public Criteria andReomveSignIn(List<Integer> values) {
            addCriterion("Reomve_Sign in", values, "reomveSign");
            return (Criteria) this;
        }

        public Criteria andReomveSignNotIn(List<Integer> values) {
            addCriterion("Reomve_Sign not in", values, "reomveSign");
            return (Criteria) this;
        }

        public Criteria andReomveSignBetween(Integer value1, Integer value2) {
            addCriterion("Reomve_Sign between", value1, value2, "reomveSign");
            return (Criteria) this;
        }

        public Criteria andReomveSignNotBetween(Integer value1, Integer value2) {
            addCriterion("Reomve_Sign not between", value1, value2, "reomveSign");
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