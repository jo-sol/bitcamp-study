package com.eomcs.pms1;

import com.eomcs.pms1.handler.BoardHandler;
import com.eomcs.pms1.handler.MemberHandler;
import com.eomcs.pms1.handler.ProjectHandler;
import com.eomcs.pms1.handler.TaskHandler;
import com.eomcs.util.Prompt02;

public class App {

  public static void main(String[] args) {

    // 각 게시판의 게시글을 담은 메모리(boards 레퍼런스 배열과 size)를 준비한다.
    // new BoardHandler()
    //  - BoardHandler의 메서드가 작업할 때 사용할 변수를 준비한다.
    BoardHandler boardHandler = new BoardHandler();
    BoardHandler boardHandler2 = new BoardHandler();
    BoardHandler boardHandler3 = new BoardHandler();
    BoardHandler boardHandler4 = new BoardHandler();
    BoardHandler boardHandler5 = new BoardHandler();
    BoardHandler boardHandler6 = new BoardHandler();

    MemberHandler memberHandler = new MemberHandler();

    ProjectHandler projectHandler = new ProjectHandler();

    TaskHandler taskHandler = new TaskHandler();

    while (true) {
      String input = Prompt02.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (input.equals("/member/add")) {
        memberHandler.add();

      } else if (input.equals("/member/list")) {
        memberHandler.list();

      }  else if (input.equals("/project/add")) {
        projectHandler.add(memberHandler); // add를 실행할 때는 사용자가 입력한 프로젝트를 저장하기 위한 인스턴스 주소를 줘야 함
        // 파라미터로는 exist를 호출하기 위해 exist를 사용할 member 데이터(배열)가 저장된 인스턴스 주소가 필요함
      }  else if (input.equals("/project/list")) {
        projectHandler.list();

      }  else if (input.equals("/task/add")) {
        taskHandler.add(memberHandler); // member 데이터가 저장된 배열과 몇 개의 값을 가지고 있는 사이즈라는 주소를 memberHandler가 가지고 있기 때문

      }  else if (input.equals("/task/list")) {
        taskHandler.list();

      } else if (input.equals("/board/add")) {
        // BoardHandler의 add()를 실행할 때
        // add()에서 사용할 게시글 배열이 있는 인스턴스 주소를 넘겨준다.
        boardHandler.add();

      } else if (input.equals("/board/list")) {
        boardHandler.list();
        // BoardHandler의 list()를 실행할 때
        // list()에서 사용할 게시글 배열이 있는 인스턴스 주소를 넘겨준다.

      } else if (input.equals("/board2/add")) {
        boardHandler2.add();

      } else if (input.equals("/board2/list")) {
        boardHandler2.list();

      } else if (input.equals("/board3/add")) {
        boardHandler3.add();

      } else if (input.equals("/board3/list")) {
        boardHandler3.list();

      } else if (input.equals("/board4/add")) {
        boardHandler4.add();

      } else if (input.equals("/board4/list")) {
        boardHandler4.list();

      } else if (input.equals("/board5/add")) {
        boardHandler5.add();

      } else if (input.equals("/board5/list")) {
        boardHandler5.list();

      } else if (input.equals("/board6/add")) {
        boardHandler6.add();

      } else if (input.equals("/board6/list")) {
        boardHandler6.list();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    // Prompt 가 소유하고 관리하고 있는 자원을 닫으라고 명령한다. 
    Prompt02.close();
  }
}












