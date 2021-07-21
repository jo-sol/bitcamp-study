package com.eomcs.pms1.handler;

import java.sql.Date;
import com.eomcs.pms1.domain.Board2;
import com.eomcs.util.Prompt02;

public class BoardHandler {

  // 모든 게시판의 최대 배열 개수가 같기 때문에 다음 변수는
  // 그냥 static 필드로 남겨둔다
  static final int MAX_LENGTH = 100;

  // 게시판마다 따로 관리해야 하기 때문에 인스턴스 필드로 전환한다.
  // => static 옵션을 뺀다.
  Board2[] boards = new Board2[MAX_LENGTH];
  int size = 0;

  // BoardHandler 설계도에 따라 만든 변수(boards, size)를 다룰 수 있도록
  // 파라미터로 인스턴스 주소를 받는다
  //
  public void add() {
    System.out.println("[새 게시글]");

    Board2 board = new Board2();

    board.no = Prompt02.inputInt("번호? ");
    board.title = Prompt02.inputString("제목? ");
    board.content = Prompt02.inputString("내용? ");
    board.writer = Prompt02.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());
    board.viewCount = Prompt02.inputInt("조회수? ");

    this.boards[this.size++] = board; // that 메모리의 boards 변수를 that 메모리의 size 변수에 따라 실행하겠다.
  }

  public void list() {
    System.out.println("[게시글 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          this.boards[i].no, 
          this.boards[i].title, 
          this.boards[i].writer, 
          this.boards[i].registeredDate, 
          this.boards[i].viewCount,
          this.boards[i].like);
    }
  }



}







