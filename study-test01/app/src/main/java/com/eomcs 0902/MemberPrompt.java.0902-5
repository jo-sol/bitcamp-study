package com.eomcs.pms.handler; // MemberPromptHandler >> 명령어를 처리하는 게 아니기 때문에 이름 변경

import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

// prompt만 전문적으로 다루는 놈
public class MemberPrompt {

  List<Member> memberList;
  // 명령을 처리하고자 만든 게 아니라 다른 핸들러에게 도움을 주기 위해 만든 것이기 때문
  // 상속 받지 말고 자체적으로 처리
  public MemberPrompt(List<Member> memberList) {
    this.memberList = memberList;
  }

  // findByName은 여기에서 사용하기 때문에 삭제 안 함
  protected Member findByName(String name) {
    for (Member member : memberList) {
      if (member.getName().equalsIgnoreCase(name)) {
        return member;
      }
    }
    return null;
  }

  protected static Member findByName(String name, List<Member> memberList) {
    for (Member member : memberList) {
      if (member.getName().equalsIgnoreCase(name)) {
        return member;
      }
    }
    return null;
  }

  public Member promptMember(String label) {
    while (true) {
      String memberName = Prompt.inputString(label); // 1) label에 따라 출력하면서 member 이름을 받기
      if (memberName.length() == 0) { // 2) memberName이 빈 문자열이면 null 리턴
        return null;
      }

      Member member = findByName(memberName); // 3) 만약 찾았으면 그 찾은 정보를 리턴하고
      if (member != null) {
        return member;
      } 
      // 4) 둘 다 아닐 경우에 하단 내용 출력
      System.out.println("등록된 회원이 아닙니다.");
    }
  }
  // 내부에서 어떠한 인스턴스도 사용하지 않기 때문에 static으로 바뀜
  // 파라미터로 받아서 사용하는 놈
  public static Member promptMember(String label, List<Member> memberList) { // 찾을 때 <Member>에서 찾아~
    while (true) {
      String memberName = Prompt.inputString(label); 
      if (memberName.length() == 0) { 
        return null;
      }

      Member member = findByName(memberName, memberList); 
      if (member != null) {
        return member;
      } 
      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  public List<Member> promptMembers(String label) { // 현재의 promptMembers는 멤버 목록을 리턴
    ArrayList<Member> members = new ArrayList<>(); // 멤버를 못 찾아도 빈값을 리턴하겠다

    while (true) {
      String memberName = Prompt.inputString(label);
      Member member = findByName(memberName);
      if (member != null) { // 만약 member를 찾았다면
        members.add(member);
        continue;
      } else if (memberName.length() == 0) {
        break;
      } 
      System.out.println("등록된 회원이 아닙니다.");
    }
    return members; // 최종적으로 이 List를 리턴한다
  }
}







