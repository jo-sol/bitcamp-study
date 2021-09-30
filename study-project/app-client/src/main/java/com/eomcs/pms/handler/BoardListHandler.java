package com.eomcs.pms.handler;

import java.util.Collection;
import com.eomcs.pms.domain.Board;
import com.eomcs.request.RequestAgent;

public class BoardListHandler implements Command {

  RequestAgent requestAgent;

  public BoardListHandler(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[회원 목록]");

    requestAgent.request("board.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      System.out.println("목록 조회 실패!");
      return;
    }

    Collection<Board> boardList = requestAgent.getObjects(Board.class);

    for (Board board : boardList) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          board.getNo(), 
          board.getTitle(), 
          board.getContent(), 
          board.getWriter(), 
          board.getRegisteredDate());
    }
  }
}
