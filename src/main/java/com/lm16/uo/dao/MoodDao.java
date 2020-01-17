package com.lm16.uo.dao;

import com.lm16.uo.bean.Mood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodDao extends JpaRepository<Mood, String> {
}
