package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;

public class TaskListHandler extends AbstractTaskHandler {

  public TaskListHandler(ProjectPrompt projectPrompt) {
    super(projectPrompt);
  }

  public void execute() {
    System.out.println("[작업 목록]");

    Project project = projectPrompt.promptProject();
    if (project == null) { // 만약 취소했을 경우
      System.out.println("작업 등록을 취소합니다.");
      return;
    }

    printTasks(project);
  }
}





