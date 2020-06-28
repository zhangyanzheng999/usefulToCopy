package neu.showchart.entity;

import javax.persistence.*;

@Entity
@Table(name="Info")
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name="FAN_NO")
    private String fanNo;

    @Column(name="TIME")
    private String time;

    @Column(name="COUNT")
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFanNo() {
        return fanNo;
    }

    public void setFanNo(String fanNo) {
        this.fanNo = fanNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
