package com.ogong.pms.domain;

import java.sql.Date;

public class Member {

  private int perNo;
  private String perNickname;
  private String perEmail;
  private String perPassword;
  private String perPhoto;
  private Date perRegisteredDate;

  private int masterno;
  private String masterNickname;
  private String masterEmail;
  private String masterPassword;
  private Date masterRegisteredDate;

  // 객체의 내용을 출력할 때 println으로 바로바로 출력하면
  // 개발하는 동안 확인하기 쉽기 때문에 toString()을 오버라이딩 함
  @Override
  public String toString() {
    return "Member [perNo=" + perNo + ", perNickname=" + perNickname + ", perEmail=" + perEmail
        + ", perPassword=" + perPassword + ", perPhoto=" + perPhoto + ", perRegisteredDate="
        + perRegisteredDate + ", masterno=" + masterno + ", masterNickname=" + masterNickname
        + ", masterEmail=" + masterEmail + ", masterPassword=" + masterPassword
        + ", masterRegisteredDate=" + masterRegisteredDate + "]";
  }


  public int getPerNo() {
    return perNo;
  }
  public void setPerNo(int perNo) {
    this.perNo = perNo;
  }
  public String getPerNickname() {
    return perNickname;
  }
  public void setPerNickname(String perNickname) {
    this.perNickname = perNickname;
  }
  public String getPerEmail() {
    return perEmail;
  }
  public void setPerEmail(String perEmail) {
    this.perEmail = perEmail;
  }
  public String getPerPassword() {
    return perPassword;
  }
  public void setPerPassword(String perPassword) {
    this.perPassword = perPassword;
  }
  public String getPerPhoto() {
    return perPhoto;
  }
  public void setPerPhoto(String perPhoto) {
    this.perPhoto = perPhoto;
  }
  public Date getPerRegisteredDate() {
    return perRegisteredDate;
  }
  public void setPerRegisteredDate(Date perRegisteredDate) {
    this.perRegisteredDate = perRegisteredDate;
  }
  // ---------------------------------------------------------------------------------
  public int getMasterno() {
    return masterno;
  }
  public void setMasterno(int masterno) {
    this.masterno = masterno;
  }
  public String getMasterNickname() {
    return masterNickname;
  }
  public void setMasterNickname(String masterNickname) {
    this.masterNickname = masterNickname;
  }
  public String getMasterEmail() {
    return masterEmail;
  }
  public void setMasterEmail(String masterEmail) {
    this.masterEmail = masterEmail;
  }
  public String getMasterPassword() {
    return masterPassword;
  }
  public void setMasterPassword(String masterPassword) {
    this.masterPassword = masterPassword;
  }
  public Date getMasterRegisteredDate() {
    return masterRegisteredDate;
  }
  public void setMasterRegisteredDate(Date masterRegisteredDate) {
    this.masterRegisteredDate = masterRegisteredDate;
  }

}