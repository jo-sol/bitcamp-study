package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Member;

public class MemberList extends ArrayList {

  public Member findByNo(int no) {
    Object[] arr = toArray();
    for (Object obj : arr) {
      Member member = (Member) obj; // 반복문을 돌 때마다 하는 게 아니라 여기에서 한 번 쓰는 것
      if (member.no == no) {
        return member; // member에서만 하는 거니까 -> 변수명(int no 등)이 같을 거라는 보장을 못하기 때문!
      }
    }
    return null;
  }

  // ArrayList의 공통이 아니기 때문에 여기에서 사용
  public boolean exist(String name) {
    Object[] arr = toArray();
    for (Object obj : arr) {
      Member member = (Member) obj; // 반복문을 돌 때마다 하는 게 아니라 여기에서 한 번 쓰는 것
      if (member.name.equals(name)) {
        return true; // 같으면 true
      }
    }
    return false; // 아니면 false
  }
}








