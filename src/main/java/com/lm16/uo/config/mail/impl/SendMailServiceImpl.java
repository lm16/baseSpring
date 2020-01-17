package com.lm16.uo.config.mail.impl;

import com.lm16.uo.bean.User;
import com.lm16.uo.config.mail.SendMailService;
import com.lm16.uo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class SendMailServiceImpl implements SendMailService {

    static Logger logger = LogManager.getLogger(SendMailService.class);

    @Resource
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public boolean sendMail(List<User> users) {

        try{
            if(users==null || users.size()<=0)
                return false;
            for(User user: users){
                MimeMessage mimeMessage = this.mailSender.createMimeMessage();

                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
                helper.setFrom(from);
                helper.setTo("2070152298@qq.com");
                helper.setSubject("不过没上线，。");
                helper.setText("2070152298@qq.com  "+ user.getName());

                this.mailSender.send(mimeMessage);

                logger.info("发送邮件");
            }
        }catch (Exception e){

            logger.error("error from Mail: user=%s", users, e);

            return false;
        }

        return true;
    }
}
