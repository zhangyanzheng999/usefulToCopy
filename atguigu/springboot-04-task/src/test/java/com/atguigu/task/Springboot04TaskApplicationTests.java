package com.atguigu.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootTest
class Springboot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Value("${spring.mail.username}")
    String mail;

    @Test
    void contextLoads() {
        System.out.println(mail);
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件
        message.setSubject("恭喜您-于海源同学");
        message.setText("恭喜您，获得与ZYZ先生出去睡机会一次，点击确认");

        message.setTo("1424373051@qq.com");
        message.setFrom("1010561415@qq.com");

        mailSender.send(message);
        System.out.println("发送完成！");
    }

    @Test
    public void test02() throws MessagingException {
        //创建一个复杂的消息邮件
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        //邮件
        messageHelper.setSubject("恭喜您-于海源同学");
        // html默认关闭，需要设置为true
        messageHelper.setText("<b style='color:red'>恭喜您，获得与ZYZ先生出去睡机会一次，点击确认</b>",true);

        messageHelper.setTo(mail);
        messageHelper.setFrom("1010561415@qq.com");
        //上传文件
        //messageHelper.addAttachment();
        mailSender.send(message);
        System.out.println("发送完成！");
    }

}
