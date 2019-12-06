package com.zt.service;

import com.zt.entity.User;

import java.util.List;

/**
 *
 * Title: UserServiceImpl
 * 用户操作接口
 */
public interface UserService {

    /**
     * 新增用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    boolean updateUser(User user);


    /**
     * 删除用户
     * @param id
     * @return
     */
    boolean deleteUser(int id);

    /**
     * 根据用户名字查询用户信息
     * @param userName
     */
    User findUserByName(String userName);

    User findUserById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 查询课程所有学生
     * @return
     */
    List<User> findUserByClassId(Integer id);
}
