package com.boss.base.utils;

import com.boss.base.email.Mail;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 发送邮箱验证码工具类
 * @author : 尚鹏辉
 * @date : 2020/7/1
 * @version : 1.0.0
 */
public class EmailUtil {
    //用户名
    private static final String USERNAME = "sph19990@163.com";
    // 授权码
    private static final String PASSWORD = "ZUDLSSTKHYYSFQII";
    // SMTP服务器
    private static final String HOST = "smtp.163.com";
    // 163端口号
    private static final String PORT = "25";
    public static void sendMail(Mail mail) throws AddressException, MessagingException{
        Properties p = new Properties();
        p.setProperty("mail.smtp.host",HOST);
        p.setProperty("mail.smtp.port",PORT);
        p.setProperty("mail.smtp.socketFactory.port",PORT);
        p.setProperty("mail.smtp.auth","true");
        p.setProperty("mail.smtp.socketFactory.class", "SSL_FACTORY");
        Session session = Session.getInstance(p, new Authenticator() {
            // 设置认证账户信息
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        // 发件人
        message.setFrom(new InternetAddress(USERNAME));
        // 收件人
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getTo()));
        // 主题
        message.setSubject(mail.getSubject());
        //内容
        message.setContent("<h1>"+mail.getText()+"</h1>", "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        Transport.send(message);

    }
}
