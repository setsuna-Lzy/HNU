package com.setsuna.springboot.Controller;

import com.setsuna.springboot.pojo.Score;
import com.setsuna.springboot.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@Controller
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @ResponseBody
    @RequestMapping(value="/addScore",produces = "application/json;charset=utf-8")
    public int addScore(@ModelAttribute("score")Score score){
        System.out.println(score);
        return scoreService.addScore(score);
    }
    @ResponseBody
    @RequestMapping(value="/deleteScore",produces = "application/json;charset=utf-8")
    public int deleteScore(@PathParam("id") int id){
        return scoreService.deleteScoreById(id);
    }
    @ResponseBody
    @RequestMapping(value="/getScoreByStuNo",produces = "application/json;charset=utf-8")
    public List<Map<String, Object>> getScoreByStuNo(@PathParam("std_no") String std_no) {
        return scoreService.getScoreByStuNo(std_no);
    }
    @ResponseBody
    @RequestMapping(value="/getScoreById",produces = "application/json;charset=utf-8")
    public Score getScoreById(@PathParam("id") int id) {
        return scoreService.getScoreById(id);
    }
    @ResponseBody
    @RequestMapping(value="/updateScore",produces = "application/json;charset=utf-8")
    public int UpdateScore(@ModelAttribute Score score) {
        return scoreService.UpdateScore(score);
    }
}
