package com.lm16.uo.service.impl;


import com.lm16.uo.bean.Mood;
import com.lm16.uo.config.activeMQ.MoodProducer;
import com.lm16.uo.dao.MoodDao;
import com.lm16.uo.service.MoodService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
public class MoodServiceImpl implements MoodService {

    private static Destination destination = new ActiveMQQueue("to.asyn.queue");

    @Resource
    private MoodDao moodDao;

    @Resource
    private MoodProducer moodProducer;

    @Override
    public Mood save(Mood mood) {
        return moodDao.save(mood);
    }



    @Override
    public String asynSave(Mood mood) {

        moodProducer.sendMessage(destination, mood);

        return "success";
    }
}
