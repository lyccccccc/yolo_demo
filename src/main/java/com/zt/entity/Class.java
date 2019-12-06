package com.zt.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Class {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer classId;
    private String cname;

}
