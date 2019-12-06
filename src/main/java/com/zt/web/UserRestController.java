package com.zt.web;

import com.zt.entity.User;
import com.zt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Title: UserRestController
 * 用户数据操作接口
 * RestController：默认类中的方法都会以json的格式返回。
 * RequestMapping: 接口路径配置。
 * method : 请求格式。
 * RequestParam: 请求参数。
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user){
        System.out.println("开始新增...");
        return userService.addUser(user);
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public boolean updateUser(User user){
        System.out.println("开始更新...");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public boolean deleteUser(@RequestParam("id")Integer id){
        System.out.println("开始删除...");
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/user/name/{userName}",method = RequestMethod.GET)
    public User findUserByName(@PathVariable("userName") String userName){
        System.out.println("根据用户名查询..."+userName);
        return userService.findUserByName(userName);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") Integer id){
        System.out.println("根据用户id查询..."+id);
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/userAll",method = RequestMethod.GET)
    public List<User> findAll(){
        System.out.println("查询所有用户");
        return userService.findAll();
    }

    @RequestMapping(value = "/user/class/{classId}",method = RequestMethod.GET)
    public List<User> findUserByClassId(@PathVariable("classId") Integer id){
        System.out.println("查询所有用户"+id);
        return userService.findUserByClassId(id);
    }
}
