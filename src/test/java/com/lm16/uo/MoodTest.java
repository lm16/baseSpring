package com.lm16.uo;

import com.lm16.uo.bean.Mood;
import com.lm16.uo.config.activeMQ.MoodProducer;
import com.lm16.uo.service.MoodService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MoodTest {

    static Logger logger = LogManager.getLogger(MoodTest.class);

    @Resource
    private MoodService moodService;

    @Resource
    private MoodProducer moodProducer;

    @Test
    public void a(){

        Mood mood = new Mood();

        mood.setId("f514d52e-e0fc-a93b-3f3a-ce3cdd0f6hh9");
        mood.setUserId("e474bd6a-3100-25d8-62ec-0e69340c067f");

        mood.setPraiseNum(11);
        mood.setContent("经过队列后存储");
        mood.setPublishTime(new Date());

        moodService.asynSave(mood);

        logger.info("测试了队列插入操作");
    }


    @Test
    public void dd(){

        Destination destination = new ActiveMQQueue("to.queue");

        moodProducer.sendMessage(destination, "重要的是你我都走上了同一条路径");

    }
}
