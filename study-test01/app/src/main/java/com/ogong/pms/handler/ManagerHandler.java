package com.ogong.pms.handler;

import java.sql.Date;
import java.util.List;
import com.ogong.pms.domain.Manager;
import com.ogong.util.Prompt;

public class ManagerHandler {

  List<Manager> managerList;

  public ManagerHandler(List<Manager> managerList) {
    this.managerList = managerList;
  }

  public void add() {
    System.out.println("[공지사항 등록하기]");

    Manager manager = new Manager();

    manager.setHostNo(Prompt.inputInt("번호? "));
    manager.setHostTitle(Prompt.inputString("제목? "));
    manager.setHostContent(Prompt.inputString("내용? "));

    manager.setMasterWriter(LoginHandler.getLoginMaster());
    manager.setHostRegisteredDate(new Date(System.currentTimeMillis()));

    managerList.add(manager);
  }

  public void list() {
    System.out.println("[공지사항 목록]");

    Manager[] managers = managerList.toArray(new Manager[0]);

    for (Manager manager : managers) {
      System.out.printf("%d, %s, %s, %s\n", 
          manager.getHostNo(), 
          manager.getHostTitle(), 
          manager.getMasterWriter().getMasterNickname(),
          manager.getHostRegisteredDate());
    }
  }

  public void detail() {
    System.out.println("[공지사항 상세보기]");
    int inputHostNo = Prompt.inputInt("번호? ");

    Manager manager = findByHostNo(inputHostNo);

    if (manager == null) {
      System.out.println("해당 번호의 공지글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", manager.getHostTitle());
    System.out.printf("내용: %s\n", manager.getHostContent());
    System.out.printf("작성자: %s\n", manager.getMasterWriter().getMasterNickname());
    System.out.printf("등록일: %s\n", manager.getHostRegisteredDate());
  }

  public void update() {
    System.out.println("[공지사항 변경하기]");
    int hostNo = Prompt.inputInt("번호? ");

    Manager manager = findByHostNo(hostNo);

    if (manager == null) {
      System.out.println("해당 번호의 공지글이 없습니다.");
      return;
    }

    if (manager.getMasterWriter().getMasterno() != LoginHandler.getLoginMaster().getMasterno()) {
      System.out.println("변경 권한이 없습니다.");
      return;
    }

    String managerTitle = Prompt.inputString(String.format("제목(%s)? ", manager.getHostTitle()));
    String managerContent = Prompt.inputString(String.format("내용(%s)? ", manager.getHostContent()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("공지글 변경을 취소하였습니다.");
      return;
    }

    manager.setHostTitle(managerTitle);
    manager.setHostContent(managerContent);
    System.out.println("공지글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[공지사항 삭제하기]");
    int hostNo = Prompt.inputInt("번호? ");

    Manager manager = findByHostNo(hostNo);

    if (manager == null) {
      System.out.println("해당 번호의 공지글이 없습니다.");
      return;
    }

    if (manager.getMasterWriter().getMasterno() != LoginHandler.getLoginMaster().getMasterno()) {
      System.out.println("삭제 권한이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("공지글 삭제를 취소하였습니다.");
      return;
    }

    managerList.remove(manager);

    System.out.println("공지글을 삭제하였습니다.");
  }

  public Manager findByHostNo(int hostNo) {
    for (Manager manager : managerList) {
      if (manager.getHostNo() == hostNo) {
        return manager;
      }
    }
    return null;
  }

  public void memberList() {

  }
}
