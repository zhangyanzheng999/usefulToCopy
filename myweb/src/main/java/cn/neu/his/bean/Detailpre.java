package cn.neu.his.bean;

public class Detailpre {
    private Integer detialpreId;

    private Integer preId;

    private Integer drugsId;

    private String yongFa;

    private String yongLiang;

    private String pinLv;

    private Integer drugsNum;

    private Integer detailpreState;

    public Integer getDetialpreId() {
        return detialpreId;
    }

    public void setDetialpreId(Integer detialpreId) {
        this.detialpreId = detialpreId;
    }

    public Integer getPreId() {
        return preId;
    }

    public void setPreId(Integer preId) {
        this.preId = preId;
    }

    public Integer getDrugsId() {
        return drugsId;
    }

    public void setDrugsId(Integer drugsId) {
        this.drugsId = drugsId;
    }

    public String getYongFa() {
        return yongFa;
    }

    public void setYongFa(String yongFa) {
        this.yongFa = yongFa == null ? null : yongFa.trim();
    }

    public String getYongLiang() {
        return yongLiang;
    }

    public void setYongLiang(String yongLiang) {
        this.yongLiang = yongLiang == null ? null : yongLiang.trim();
    }

    public String getPinLv() {
        return pinLv;
    }

    public void setPinLv(String pinLv) {
        this.pinLv = pinLv == null ? null : pinLv.trim();
    }

    public Integer getDrugsNum() {
        return drugsNum;
    }

    public void setDrugsNum(Integer drugsNum) {
        this.drugsNum = drugsNum;
    }

    public Integer getDetailpreState() {
        return detailpreState;
    }

    public void setDetailpreState(Integer detailpreState) {
        this.detailpreState = detailpreState;
    }

	public Detailpre(Integer detialpreId, Integer preId, Integer drugsId, String yongFa, String yongLiang, String pinLv,
			Integer drugsNum, Integer detailpreState) {
		super();
		this.detialpreId = detialpreId;
		this.preId = preId;
		this.drugsId = drugsId;
		this.yongFa = yongFa;
		this.yongLiang = yongLiang;
		this.pinLv = pinLv;
		this.drugsNum = drugsNum;
		this.detailpreState = detailpreState;
	}

	public Detailpre() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}