package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.List;
import com.eomcs.util.Prompt;

public class BoardHandler {

  // *** 1) 제네릭을 적용하지 않으면 모든 타입이 Object가 되므로
  // 특정 타입으로 제한할 수가 없는 단점이 있음
  // *** 3) 그러나 제네릭을 적용하면 어떤 타입으로 진행할 것인지 지정해 줄 수 있으며
  // 잘못된 코드의 사용을 막아 줄 수 있다
  List<Board> boardList; // 제네릭 적용

  public BoardHandler(List<Board> boardList) {
    this.boardList = boardList;
  }

  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(Prompt.inputString("작성자? "));
    board.setRegisteredDate(new Date(System.currentTimeMillis()));

    boardList.add(board);
    // *** 2) 본래 boardList.add(board); 파라미터 타입을 이렇게 행하려 했으나
    // boardList.add(new String("Hello!")); 이런 식으로
    // 다른 파라미터를 넣을 수 있으며, 이를 막을 수는 없다
  }

  public void list() {
    System.out.println("[게시글 목록]");

    Object[] list = boardList.toArray();

    for (Object obj : list) {
      Board board = (Board) obj;
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          board.getNo(), 
          board.getTitle(), 
          board.getWriter(),
          board.getRegisteredDate(),
          board.getViewCount(), 
          board.getLike());
    }
  }

  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("작성자: %s\n", board.getWriter());
    System.out.printf("등록일: %s\n", board.getRegisteredDate());

    board.setViewCount(board.getViewCount() + 1);
    System.out.printf("조회수: %d\n", board.getViewCount());

  }

  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", board.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", board.getContent()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.setTitle(title);
    board.setContent(content);
    System.out.println("게시글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    boardList.remove(board);

    System.out.println("게시글을 삭제하였습니다.");
  }

  private Board findByNo(int no) {
    Object[] arr = boardList.toArray();
    for (Object obj : arr) {
      Board board = (Board) obj;
      if (board.getNo() == no) {
        return board;
      }
    }
    return null;
  }
}







