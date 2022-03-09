package com.oliver.experiment.controller;

import com.oliver.experiment.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author 21051487 sunchengyu
 * @version 1.0
 * @date 22/3/9
 * @description 用户控制器，主要实现不同的请求方式
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 创建线程安全的Map，模拟users信息的存储
     */
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @GetMapping("/")
    public List<User> getUserList(){
        return new ArrayList<User>(users.values());
    }

    @PostMapping("/")
    public String saveUser(@RequestBody User user){
        users.put(user.getId(),user);
        return "success";
    }

    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable("id") Long id){
        return users.get(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id,@RequestBody User user){
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id,u);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        users.remove(id);
        return "success";
    }
}
