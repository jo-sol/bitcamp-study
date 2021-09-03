package com.eomcs.pms.handler; // 다시 기존 소스로 돌아가기

import java.util.List;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardDetailHandler extends AbstractBoardHandler {

  // 생성자 >> 부모 클래스에서 List 객체를 받는 생성자를 호출하기
  public BoardDetailHandler(List<Board> boardList) {
    super(boardList);
  }

  public void execute() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("작성자: %s\n", board.getWriter().getName());
    System.out.printf("등록일: %s\n", board.getRegisteredDate());

    board.setViewCount(board.getViewCount() + 1);
    System.out.printf("조회수: %d\n", board.getViewCount());
  }
}







