package com.bosssoft.hr.train.dao;

import com.bosssoft.hr.train.bean.Student;

/**
 * @description:操作学生的Mapper
 * @author:zyz
 * @time:2020/6/7--19:36
 */
public interface StudentMapper {
    Student getStudentById(Integer id);

    int insertStudent(Student student);

}
