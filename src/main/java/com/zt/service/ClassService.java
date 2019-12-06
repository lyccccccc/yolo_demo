package com.zt.service;

import com.zt.entity.Class;

import java.util.List;

public interface ClassService {
    Class getClassById(Integer id);

    List<Class> findAll();
}
