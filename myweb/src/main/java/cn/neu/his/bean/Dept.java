package cn.neu.his.bean;

public class Dept {
    private Integer deptId;

    private String deptCode;

    private String deptName;

    private Integer deptcategoryId;

    private Integer deptType;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Integer getDeptcategoryId() {
        return deptcategoryId;
    }

    public void setDeptcategoryId(Integer deptcategoryId) {
        this.deptcategoryId = deptcategoryId;
    }

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }
}