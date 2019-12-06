package com.zt.dao;

import com.zt.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * mapper :在接口上添加了这个注解表示这个接口是基于注解实现的CRUD。
 * Results: 返回的map结果集，property 表示User类的字段，column 表示对应数据库的字段。
 * Param:sql条件的字段。
 * Insert、Select、Update、Delete:对应数据库的增、查、改、删。
 */
@Mapper
public interface UserDao {

    /**
     * 用户数据新增
     */
    @Insert("insert into t_user(id,name,age,classId) values (#{id},#{name},#{age},#{classId})")
    void addUser(User user);

    /**
     * 用户数据修改
     */
    @Update("update t_user set name=#{name},age=#{age},classId=#{classId} where id=#{id}")
    void updateUser(User user);

    /**
     * 用户数据删除
     */
    @Delete("delete from t_user where id=#{id}")
    void deleteUser(Integer id);

    /**
     * 根据用户名称查询用户数据
     */
    @Select("select id,name,age,classId from t_user where name = #{name}")
    User findUserByName(@Param("name") String userName);

    /**
     * 根据用户名称查询用户数据
     */
    @Select("select id,name,age,classId from t_user where id = #{id}")
    User findUserById(@Param("id") Integer id);

    /**
     * 查询所有
     */
    @Select("select id,name,age,classId from t_user")
    List<User> findAll();

    /**
     * 查找某个课程的学术
     */
    @Select("select * from t_user where classId in(select classId from class where classId = #{id})")
//    @Results({
//            @Result(id =true,property = "id",column = "id"),
//            @Result(property = "name",column = "name"),
//            @Result(property = "age",column = "age"),
//            @Result(property = "iClass",column = "classId",many = @Many(select = "com.zt.dao.ClassDao.findAll"
//            ,fetchType = FetchType.LAZY))
//    })
    List<User> findUserByClassId(Integer id);
}
