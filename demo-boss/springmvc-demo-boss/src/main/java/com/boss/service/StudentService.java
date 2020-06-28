package com.boss.service;

import com.boss.bean.Student;
import com.boss.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--17:05
 */
@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public int add(Student student) {
        return studentDao.add(student);
    }

    public Student findById(Integer id) {
        return studentDao.findById(id);
    }

    public int update(Student student){
        return studentDao.update(student);
    }

    public  int delete(Integer id){
        return studentDao.delete(id);
    }
}
