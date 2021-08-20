package com.eomcs.pms01.handler;

import java.sql.Date;
import com.eomcs.pms01.domain.Member;
import com.eomcs.util.Prompt;

public class MemberHandler {

  static final int MAX_LENGTH = 5;

  // Member 인스턴스의 주소를 저장할 레퍼런스를 3개 생성한다.
  Member[] members = new Member[MAX_LENGTH];
  int size = 0;

  // 다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void add() {
    System.out.println("[회원 등록]");

    // 새 회원 정보를 담을 변수를 준비한다.
    // 낱 개의 변수가 아니라 Member에 정의된 대로 묶음 변수를 만든다.
    Member member = new Member();

    member.no = Prompt.inputInt("번호? ");
    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    this.members[this.size++] = member;
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          this.members[i].no, 
          this.members[i].name, 
          this.members[i].email, 
          this.members[i].tel, 
          this.members[i].registeredDate);
    }
  }


  public void detail() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");

    //    //    Member member = null;
    //    int index = -1; // (못 찾았을 경우를 대비하여 값을 -1로 주기)
    //    for (int i = 0; i < this.size; i++) {
    //      if (this.members[i].no == no) {
    //        index = i;
    //        //        member = this.members[i];
    //        break;
    //      }
    //    }
    // 두 번째 방법은 하단과 같음
    int i;
    for(i = 0; i < this.size; i++) {
      if (this.members[i].no == no) {
        break;
      }
    }

    if (i == this.size) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("이름? %s\n", members[i].name);
    System.out.printf("이메일? %s\n", members[i].email);
    System.out.printf("사진? %s\n", members[i].photo);
    System.out.printf("전화? %s\n", members[i].tel);
    System.out.printf("등록일? %s\n", members[i].registeredDate);
  }

  public void update() {
    System.out.println("[회원 변경]");
    int no = Prompt.inputInt("번호? ");

    Member member = null;

    for (int i = 0; i < this.size; i++) {
      if (members[i].no == no) {
        member = members[i];
        break;
      }
    }

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String person = String.format("이름:(%s)? ", member.name); // member.name = 이렇게 직접 넣으면 아예 바뀜
    String name = Prompt.inputString(person);

    // String name = Prompt.inputString("이름(" + member.name + ")? "); -> 원래 이름은 member.name인데 바꾸고 싶은 게 뭐예요?

    person = String.format("이메일:(%s)? ", member.email); // 그래서 임시 변수에 담아야 함
    String email = Prompt.inputString(person);

    // String email = Prompt.inputString(String.format("이메일:(%s)? ", member.email);

    person = String.format("암호:(%s)? ", member.password);
    String password = Prompt.inputString(person);

    person = String.format("사진:(%s)? ", member.photo);
    String photo = Prompt.inputString(person);

    person = String.format("전화:(%s)? ", member.tel);
    String tel = Prompt.inputString(person);

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.name = name;
    member.email = email;
    member.password = password;
    member.photo = photo;
    member.tel = tel;

    System.out.println("회원을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[회원 삭제]");
    int no = Prompt.inputInt("번호? ");

    // 인덱스를 알아내야 앞으로 당길 수 있음
    // 배열은 0부터 시작하기 때문에 0 자체가 유효한 인덱스라 겹칠 일 없는 -1로 선언해 줘야 한다
    int memberIndex = -1;

    for (int i = 0; i < this.size; i++) {
      if (this.members[i].no == no) {
        memberIndex = i;
        // 
        break;
      }
    }

    if (memberIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }

    // 인덱스의 앞번호에서 하나 당겨서
    for (int i = memberIndex +1; i <this.size; i++) {
      // 현재 삭제할 이전 번호(시작 번호)로 다시 옮길 수 있음
      this.members[i - 1] = this.members[i];
    }
    // 당기고 가장 맨끝을 가리키는데 그걸 null로 선언해 줌
    // size 밖을 벗어나면 반복하지 않으니까 null 선언 안 해도 되지만
    // 쓰지도 않는 메모리를 당겨지기 전(null 선언해 줘야 하는 자리)의 자리가 가지고 있기 때문에
    // 메모리를 제대로 활용할 수가 없음
    // 별도) 주소를 알고 있는 변수가 없으면 해당 메모리를 더 이상 사용할 수 없음(JVM 종료 시까지) = garbage가 됨
    this.members[--this.size] = null;

    System.out.println("회원을 삭제하였습니다.");
  }

  public boolean exist(String name) {
    for (int i = 0; i < this.size; i++) {
      if (this.members[i].name.equals(name)) {
        return true;
      }
    }
    return false;
  }

}

//public void detail() {
//  System.out.println("[회원 상세보기]");
//  int no = Prompt.inputInt("번호? ");
//
//  Member member = null;
//
//  for (int i = 0; i < this.size; i++) {
//    if (members[i].no == no) {
//      member = members[i];
//      break;
//    }
//  }
//
//  if (member == null) {
//    System.out.println("해당 번호의 회원이 없습니다.");
//    return;
//  }
//
//  System.out.printf("이름? %s\n", member.name);
//  System.out.printf("이메일? %s\n", member.email);
//  System.out.printf("사진? %s\n", member.photo);
//  System.out.printf("전화? %s\n", member.tel);
//  System.out.printf("등록일? %s\n", member.registeredDate);
//}
