package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Board;
import com.eomcs.request.RequestAgent;
import com.eomcs.util.Prompt;

public class BoardAddHandler implements Command {

  RequestAgent requestAgent;

  public BoardAddHandler(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));

    board.setWriter(AuthLoginHandler.getLoginUser()); // 가짜 데이터 사용
    board.setRegisteredDate(new Date(System.currentTimeMillis()));

    requestAgent.request("board.insert", board);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("게시글을 등록했습니다.");
    } else {
      System.out.println("게시글 등록 실패!");
    }
  }
}






