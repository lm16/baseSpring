package com.lm16.uo.config.activeMQ;

import com.lm16.uo.bean.Mood;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
public class MoodProducer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    public void sendMessage(Destination destination, final Mood mood){
        jmsMessagingTemplate.convertAndSend(destination, mood);
    }
}
