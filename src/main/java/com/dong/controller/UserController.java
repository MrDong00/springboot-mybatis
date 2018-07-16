package com.dong.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dong.entity.User;
import com.dong.service.UserService;

@RestController
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);
	
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method  = RequestMethod.GET)
    public String user(){
        User user = userService.findUserByName("admin");
        return user.getName()+"-----"+user.getAge();
    }
    
    @RequestMapping(value = "/findAll")
    public List<User> findAll() {
    	List<User> findAll = userService.findAll();
    	return findAll;
    }
    
    @RequestMapping(value = "/findById/{id}")
    public String findById(@PathVariable("id") String id) {
    	logger.error("方法进来了，请注意哈================");
    	return userService.findById(id).toString();
    }
    
}
