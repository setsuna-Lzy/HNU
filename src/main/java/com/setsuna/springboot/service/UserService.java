package com.setsuna.springboot.service;

import com.setsuna.springboot.pojo.User;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     *通过id获User对象
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 将User对象加入数据库
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 通过id删除数据库中的User
     * @param id
     * @return
     */
    int deleteUserById(Integer id);

    /**
     * 更新User对象，传入的是更新后的User
     * @param user
     * @return
     */
    int UpdateUser(User user);

    /**
     * 获取全部的学生对象
     * @return
     */
    List<Map<String, Object>> getAll();
}
