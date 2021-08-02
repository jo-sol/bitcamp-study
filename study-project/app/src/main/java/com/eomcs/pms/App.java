package com.eomcs.pms;

import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.util.Prompt;

// 1) 메인 메뉴를 출력하고 번호를 입력 받는다. (강사님 App.java.01)
//      - 0 번을 입력하면 프로그램을 종료한다.
// 2) 게시판 메뉴를 출력하고 번호를 입력 받는다. (강사님 App.java.02)
//      - 사용자가 입력한 메뉴 번호에 따라 실행할 명령어를 설정한다.
// 3) 회원/프로젝트/작업 메뉴를 출력하고 번호를 입력 받는다. (강사님 App.java.03)
//      - 사용자가 입력한 메뉴 번호에 따라 실행할 명령어를 설정한다.
// 4) 메뉴 번호를 입력했을 때 해당 기능을 바로 실행하게 한다. (강사님 App.java.04)
// 5) 각각의 메인 메뉴를 다루는 코드를 별도의 메서드로 추출한다. -> 유지보수하기 좋게 (강사님 App.java.05)
//      - doBoardMenu 메서드 정의
//      - doMemberMenu 메서드 정의
//      - doProjectMenu 메서드 정의
//      - doTaskMenu 메서드 정의
//      - doMainMenu 메서드 정의
public class App {

  // main() 메서드와 doXxxMenu() 메서드가 공유하는 변수는
  // 같은 스태틱 멤버로 만든다. => **main() 메서드와 doXxx() 메서드 둘 다 static 메서드라서**
  static BoardHandler boardHandler = new BoardHandler();
  static MemberHandler memberHandler = new MemberHandler();
  static ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  static TaskHandler taskHandler = new TaskHandler(memberHandler);

  // 위 코드는 아래 코드처럼 변환이 되며 같은 뜻이다.
  //  static BoardHandler boardHandler;
  //  
  //  static {
  //    boardHandler = new BoardHandler();
  //    memberHandler = new MemberHandler();
  //    projectHandler = new ProjectHandler(memberHandler);
  //    taskHandler = new TaskHandler(memberHandler);
  //  } 

  public static void main(String[] args) {
    while (true) {
      int menuNo = doMainMenu();

      if (menuNo == 0) {
        break;
      } else if (menuNo == 1) {
        doBoardMenu(); // 만약 번호를 입력하면 doBoardMenu() 호출
      } else if (menuNo == 2) {
        doMemberMenu(); // 만약 번호를 입력하면 doMemberMenu() 호출
      } else if (menuNo == 3) {
        doProjectMenu(); // 만약 번호를 입력하면 doProjectMenu() 호출
      } else if (menuNo == 4) {
        doTaskMenu(); // 만약 번호를 입력하면 doTaskMenu() 호출
      } else {
        System.out.println("메뉴 번호가 유효하지 않습니다.");
      }
      System.out.println();
    }

    Prompt.close();
  }

  static void doBoardMenu() {
    while (true) {
      System.out.println("[메인/게시판]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전 메뉴");

      int menuNo = Prompt.inputInt("게시판> ");
      switch (menuNo) {
        case 1: boardHandler.add(); break;
        case 2: boardHandler.list(); break; 
        case 3: boardHandler.detail(); break;
        case 4: boardHandler.update(); break;
        case 5: boardHandler.delete(); break;
        case 0: return; // 만약 0 번이면!! doBoardMenu()를 끝내자!! 라는 의미 **
        default: // 그 밖에는!!
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println(); // 위아래 공백 한 줄 넣기
    }
  }

  static void doMemberMenu() {
    while (true) {
      System.out.println("[메인/회원]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전 메뉴");

      int menuNo = Prompt.inputInt("회원> ");
      switch (menuNo) {
        case 1: memberHandler.add(); break; 
        case 2: memberHandler.list(); break; 
        case 3: memberHandler.detail(); break;
        case 4: memberHandler.update(); break;
        case 5: memberHandler.delete(); break;
        case 0: return; // 만약 0 번이면!! doMemberMenu()를 끝내자!! 라는 의미 **
        default: // 그 밖에는!!
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println(); // 위아래 공백 한 줄 넣기
    }
  }

  static void doProjectMenu() {
    while (true) {
      System.out.println("[메인/프로젝트]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전 메뉴");

      int menuNo = Prompt.inputInt("프로젝트> "); // 기존 변수 재활용이 아니니까 int 붙여서 새로 만들기
      switch (menuNo) {
        case 1: projectHandler.add(); break; // break -> switch를 나가는 것이기 때문에 while 나갈 수 있게 loop 사용
        case 2: projectHandler.list(); break; // /project/list를 입력한 것처럼 사용하기
        case 3: projectHandler.detail(); break;
        case 4: projectHandler.update(); break;
        case 5: projectHandler.delete(); break;
        case 0: return; // 만약 0 번이면!! doProjectMenu()를 끝내자!! 라는 의미 **
        default: // 그 밖에는!!
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println(); // 위아래 공백 한 줄 넣기
    }
  }

  static void doTaskMenu() {
    while (true) {
      System.out.println("[메인/작업]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전 메뉴");

      int menuNo = Prompt.inputInt("작업> ");
      switch (menuNo) {
        case 1: taskHandler.add(); break; // break -> switch를 나가는 것이기 때문에 while 나갈 수 있게 loop 사용
        case 2: taskHandler.list(); break; // /task/list를 입력한 것처럼 사용하기
        case 3: taskHandler.detail(); break;
        case 4: taskHandler.update(); break;
        case 5: taskHandler.delete(); break;
        case 0: return; // 만약 0 번이면!! doTaskMenu()를 끝내자!! 라는 의미 **
        default: // 그 밖에는!!
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println(); // 위아래 공백 한 줄 넣기
    }
  }

  static int doMainMenu() {
    System.out.println("[메인]");
    System.out.println("1. 게시판");
    System.out.println("2. 회원");
    System.out.println("3. 프로젝트");
    System.out.println("4. 작업");
    System.out.println("0. 종료");
    return Prompt.inputInt("메인> ");
  }

}












