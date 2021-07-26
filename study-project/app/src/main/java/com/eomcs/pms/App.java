package com.eomcs.pms;

import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.util.Prompt;

public class App {

  public static void main(String[] args) {

    BoardHandler boardHandler = new BoardHandler();

    MemberHandler memberHandler = new MemberHandler();

    // projectHandler.memberHandler(파라미터로 안 받고 인스턴스 변수에 미리 주입 선언) = memberHandler(의존 객체);
    // projectHandler 안에 memberHandler가 있는데 그 안에 의존 객체 memberHandler를 주입해 주세요!!
    // 만약 ProjectHandler의 메서드가 사용할 의존 객체를 주입하지 않는다면?
    // - 그 의존 객체를 사용하는 메서드를 호출할 때 실행 오류가 발생할 것이다.
    // ProjectHandler projectHandler = new ProjectHandler();
    // projectHandler.memberHandler = memberHandler;
    //
    // 왜 이런 문제가 발생하는가?
    // - 의존 객체 주입을 강제하지 않기 때문이다.
    // 해결책?
    // - 의존 객체 주입을 강제하면 된다.
    // - ProjectHandler의 인스턴스를 생성할 때 반드시 MemberHandler의 인스턴스를 주입하게
    //   만들면 된다.
    // 어떻게?
    // - 생성자를 도입하라!
    ProjectHandler projectHandler = new ProjectHandler(memberHandler);
    // public ProjectHandler(MemberHandler memberHandler) 이렇게 선언해 버렸기 때문에 memberHandler를 받아 줘야 함
    //    projectHandler.memberHandler = memberHandler;

    // taskHandler 안에 memberHandler가 있는데 그 안에 의존 객체 memberHandler를 주입해 주세요!!
    // 그 의존 객체를 사용하는 메서드를 호출할 때 실행 오류가 발생할 것이다.
    // 생성자를 이용하면 다음과 같이 인스턴스를 생성할 때 의존 객체 주입을 강제할 수 있다.
    TaskHandler taskHandler = new TaskHandler(memberHandler);
    // 만약 TaskHandler의 메서드가 사용할 의존 객체를 주입하지 않는다면?
    // taskHandler.memberHandler = memberHandler;
    // - 그 의존 객체를 사용하는 메서드를 호출할 때 실행 오류가 발생할 것이다.

    // public TaskHandler(MemberHandler memberHandler) 이렇게 선언해 버렸기 때문에 memberHandler를 받아 줘야 함
    //    taskHandler.memberHandler = memberHandler;

    while (true) {
      String input = Prompt.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        memberHandler.add();

      } else if (input.equals("/member/list")) {
        memberHandler.list();

      } else if (input.equals("/member/detail")) {
        memberHandler.detail();

      } else if (input.equals("/member/update")) {
        memberHandler.update();

      } else if (input.equals("/member/delete")) {
        memberHandler.delete();

      }  else if (input.equals("/project/add")) {
        projectHandler.add();

      }  else if (input.equals("/project/list")) {
        projectHandler.list();

      }  else if (input.equals("/project/detail")) {
        projectHandler.detail();

      }  else if (input.equals("/project/update")) {
        projectHandler.update();

      }  else if (input.equals("/project/delete")) {
        projectHandler.delete();

      }  else if (input.equals("/task/add")) {
        taskHandler.add();

      }  else if (input.equals("/task/list")) {
        taskHandler.list();

      }  else if (input.equals("/task/detail")) {
        taskHandler.detail();

      }  else if (input.equals("/task/update")) {
        taskHandler.update();

      }  else if (input.equals("/task/delete")) {
        taskHandler.delete();

      }  else if (input.equals("/board/add")) {
        boardHandler.add();

      }  else if (input.equals("/board/list")) {
        boardHandler.list();

      }  else if (input.equals("/board/detail")) {
        boardHandler.detail();

      }  else if (input.equals("/board/update")) {
        boardHandler.update();

      }  else if (input.equals("/board/delete")) {
        boardHandler.delete();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    // Prompt 가 소유하고 관리하고 있는 자원을 닫으라고 명령한다. 
    Prompt.close();
  }
}












