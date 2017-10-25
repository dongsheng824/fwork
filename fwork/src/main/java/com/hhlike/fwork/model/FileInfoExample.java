package com.hhlike.fwork.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FileInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSubFolderIsNull() {
            addCriterion("SUB_FOLDER is null");
            return (Criteria) this;
        }

        public Criteria andSubFolderIsNotNull() {
            addCriterion("SUB_FOLDER is not null");
            return (Criteria) this;
        }

        public Criteria andSubFolderEqualTo(String value) {
            addCriterion("SUB_FOLDER =", value, "subFolder");
            return (Criteria) this;
        }

        public Criteria andSubFolderNotEqualTo(String value) {
            addCriterion("SUB_FOLDER <>", value, "subFolder");
            return (Criteria) this;
        }

        public Criteria andSubFolderGreaterThan(String value) {
            addCriterion("SUB_FOLDER >", value, "subFolder");
            return (Criteria) this;
        }

        public Criteria andSubFolderGreaterThanOrEqualTo(String value) {
            addCriterion("SUB_FOLDER >=", value, "subFolder");
            return (Criteria) this;
        }

        public Criteria andSubFolderLessThan(String value) {
            addCriterion("SUB_FOLDER <", value, "subFolder");
            return (Criteria) this;
        }

        public Criteria andSubFolderLessThanOrEqualTo(String value) {
            addCriterion("SUB_FOLDER <=", value, "subFolder");
            return (Criteria) this;
        }

        public Criteria andSubFolderLike(String value) {
            addCriterion("SUB_FOLDER like", value, "subFolder");
            return (Criteria) this;
        }

        public Criteria andSubFolderNotLike(String value) {
            addCriterion("SUB_FOLDER not like", value, "subFolder");
            return (Criteria) this;
        }

        public Criteria andSubFolderIn(List<String> values) {
            addCriterion("SUB_FOLDER in", values, "subFolder");
            return (Criteria) this;
        }

        public Criteria andSubFolderNotIn(List<String> values) {
            addCriterion("SUB_FOLDER not in", values, "subFolder");
            return (Criteria) this;
        }

        public Criteria andSubFolderBetween(String value1, String value2) {
            addCriterion("SUB_FOLDER between", value1, value2, "subFolder");
            return (Criteria) this;
        }

        public Criteria andSubFolderNotBetween(String value1, String value2) {
            addCriterion("SUB_FOLDER not between", value1, value2, "subFolder");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("FILE_NAME =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("FILE_NAME <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("FILE_NAME >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_NAME >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("FILE_NAME <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("FILE_NAME <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("FILE_NAME like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("FILE_NAME not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("FILE_NAME in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("FILE_NAME not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("FILE_NAME between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("FILE_NAME not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andMd5CodeIsNull() {
            addCriterion("MD5_CODE is null");
            return (Criteria) this;
        }

        public Criteria andMd5CodeIsNotNull() {
            addCriterion("MD5_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andMd5CodeEqualTo(String value) {
            addCriterion("MD5_CODE =", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeNotEqualTo(String value) {
            addCriterion("MD5_CODE <>", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeGreaterThan(String value) {
            addCriterion("MD5_CODE >", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeGreaterThanOrEqualTo(String value) {
            addCriterion("MD5_CODE >=", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeLessThan(String value) {
            addCriterion("MD5_CODE <", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeLessThanOrEqualTo(String value) {
            addCriterion("MD5_CODE <=", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeLike(String value) {
            addCriterion("MD5_CODE like", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeNotLike(String value) {
            addCriterion("MD5_CODE not like", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeIn(List<String> values) {
            addCriterion("MD5_CODE in", values, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeNotIn(List<String> values) {
            addCriterion("MD5_CODE not in", values, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeBetween(String value1, String value2) {
            addCriterion("MD5_CODE between", value1, value2, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeNotBetween(String value1, String value2) {
            addCriterion("MD5_CODE not between", value1, value2, "md5Code");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
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