package com.lm16.uo.config.quatrz;

import com.lm16.uo.config.mail.SendMailService;
import com.lm16.uo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
@Configurable
//@EnableScheduling
public class SendMailQuatrz {

    Logger logger = LogManager.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @Resource
    private SendMailService sendMailService;

    @Scheduled(cron = "*/5 * * * * *")
    public void secondCron(){

//        sendMailService.sendMail(userService.findAll());

        logger.info("定时启动");
    }

}
