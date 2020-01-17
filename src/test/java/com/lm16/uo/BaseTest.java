package com.lm16.uo;

import com.lm16.uo.service.AttachmentService;
import com.lm16.uo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseTest {

    protected static Logger logger = LogManager.getLogger(BaseTest.class);

    @Resource
    protected UserService userService;

    @Resource
    protected AttachmentService attachmentService;
}
