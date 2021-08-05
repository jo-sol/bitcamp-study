package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Board;
// 배열 쓰고 싶을 때는 이거 쓰면 됨
public class BoardList extends ArrayList {

  public Board findByNo(int no) { // findByNo(?) ?: 뭐로 찾을 수 있을지 모르니까 list에서 따로 추가해 줌
    // -> findByNo(int no) int no: 번호를 구분한다는 보장이 없음
    Object[] arr = toArray();
    for (Object obj : arr) {
      Board board = (Board) obj; // 반복문을 돌 때마다 하는 게 아니라 여기에서 한 번 쓰는 것
      if (board.no == no) {
        return board; // board에서만 하는 거니까 -> 변수명(int no 등)이 같을 거라는 보장을 못하기 때문!
      }
    }
    return null;
  }
}

//    for (Object obj : arr) {
//      if (((Board)obj).no == no) {
//        return (Board)obj; // board에서만 하는 거니까 -> 변수명(int no 등)이 같을 거라는 보장을 못하기 때문!
//      }
//    }








