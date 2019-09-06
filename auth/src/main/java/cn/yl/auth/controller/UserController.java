package cn.yl.auth.controller;


import cn.yl.auth.dao.UserRepository;
import cn.yl.auth.entity.UserEntity;
import cn.yl.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 杨列
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List listUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserEntity create(@RequestBody UserEntity user){
        return userRepository.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Integer id){
        userRepository.deleteByStaffId(id);
        return "success";
    }

}
