package com.zt.service.impl;

import com.zt.dao.ClassDao;
import com.zt.entity.Class;
import com.zt.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;


    @Override
    public Class getClassById(Integer classId) {
        return classDao.getClassById(classId);
    }

    @Override
    public List<Class> findAll() {
        return classDao.findAll();
    }
}
