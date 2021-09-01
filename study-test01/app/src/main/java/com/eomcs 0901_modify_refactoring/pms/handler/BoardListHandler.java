package com.eomcs.pms.handler; // 다시 기존 소스로 돌아가기

import java.util.List;
import com.eomcs.pms.domain.Board;

public class BoardListHandler extends AbstractBoardHandler {

  // 생성자 >> 부모 클래스에서 List 객체를 받는 생성자를 호출하기
  public BoardListHandler(List<Board> boardList) {
    super(boardList);
  }

  public void list() {
    System.out.println("[게시글 목록]");

    for (Board board : boardList) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          board.getNo(), 
          board.getTitle(), 
          // 그냥 getWriter는 작성자 목록만 있음
          // 그래서 getName으로 이름 뽑아줘야 함
          board.getWriter().getName(),
          board.getRegisteredDate(),
          board.getViewCount(), 
          board.getLike());
    }
  }
}







