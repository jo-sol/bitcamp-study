package com.eomcs.pms1;

import com.eomcs.pms1.handler.BoardHandler02;
import com.eomcs.pms1.handler.MemberHandler;
import com.eomcs.pms1.handler.ProjectHandler;
import com.eomcs.pms1.handler.TaskHandler;
import com.eomcs.util.Prompt02;

public class App {

  public static void main(String[] args) {

    while (true) {
      String input = Prompt02.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        MemberHandler.add();

      } else if (input.equals("/member/list")) {
        MemberHandler.list();

      }  else if (input.equals("/project/add")) {
        ProjectHandler.add();

      }  else if (input.equals("/project/list")) {
        ProjectHandler.list();

      }  else if (input.equals("/task/add")) {
        TaskHandler.add();

      }  else if (input.equals("/task/list")) {
        TaskHandler.list();

      } else if (input.equals("/board02/add")) {
        BoardHandler02.add();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    // Prompt 가 소유하고 관리하고 있는 자원을 닫으라고 명령한다. 
    Prompt02.close();
  }
}












