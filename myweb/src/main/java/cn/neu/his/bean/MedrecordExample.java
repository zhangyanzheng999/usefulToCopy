package cn.neu.his.bean;

import java.util.ArrayList;
import java.util.List;

public class MedrecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MedrecordExample() {
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

        public Criteria andChiefComplaintIsNull() {
            addCriterion("Chief_Complaint is null");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintIsNotNull() {
            addCriterion("Chief_Complaint is not null");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintEqualTo(String value) {
            addCriterion("Chief_Complaint =", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintNotEqualTo(String value) {
            addCriterion("Chief_Complaint <>", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintGreaterThan(String value) {
            addCriterion("Chief_Complaint >", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintGreaterThanOrEqualTo(String value) {
            addCriterion("Chief_Complaint >=", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintLessThan(String value) {
            addCriterion("Chief_Complaint <", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintLessThanOrEqualTo(String value) {
            addCriterion("Chief_Complaint <=", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintLike(String value) {
            addCriterion("Chief_Complaint like", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintNotLike(String value) {
            addCriterion("Chief_Complaint not like", value, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintIn(List<String> values) {
            addCriterion("Chief_Complaint in", values, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintNotIn(List<String> values) {
            addCriterion("Chief_Complaint not in", values, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintBetween(String value1, String value2) {
            addCriterion("Chief_Complaint between", value1, value2, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andChiefComplaintNotBetween(String value1, String value2) {
            addCriterion("Chief_Complaint not between", value1, value2, "chiefComplaint");
            return (Criteria) this;
        }

        public Criteria andNowIllnessIsNull() {
            addCriterion("Now_illness is null");
            return (Criteria) this;
        }

        public Criteria andNowIllnessIsNotNull() {
            addCriterion("Now_illness is not null");
            return (Criteria) this;
        }

        public Criteria andNowIllnessEqualTo(String value) {
            addCriterion("Now_illness =", value, "nowIllness");
            return (Criteria) this;
        }

        public Criteria andNowIllnessNotEqualTo(String value) {
            addCriterion("Now_illness <>", value, "nowIllness");
            return (Criteria) this;
        }

        public Criteria andNowIllnessGreaterThan(String value) {
            addCriterion("Now_illness >", value, "nowIllness");
            return (Criteria) this;
        }

        public Criteria andNowIllnessGreaterThanOrEqualTo(String value) {
            addCriterion("Now_illness >=", value, "nowIllness");
            return (Criteria) this;
        }

        public Criteria andNowIllnessLessThan(String value) {
            addCriterion("Now_illness <", value, "nowIllness");
            return (Criteria) this;
        }

        public Criteria andNowIllnessLessThanOrEqualTo(String value) {
            addCriterion("Now_illness <=", value, "nowIllness");
            return (Criteria) this;
        }

        public Criteria andNowIllnessLike(String value) {
            addCriterion("Now_illness like", value, "nowIllness");
            return (Criteria) this;
        }

        public Criteria andNowIllnessNotLike(String value) {
            addCriterion("Now_illness not like", value, "nowIllness");
            return (Criteria) this;
        }

        public Criteria andNowIllnessIn(List<String> values) {
            addCriterion("Now_illness in", values, "nowIllness");
            return (Criteria) this;
        }

        public Criteria andNowIllnessNotIn(List<String> values) {
            addCriterion("Now_illness not in", values, "nowIllness");
            return (Criteria) this;
        }

        public Criteria andNowIllnessBetween(String value1, String value2) {
            addCriterion("Now_illness between", value1, value2, "nowIllness");
            return (Criteria) this;
        }

        public Criteria andNowIllnessNotBetween(String value1, String value2) {
            addCriterion("Now_illness not between", value1, value2, "nowIllness");
            return (Criteria) this;
        }

        public Criteria andNowMedicalStatusIsNull() {
            addCriterion("Now_Medical_Status is null");
            return (Criteria) this;
        }

        public Criteria andNowMedicalStatusIsNotNull() {
            addCriterion("Now_Medical_Status is not null");
            return (Criteria) this;
        }

        public Criteria andNowMedicalStatusEqualTo(String value) {
            addCriterion("Now_Medical_Status =", value, "nowMedicalStatus");
            return (Criteria) this;
        }

        public Criteria andNowMedicalStatusNotEqualTo(String value) {
            addCriterion("Now_Medical_Status <>", value, "nowMedicalStatus");
            return (Criteria) this;
        }

        public Criteria andNowMedicalStatusGreaterThan(String value) {
            addCriterion("Now_Medical_Status >", value, "nowMedicalStatus");
            return (Criteria) this;
        }

        public Criteria andNowMedicalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("Now_Medical_Status >=", value, "nowMedicalStatus");
            return (Criteria) this;
        }

        public Criteria andNowMedicalStatusLessThan(String value) {
            addCriterion("Now_Medical_Status <", value, "nowMedicalStatus");
            return (Criteria) this;
        }

        public Criteria andNowMedicalStatusLessThanOrEqualTo(String value) {
            addCriterion("Now_Medical_Status <=", value, "nowMedicalStatus");
            return (Criteria) this;
        }

        public Criteria andNowMedicalStatusLike(String value) {
            addCriterion("Now_Medical_Status like", value, "nowMedicalStatus");
            return (Criteria) this;
        }

        public Criteria andNowMedicalStatusNotLike(String value) {
            addCriterion("Now_Medical_Status not like", value, "nowMedicalStatus");
            return (Criteria) this;
        }

        public Criteria andNowMedicalStatusIn(List<String> values) {
            addCriterion("Now_Medical_Status in", values, "nowMedicalStatus");
            return (Criteria) this;
        }

        public Criteria andNowMedicalStatusNotIn(List<String> values) {
            addCriterion("Now_Medical_Status not in", values, "nowMedicalStatus");
            return (Criteria) this;
        }

        public Criteria andNowMedicalStatusBetween(String value1, String value2) {
            addCriterion("Now_Medical_Status between", value1, value2, "nowMedicalStatus");
            return (Criteria) this;
        }

        public Criteria andNowMedicalStatusNotBetween(String value1, String value2) {
            addCriterion("Now_Medical_Status not between", value1, value2, "nowMedicalStatus");
            return (Criteria) this;
        }

        public Criteria andPastIllnessIsNull() {
            addCriterion("Past_illness is null");
            return (Criteria) this;
        }

        public Criteria andPastIllnessIsNotNull() {
            addCriterion("Past_illness is not null");
            return (Criteria) this;
        }

        public Criteria andPastIllnessEqualTo(String value) {
            addCriterion("Past_illness =", value, "pastIllness");
            return (Criteria) this;
        }

        public Criteria andPastIllnessNotEqualTo(String value) {
            addCriterion("Past_illness <>", value, "pastIllness");
            return (Criteria) this;
        }

        public Criteria andPastIllnessGreaterThan(String value) {
            addCriterion("Past_illness >", value, "pastIllness");
            return (Criteria) this;
        }

        public Criteria andPastIllnessGreaterThanOrEqualTo(String value) {
            addCriterion("Past_illness >=", value, "pastIllness");
            return (Criteria) this;
        }

        public Criteria andPastIllnessLessThan(String value) {
            addCriterion("Past_illness <", value, "pastIllness");
            return (Criteria) this;
        }

        public Criteria andPastIllnessLessThanOrEqualTo(String value) {
            addCriterion("Past_illness <=", value, "pastIllness");
            return (Criteria) this;
        }

        public Criteria andPastIllnessLike(String value) {
            addCriterion("Past_illness like", value, "pastIllness");
            return (Criteria) this;
        }

        public Criteria andPastIllnessNotLike(String value) {
            addCriterion("Past_illness not like", value, "pastIllness");
            return (Criteria) this;
        }

        public Criteria andPastIllnessIn(List<String> values) {
            addCriterion("Past_illness in", values, "pastIllness");
            return (Criteria) this;
        }

        public Criteria andPastIllnessNotIn(List<String> values) {
            addCriterion("Past_illness not in", values, "pastIllness");
            return (Criteria) this;
        }

        public Criteria andPastIllnessBetween(String value1, String value2) {
            addCriterion("Past_illness between", value1, value2, "pastIllness");
            return (Criteria) this;
        }

        public Criteria andPastIllnessNotBetween(String value1, String value2) {
            addCriterion("Past_illness not between", value1, value2, "pastIllness");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryIsNull() {
            addCriterion("Allergy_History is null");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryIsNotNull() {
            addCriterion("Allergy_History is not null");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryEqualTo(String value) {
            addCriterion("Allergy_History =", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryNotEqualTo(String value) {
            addCriterion("Allergy_History <>", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryGreaterThan(String value) {
            addCriterion("Allergy_History >", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("Allergy_History >=", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryLessThan(String value) {
            addCriterion("Allergy_History <", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryLessThanOrEqualTo(String value) {
            addCriterion("Allergy_History <=", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryLike(String value) {
            addCriterion("Allergy_History like", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryNotLike(String value) {
            addCriterion("Allergy_History not like", value, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryIn(List<String> values) {
            addCriterion("Allergy_History in", values, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryNotIn(List<String> values) {
            addCriterion("Allergy_History not in", values, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryBetween(String value1, String value2) {
            addCriterion("Allergy_History between", value1, value2, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andAllergyHistoryNotBetween(String value1, String value2) {
            addCriterion("Allergy_History not between", value1, value2, "allergyHistory");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationIsNull() {
            addCriterion("Physical_Examination is null");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationIsNotNull() {
            addCriterion("Physical_Examination is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationEqualTo(String value) {
            addCriterion("Physical_Examination =", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationNotEqualTo(String value) {
            addCriterion("Physical_Examination <>", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationGreaterThan(String value) {
            addCriterion("Physical_Examination >", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationGreaterThanOrEqualTo(String value) {
            addCriterion("Physical_Examination >=", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationLessThan(String value) {
            addCriterion("Physical_Examination <", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationLessThanOrEqualTo(String value) {
            addCriterion("Physical_Examination <=", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationLike(String value) {
            addCriterion("Physical_Examination like", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationNotLike(String value) {
            addCriterion("Physical_Examination not like", value, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationIn(List<String> values) {
            addCriterion("Physical_Examination in", values, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationNotIn(List<String> values) {
            addCriterion("Physical_Examination not in", values, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationBetween(String value1, String value2) {
            addCriterion("Physical_Examination between", value1, value2, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andPhysicalExaminationNotBetween(String value1, String value2) {
            addCriterion("Physical_Examination not between", value1, value2, "physicalExamination");
            return (Criteria) this;
        }

        public Criteria andInspectionRecommendationIsNull() {
            addCriterion("Inspection_Recommendation is null");
            return (Criteria) this;
        }

        public Criteria andInspectionRecommendationIsNotNull() {
            addCriterion("Inspection_Recommendation is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionRecommendationEqualTo(String value) {
            addCriterion("Inspection_Recommendation =", value, "inspectionRecommendation");
            return (Criteria) this;
        }

        public Criteria andInspectionRecommendationNotEqualTo(String value) {
            addCriterion("Inspection_Recommendation <>", value, "inspectionRecommendation");
            return (Criteria) this;
        }

        public Criteria andInspectionRecommendationGreaterThan(String value) {
            addCriterion("Inspection_Recommendation >", value, "inspectionRecommendation");
            return (Criteria) this;
        }

        public Criteria andInspectionRecommendationGreaterThanOrEqualTo(String value) {
            addCriterion("Inspection_Recommendation >=", value, "inspectionRecommendation");
            return (Criteria) this;
        }

        public Criteria andInspectionRecommendationLessThan(String value) {
            addCriterion("Inspection_Recommendation <", value, "inspectionRecommendation");
            return (Criteria) this;
        }

        public Criteria andInspectionRecommendationLessThanOrEqualTo(String value) {
            addCriterion("Inspection_Recommendation <=", value, "inspectionRecommendation");
            return (Criteria) this;
        }

        public Criteria andInspectionRecommendationLike(String value) {
            addCriterion("Inspection_Recommendation like", value, "inspectionRecommendation");
            return (Criteria) this;
        }

        public Criteria andInspectionRecommendationNotLike(String value) {
            addCriterion("Inspection_Recommendation not like", value, "inspectionRecommendation");
            return (Criteria) this;
        }

        public Criteria andInspectionRecommendationIn(List<String> values) {
            addCriterion("Inspection_Recommendation in", values, "inspectionRecommendation");
            return (Criteria) this;
        }

        public Criteria andInspectionRecommendationNotIn(List<String> values) {
            addCriterion("Inspection_Recommendation not in", values, "inspectionRecommendation");
            return (Criteria) this;
        }

        public Criteria andInspectionRecommendationBetween(String value1, String value2) {
            addCriterion("Inspection_Recommendation between", value1, value2, "inspectionRecommendation");
            return (Criteria) this;
        }

        public Criteria andInspectionRecommendationNotBetween(String value1, String value2) {
            addCriterion("Inspection_Recommendation not between", value1, value2, "inspectionRecommendation");
            return (Criteria) this;
        }

        public Criteria andAttentionIsNull() {
            addCriterion("Attention is null");
            return (Criteria) this;
        }

        public Criteria andAttentionIsNotNull() {
            addCriterion("Attention is not null");
            return (Criteria) this;
        }

        public Criteria andAttentionEqualTo(String value) {
            addCriterion("Attention =", value, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionNotEqualTo(String value) {
            addCriterion("Attention <>", value, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionGreaterThan(String value) {
            addCriterion("Attention >", value, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionGreaterThanOrEqualTo(String value) {
            addCriterion("Attention >=", value, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionLessThan(String value) {
            addCriterion("Attention <", value, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionLessThanOrEqualTo(String value) {
            addCriterion("Attention <=", value, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionLike(String value) {
            addCriterion("Attention like", value, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionNotLike(String value) {
            addCriterion("Attention not like", value, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionIn(List<String> values) {
            addCriterion("Attention in", values, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionNotIn(List<String> values) {
            addCriterion("Attention not in", values, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionBetween(String value1, String value2) {
            addCriterion("Attention between", value1, value2, "attention");
            return (Criteria) this;
        }

        public Criteria andAttentionNotBetween(String value1, String value2) {
            addCriterion("Attention not between", value1, value2, "attention");
            return (Criteria) this;
        }

        public Criteria andExamResultIsNull() {
            addCriterion("Exam_Result is null");
            return (Criteria) this;
        }

        public Criteria andExamResultIsNotNull() {
            addCriterion("Exam_Result is not null");
            return (Criteria) this;
        }

        public Criteria andExamResultEqualTo(String value) {
            addCriterion("Exam_Result =", value, "examResult");
            return (Criteria) this;
        }

        public Criteria andExamResultNotEqualTo(String value) {
            addCriterion("Exam_Result <>", value, "examResult");
            return (Criteria) this;
        }

        public Criteria andExamResultGreaterThan(String value) {
            addCriterion("Exam_Result >", value, "examResult");
            return (Criteria) this;
        }

        public Criteria andExamResultGreaterThanOrEqualTo(String value) {
            addCriterion("Exam_Result >=", value, "examResult");
            return (Criteria) this;
        }

        public Criteria andExamResultLessThan(String value) {
            addCriterion("Exam_Result <", value, "examResult");
            return (Criteria) this;
        }

        public Criteria andExamResultLessThanOrEqualTo(String value) {
            addCriterion("Exam_Result <=", value, "examResult");
            return (Criteria) this;
        }

        public Criteria andExamResultLike(String value) {
            addCriterion("Exam_Result like", value, "examResult");
            return (Criteria) this;
        }

        public Criteria andExamResultNotLike(String value) {
            addCriterion("Exam_Result not like", value, "examResult");
            return (Criteria) this;
        }

        public Criteria andExamResultIn(List<String> values) {
            addCriterion("Exam_Result in", values, "examResult");
            return (Criteria) this;
        }

        public Criteria andExamResultNotIn(List<String> values) {
            addCriterion("Exam_Result not in", values, "examResult");
            return (Criteria) this;
        }

        public Criteria andExamResultBetween(String value1, String value2) {
            addCriterion("Exam_Result between", value1, value2, "examResult");
            return (Criteria) this;
        }

        public Criteria andExamResultNotBetween(String value1, String value2) {
            addCriterion("Exam_Result not between", value1, value2, "examResult");
            return (Criteria) this;
        }

        public Criteria andDiagnosticResultIsNull() {
            addCriterion("Diagnostic_Result is null");
            return (Criteria) this;
        }

        public Criteria andDiagnosticResultIsNotNull() {
            addCriterion("Diagnostic_Result is not null");
            return (Criteria) this;
        }

        public Criteria andDiagnosticResultEqualTo(String value) {
            addCriterion("Diagnostic_Result =", value, "diagnosticResult");
            return (Criteria) this;
        }

        public Criteria andDiagnosticResultNotEqualTo(String value) {
            addCriterion("Diagnostic_Result <>", value, "diagnosticResult");
            return (Criteria) this;
        }

        public Criteria andDiagnosticResultGreaterThan(String value) {
            addCriterion("Diagnostic_Result >", value, "diagnosticResult");
            return (Criteria) this;
        }

        public Criteria andDiagnosticResultGreaterThanOrEqualTo(String value) {
            addCriterion("Diagnostic_Result >=", value, "diagnosticResult");
            return (Criteria) this;
        }

        public Criteria andDiagnosticResultLessThan(String value) {
            addCriterion("Diagnostic_Result <", value, "diagnosticResult");
            return (Criteria) this;
        }

        public Criteria andDiagnosticResultLessThanOrEqualTo(String value) {
            addCriterion("Diagnostic_Result <=", value, "diagnosticResult");
            return (Criteria) this;
        }

        public Criteria andDiagnosticResultLike(String value) {
            addCriterion("Diagnostic_Result like", value, "diagnosticResult");
            return (Criteria) this;
        }

        public Criteria andDiagnosticResultNotLike(String value) {
            addCriterion("Diagnostic_Result not like", value, "diagnosticResult");
            return (Criteria) this;
        }

        public Criteria andDiagnosticResultIn(List<String> values) {
            addCriterion("Diagnostic_Result in", values, "diagnosticResult");
            return (Criteria) this;
        }

        public Criteria andDiagnosticResultNotIn(List<String> values) {
            addCriterion("Diagnostic_Result not in", values, "diagnosticResult");
            return (Criteria) this;
        }

        public Criteria andDiagnosticResultBetween(String value1, String value2) {
            addCriterion("Diagnostic_Result between", value1, value2, "diagnosticResult");
            return (Criteria) this;
        }

        public Criteria andDiagnosticResultNotBetween(String value1, String value2) {
            addCriterion("Diagnostic_Result not between", value1, value2, "diagnosticResult");
            return (Criteria) this;
        }

        public Criteria andOpinionRecommendationIsNull() {
            addCriterion("Opinion_Recommendation is null");
            return (Criteria) this;
        }

        public Criteria andOpinionRecommendationIsNotNull() {
            addCriterion("Opinion_Recommendation is not null");
            return (Criteria) this;
        }

        public Criteria andOpinionRecommendationEqualTo(String value) {
            addCriterion("Opinion_Recommendation =", value, "opinionRecommendation");
            return (Criteria) this;
        }

        public Criteria andOpinionRecommendationNotEqualTo(String value) {
            addCriterion("Opinion_Recommendation <>", value, "opinionRecommendation");
            return (Criteria) this;
        }

        public Criteria andOpinionRecommendationGreaterThan(String value) {
            addCriterion("Opinion_Recommendation >", value, "opinionRecommendation");
            return (Criteria) this;
        }

        public Criteria andOpinionRecommendationGreaterThanOrEqualTo(String value) {
            addCriterion("Opinion_Recommendation >=", value, "opinionRecommendation");
            return (Criteria) this;
        }

        public Criteria andOpinionRecommendationLessThan(String value) {
            addCriterion("Opinion_Recommendation <", value, "opinionRecommendation");
            return (Criteria) this;
        }

        public Criteria andOpinionRecommendationLessThanOrEqualTo(String value) {
            addCriterion("Opinion_Recommendation <=", value, "opinionRecommendation");
            return (Criteria) this;
        }

        public Criteria andOpinionRecommendationLike(String value) {
            addCriterion("Opinion_Recommendation like", value, "opinionRecommendation");
            return (Criteria) this;
        }

        public Criteria andOpinionRecommendationNotLike(String value) {
            addCriterion("Opinion_Recommendation not like", value, "opinionRecommendation");
            return (Criteria) this;
        }

        public Criteria andOpinionRecommendationIn(List<String> values) {
            addCriterion("Opinion_Recommendation in", values, "opinionRecommendation");
            return (Criteria) this;
        }

        public Criteria andOpinionRecommendationNotIn(List<String> values) {
            addCriterion("Opinion_Recommendation not in", values, "opinionRecommendation");
            return (Criteria) this;
        }

        public Criteria andOpinionRecommendationBetween(String value1, String value2) {
            addCriterion("Opinion_Recommendation between", value1, value2, "opinionRecommendation");
            return (Criteria) this;
        }

        public Criteria andOpinionRecommendationNotBetween(String value1, String value2) {
            addCriterion("Opinion_Recommendation not between", value1, value2, "opinionRecommendation");
            return (Criteria) this;
        }

        public Criteria andMedrecordStateIsNull() {
            addCriterion("MedRecord_State is null");
            return (Criteria) this;
        }

        public Criteria andMedrecordStateIsNotNull() {
            addCriterion("MedRecord_State is not null");
            return (Criteria) this;
        }

        public Criteria andMedrecordStateEqualTo(Integer value) {
            addCriterion("MedRecord_State =", value, "medrecordState");
            return (Criteria) this;
        }

        public Criteria andMedrecordStateNotEqualTo(Integer value) {
            addCriterion("MedRecord_State <>", value, "medrecordState");
            return (Criteria) this;
        }

        public Criteria andMedrecordStateGreaterThan(Integer value) {
            addCriterion("MedRecord_State >", value, "medrecordState");
            return (Criteria) this;
        }

        public Criteria andMedrecordStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("MedRecord_State >=", value, "medrecordState");
            return (Criteria) this;
        }

        public Criteria andMedrecordStateLessThan(Integer value) {
            addCriterion("MedRecord_State <", value, "medrecordState");
            return (Criteria) this;
        }

        public Criteria andMedrecordStateLessThanOrEqualTo(Integer value) {
            addCriterion("MedRecord_State <=", value, "medrecordState");
            return (Criteria) this;
        }

        public Criteria andMedrecordStateIn(List<Integer> values) {
            addCriterion("MedRecord_State in", values, "medrecordState");
            return (Criteria) this;
        }

        public Criteria andMedrecordStateNotIn(List<Integer> values) {
            addCriterion("MedRecord_State not in", values, "medrecordState");
            return (Criteria) this;
        }

        public Criteria andMedrecordStateBetween(Integer value1, Integer value2) {
            addCriterion("MedRecord_State between", value1, value2, "medrecordState");
            return (Criteria) this;
        }

        public Criteria andMedrecordStateNotBetween(Integer value1, Integer value2) {
            addCriterion("MedRecord_State not between", value1, value2, "medrecordState");
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