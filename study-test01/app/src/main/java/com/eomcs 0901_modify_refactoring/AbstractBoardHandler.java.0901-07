package com.eomcs.pms.handler; // List<Board> boardList가 공통점이 됨

import java.util.List;
import com.eomcs.pms.domain.Board;

public abstract class AbstractBoardHandler { 
  // 추상 클래스인걸 강조하기 위해 이름을 이렇게 함
  // 추상 클래스 >> 직접 인스턴스를 만들지 말고 상속받아서 쓰기 위한 것

  // 생성자 >> 같은 List 객체 사용하기 위해 있어야 함
  // protected >> 100 % 공개하지 말고 자식 클래스까지는 접근할 수 있게 허용해 주기
  protected List<Board> boardList;

  public AbstractBoardHandler(List<Board> boardList) {
    this.boardList = boardList;
  }

  // 내부적으로 사용하고자 만든 메서드
  // 자식 클래스까지는 쓸 수 있게 protected로 설정
  protected Board findByNo(int no) {
    for (Board board : boardList) {
      if (board.getNo() == no) {
        return board;
      }
    }
    return null;
  }
}







