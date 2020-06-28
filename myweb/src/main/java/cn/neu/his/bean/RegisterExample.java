package cn.neu.his.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RegisterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegisterExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andMedrecordCodeIsNull() {
            addCriterion("MedRecord_Code is null");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeIsNotNull() {
            addCriterion("MedRecord_Code is not null");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeEqualTo(Integer value) {
            addCriterion("MedRecord_Code =", value, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeNotEqualTo(Integer value) {
            addCriterion("MedRecord_Code <>", value, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeGreaterThan(Integer value) {
            addCriterion("MedRecord_Code >", value, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("MedRecord_Code >=", value, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeLessThan(Integer value) {
            addCriterion("MedRecord_Code <", value, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeLessThanOrEqualTo(Integer value) {
            addCriterion("MedRecord_Code <=", value, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeIn(List<Integer> values) {
            addCriterion("MedRecord_Code in", values, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeNotIn(List<Integer> values) {
            addCriterion("MedRecord_Code not in", values, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeBetween(Integer value1, Integer value2) {
            addCriterion("MedRecord_Code between", value1, value2, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andMedrecordCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("MedRecord_Code not between", value1, value2, "medrecordCode");
            return (Criteria) this;
        }

        public Criteria andPatientNameIsNull() {
            addCriterion("Patient_Name is null");
            return (Criteria) this;
        }

        public Criteria andPatientNameIsNotNull() {
            addCriterion("Patient_Name is not null");
            return (Criteria) this;
        }

        public Criteria andPatientNameEqualTo(String value) {
            addCriterion("Patient_Name =", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotEqualTo(String value) {
            addCriterion("Patient_Name <>", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThan(String value) {
            addCriterion("Patient_Name >", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThanOrEqualTo(String value) {
            addCriterion("Patient_Name >=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThan(String value) {
            addCriterion("Patient_Name <", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThanOrEqualTo(String value) {
            addCriterion("Patient_Name <=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLike(String value) {
            addCriterion("Patient_Name like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotLike(String value) {
            addCriterion("Patient_Name not like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameIn(List<String> values) {
            addCriterion("Patient_Name in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotIn(List<String> values) {
            addCriterion("Patient_Name not in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameBetween(String value1, String value2) {
            addCriterion("Patient_Name between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotBetween(String value1, String value2) {
            addCriterion("Patient_Name not between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientSexIsNull() {
            addCriterion("Patient_Sex is null");
            return (Criteria) this;
        }

        public Criteria andPatientSexIsNotNull() {
            addCriterion("Patient_Sex is not null");
            return (Criteria) this;
        }

        public Criteria andPatientSexEqualTo(String value) {
            addCriterion("Patient_Sex =", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexNotEqualTo(String value) {
            addCriterion("Patient_Sex <>", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexGreaterThan(String value) {
            addCriterion("Patient_Sex >", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexGreaterThanOrEqualTo(String value) {
            addCriterion("Patient_Sex >=", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexLessThan(String value) {
            addCriterion("Patient_Sex <", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexLessThanOrEqualTo(String value) {
            addCriterion("Patient_Sex <=", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexLike(String value) {
            addCriterion("Patient_Sex like", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexNotLike(String value) {
            addCriterion("Patient_Sex not like", value, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexIn(List<String> values) {
            addCriterion("Patient_Sex in", values, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexNotIn(List<String> values) {
            addCriterion("Patient_Sex not in", values, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexBetween(String value1, String value2) {
            addCriterion("Patient_Sex between", value1, value2, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientSexNotBetween(String value1, String value2) {
            addCriterion("Patient_Sex not between", value1, value2, "patientSex");
            return (Criteria) this;
        }

        public Criteria andPatientIdcardIsNull() {
            addCriterion("Patient_IDCard is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdcardIsNotNull() {
            addCriterion("Patient_IDCard is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdcardEqualTo(String value) {
            addCriterion("Patient_IDCard =", value, "patientIdcard");
            return (Criteria) this;
        }

        public Criteria andPatientIdcardNotEqualTo(String value) {
            addCriterion("Patient_IDCard <>", value, "patientIdcard");
            return (Criteria) this;
        }

        public Criteria andPatientIdcardGreaterThan(String value) {
            addCriterion("Patient_IDCard >", value, "patientIdcard");
            return (Criteria) this;
        }

        public Criteria andPatientIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("Patient_IDCard >=", value, "patientIdcard");
            return (Criteria) this;
        }

        public Criteria andPatientIdcardLessThan(String value) {
            addCriterion("Patient_IDCard <", value, "patientIdcard");
            return (Criteria) this;
        }

        public Criteria andPatientIdcardLessThanOrEqualTo(String value) {
            addCriterion("Patient_IDCard <=", value, "patientIdcard");
            return (Criteria) this;
        }

        public Criteria andPatientIdcardLike(String value) {
            addCriterion("Patient_IDCard like", value, "patientIdcard");
            return (Criteria) this;
        }

        public Criteria andPatientIdcardNotLike(String value) {
            addCriterion("Patient_IDCard not like", value, "patientIdcard");
            return (Criteria) this;
        }

        public Criteria andPatientIdcardIn(List<String> values) {
            addCriterion("Patient_IDCard in", values, "patientIdcard");
            return (Criteria) this;
        }

        public Criteria andPatientIdcardNotIn(List<String> values) {
            addCriterion("Patient_IDCard not in", values, "patientIdcard");
            return (Criteria) this;
        }

        public Criteria andPatientIdcardBetween(String value1, String value2) {
            addCriterion("Patient_IDCard between", value1, value2, "patientIdcard");
            return (Criteria) this;
        }

        public Criteria andPatientIdcardNotBetween(String value1, String value2) {
            addCriterion("Patient_IDCard not between", value1, value2, "patientIdcard");
            return (Criteria) this;
        }

        public Criteria andPatientBirthIsNull() {
            addCriterion("Patient_Birth is null");
            return (Criteria) this;
        }

        public Criteria andPatientBirthIsNotNull() {
            addCriterion("Patient_Birth is not null");
            return (Criteria) this;
        }

        public Criteria andPatientBirthEqualTo(Date value) {
            addCriterionForJDBCDate("Patient_Birth =", value, "patientBirth");
            return (Criteria) this;
        }

        public Criteria andPatientBirthNotEqualTo(Date value) {
            addCriterionForJDBCDate("Patient_Birth <>", value, "patientBirth");
            return (Criteria) this;
        }

        public Criteria andPatientBirthGreaterThan(Date value) {
            addCriterionForJDBCDate("Patient_Birth >", value, "patientBirth");
            return (Criteria) this;
        }

        public Criteria andPatientBirthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Patient_Birth >=", value, "patientBirth");
            return (Criteria) this;
        }

        public Criteria andPatientBirthLessThan(Date value) {
            addCriterionForJDBCDate("Patient_Birth <", value, "patientBirth");
            return (Criteria) this;
        }

        public Criteria andPatientBirthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Patient_Birth <=", value, "patientBirth");
            return (Criteria) this;
        }

        public Criteria andPatientBirthIn(List<Date> values) {
            addCriterionForJDBCDate("Patient_Birth in", values, "patientBirth");
            return (Criteria) this;
        }

        public Criteria andPatientBirthNotIn(List<Date> values) {
            addCriterionForJDBCDate("Patient_Birth not in", values, "patientBirth");
            return (Criteria) this;
        }

        public Criteria andPatientBirthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Patient_Birth between", value1, value2, "patientBirth");
            return (Criteria) this;
        }

        public Criteria andPatientBirthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Patient_Birth not between", value1, value2, "patientBirth");
            return (Criteria) this;
        }

        public Criteria andPatientYearIsNull() {
            addCriterion("Patient_Year is null");
            return (Criteria) this;
        }

        public Criteria andPatientYearIsNotNull() {
            addCriterion("Patient_Year is not null");
            return (Criteria) this;
        }

        public Criteria andPatientYearEqualTo(Integer value) {
            addCriterion("Patient_Year =", value, "patientYear");
            return (Criteria) this;
        }

        public Criteria andPatientYearNotEqualTo(Integer value) {
            addCriterion("Patient_Year <>", value, "patientYear");
            return (Criteria) this;
        }

        public Criteria andPatientYearGreaterThan(Integer value) {
            addCriterion("Patient_Year >", value, "patientYear");
            return (Criteria) this;
        }

        public Criteria andPatientYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("Patient_Year >=", value, "patientYear");
            return (Criteria) this;
        }

        public Criteria andPatientYearLessThan(Integer value) {
            addCriterion("Patient_Year <", value, "patientYear");
            return (Criteria) this;
        }

        public Criteria andPatientYearLessThanOrEqualTo(Integer value) {
            addCriterion("Patient_Year <=", value, "patientYear");
            return (Criteria) this;
        }

        public Criteria andPatientYearIn(List<Integer> values) {
            addCriterion("Patient_Year in", values, "patientYear");
            return (Criteria) this;
        }

        public Criteria andPatientYearNotIn(List<Integer> values) {
            addCriterion("Patient_Year not in", values, "patientYear");
            return (Criteria) this;
        }

        public Criteria andPatientYearBetween(Integer value1, Integer value2) {
            addCriterion("Patient_Year between", value1, value2, "patientYear");
            return (Criteria) this;
        }

        public Criteria andPatientYearNotBetween(Integer value1, Integer value2) {
            addCriterion("Patient_Year not between", value1, value2, "patientYear");
            return (Criteria) this;
        }

        public Criteria andPatientYearTypeIsNull() {
            addCriterion("Patient_Year_Type is null");
            return (Criteria) this;
        }

        public Criteria andPatientYearTypeIsNotNull() {
            addCriterion("Patient_Year_Type is not null");
            return (Criteria) this;
        }

        public Criteria andPatientYearTypeEqualTo(String value) {
            addCriterion("Patient_Year_Type =", value, "patientYearType");
            return (Criteria) this;
        }

        public Criteria andPatientYearTypeNotEqualTo(String value) {
            addCriterion("Patient_Year_Type <>", value, "patientYearType");
            return (Criteria) this;
        }

        public Criteria andPatientYearTypeGreaterThan(String value) {
            addCriterion("Patient_Year_Type >", value, "patientYearType");
            return (Criteria) this;
        }

        public Criteria andPatientYearTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Patient_Year_Type >=", value, "patientYearType");
            return (Criteria) this;
        }

        public Criteria andPatientYearTypeLessThan(String value) {
            addCriterion("Patient_Year_Type <", value, "patientYearType");
            return (Criteria) this;
        }

        public Criteria andPatientYearTypeLessThanOrEqualTo(String value) {
            addCriterion("Patient_Year_Type <=", value, "patientYearType");
            return (Criteria) this;
        }

        public Criteria andPatientYearTypeLike(String value) {
            addCriterion("Patient_Year_Type like", value, "patientYearType");
            return (Criteria) this;
        }

        public Criteria andPatientYearTypeNotLike(String value) {
            addCriterion("Patient_Year_Type not like", value, "patientYearType");
            return (Criteria) this;
        }

        public Criteria andPatientYearTypeIn(List<String> values) {
            addCriterion("Patient_Year_Type in", values, "patientYearType");
            return (Criteria) this;
        }

        public Criteria andPatientYearTypeNotIn(List<String> values) {
            addCriterion("Patient_Year_Type not in", values, "patientYearType");
            return (Criteria) this;
        }

        public Criteria andPatientYearTypeBetween(String value1, String value2) {
            addCriterion("Patient_Year_Type between", value1, value2, "patientYearType");
            return (Criteria) this;
        }

        public Criteria andPatientYearTypeNotBetween(String value1, String value2) {
            addCriterion("Patient_Year_Type not between", value1, value2, "patientYearType");
            return (Criteria) this;
        }

        public Criteria andPatientAddressIsNull() {
            addCriterion("Patient_Address is null");
            return (Criteria) this;
        }

        public Criteria andPatientAddressIsNotNull() {
            addCriterion("Patient_Address is not null");
            return (Criteria) this;
        }

        public Criteria andPatientAddressEqualTo(String value) {
            addCriterion("Patient_Address =", value, "patientAddress");
            return (Criteria) this;
        }

        public Criteria andPatientAddressNotEqualTo(String value) {
            addCriterion("Patient_Address <>", value, "patientAddress");
            return (Criteria) this;
        }

        public Criteria andPatientAddressGreaterThan(String value) {
            addCriterion("Patient_Address >", value, "patientAddress");
            return (Criteria) this;
        }

        public Criteria andPatientAddressGreaterThanOrEqualTo(String value) {
            addCriterion("Patient_Address >=", value, "patientAddress");
            return (Criteria) this;
        }

        public Criteria andPatientAddressLessThan(String value) {
            addCriterion("Patient_Address <", value, "patientAddress");
            return (Criteria) this;
        }

        public Criteria andPatientAddressLessThanOrEqualTo(String value) {
            addCriterion("Patient_Address <=", value, "patientAddress");
            return (Criteria) this;
        }

        public Criteria andPatientAddressLike(String value) {
            addCriterion("Patient_Address like", value, "patientAddress");
            return (Criteria) this;
        }

        public Criteria andPatientAddressNotLike(String value) {
            addCriterion("Patient_Address not like", value, "patientAddress");
            return (Criteria) this;
        }

        public Criteria andPatientAddressIn(List<String> values) {
            addCriterion("Patient_Address in", values, "patientAddress");
            return (Criteria) this;
        }

        public Criteria andPatientAddressNotIn(List<String> values) {
            addCriterion("Patient_Address not in", values, "patientAddress");
            return (Criteria) this;
        }

        public Criteria andPatientAddressBetween(String value1, String value2) {
            addCriterion("Patient_Address between", value1, value2, "patientAddress");
            return (Criteria) this;
        }

        public Criteria andPatientAddressNotBetween(String value1, String value2) {
            addCriterion("Patient_Address not between", value1, value2, "patientAddress");
            return (Criteria) this;
        }

        public Criteria andThisVisitDateIsNull() {
            addCriterion("This_Visit_Date is null");
            return (Criteria) this;
        }

        public Criteria andThisVisitDateIsNotNull() {
            addCriterion("This_Visit_Date is not null");
            return (Criteria) this;
        }

        public Criteria andThisVisitDateEqualTo(Date value) {
            addCriterionForJDBCDate("This_Visit_Date =", value, "thisVisitDate");
            return (Criteria) this;
        }

        public Criteria andThisVisitDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("This_Visit_Date <>", value, "thisVisitDate");
            return (Criteria) this;
        }

        public Criteria andThisVisitDateGreaterThan(Date value) {
            addCriterionForJDBCDate("This_Visit_Date >", value, "thisVisitDate");
            return (Criteria) this;
        }

        public Criteria andThisVisitDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("This_Visit_Date >=", value, "thisVisitDate");
            return (Criteria) this;
        }

        public Criteria andThisVisitDateLessThan(Date value) {
            addCriterionForJDBCDate("This_Visit_Date <", value, "thisVisitDate");
            return (Criteria) this;
        }

        public Criteria andThisVisitDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("This_Visit_Date <=", value, "thisVisitDate");
            return (Criteria) this;
        }

        public Criteria andThisVisitDateIn(List<Date> values) {
            addCriterionForJDBCDate("This_Visit_Date in", values, "thisVisitDate");
            return (Criteria) this;
        }

        public Criteria andThisVisitDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("This_Visit_Date not in", values, "thisVisitDate");
            return (Criteria) this;
        }

        public Criteria andThisVisitDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("This_Visit_Date between", value1, value2, "thisVisitDate");
            return (Criteria) this;
        }

        public Criteria andThisVisitDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("This_Visit_Date not between", value1, value2, "thisVisitDate");
            return (Criteria) this;
        }

        public Criteria andNoonBreakIsNull() {
            addCriterion("Noon_Break is null");
            return (Criteria) this;
        }

        public Criteria andNoonBreakIsNotNull() {
            addCriterion("Noon_Break is not null");
            return (Criteria) this;
        }

        public Criteria andNoonBreakEqualTo(String value) {
            addCriterion("Noon_Break =", value, "noonBreak");
            return (Criteria) this;
        }

        public Criteria andNoonBreakNotEqualTo(String value) {
            addCriterion("Noon_Break <>", value, "noonBreak");
            return (Criteria) this;
        }

        public Criteria andNoonBreakGreaterThan(String value) {
            addCriterion("Noon_Break >", value, "noonBreak");
            return (Criteria) this;
        }

        public Criteria andNoonBreakGreaterThanOrEqualTo(String value) {
            addCriterion("Noon_Break >=", value, "noonBreak");
            return (Criteria) this;
        }

        public Criteria andNoonBreakLessThan(String value) {
            addCriterion("Noon_Break <", value, "noonBreak");
            return (Criteria) this;
        }

        public Criteria andNoonBreakLessThanOrEqualTo(String value) {
            addCriterion("Noon_Break <=", value, "noonBreak");
            return (Criteria) this;
        }

        public Criteria andNoonBreakLike(String value) {
            addCriterion("Noon_Break like", value, "noonBreak");
            return (Criteria) this;
        }

        public Criteria andNoonBreakNotLike(String value) {
            addCriterion("Noon_Break not like", value, "noonBreak");
            return (Criteria) this;
        }

        public Criteria andNoonBreakIn(List<String> values) {
            addCriterion("Noon_Break in", values, "noonBreak");
            return (Criteria) this;
        }

        public Criteria andNoonBreakNotIn(List<String> values) {
            addCriterion("Noon_Break not in", values, "noonBreak");
            return (Criteria) this;
        }

        public Criteria andNoonBreakBetween(String value1, String value2) {
            addCriterion("Noon_Break between", value1, value2, "noonBreak");
            return (Criteria) this;
        }

        public Criteria andNoonBreakNotBetween(String value1, String value2) {
            addCriterion("Noon_Break not between", value1, value2, "noonBreak");
            return (Criteria) this;
        }

        public Criteria andRegisterDeptIdIsNull() {
            addCriterion("Register_Dept_ID is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDeptIdIsNotNull() {
            addCriterion("Register_Dept_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDeptIdEqualTo(Integer value) {
            addCriterion("Register_Dept_ID =", value, "registerDeptId");
            return (Criteria) this;
        }

        public Criteria andRegisterDeptIdNotEqualTo(Integer value) {
            addCriterion("Register_Dept_ID <>", value, "registerDeptId");
            return (Criteria) this;
        }

        public Criteria andRegisterDeptIdGreaterThan(Integer value) {
            addCriterion("Register_Dept_ID >", value, "registerDeptId");
            return (Criteria) this;
        }

        public Criteria andRegisterDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Register_Dept_ID >=", value, "registerDeptId");
            return (Criteria) this;
        }

        public Criteria andRegisterDeptIdLessThan(Integer value) {
            addCriterion("Register_Dept_ID <", value, "registerDeptId");
            return (Criteria) this;
        }

        public Criteria andRegisterDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("Register_Dept_ID <=", value, "registerDeptId");
            return (Criteria) this;
        }

        public Criteria andRegisterDeptIdIn(List<Integer> values) {
            addCriterion("Register_Dept_ID in", values, "registerDeptId");
            return (Criteria) this;
        }

        public Criteria andRegisterDeptIdNotIn(List<Integer> values) {
            addCriterion("Register_Dept_ID not in", values, "registerDeptId");
            return (Criteria) this;
        }

        public Criteria andRegisterDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("Register_Dept_ID between", value1, value2, "registerDeptId");
            return (Criteria) this;
        }

        public Criteria andRegisterDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Register_Dept_ID not between", value1, value2, "registerDeptId");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorIdIsNull() {
            addCriterion("Register_Doctor_ID is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorIdIsNotNull() {
            addCriterion("Register_Doctor_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorIdEqualTo(Integer value) {
            addCriterion("Register_Doctor_ID =", value, "registerDoctorId");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorIdNotEqualTo(Integer value) {
            addCriterion("Register_Doctor_ID <>", value, "registerDoctorId");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorIdGreaterThan(Integer value) {
            addCriterion("Register_Doctor_ID >", value, "registerDoctorId");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Register_Doctor_ID >=", value, "registerDoctorId");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorIdLessThan(Integer value) {
            addCriterion("Register_Doctor_ID <", value, "registerDoctorId");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorIdLessThanOrEqualTo(Integer value) {
            addCriterion("Register_Doctor_ID <=", value, "registerDoctorId");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorIdIn(List<Integer> values) {
            addCriterion("Register_Doctor_ID in", values, "registerDoctorId");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorIdNotIn(List<Integer> values) {
            addCriterion("Register_Doctor_ID not in", values, "registerDoctorId");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorIdBetween(Integer value1, Integer value2) {
            addCriterion("Register_Doctor_ID between", value1, value2, "registerDoctorId");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Register_Doctor_ID not between", value1, value2, "registerDoctorId");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeIsNull() {
            addCriterion("Register_Type is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeIsNotNull() {
            addCriterion("Register_Type is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeEqualTo(Integer value) {
            addCriterion("Register_Type =", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeNotEqualTo(Integer value) {
            addCriterion("Register_Type <>", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeGreaterThan(Integer value) {
            addCriterion("Register_Type >", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Register_Type >=", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeLessThan(Integer value) {
            addCriterion("Register_Type <", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Register_Type <=", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeIn(List<Integer> values) {
            addCriterion("Register_Type in", values, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeNotIn(List<Integer> values) {
            addCriterion("Register_Type not in", values, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeBetween(Integer value1, Integer value2) {
            addCriterion("Register_Type between", value1, value2, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Register_Type not between", value1, value2, "registerType");
            return (Criteria) this;
        }

        public Criteria andFinalTypeIdIsNull() {
            addCriterion("Final_Type_ID is null");
            return (Criteria) this;
        }

        public Criteria andFinalTypeIdIsNotNull() {
            addCriterion("Final_Type_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFinalTypeIdEqualTo(Integer value) {
            addCriterion("Final_Type_ID =", value, "finalTypeId");
            return (Criteria) this;
        }

        public Criteria andFinalTypeIdNotEqualTo(Integer value) {
            addCriterion("Final_Type_ID <>", value, "finalTypeId");
            return (Criteria) this;
        }

        public Criteria andFinalTypeIdGreaterThan(Integer value) {
            addCriterion("Final_Type_ID >", value, "finalTypeId");
            return (Criteria) this;
        }

        public Criteria andFinalTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Final_Type_ID >=", value, "finalTypeId");
            return (Criteria) this;
        }

        public Criteria andFinalTypeIdLessThan(Integer value) {
            addCriterion("Final_Type_ID <", value, "finalTypeId");
            return (Criteria) this;
        }

        public Criteria andFinalTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("Final_Type_ID <=", value, "finalTypeId");
            return (Criteria) this;
        }

        public Criteria andFinalTypeIdIn(List<Integer> values) {
            addCriterion("Final_Type_ID in", values, "finalTypeId");
            return (Criteria) this;
        }

        public Criteria andFinalTypeIdNotIn(List<Integer> values) {
            addCriterion("Final_Type_ID not in", values, "finalTypeId");
            return (Criteria) this;
        }

        public Criteria andFinalTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("Final_Type_ID between", value1, value2, "finalTypeId");
            return (Criteria) this;
        }

        public Criteria andFinalTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Final_Type_ID not between", value1, value2, "finalTypeId");
            return (Criteria) this;
        }

        public Criteria andMedrecordBookIsNull() {
            addCriterion("MedRecord_Book is null");
            return (Criteria) this;
        }

        public Criteria andMedrecordBookIsNotNull() {
            addCriterion("MedRecord_Book is not null");
            return (Criteria) this;
        }

        public Criteria andMedrecordBookEqualTo(Integer value) {
            addCriterion("MedRecord_Book =", value, "medrecordBook");
            return (Criteria) this;
        }

        public Criteria andMedrecordBookNotEqualTo(Integer value) {
            addCriterion("MedRecord_Book <>", value, "medrecordBook");
            return (Criteria) this;
        }

        public Criteria andMedrecordBookGreaterThan(Integer value) {
            addCriterion("MedRecord_Book >", value, "medrecordBook");
            return (Criteria) this;
        }

        public Criteria andMedrecordBookGreaterThanOrEqualTo(Integer value) {
            addCriterion("MedRecord_Book >=", value, "medrecordBook");
            return (Criteria) this;
        }

        public Criteria andMedrecordBookLessThan(Integer value) {
            addCriterion("MedRecord_Book <", value, "medrecordBook");
            return (Criteria) this;
        }

        public Criteria andMedrecordBookLessThanOrEqualTo(Integer value) {
            addCriterion("MedRecord_Book <=", value, "medrecordBook");
            return (Criteria) this;
        }

        public Criteria andMedrecordBookIn(List<Integer> values) {
            addCriterion("MedRecord_Book in", values, "medrecordBook");
            return (Criteria) this;
        }

        public Criteria andMedrecordBookNotIn(List<Integer> values) {
            addCriterion("MedRecord_Book not in", values, "medrecordBook");
            return (Criteria) this;
        }

        public Criteria andMedrecordBookBetween(Integer value1, Integer value2) {
            addCriterion("MedRecord_Book between", value1, value2, "medrecordBook");
            return (Criteria) this;
        }

        public Criteria andMedrecordBookNotBetween(Integer value1, Integer value2) {
            addCriterion("MedRecord_Book not between", value1, value2, "medrecordBook");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNull() {
            addCriterion("Register_Time is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNotNull() {
            addCriterion("Register_Time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeEqualTo(Date value) {
            addCriterion("Register_Time =", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotEqualTo(Date value) {
            addCriterion("Register_Time <>", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThan(Date value) {
            addCriterion("Register_Time >", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Register_Time >=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThan(Date value) {
            addCriterion("Register_Time <", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("Register_Time <=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIn(List<Date> values) {
            addCriterion("Register_Time in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotIn(List<Date> values) {
            addCriterion("Register_Time not in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("Register_Time between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("Register_Time not between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterPersonIdIsNull() {
            addCriterion("Register_Person_ID is null");
            return (Criteria) this;
        }

        public Criteria andRegisterPersonIdIsNotNull() {
            addCriterion("Register_Person_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterPersonIdEqualTo(Integer value) {
            addCriterion("Register_Person_ID =", value, "registerPersonId");
            return (Criteria) this;
        }

        public Criteria andRegisterPersonIdNotEqualTo(Integer value) {
            addCriterion("Register_Person_ID <>", value, "registerPersonId");
            return (Criteria) this;
        }

        public Criteria andRegisterPersonIdGreaterThan(Integer value) {
            addCriterion("Register_Person_ID >", value, "registerPersonId");
            return (Criteria) this;
        }

        public Criteria andRegisterPersonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Register_Person_ID >=", value, "registerPersonId");
            return (Criteria) this;
        }

        public Criteria andRegisterPersonIdLessThan(Integer value) {
            addCriterion("Register_Person_ID <", value, "registerPersonId");
            return (Criteria) this;
        }

        public Criteria andRegisterPersonIdLessThanOrEqualTo(Integer value) {
            addCriterion("Register_Person_ID <=", value, "registerPersonId");
            return (Criteria) this;
        }

        public Criteria andRegisterPersonIdIn(List<Integer> values) {
            addCriterion("Register_Person_ID in", values, "registerPersonId");
            return (Criteria) this;
        }

        public Criteria andRegisterPersonIdNotIn(List<Integer> values) {
            addCriterion("Register_Person_ID not in", values, "registerPersonId");
            return (Criteria) this;
        }

        public Criteria andRegisterPersonIdBetween(Integer value1, Integer value2) {
            addCriterion("Register_Person_ID between", value1, value2, "registerPersonId");
            return (Criteria) this;
        }

        public Criteria andRegisterPersonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Register_Person_ID not between", value1, value2, "registerPersonId");
            return (Criteria) this;
        }

        public Criteria andThisVisitStateIsNull() {
            addCriterion("This_Visit_State is null");
            return (Criteria) this;
        }

        public Criteria andThisVisitStateIsNotNull() {
            addCriterion("This_Visit_State is not null");
            return (Criteria) this;
        }

        public Criteria andThisVisitStateEqualTo(Integer value) {
            addCriterion("This_Visit_State =", value, "thisVisitState");
            return (Criteria) this;
        }

        public Criteria andThisVisitStateNotEqualTo(Integer value) {
            addCriterion("This_Visit_State <>", value, "thisVisitState");
            return (Criteria) this;
        }

        public Criteria andThisVisitStateGreaterThan(Integer value) {
            addCriterion("This_Visit_State >", value, "thisVisitState");
            return (Criteria) this;
        }

        public Criteria andThisVisitStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("This_Visit_State >=", value, "thisVisitState");
            return (Criteria) this;
        }

        public Criteria andThisVisitStateLessThan(Integer value) {
            addCriterion("This_Visit_State <", value, "thisVisitState");
            return (Criteria) this;
        }

        public Criteria andThisVisitStateLessThanOrEqualTo(Integer value) {
            addCriterion("This_Visit_State <=", value, "thisVisitState");
            return (Criteria) this;
        }

        public Criteria andThisVisitStateIn(List<Integer> values) {
            addCriterion("This_Visit_State in", values, "thisVisitState");
            return (Criteria) this;
        }

        public Criteria andThisVisitStateNotIn(List<Integer> values) {
            addCriterion("This_Visit_State not in", values, "thisVisitState");
            return (Criteria) this;
        }

        public Criteria andThisVisitStateBetween(Integer value1, Integer value2) {
            addCriterion("This_Visit_State between", value1, value2, "thisVisitState");
            return (Criteria) this;
        }

        public Criteria andThisVisitStateNotBetween(Integer value1, Integer value2) {
            addCriterion("This_Visit_State not between", value1, value2, "thisVisitState");
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