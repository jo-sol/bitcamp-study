package com.ogong.pms.domain;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Admin implements Serializable{

  private int masterNo; // 관리자 번호
  private String masterNickname; // 관리자 닉네임
  private String masterEmail;    // 관리자 이메일
  private String masterPassword; // 관리자 비밀번호
  private List<Member> blockMember; // 차단된 회원


  @Override
  public String toString() {
    return "Admin [masterNo=" + masterNo + ", masterNickname=" + masterNickname + ", masterEmail="
        + masterEmail + ", masterPassword=" + masterPassword + ", blockMember=" + blockMember + "]";
  }

  public int getMasterNo() {
    return masterNo;
  }

  public void setMasterNo(int masterNo) {
    this.masterNo = masterNo;
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

  public List<Member> getBlockMember() {
    return blockMember;
  }

  public void setBlockMember(List<Member> blockMember) {
    this.blockMember = blockMember;
  }



}
