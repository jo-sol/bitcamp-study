package com.eomcs.pms.domain;

import java.sql.Date;

public class Member {
  // 한 회원의 데이터를 저장할 수 있도록
  // 새 구조의 데이터 타입(user defined data type)을 정의한다.
  public int no;
  public String name;
  public String email;
  public String password;
  public String photo;
  public String tel;
  public Date registeredDate;
}
