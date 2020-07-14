package com.setsuna.springboot.service.Impl;

import com.setsuna.springboot.pojo.User;
import com.setsuna.springboot.service.UserService;
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
public class UserServiceImpl implements UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public User getUserById(Integer id) {
        String sql="SELECT * FROM `student` where id=?";
        List<User> userList=jdbcTemplate.query(sql,new Object[]{id},new UserRowMapper());
        if(!userList.isEmpty()){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public int addUser(User user) {
        String sql="INSERT INTO `student`(`stu_no`,`stu_name`,`sex`,`birth`,`department`,`addr`) VALUE (?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,user.getStu_no(),user.getStu_name(),user.getSex(),user.getBirth(),user.getDepartment(),user.getAddr());
    }

    @Override
    public int deleteUserById(Integer id) {
        String sql="DELETE FROM `student` WHERE `id`=?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int UpdateUser(User user) {
       String sql="UPDATE `student` SET `stu_no`=?,`stu_name`=?,`sex`=?,`birth`=?,`department`=?,`addr`=? WHERE `id`=?";
       return jdbcTemplate.update(sql,user.getStu_no(),user.getStu_name(),user.getSex(),user.getBirth(),user.getDepartment(),user.getAddr(),user.getId());
    }

    @Override
    public List<Map<String,Object>> getAll() {
        String sql="SELECT * FROM student";
        return jdbcTemplate.queryForList(sql);
    }
}
class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User();
        user.setId(resultSet.getInt("id"));
        user.setStu_no(resultSet.getString("stu_no"));
        user.setStu_name(resultSet.getString("stu_name"));
        user.setSex(resultSet.getString("sex"));
        try {
            user.setBirth((resultSet.getDate("birth")).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setDepartment(resultSet.getString("department"));
        user.setAddr(resultSet.getString("addr"));
        return user;
    }
}
