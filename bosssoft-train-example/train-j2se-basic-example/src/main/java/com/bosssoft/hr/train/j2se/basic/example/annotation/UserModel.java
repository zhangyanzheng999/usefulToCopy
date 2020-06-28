package com.bosssoft.hr.train.j2se.basic.example.annotation;


/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-28 22:42
 * @since
 **/
@Table("t_user")
public class UserModel extends BaseModel {
    @Column("name")
    private String name;

    @Id("id")
    private Integer id;

    @Column("age")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserModel() {
    }

    public UserModel(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


}
