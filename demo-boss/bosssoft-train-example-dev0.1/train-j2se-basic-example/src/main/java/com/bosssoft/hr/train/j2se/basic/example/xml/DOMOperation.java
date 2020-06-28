package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-28 22:13
 * @since
 **/
public class DOMOperation implements XMLOperation<Student> {
    @Override
    public boolean create(Student object) {
        return false;
    }

    @Override
    public boolean remove(Student object) {
        return false;
    }

    @Override
    public boolean update(Student object) {
        return false;
    }

    @Override
    public Student query(Student object) {
        return null;
    }
}
