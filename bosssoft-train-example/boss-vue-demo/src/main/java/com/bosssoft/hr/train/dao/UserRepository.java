package com.bosssoft.hr.train.dao;

import com.bosssoft.hr.train.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/11-20:50
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {



}


