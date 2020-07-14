package com.setsuna.springboot.Controller;

import com.setsuna.springboot.pojo.User;
import com.setsuna.springboot.service.UserService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.rmi.MarshalledObject;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    @ResponseBody
    @RequestMapping(value="/getUser",produces = "application/json;charset=utf-8")
    public User getUserById(@PathParam("id") int id){
        return service.getUserById(id);
    }

    @ResponseBody
    @RequestMapping(value="/addUser",produces = "application/json;charset=utf-8")
    public int addUser(@ModelAttribute("user")User user){
        return service.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value="/updateUser",produces = "application/json;charset=utf-8")
    public int UpdateUser(@ModelAttribute("user")User user){
        return service.UpdateUser(user);
    }

    @ResponseBody
    @RequestMapping(value="/deleteUser",produces = "application/json;charset=utf-8")
    public int DeleteUser(@PathParam("id") int id){
        return service.deleteUserById(id);
    }

    @ResponseBody
    @RequestMapping(value="/getAllUser",produces = "application/json;charset=utf-8")
    public List<Map<String,Object>> getAll(){
        return service.getAll();
    }
}

