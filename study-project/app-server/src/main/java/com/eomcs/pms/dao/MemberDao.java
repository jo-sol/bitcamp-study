package com.eomcs.pms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.eomcs.pms.domain.Member;

// <mapper namespace="com.eomcs.pms.dao.XXXDao">와 인터페이스에 있는 이름이 일치해야 한다!!
// <select id="findAll"> 이라면 인터페이스의 findAll() 메서드와 이름이 일치해야 함!!
// 치명적인 문제! >>
// ex. findByEmailAndPassword(String email, String password) 의 경우 Mapper에서 파라미터 타입이 Map인 상태
// [ 방법 1) 기존 ]
// <select id="findByEmailAndPassword" resultMap="XXXMap" parameterType="map">
// email=#{email} and password=password(#{password})
// - 파라미터는 반드시 하나여야 하지만 파라미터가 두 개 이상인 경우, 하기 내용처럼 앞에 표시를 해 줘야 한다.
// [ 방법 1) 변경 ]
// <select id="findByEmailAndPassword" resultMap="XXXMap">
// email=#{param1} and password=password(#{param2}) >> 파라미터의 순서대로 지정
// [ 방법 2) 이름으로 쓰고 싶어요 > Dao ]
// findByEmailAndPassword(String email, String password)
// email=#{param1} and password=password(#{param2})
// [ 방법 2) 변경 ]
// - annotation(주석) 달아 주기 > Param(ibatis)
// findByEmailAndPassword(@Param("email") String email, @Param("password") String password)
// email=#{email} and password=password(#{password})

// 역할
// - 회원 데이터를 처리하는 객체 사용법을 정의한다.
public interface MemberDao {
  void insert(Member member) throws Exception;
  List<Member> findAll() throws Exception;
  Member findByNo(int no) throws Exception;
  Member findByName(String name) throws Exception;
  Member findByEmailAndPassword(@Param("email") String email, @Param("password") String password) throws Exception;
  void update(Member member) throws Exception;
  void delete(int no) throws Exception;
}
