package com.lm16.uo.config.mail;

import com.lm16.uo.bean.User;

import java.util.List;

public interface SendMailService {

    boolean sendMail(List<User> user);
}
