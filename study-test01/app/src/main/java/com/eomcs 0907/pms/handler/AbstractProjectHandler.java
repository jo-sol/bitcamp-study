package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Project;

public abstract class AbstractProjectHandler implements Command {

  // >> AbstractProjectHandler에서는 memberHandler를 사용할 이유가 없기 때문에
  //    굳이 대표로 뽑지 않고 사용하는 부분에서만 직접 선언하여 적용해 주었다
  protected List<Project> projectList;

  public AbstractProjectHandler(List<Project> projectList) {
    this.projectList = projectList;
  }

  // ProjectPrompt 클래스에 복사
  // 그러나 얘는 여기와 다른 곳에서도 쓰기 때문에 복사로 함
  protected Project findByNo(int no) {
    for (Project project : projectList) {
      if (project.getNo() == no) {
        return project;
      }
    }
    return null;
  }

}





