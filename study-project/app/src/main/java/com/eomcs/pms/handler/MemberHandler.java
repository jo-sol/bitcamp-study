package com.eomcs.pms.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberHandler {

  List<Member> memberList;

  public MemberHandler(List<Member> memberList) {
    this.memberList = memberList;

    // AuthHandler에 있는 걸 MemberHandler로 옮김(여기 샘플이 우선)
    // 샘플 회원 미리 입력
    Member testUser = new Member();
    testUser.setNo(1);
    testUser.setName("aaa");
    testUser.setEmail("aaa@test.com");
    testUser.setPassword("1111");
    testUser.setPhoto("aaa.gif");
    testUser.setTel("010-1111-1111");
    testUser.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(testUser);

    testUser = new Member();
    testUser.setNo(2);
    testUser.setName("bbb");
    testUser.setEmail("bbb@test.com");
    testUser.setPassword("1111");
    testUser.setPhoto("bbb.gif");
    testUser.setTel("010-1111-2222");
    testUser.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(testUser);

    testUser = new Member();
    testUser.setNo(3);
    testUser.setName("ccc");
    testUser.setEmail("ccc@test.com");
    testUser.setPassword("1111");
    testUser.setPhoto("ccc.gif");
    testUser.setTel("010-1111-3333");
    testUser.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(testUser);

    testUser = new Member();
    testUser.setNo(4);
    testUser.setName("ddd");
    testUser.setEmail("ddd@test.com");
    testUser.setPassword("1111");
    testUser.setPhoto("ddd.gif");
    testUser.setTel("010-1111-4444");
    testUser.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(testUser);
  }

  public void add() {
    System.out.println("[회원 등록]");

    Member member = new Member();

    member.setNo(Prompt.inputInt("번호? "));
    member.setName(Prompt.inputString("이름? "));
    member.setEmail(Prompt.inputString("이메일? "));
    member.setPassword(Prompt.inputString("암호? "));
    member.setPhoto(Prompt.inputString("사진? "));
    member.setTel(Prompt.inputString("전화? "));
    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(member);
  }

  public void list() {
    System.out.println("[회원 목록]");

    Member[] list = memberList.toArray(new Member[0]);

    for (Member member : list) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          member.getNo(), 
          member.getName(), 
          member.getEmail(), 
          member.getTel(), 
          member.getRegisteredDate());
    }
  }

  public void detail() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("사진: %s\n", member.getPhoto());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("등록일: %s\n", member.getRegisteredDate());
  }

  public void update() {
    System.out.println("[회원 변경]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String name = Prompt.inputString("이름(" + member.getName()  + ")? ");
    String email = Prompt.inputString("이메일(" + member.getEmail() + ")? ");
    String password = Prompt.inputString("암호? ");
    String photo = Prompt.inputString("사진(" + member.getPhoto() + ")? ");
    String tel = Prompt.inputString("전화(" + member.getTel() + ")? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.setName(name);
    member.setEmail(email);
    member.setPassword(password);
    member.setPhoto(photo);
    member.setTel(tel);

    System.out.println("회원을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[회원 삭제]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }

    memberList.remove(member);

    System.out.println("회원을 삭제하였습니다.");
  }

  private Member findByNo(int no) {
    for (Member member : memberList) {
      if (member.getNo() == no) {
        return member;
      }
    }
    return null;
  }

  private Member findByName(String name) {
    for (Member member : memberList) {
      if (member.getName().equalsIgnoreCase(name)) {
        return member;
      }
    }
    return null;
  }

  private static Member findByName(String name, List<Member> memberList) {
    for (Member member : memberList) {
      if (member.getName().equalsIgnoreCase(name)) {
        return member;
      }
    }
    return null;
  }

  public boolean exist(String name) {
    for (Member member : memberList) {
      if (member.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  // 파라미터가 다르더라도 같은 기능을 수용하는 메서드에 대해
  // 같은 이름을 부여함으로서 일관성을 보여 줄 수 있음
  // 오버로딩
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
  // 내부에서 어떠한 인스턴스도 사용하지 않기 때문에 static으로 바뀜 ***
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







