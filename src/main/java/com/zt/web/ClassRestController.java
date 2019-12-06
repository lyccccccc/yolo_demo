package com.zt.web;


import com.zt.entity.Class;
import com.zt.entity.User;
import com.zt.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassRestController {

    @Autowired
    private ClassService classService;

    @RequestMapping(value = "/class/{id}",method = RequestMethod.GET)
    public Class findClassById(@PathVariable("id") Integer id){
        System.out.println("根据课程id查询..."+id);
        return classService.getClassById(id);
    }

    @RequestMapping(value = "/allClass",method = RequestMethod.GET)
    public List<Class> findAll(){
        System.out.println("查询所有课程。。。");
        return classService.findAll();
    }

}
