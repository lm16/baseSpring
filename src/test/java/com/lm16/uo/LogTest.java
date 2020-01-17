package com.lm16.uo;

import com.lm16.uo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogTest {

    Logger logger = LogManager.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @Test
    public void a() throws IOException {

        userService.delete("e761027f-d3f8-3f2d-8898-43d867be42b9");

    }

}
