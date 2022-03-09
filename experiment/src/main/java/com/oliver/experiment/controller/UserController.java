package com.oliver.experiment.controller;

import com.oliver.experiment.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author 21051487 sunchengyu
 * @version 1.0
 * @date 22/3/9
 * @description 用户控制器，主要实现不同的请求方式
 */
@Api (tags = "用户管理")
@RestController
@RequestMapping ("/user")
public class UserController {
    
    /**
     * 创建线程安全的Map，模拟users信息的存储
     */
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());
    
    /**
     * 处理"/users/"的GET请求，用来获取用户列表
     *
     * @return 所有用户
     */
    @GetMapping ("/")
    @ApiOperation ("获取用户列表")
    public List<User> getUserList() {
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        return new ArrayList<>(users.values());
    }
    
    /**
     * 处理"/users/"的POST请求，用来创建User
     *
     * @param user 用户详细信息
     * @return 状态码
     */
    @PostMapping ("/")
    @ApiOperation (value = "创建用户", notes = "根据 User 对象创建用户")
    public String saveUser(@RequestBody User user) {
        // @RequestBody注解用来绑定通过http请求中application/json类型上传的数据
        users.put(user.getId(), user);
        return "success";
    }
    
    /**
     * 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
     *
     * @param id 用户ID
     * @return 用户详细信息
     */
    @GetMapping ("/{id}")
    @ApiOperation (value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    public User getUserInfo(@PathVariable ("id") Long id) {
        // url中的id可通过@PathVariable绑定到函数的参数中
        User user = users.get(id);
        if (user == null) {
            return new User();
        }
        return users.get(id);
    }
    
    /**
     * 处理"/users/{id}"的PUT请求，用来更新User信息
     *
     * @param id   用户ID
     * @param user 更新的用户信息
     * @return 状态码
     */
    @PutMapping ("/{id}")
    @ApiImplicitParam (paramType = "path", dataType = "Long", name = "id", value = "用户编号", required = true, example = "1")
    @ApiOperation (value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    public String updateUser(@PathVariable ("id") Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }
    
    /**
     * 处理"/users/{id}"的DELETE请求，用来删除User
     *
     * @param id 用户id
     * @return 状态码
     */
    @DeleteMapping ("/{id}")
    @ApiOperation (value = "删除用户", notes = "根据url的id来指定删除对象")
    public String deleteUser(@PathVariable ("id") Long id) {
        users.remove(id);
        return "success";
    }
}
