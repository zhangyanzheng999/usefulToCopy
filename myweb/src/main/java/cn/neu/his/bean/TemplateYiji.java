package cn.neu.his.bean;

public class TemplateYiji {
    private Integer templateid;

    private String templatename;

    private String templatecreatetime;

    private Integer templaterange;

    private Integer templatetype;

    public Integer getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Integer templateid) {
        this.templateid = templateid;
    }

    public String getTemplatename() {
        return templatename;
    }

    public void setTemplatename(String templatename) {
        this.templatename = templatename == null ? null : templatename.trim();
    }

    public String getTemplatecreatetime() {
        return templatecreatetime;
    }

    public void setTemplatecreatetime(String templatecreatetime) {
        this.templatecreatetime = templatecreatetime == null ? null : templatecreatetime.trim();
    }

    public Integer getTemplaterange() {
        return templaterange;
    }

    public void setTemplaterange(Integer templaterange) {
        this.templaterange = templaterange;
    }

    public Integer getTemplatetype() {
        return templatetype;
    }

    public void setTemplatetype(Integer templatetype) {
        this.templatetype = templatetype;
    }
}