package com.lm16.uo.config.web;

import com.lm16.uo.bean.User;
import com.lm16.uo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;

//@WebListener
public class UserListener implements ServletContextListener {

    private static final Logger logger = LogManager.getLogger(UserListener.class);

    private static final String ALL_USER = "ALL_USER_LIST";

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private UserService userService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        redisTemplate.delete(ALL_USER);

        redisTemplate.opsForList().leftPushAll(ALL_USER, userService.findAll());

        logger.info("完成上下文初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
