package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardHandler {
  // 배열을 LinkedList 방식으로 돌아가도록 변경하기 -> 클래스 이름만 바꿔 주면 됨
  // BoardList boardList = new BoardList -> BoardList2 boardList = new BoardList2
  // BoardList에서 ArrayList를 다이렉트로 쓰는 방법 (0806 -1) 
  // BoardList에서 LinkedList로 바꾸는 방법 (0806 -2) => 데이터 처리
  // List를 만드는 순간 new ArrayList()와 new LinkedList() 둘 다 올 수 있다. (0806 -3)
  //    => 같은 타입으로 묶으면 두 클래스의 객체를 한 개의 레퍼런스로 다룰 수 있다.
  //    => 추상 메서드를 통한 메서드의 시그니처 통일 및 프로그래밍에 일관성 제공
  // List 객체를 외부에서 주입 받는 방식으로 변경하기. (0806 -4)
  //    => BoardHandler가 사용할 리스트 객체를 만들어 주입한다.
  //    => 생성자가 기본 생성자가 아니기 때문에 App에 가서 수정
  List boardList;

  public BoardHandler(List boardList) {
    this.boardList = boardList;
  }

  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());

    boardList.add(board);
  }

  public void list() {
    System.out.println("[게시글 목록]");

    Object[] list = boardList.toArray();

    for (Object obj : list) {
      Board board = (Board) obj; // 원래 obj 타입이니까 board로 형변환 시켜 주기
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          board.no, 
          board.title, 
          board.writer,
          board.registeredDate,
          board.viewCount, 
          board.like);
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

    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("등록일: %s\n", board.registeredDate);
    System.out.printf("조회수: %d\n", ++board.viewCount);
  }

  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", board.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", board.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.title = title;
    board.content = content;
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
  public Board findByNo(int no) { // findByNo(?) ?: 뭐로 찾을 수 있을지 모르니까 list에서 따로 추가해 줌
    // -> findByNo(int no) int no: 번호를 구분한다는 보장이 없음
    Object[] arr = boardList.toArray();
    for (Object obj : arr) {
      Board board = (Board) obj; // 반복문을 돌 때마다 하는 게 아니라 여기에서 한 번 쓰는 것
      if (board.no == no) {
        return board; // board에서만 하는 거니까 -> 변수명(int no 등)이 같을 거라는 보장을 못하기 때문!
      }
    }
    return null;
  }
}







