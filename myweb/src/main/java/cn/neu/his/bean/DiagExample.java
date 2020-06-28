package cn.neu.his.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DiagExample() {
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

        public Criteria andDiagIdIsNull() {
            addCriterion("Diag_ID is null");
            return (Criteria) this;
        }

        public Criteria andDiagIdIsNotNull() {
            addCriterion("Diag_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDiagIdEqualTo(Integer value) {
            addCriterion("Diag_ID =", value, "diagId");
            return (Criteria) this;
        }

        public Criteria andDiagIdNotEqualTo(Integer value) {
            addCriterion("Diag_ID <>", value, "diagId");
            return (Criteria) this;
        }

        public Criteria andDiagIdGreaterThan(Integer value) {
            addCriterion("Diag_ID >", value, "diagId");
            return (Criteria) this;
        }

        public Criteria andDiagIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Diag_ID >=", value, "diagId");
            return (Criteria) this;
        }

        public Criteria andDiagIdLessThan(Integer value) {
            addCriterion("Diag_ID <", value, "diagId");
            return (Criteria) this;
        }

        public Criteria andDiagIdLessThanOrEqualTo(Integer value) {
            addCriterion("Diag_ID <=", value, "diagId");
            return (Criteria) this;
        }

        public Criteria andDiagIdIn(List<Integer> values) {
            addCriterion("Diag_ID in", values, "diagId");
            return (Criteria) this;
        }

        public Criteria andDiagIdNotIn(List<Integer> values) {
            addCriterion("Diag_ID not in", values, "diagId");
            return (Criteria) this;
        }

        public Criteria andDiagIdBetween(Integer value1, Integer value2) {
            addCriterion("Diag_ID between", value1, value2, "diagId");
            return (Criteria) this;
        }

        public Criteria andDiagIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Diag_ID not between", value1, value2, "diagId");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeIsNull() {
            addCriterion("Medrecord_Code is null");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeIsNotNull() {
            addCriterion("Medrecord_Code is not null");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeEqualTo(Integer value) {
            addCriterion("Medrecord_Code =", value, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeNotEqualTo(Integer value) {
            addCriterion("Medrecord_Code <>", value, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeGreaterThan(Integer value) {
            addCriterion("Medrecord_Code >", value, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Medrecord_Code >=", value, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeLessThan(Integer value) {
            addCriterion("Medrecord_Code <", value, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeLessThanOrEqualTo(Integer value) {
            addCriterion("Medrecord_Code <=", value, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeIn(List<Integer> values) {
            addCriterion("Medrecord_Code in", values, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeNotIn(List<Integer> values) {
            addCriterion("Medrecord_Code not in", values, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeBetween(Integer value1, Integer value2) {
            addCriterion("Medrecord_Code between", value1, value2, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("Medrecord_Code not between", value1, value2, "medrecordCode");
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

        public Criteria andDiseaseIdIsNull() {
            addCriterion("Disease_ID is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIsNotNull() {
            addCriterion("Disease_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdEqualTo(Integer value) {
            addCriterion("Disease_ID =", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotEqualTo(Integer value) {
            addCriterion("Disease_ID <>", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThan(Integer value) {
            addCriterion("Disease_ID >", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Disease_ID >=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThan(Integer value) {
            addCriterion("Disease_ID <", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("Disease_ID <=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIn(List<Integer> values) {
            addCriterion("Disease_ID in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotIn(List<Integer> values) {
            addCriterion("Disease_ID not in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdBetween(Integer value1, Integer value2) {
            addCriterion("Disease_ID between", value1, value2, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Disease_ID not between", value1, value2, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiagTypeIsNull() {
            addCriterion("Diag_Type is null");
            return (Criteria) this;
        }

        public Criteria andDiagTypeIsNotNull() {
            addCriterion("Diag_Type is not null");
            return (Criteria) this;
        }

        public Criteria andDiagTypeEqualTo(Integer value) {
            addCriterion("Diag_Type =", value, "diagType");
            return (Criteria) this;
        }

        public Criteria andDiagTypeNotEqualTo(Integer value) {
            addCriterion("Diag_Type <>", value, "diagType");
            return (Criteria) this;
        }

        public Criteria andDiagTypeGreaterThan(Integer value) {
            addCriterion("Diag_Type >", value, "diagType");
            return (Criteria) this;
        }

        public Criteria andDiagTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Diag_Type >=", value, "diagType");
            return (Criteria) this;
        }

        public Criteria andDiagTypeLessThan(Integer value) {
            addCriterion("Diag_Type <", value, "diagType");
            return (Criteria) this;
        }

        public Criteria andDiagTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Diag_Type <=", value, "diagType");
            return (Criteria) this;
        }

        public Criteria andDiagTypeIn(List<Integer> values) {
            addCriterion("Diag_Type in", values, "diagType");
            return (Criteria) this;
        }

        public Criteria andDiagTypeNotIn(List<Integer> values) {
            addCriterion("Diag_Type not in", values, "diagType");
            return (Criteria) this;
        }

        public Criteria andDiagTypeBetween(Integer value1, Integer value2) {
            addCriterion("Diag_Type between", value1, value2, "diagType");
            return (Criteria) this;
        }

        public Criteria andDiagTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Diag_Type not between", value1, value2, "diagType");
            return (Criteria) this;
        }

        public Criteria andOnsetTimeIsNull() {
            addCriterion("Onset_Time is null");
            return (Criteria) this;
        }

        public Criteria andOnsetTimeIsNotNull() {
            addCriterion("Onset_Time is not null");
            return (Criteria) this;
        }

        public Criteria andOnsetTimeEqualTo(Date value) {
            addCriterion("Onset_Time =", value, "onsetTime");
            return (Criteria) this;
        }

        public Criteria andOnsetTimeNotEqualTo(Date value) {
            addCriterion("Onset_Time <>", value, "onsetTime");
            return (Criteria) this;
        }

        public Criteria andOnsetTimeGreaterThan(Date value) {
            addCriterion("Onset_Time >", value, "onsetTime");
            return (Criteria) this;
        }

        public Criteria andOnsetTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Onset_Time >=", value, "onsetTime");
            return (Criteria) this;
        }

        public Criteria andOnsetTimeLessThan(Date value) {
            addCriterion("Onset_Time <", value, "onsetTime");
            return (Criteria) this;
        }

        public Criteria andOnsetTimeLessThanOrEqualTo(Date value) {
            addCriterion("Onset_Time <=", value, "onsetTime");
            return (Criteria) this;
        }

        public Criteria andOnsetTimeIn(List<Date> values) {
            addCriterion("Onset_Time in", values, "onsetTime");
            return (Criteria) this;
        }

        public Criteria andOnsetTimeNotIn(List<Date> values) {
            addCriterion("Onset_Time not in", values, "onsetTime");
            return (Criteria) this;
        }

        public Criteria andOnsetTimeBetween(Date value1, Date value2) {
            addCriterion("Onset_Time between", value1, value2, "onsetTime");
            return (Criteria) this;
        }

        public Criteria andOnsetTimeNotBetween(Date value1, Date value2) {
            addCriterion("Onset_Time not between", value1, value2, "onsetTime");
            return (Criteria) this;
        }

        public Criteria andChuZhongIsNull() {
            addCriterion("Chu_Zhong is null");
            return (Criteria) this;
        }

        public Criteria andChuZhongIsNotNull() {
            addCriterion("Chu_Zhong is not null");
            return (Criteria) this;
        }

        public Criteria andChuZhongEqualTo(Integer value) {
            addCriterion("Chu_Zhong =", value, "chuZhong");
            return (Criteria) this;
        }

        public Criteria andChuZhongNotEqualTo(Integer value) {
            addCriterion("Chu_Zhong <>", value, "chuZhong");
            return (Criteria) this;
        }

        public Criteria andChuZhongGreaterThan(Integer value) {
            addCriterion("Chu_Zhong >", value, "chuZhong");
            return (Criteria) this;
        }

        public Criteria andChuZhongGreaterThanOrEqualTo(Integer value) {
            addCriterion("Chu_Zhong >=", value, "chuZhong");
            return (Criteria) this;
        }

        public Criteria andChuZhongLessThan(Integer value) {
            addCriterion("Chu_Zhong <", value, "chuZhong");
            return (Criteria) this;
        }

        public Criteria andChuZhongLessThanOrEqualTo(Integer value) {
            addCriterion("Chu_Zhong <=", value, "chuZhong");
            return (Criteria) this;
        }

        public Criteria andChuZhongIn(List<Integer> values) {
            addCriterion("Chu_Zhong in", values, "chuZhong");
            return (Criteria) this;
        }

        public Criteria andChuZhongNotIn(List<Integer> values) {
            addCriterion("Chu_Zhong not in", values, "chuZhong");
            return (Criteria) this;
        }

        public Criteria andChuZhongBetween(Integer value1, Integer value2) {
            addCriterion("Chu_Zhong between", value1, value2, "chuZhong");
            return (Criteria) this;
        }

        public Criteria andChuZhongNotBetween(Integer value1, Integer value2) {
            addCriterion("Chu_Zhong not between", value1, value2, "chuZhong");
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