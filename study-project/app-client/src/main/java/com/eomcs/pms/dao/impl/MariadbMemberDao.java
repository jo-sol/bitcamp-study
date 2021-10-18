package com.eomcs.pms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;

// 역할
// - 회원 데이터를 DBMS 서버를 통해 관리한다.
//
public class MariadbMemberDao implements MemberDao {

  Connection con;

  public MariadbMemberDao(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(Member member) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into pms_member(name,email,password,photo,tel) values(?,?,password(?),?,?)")) {

      // DB는 1부터 시작함 > Array는 0부터
      stmt.setString(1, member.getName());
      stmt.setString(2, member.getEmail());
      stmt.setString(3, member.getPassword());
      stmt.setString(4, member.getPhoto());
      stmt.setString(5, member.getTel());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 저장 실패!");
      }
    }
  }

  @Override
  public List<Member> findAll() throws Exception {
    // pms_member를 불러오는데 이름 알파벳 순으로
    // con.pre~가 리턴하는 건 Prepared~
    try (PreparedStatement stmt = con.prepareStatement(
        "select member_no,name,email,tel,created_dt from pms_member order by name asc");
        ResultSet rs = stmt.executeQuery()) {

      ArrayList<Member> list = new ArrayList<>();

      // 서버에서 내 코드 하나 가지고 와 > 가지고 왔으면 하나 꺼내서 멤버 객체에 담아
      while (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_no"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setTel(rs.getString("tel"));
        member.setRegisteredDate(rs.getDate("created_dt"));

        list.add(member);
      }

      return list;
    }
  }

  @Override
  public Member findByNo(int no) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select member_no,name,email,photo,tel,created_dt from pms_member where member_no=" + no);
        ResultSet rs = stmt.executeQuery()) {

      if (!rs.next()) {
        return null;
      }

      Member member = new Member();
      member.setNo(rs.getInt("member_no"));
      member.setName(rs.getString("name"));
      member.setEmail(rs.getString("email"));
      member.setPhoto(rs.getString("photo"));
      member.setTel(rs.getString("tel"));
      member.setRegisteredDate(rs.getDate("created_dt"));

      return member;
    }
  }

  @Override
  public Member findByName(String name) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select member_no,name,email,photo,tel,created_dt from pms_member"
            + " where name=?")) {

      stmt.setString(1, name);

      // ResultSet을 자동 Close 하기 위해 try문 안에 try문을 또 둠
      // 일반 문장은 try() 안에 둘 수 없기 때문에 stmt.setString(1, name); 문장을 밖에 따로 둔 것
      try (ResultSet rs = stmt.executeQuery()) {

        if (!rs.next()) {
          return null;
        }

        Member member = new Member();
        member.setNo(rs.getInt("member_no"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setPhoto(rs.getString("photo"));
        member.setTel(rs.getString("tel"));
        member.setRegisteredDate(rs.getDate("created_dt"));

        return member;
      }
    }
  }

  @Override
  public Member findByEmailAndPassword(String email, String password) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select member_no,name,email,photo,tel,created_dt from pms_member"
            + " where email=? and password=password(?)")) {

      stmt.setString(1, email);
      stmt.setString(2, password);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }
        Member member = new Member();
        member.setNo(rs.getInt("member_no"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setPhoto(rs.getString("photo"));
        member.setTel(rs.getString("tel"));
        member.setRegisteredDate(rs.getDate("created_dt"));
        return member;
      }
    }
  }

  @Override
  public void update(Member member) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "update pms_member set"
            + " name=?,email=?,password=password(?),photo=?,tel=?"
            + " where member_no=?")) {

      stmt.setString(1, member.getName());
      stmt.setString(2, member.getEmail());
      stmt.setString(3, member.getPassword());
      stmt.setString(4, member.getPhoto());
      stmt.setString(5, member.getTel());
      stmt.setInt(6, member.getNo());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 변경 실패!");
      }
    }
  }

  @Override
  public void delete(int no) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from pms_member where member_no=?")) {

      stmt.setInt(1, no);

      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 삭제 실패!");
      }
    }
  }
}



