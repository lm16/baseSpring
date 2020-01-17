package com.lm16.uo.config.activeMQ;

import com.lm16.uo.bean.Mood;
import com.lm16.uo.service.MoodService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MoodConsumer {

    static Logger logger = LogManager.getLogger(MoodConsumer.class);

    @JmsListener(destination = "to.queue")
    public void receiveQueue(String text){
        logger.info("发表了  "+ text + "  这样一句话");
    }

    @Resource
    private MoodService moodService;

    @JmsListener(destination = "to.asyn.queue")
    public void receiveQueue(Mood mood){
        moodService.save(mood);

        logger.info("消费者代存");
    }
}
