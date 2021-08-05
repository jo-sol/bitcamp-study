package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Board;

public class BoardList2 extends LinkedList {

  public Board findByNo(int no) {
    Object[] list = toArray();
    for (Object obj : list) {
      Board board = (Board) obj;
      if (board.no == no) { // 1. node의 board에 들어있는 no값이 파라미터에 있는 no의 값과 같으면
        return board; // ** node가 아니라 node.board를 리턴해야 함
      }
    }
    return null; // 2. null을 리턴
  }

}








