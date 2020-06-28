package com.bosssoft.hr.train.service.impl;

import com.bosssoft.hr.train.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/9--10:39
 */
@Service
public class SendEmailServiceImpl implements SendEmailService {
    @Value("${spring.mail.username}")
    private String fromEmail;

    //注入Spring发邮件的对象
    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    @Scheduled(cron = "0 0/30 * * * ?")
    public Boolean sendEmail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //目标邮箱
        simpleMailMessage.setTo("1010561415@qq.com");
        simpleMailMessage.setFrom(fromEmail);

        //主题
        simpleMailMessage.setSubject("定时任务测试");
        simpleMailMessage.setText("这是zyz通过定时任务发给你的邮件");
        try {
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
