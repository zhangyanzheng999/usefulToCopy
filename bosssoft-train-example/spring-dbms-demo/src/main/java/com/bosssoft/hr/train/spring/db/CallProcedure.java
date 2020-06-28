package com.bosssoft.hr.train.spring.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


/**
 * @description:
 * @author:zyz
 * @time:2020/6/9-20:01
 */
@Component
public class CallProcedure {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String SQL = "{call proc_init_sysdata(?,?)}";

    /**
     * 进行存储过程的调用
     *
     * @param userNum 用户数量
     * @param roleNum 角色数量
     * @return
     */
    public int callProcedure(int userNum, int roleNum) {
        return jdbcTemplate.update(SQL, userNum, roleNum);
    }

}
