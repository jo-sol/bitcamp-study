package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;

public class ProjectList extends ArrayList {

  public Project findByNo(int no) {
    Object[] arr = toArray();
    for (Object obj : arr) {
      Project project = (Project) obj; // 반복문을 돌 때마다 하는 게 아니라 여기에서 한 번 쓰는 것
      if (project.no == no) {
        return project; // project에서만 하는 거니까 -> 변수명(int no 등)이 같을 거라는 보장을 못하기 때문!
      }
    }
    return null;
  }
}








