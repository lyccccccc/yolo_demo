package com.zt.service.impl;

import com.zt.dao.UserDao;
import com.zt.entity.User;
import com.zt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Title: UserServiceImpl
 * 用户操作实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @Override
    public boolean addUser(User user) {
        boolean flag=false;
        try{
            userDao.addUser(user);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        boolean flag=false;
        try{
            userDao.updateUser(user);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteUser(int id) {
        boolean flag=false;
        try{
            userDao.deleteUser(id);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 根据用户名字查询用户信息
     *
     * @param userName
     */
    @Override
    public User findUserByName(String userName) {
        return userDao.findUserByName(userName);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
