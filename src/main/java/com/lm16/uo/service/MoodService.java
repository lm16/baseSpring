package com.lm16.uo.service;

import com.lm16.uo.bean.Mood;

public interface MoodService {

    Mood save(Mood mood);

    String asynSave(Mood mood);
}
