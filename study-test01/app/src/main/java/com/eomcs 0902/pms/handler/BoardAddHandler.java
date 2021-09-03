package com.eomcs.pms.handler; // 추상 클래스, 제너럴라이제이션 연습도 가능

import java.sql.Date;
import java.util.List;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardAddHandler extends AbstractBoardHandler {

  // 생성자 >> 부모 클래스에서 List 객체를 받는 생성자를 호출하기
  public BoardAddHandler(List<Board> boardList) {
    super(boardList);
  }

  public void execute() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    // 사용자로부터 입력받는 것
    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));

    // 자동으로 뜨는 것
    board.setWriter(AuthLoginHandler.getLoginUser());
    board.setRegisteredDate(new Date(System.currentTimeMillis()));

    boardList.add(board);
  }

}







