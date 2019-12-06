package com.zt.entity;


import lombok.Data;

import javax.persistence.Id;
import java.util.List;

@Data
public class User {

  private static final long serialVersionUID = 1L;

  @Id
  private Integer id;

  private String name;
  private Integer age;
  private Integer classId;


}
