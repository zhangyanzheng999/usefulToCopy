package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.dao.UserRepository;
import com.bosssoft.hr.train.entity.User;
import com.bosssoft.hr.train.pojo.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/**
 * @description:
 * @author:zyz
 * @time:2020/6/11-21:08
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<User> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return userRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody UserDTO userDTO) {
        User result = userRepository.save(new User(userDTO));
        if (result.getId() != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            return null;
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody UserDTO userDTO) {
        User result = userRepository.save(new User(userDTO));
        if (result.getId() == null) {
            return "error";
        } else {
            return "success";
        }
    }


    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }
}
