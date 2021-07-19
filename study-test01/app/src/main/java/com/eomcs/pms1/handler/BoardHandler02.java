package com.eomcs.pms1.handler;

import com.eomcs.pms1.domain.Board2;
import com.eomcs.util.Prompt02;

public class BoardHandler02 {

  static final int MAX_LENGTH = 5;

  static Board2[] boards = new Board2[MAX_LENGTH];
  static int size = 0;

  public static void add() {
    System.out.println("[새 게시글]");

    Board2 board = new Board2();

    board.no = Prompt02.inputInt("번호? ");
    board.title = Prompt02.inputString("제목? ");
    board.content = Prompt02.inputString("내용? ");
    board.writer = Prompt02.inputString("작성자? ");

    System.out.println("게시글을 등록하였습니다.");

    boards[size++] = board;
  }
}
