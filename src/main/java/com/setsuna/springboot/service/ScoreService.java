package com.setsuna.springboot.service;

import com.setsuna.springboot.pojo.Score;

import java.util.List;
import java.util.Map;

public interface ScoreService {
    public int addScore(Score score);
    public int deleteScoreById(int id);
    public List<Map<String,Object>> getScoreByStuNo(String std_no);
    public Score getScoreById(int id);
    public int UpdateScore(Score score);
}
