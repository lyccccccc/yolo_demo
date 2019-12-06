package com.zt.dao;


import com.zt.entity.Class;
import com.zt.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * mapper :在接口上添加了这个注解表示这个接口是基于注解实现的CRUD。
 * Results: 返回的map结果集，property 表示User类的字段，column 表示对应数据库的字段。
 * Param:sql条件的字段。
 * Insert、Select、Update、Delete:对应数据库的增、查、改、删。
 */
@Mapper
public interface ClassDao {

    @Select("select * from class where classId = #{id}")
    Class getClassById(Integer classId);

    @Select("select * from class")
    List<Class> findAll();

//    我们要使用@Resutl注解对返回的结果进行配置，
//- property = “cars”, 表示要将返回的查询结果赋值给user的cars属性
//- column = “id” 是指将user表中的用户主键id作为com.kingboy.repository.address.CarRepository.findCarByUserId的查询参数
//- many 表示这是一个一对多的查询
//- @Many(select = “方法全路径) 表示我们调用的方法, 方法参数userId就是上面column指定的列值
}
