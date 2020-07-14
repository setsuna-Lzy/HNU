package com.setsuna.springboot.service.Impl;

import com.setsuna.springboot.pojo.Score;
import com.setsuna.springboot.pojo.User;
import com.setsuna.springboot.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int addScore(Score score) {
        String sql="INSERT INTO `score`(`stu_no`,`c_name`,`grade`) VALUE (?,?,?)";
        return jdbcTemplate.update(sql,score.getStu_no(),score.getC_name(),score.getGrade());
    }

    @Override
    public int deleteScoreById(int id) {
        String sql="DELETE FROM `score` WHERE `score_id`=?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Map<String, Object>> getScoreByStuNo(String std_no) {
        String sql="SELECT * FROM `score` WHERE `stu_no`=?";
        return jdbcTemplate.queryForList(sql,std_no);
    }

    @Override
    public Score getScoreById(int id) {
        String sql="SELECT * FROM `score` WHERE score_id=?";
        List<Score>scoreList=jdbcTemplate.query(sql,new Object[]{id},new ScoreRowMapper());
        if(!scoreList.isEmpty()){
            return  scoreList.get(0);
        }
        return null;
    }

    @Override
    public int UpdateScore(Score score) {
        String sql="UPDATE `score` SET `stu_no`=?,`c_name`=?,`grade`=? WHERE `score_id`=?";
        return jdbcTemplate.update(sql,score.getStu_no(),score.getC_name(),score.getGrade(),score.getScore_id());
    }
}

class ScoreRowMapper implements RowMapper<Score> {
    @Override
    public Score mapRow(ResultSet resultSet, int i) throws SQLException {
        Score score=new Score();
        score.setScore_id(resultSet.getInt("score_id"));
        score.setC_name(resultSet.getString("c_name"));
        score.setGrade(resultSet.getInt("grade"));
        score.setStu_no(resultSet.getString("stu_no"));
        return score;
    }
}
