package cn.neu.his.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DrugExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugExample() {
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

        public Criteria andDrugsCodeIsNull() {
            addCriterion("Drugs_Code is null");
            return (Criteria) this;
        }

        public Criteria andDrugsCodeIsNotNull() {
            addCriterion("Drugs_Code is not null");
            return (Criteria) this;
        }

        public Criteria andDrugsCodeEqualTo(String value) {
            addCriterion("Drugs_Code =", value, "drugsCode");
            return (Criteria) this;
        }

        public Criteria andDrugsCodeNotEqualTo(String value) {
            addCriterion("Drugs_Code <>", value, "drugsCode");
            return (Criteria) this;
        }

        public Criteria andDrugsCodeGreaterThan(String value) {
            addCriterion("Drugs_Code >", value, "drugsCode");
            return (Criteria) this;
        }

        public Criteria andDrugsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Drugs_Code >=", value, "drugsCode");
            return (Criteria) this;
        }

        public Criteria andDrugsCodeLessThan(String value) {
            addCriterion("Drugs_Code <", value, "drugsCode");
            return (Criteria) this;
        }

        public Criteria andDrugsCodeLessThanOrEqualTo(String value) {
            addCriterion("Drugs_Code <=", value, "drugsCode");
            return (Criteria) this;
        }

        public Criteria andDrugsCodeLike(String value) {
            addCriterion("Drugs_Code like", value, "drugsCode");
            return (Criteria) this;
        }

        public Criteria andDrugsCodeNotLike(String value) {
            addCriterion("Drugs_Code not like", value, "drugsCode");
            return (Criteria) this;
        }

        public Criteria andDrugsCodeIn(List<String> values) {
            addCriterion("Drugs_Code in", values, "drugsCode");
            return (Criteria) this;
        }

        public Criteria andDrugsCodeNotIn(List<String> values) {
            addCriterion("Drugs_Code not in", values, "drugsCode");
            return (Criteria) this;
        }

        public Criteria andDrugsCodeBetween(String value1, String value2) {
            addCriterion("Drugs_Code between", value1, value2, "drugsCode");
            return (Criteria) this;
        }

        public Criteria andDrugsCodeNotBetween(String value1, String value2) {
            addCriterion("Drugs_Code not between", value1, value2, "drugsCode");
            return (Criteria) this;
        }

        public Criteria andDrugsNameIsNull() {
            addCriterion("Drugs_Name is null");
            return (Criteria) this;
        }

        public Criteria andDrugsNameIsNotNull() {
            addCriterion("Drugs_Name is not null");
            return (Criteria) this;
        }

        public Criteria andDrugsNameEqualTo(String value) {
            addCriterion("Drugs_Name =", value, "drugsName");
            return (Criteria) this;
        }

        public Criteria andDrugsNameNotEqualTo(String value) {
            addCriterion("Drugs_Name <>", value, "drugsName");
            return (Criteria) this;
        }

        public Criteria andDrugsNameGreaterThan(String value) {
            addCriterion("Drugs_Name >", value, "drugsName");
            return (Criteria) this;
        }

        public Criteria andDrugsNameGreaterThanOrEqualTo(String value) {
            addCriterion("Drugs_Name >=", value, "drugsName");
            return (Criteria) this;
        }

        public Criteria andDrugsNameLessThan(String value) {
            addCriterion("Drugs_Name <", value, "drugsName");
            return (Criteria) this;
        }

        public Criteria andDrugsNameLessThanOrEqualTo(String value) {
            addCriterion("Drugs_Name <=", value, "drugsName");
            return (Criteria) this;
        }

        public Criteria andDrugsNameLike(String value) {
            addCriterion("Drugs_Name like", value, "drugsName");
            return (Criteria) this;
        }

        public Criteria andDrugsNameNotLike(String value) {
            addCriterion("Drugs_Name not like", value, "drugsName");
            return (Criteria) this;
        }

        public Criteria andDrugsNameIn(List<String> values) {
            addCriterion("Drugs_Name in", values, "drugsName");
            return (Criteria) this;
        }

        public Criteria andDrugsNameNotIn(List<String> values) {
            addCriterion("Drugs_Name not in", values, "drugsName");
            return (Criteria) this;
        }

        public Criteria andDrugsNameBetween(String value1, String value2) {
            addCriterion("Drugs_Name between", value1, value2, "drugsName");
            return (Criteria) this;
        }

        public Criteria andDrugsNameNotBetween(String value1, String value2) {
            addCriterion("Drugs_Name not between", value1, value2, "drugsName");
            return (Criteria) this;
        }

        public Criteria andDrugsFormatIsNull() {
            addCriterion("Drugs_Format is null");
            return (Criteria) this;
        }

        public Criteria andDrugsFormatIsNotNull() {
            addCriterion("Drugs_Format is not null");
            return (Criteria) this;
        }

        public Criteria andDrugsFormatEqualTo(String value) {
            addCriterion("Drugs_Format =", value, "drugsFormat");
            return (Criteria) this;
        }

        public Criteria andDrugsFormatNotEqualTo(String value) {
            addCriterion("Drugs_Format <>", value, "drugsFormat");
            return (Criteria) this;
        }

        public Criteria andDrugsFormatGreaterThan(String value) {
            addCriterion("Drugs_Format >", value, "drugsFormat");
            return (Criteria) this;
        }

        public Criteria andDrugsFormatGreaterThanOrEqualTo(String value) {
            addCriterion("Drugs_Format >=", value, "drugsFormat");
            return (Criteria) this;
        }

        public Criteria andDrugsFormatLessThan(String value) {
            addCriterion("Drugs_Format <", value, "drugsFormat");
            return (Criteria) this;
        }

        public Criteria andDrugsFormatLessThanOrEqualTo(String value) {
            addCriterion("Drugs_Format <=", value, "drugsFormat");
            return (Criteria) this;
        }

        public Criteria andDrugsFormatLike(String value) {
            addCriterion("Drugs_Format like", value, "drugsFormat");
            return (Criteria) this;
        }

        public Criteria andDrugsFormatNotLike(String value) {
            addCriterion("Drugs_Format not like", value, "drugsFormat");
            return (Criteria) this;
        }

        public Criteria andDrugsFormatIn(List<String> values) {
            addCriterion("Drugs_Format in", values, "drugsFormat");
            return (Criteria) this;
        }

        public Criteria andDrugsFormatNotIn(List<String> values) {
            addCriterion("Drugs_Format not in", values, "drugsFormat");
            return (Criteria) this;
        }

        public Criteria andDrugsFormatBetween(String value1, String value2) {
            addCriterion("Drugs_Format between", value1, value2, "drugsFormat");
            return (Criteria) this;
        }

        public Criteria andDrugsFormatNotBetween(String value1, String value2) {
            addCriterion("Drugs_Format not between", value1, value2, "drugsFormat");
            return (Criteria) this;
        }

        public Criteria andDrugsUnitIsNull() {
            addCriterion("Drugs_Unit is null");
            return (Criteria) this;
        }

        public Criteria andDrugsUnitIsNotNull() {
            addCriterion("Drugs_Unit is not null");
            return (Criteria) this;
        }

        public Criteria andDrugsUnitEqualTo(String value) {
            addCriterion("Drugs_Unit =", value, "drugsUnit");
            return (Criteria) this;
        }

        public Criteria andDrugsUnitNotEqualTo(String value) {
            addCriterion("Drugs_Unit <>", value, "drugsUnit");
            return (Criteria) this;
        }

        public Criteria andDrugsUnitGreaterThan(String value) {
            addCriterion("Drugs_Unit >", value, "drugsUnit");
            return (Criteria) this;
        }

        public Criteria andDrugsUnitGreaterThanOrEqualTo(String value) {
            addCriterion("Drugs_Unit >=", value, "drugsUnit");
            return (Criteria) this;
        }

        public Criteria andDrugsUnitLessThan(String value) {
            addCriterion("Drugs_Unit <", value, "drugsUnit");
            return (Criteria) this;
        }

        public Criteria andDrugsUnitLessThanOrEqualTo(String value) {
            addCriterion("Drugs_Unit <=", value, "drugsUnit");
            return (Criteria) this;
        }

        public Criteria andDrugsUnitLike(String value) {
            addCriterion("Drugs_Unit like", value, "drugsUnit");
            return (Criteria) this;
        }

        public Criteria andDrugsUnitNotLike(String value) {
            addCriterion("Drugs_Unit not like", value, "drugsUnit");
            return (Criteria) this;
        }

        public Criteria andDrugsUnitIn(List<String> values) {
            addCriterion("Drugs_Unit in", values, "drugsUnit");
            return (Criteria) this;
        }

        public Criteria andDrugsUnitNotIn(List<String> values) {
            addCriterion("Drugs_Unit not in", values, "drugsUnit");
            return (Criteria) this;
        }

        public Criteria andDrugsUnitBetween(String value1, String value2) {
            addCriterion("Drugs_Unit between", value1, value2, "drugsUnit");
            return (Criteria) this;
        }

        public Criteria andDrugsUnitNotBetween(String value1, String value2) {
            addCriterion("Drugs_Unit not between", value1, value2, "drugsUnit");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("Manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("Manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("Manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("Manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("Manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("Manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("Manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("Manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("Manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("Manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("Manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("Manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("Manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("Manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andDrugsDosageIdIsNull() {
            addCriterion("Drugs_Dosage_ID is null");
            return (Criteria) this;
        }

        public Criteria andDrugsDosageIdIsNotNull() {
            addCriterion("Drugs_Dosage_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDrugsDosageIdEqualTo(Integer value) {
            addCriterion("Drugs_Dosage_ID =", value, "drugsDosageId");
            return (Criteria) this;
        }

        public Criteria andDrugsDosageIdNotEqualTo(Integer value) {
            addCriterion("Drugs_Dosage_ID <>", value, "drugsDosageId");
            return (Criteria) this;
        }

        public Criteria andDrugsDosageIdGreaterThan(Integer value) {
            addCriterion("Drugs_Dosage_ID >", value, "drugsDosageId");
            return (Criteria) this;
        }

        public Criteria andDrugsDosageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Drugs_Dosage_ID >=", value, "drugsDosageId");
            return (Criteria) this;
        }

        public Criteria andDrugsDosageIdLessThan(Integer value) {
            addCriterion("Drugs_Dosage_ID <", value, "drugsDosageId");
            return (Criteria) this;
        }

        public Criteria andDrugsDosageIdLessThanOrEqualTo(Integer value) {
            addCriterion("Drugs_Dosage_ID <=", value, "drugsDosageId");
            return (Criteria) this;
        }

        public Criteria andDrugsDosageIdIn(List<Integer> values) {
            addCriterion("Drugs_Dosage_ID in", values, "drugsDosageId");
            return (Criteria) this;
        }

        public Criteria andDrugsDosageIdNotIn(List<Integer> values) {
            addCriterion("Drugs_Dosage_ID not in", values, "drugsDosageId");
            return (Criteria) this;
        }

        public Criteria andDrugsDosageIdBetween(Integer value1, Integer value2) {
            addCriterion("Drugs_Dosage_ID between", value1, value2, "drugsDosageId");
            return (Criteria) this;
        }

        public Criteria andDrugsDosageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Drugs_Dosage_ID not between", value1, value2, "drugsDosageId");
            return (Criteria) this;
        }

        public Criteria andDrugsTypeIdIsNull() {
            addCriterion("Drugs_Type_ID is null");
            return (Criteria) this;
        }

        public Criteria andDrugsTypeIdIsNotNull() {
            addCriterion("Drugs_Type_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDrugsTypeIdEqualTo(Integer value) {
            addCriterion("Drugs_Type_ID =", value, "drugsTypeId");
            return (Criteria) this;
        }

        public Criteria andDrugsTypeIdNotEqualTo(Integer value) {
            addCriterion("Drugs_Type_ID <>", value, "drugsTypeId");
            return (Criteria) this;
        }

        public Criteria andDrugsTypeIdGreaterThan(Integer value) {
            addCriterion("Drugs_Type_ID >", value, "drugsTypeId");
            return (Criteria) this;
        }

        public Criteria andDrugsTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Drugs_Type_ID >=", value, "drugsTypeId");
            return (Criteria) this;
        }

        public Criteria andDrugsTypeIdLessThan(Integer value) {
            addCriterion("Drugs_Type_ID <", value, "drugsTypeId");
            return (Criteria) this;
        }

        public Criteria andDrugsTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("Drugs_Type_ID <=", value, "drugsTypeId");
            return (Criteria) this;
        }

        public Criteria andDrugsTypeIdIn(List<Integer> values) {
            addCriterion("Drugs_Type_ID in", values, "drugsTypeId");
            return (Criteria) this;
        }

        public Criteria andDrugsTypeIdNotIn(List<Integer> values) {
            addCriterion("Drugs_Type_ID not in", values, "drugsTypeId");
            return (Criteria) this;
        }

        public Criteria andDrugsTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("Drugs_Type_ID between", value1, value2, "drugsTypeId");
            return (Criteria) this;
        }

        public Criteria andDrugsTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Drugs_Type_ID not between", value1, value2, "drugsTypeId");
            return (Criteria) this;
        }

        public Criteria andDrugsPriceIsNull() {
            addCriterion("Drugs_Price is null");
            return (Criteria) this;
        }

        public Criteria andDrugsPriceIsNotNull() {
            addCriterion("Drugs_Price is not null");
            return (Criteria) this;
        }

        public Criteria andDrugsPriceEqualTo(Float value) {
            addCriterion("Drugs_Price =", value, "drugsPrice");
            return (Criteria) this;
        }

        public Criteria andDrugsPriceNotEqualTo(Float value) {
            addCriterion("Drugs_Price <>", value, "drugsPrice");
            return (Criteria) this;
        }

        public Criteria andDrugsPriceGreaterThan(Float value) {
            addCriterion("Drugs_Price >", value, "drugsPrice");
            return (Criteria) this;
        }

        public Criteria andDrugsPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("Drugs_Price >=", value, "drugsPrice");
            return (Criteria) this;
        }

        public Criteria andDrugsPriceLessThan(Float value) {
            addCriterion("Drugs_Price <", value, "drugsPrice");
            return (Criteria) this;
        }

        public Criteria andDrugsPriceLessThanOrEqualTo(Float value) {
            addCriterion("Drugs_Price <=", value, "drugsPrice");
            return (Criteria) this;
        }

        public Criteria andDrugsPriceIn(List<Float> values) {
            addCriterion("Drugs_Price in", values, "drugsPrice");
            return (Criteria) this;
        }

        public Criteria andDrugsPriceNotIn(List<Float> values) {
            addCriterion("Drugs_Price not in", values, "drugsPrice");
            return (Criteria) this;
        }

        public Criteria andDrugsPriceBetween(Float value1, Float value2) {
            addCriterion("Drugs_Price between", value1, value2, "drugsPrice");
            return (Criteria) this;
        }

        public Criteria andDrugsPriceNotBetween(Float value1, Float value2) {
            addCriterion("Drugs_Price not between", value1, value2, "drugsPrice");
            return (Criteria) this;
        }

        public Criteria andMnemoniccodeIsNull() {
            addCriterion("MnemonicCode is null");
            return (Criteria) this;
        }

        public Criteria andMnemoniccodeIsNotNull() {
            addCriterion("MnemonicCode is not null");
            return (Criteria) this;
        }

        public Criteria andMnemoniccodeEqualTo(String value) {
            addCriterion("MnemonicCode =", value, "mnemoniccode");
            return (Criteria) this;
        }

        public Criteria andMnemoniccodeNotEqualTo(String value) {
            addCriterion("MnemonicCode <>", value, "mnemoniccode");
            return (Criteria) this;
        }

        public Criteria andMnemoniccodeGreaterThan(String value) {
            addCriterion("MnemonicCode >", value, "mnemoniccode");
            return (Criteria) this;
        }

        public Criteria andMnemoniccodeGreaterThanOrEqualTo(String value) {
            addCriterion("MnemonicCode >=", value, "mnemoniccode");
            return (Criteria) this;
        }

        public Criteria andMnemoniccodeLessThan(String value) {
            addCriterion("MnemonicCode <", value, "mnemoniccode");
            return (Criteria) this;
        }

        public Criteria andMnemoniccodeLessThanOrEqualTo(String value) {
            addCriterion("MnemonicCode <=", value, "mnemoniccode");
            return (Criteria) this;
        }

        public Criteria andMnemoniccodeLike(String value) {
            addCriterion("MnemonicCode like", value, "mnemoniccode");
            return (Criteria) this;
        }

        public Criteria andMnemoniccodeNotLike(String value) {
            addCriterion("MnemonicCode not like", value, "mnemoniccode");
            return (Criteria) this;
        }

        public Criteria andMnemoniccodeIn(List<String> values) {
            addCriterion("MnemonicCode in", values, "mnemoniccode");
            return (Criteria) this;
        }

        public Criteria andMnemoniccodeNotIn(List<String> values) {
            addCriterion("MnemonicCode not in", values, "mnemoniccode");
            return (Criteria) this;
        }

        public Criteria andMnemoniccodeBetween(String value1, String value2) {
            addCriterion("MnemonicCode between", value1, value2, "mnemoniccode");
            return (Criteria) this;
        }

        public Criteria andMnemoniccodeNotBetween(String value1, String value2) {
            addCriterion("MnemonicCode not between", value1, value2, "mnemoniccode");
            return (Criteria) this;
        }

        public Criteria andCreationdateIsNull() {
            addCriterion("CreationDate is null");
            return (Criteria) this;
        }

        public Criteria andCreationdateIsNotNull() {
            addCriterion("CreationDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreationdateEqualTo(Date value) {
            addCriterionForJDBCDate("CreationDate =", value, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CreationDate <>", value, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateGreaterThan(Date value) {
            addCriterionForJDBCDate("CreationDate >", value, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreationDate >=", value, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateLessThan(Date value) {
            addCriterionForJDBCDate("CreationDate <", value, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreationDate <=", value, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateIn(List<Date> values) {
            addCriterionForJDBCDate("CreationDate in", values, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CreationDate not in", values, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreationDate between", value1, value2, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreationDate not between", value1, value2, "creationdate");
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