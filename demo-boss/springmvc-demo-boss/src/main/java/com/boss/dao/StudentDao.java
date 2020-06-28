package com.boss.dao;

import com.boss.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--16:58
 */
@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> findAll() {
        String sql = "select * from tb_student";

        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    public Student findById(Integer id) {
        String sql = "select * from tb_student where id = ?";
        Student student = null;
        //如果查询结果为空，会抛出EmptyResultDataAccessException
        try {
            student = jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return student;
    }

    //修改
    public int update(Student student) {
        String sql = "update tb_student set name=? ,age=? where id =?";

        return jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getId());
    }


    class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            return student;
        }
    }

    //学生添加
    public int add(Student student) {
        String sql = "insert into tb_student(name,age) values(?,?)";
        return jdbcTemplate.update(sql, student.getName(), student.getAge());
    }
    //删除
    public int delete(Integer id) {
        String sql = "delete from tb_student where id = ?";
        return jdbcTemplate.update(sql,id);
    }
}
