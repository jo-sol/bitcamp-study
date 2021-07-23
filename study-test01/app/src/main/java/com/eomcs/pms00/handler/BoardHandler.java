package com.eomcs.pms00.handler;

import java.sql.Date;
import com.eomcs.pms00.domain.Board;
import com.eomcs.util.Prompt;

public class BoardHandler {

  // 모든 게시판의 최대 배열 개수가 같기 때문에 다음 변수는
  // 그냥 static 필드로 남겨둔다
  static final int MAX_LENGTH = 5;

  // 게시판마다 따로 관리해야 하기 때문에 인스턴스 필드로 전환한다.
  // => static 옵션을 뺀다.
  // Board 인스턴스 주소를 담을 Board 래퍼런스의 주소를 담는다.
  // => Board[MAX_LENGTH] -> boards
  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;
  // !! this는 현재 실행하는 메서드가 사용할 변수 (상위 둘) !!
  // Boards = 인스턴스 배열

  // BoardHandler 설계도에 따라 만든 변수(boards, size)를 다룰 수 있도록
  // 파라미터로 인스턴스 주소를 받는다
  //
  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board(); // 클래스명.변수가 들어있는 주소 = new 클래스명();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());
    //    board.viewCount = Prompt.inputInt("조회수? ");

    this.boards[this.size++] = board; // that 메모리의 boards 변수를 that 메모리의 size 변수에 따라 실행하겠다.
  }

  public void list() {
    System.out.println("[게시글 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %d\n", 
          this.boards[i].no, 
          this.boards[i].title, 
          this.boards[i].writer, 
          this.boards[i].registeredDate, 
          this.boards[i].viewCount);
      //          this.boards[i].like
    }
  }

  public void detail() {
    System.out.println("게시글 상세보기");

    int no = Prompt.inputInt("번호? ");

    Board board = null;

    for (int i = 0; i < this.size; i++) { // 위에 선언한 int size = 0; 이 변수를 공유하는 것이기 때문에 this.size라 표기
      if (boards[i].no == no) {
        board = boards[i];
        break;
      }
    }

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

  public void update( ) {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    Board board = null;

    for (int i = 0; i < this.size; i++) {
      if (boards[i].no == no) {
        board = boards[i];
        break;
      }
    }

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String label = String.format("제목(%s)? ", board.title);
    String title = Prompt.inputString(label);

    label = String.format("내용(%s)? ", board.content);
    String content = Prompt.inputString(label);


    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N)");
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

    int boardIndex = -1;
    // for문의 배열에서 찾은 인스턴스가 null에 들어감
    // for문에서 해당 값을 찾을 때까지 돌리는데
    // 값이 없을 경우 값이 계속 null인 상태로 있게 된다
    // boardIndex : 삭제해야 할 번호가 들어있는 주소

    // Board 인스턴스가 들어있는 배열을 뒤져서 
    // 게시글 번호와 일치하는 Board 인스턴스를 찾는다.
    for (int i = 0; i < this.size; i++) { // this.size -> 배열에 입력된 개수
      if (this.boards[i].no == no) { // this 생략 가능
        boardIndex = i;
        break; // 배열에 입력된 개수만큼 반복하는 반복 for문
      } // break는 현재 반복문을 나가라는 의미
    } // return은 실행을 끝내라는 의미

    if (boardIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) { // length() == 0 빈문자열이면
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    for (int i = boardIndex; i < this.size -1; i++) { // boardIndex에서부터 시작
      this.boards[i] = this.boards[i + 1]; // boards의 i 번 방에 i + 1 방에 있는 애를 당겨오기
    }
    this.boards[this.size -1] = null;
    this.size--; // 당겼으니까 size 수를 줄여 줘야 함
    System.out.println("게시글을 삭제하였습니다.");
  }

}
//  public void update() {
//    System.out.println("[게시글 변경]");
//
//    int no = Prompt.inputInt("번호? ");
//
//    Board board = null;
//
//    for (int i = 0; i < this.size; i++) {
//      if (boards[i].no == no) {
//        board = boards[i];
//        break;
//      }
//    }
//
//    if (board == null) {
//      System.out.println("해당 번호의 게시글이 없습니다.");
//      return;
//    }
//    // String title = Prompt.inputString(String.format("제목:(%s)?", board.title));
//    // 임시변수가 들어갈 자리에 위와 같이 넣는 게 유지보수에 낫다
//    // board 인스턴스의 title이 있는 걸 
//    String label = String.format("제목:(%s)?", board.title); // String 클래스의 format은 printf와 비슷하지만 제목:(%s)?이 문자열을 만들고 리턴한다
//    String title = Prompt.inputString(label); // 제목:(%s)?을 출력하고 입력받아야 함
//    // 제목:(%s)? 문자열을 입력받아서(문자열을 만들어) label 변수에 리턴함
//    // label은 해당 문자열을 다시 title에 줌
//    // printf = 문자열을 만들어서 출력한다
//    // format = 문자열을 만들어서 리턴한다
//    label = String.format("내용:(%s)?", board.content);
//    String content = Prompt.inputString(label);
//
//    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N)");
//    if (input.equalsIgnoreCase("n") || input.length() == 0) { // equalsIgnoreCase = 대소문자 구분 없이 비교하고 출력하라
//      System.out.println("게시글 변경을 취소하였습니다."); // 또는 (input.length() == 0)그냥 엔터를 치거나 대문자 N을 쳤을 때 no로 처리하겠다
//      return;
//    }
//    // yes인 경우에는 아래와 같이 해당 내용을 변경한다
//    board.title = title; // board에 입력된 title값을 사용자가 입력한 title 값으로 바꾼다
//    board.content = content; // board에 입력된 content값을 사용자가 입력한 content 값으로 바꾼다
//    System.out.println("게시글을 변경하였습니다."); // 바꾼 뒤 게시글을 변경하였습니다 출력
//
//  }




//public void detail() {
//  System.out.println("[게시글 상세보기]");
//  
//  int no = Prompt.inputInt("번호? "); // 정수 입력받기
//  
//  
//  Board board = null; // 레퍼런스 주소를 주기 전에 null로 초기화 -> 로컬 변수기 때문
//  
//  for (int i = 0; i < this.size; i++) { // 반복 돌리기
//    if (boards[i].no == no) { // boards[i]에 있는 no와 사용자가 입력한 no가 같은지
//      board = boards[i]; // 같다면 board라는 레퍼런스에 boards[i] 주소를 저장
//      break; // 더 이상 반복할 필요 없으니까 반복문 나가기
//    }
//  }
//  
//  if (board == null) { // 만약 board가 null일 경우
//    System.out.println("해당 번호의 게시글이 없습니다.");
//    return;
//  }
//  
//  System.out.printf("제목: %s\n", board.title); // board 변수에 저장된 title 인스턴스가 들어있는 주소 -> 찾아가서 출력해라
//  System.out.printf("내용: %s\n", board.content); // 문자열
//  System.out.printf("작성자: %s\n", board.writer);
//  System.out.printf("등록일: %s\n", board.registeredDate);
//  System.out.printf("조회수: %d\n", ++board.viewCount); // 숫자 // 조회수 필드값 1씩 증가
//}

//public void update() {
//  System.out.println("[게시글 변경]");
//
//  int no = Prompt.inputInt("번호? ");
//
//  Board board = null;
//
//  for (int i = 0; i < this.size; i++) {
//    if (boards[i].no == no) {
//      board = boards[i];
//      break;
//    }
//  }
//
//  if (board == null) {
//    System.out.println("해당 번호의 게시글이 없습니다.");
//    return;
//  }
//  // String title = Prompt.inputString(String.format("제목:(%s)?", board.title));
//  // 임시변수가 들어갈 자리에 위와 같이 넣는 게 유지보수에 낫다
//  // board 인스턴스의 title이 있는 걸 
//  String label = String.format("제목:(%s)?", board.title); // String 클래스의 format은 printf와 비슷하지만 제목:(%s)?이 문자열을 만들고 리턴한다
//  String title = Prompt.inputString(label); // 제목:(%s)?을 출력하고 입력받아야 함
//  // 제목:(%s)? 문자열을 입력받아서(문자열을 만들어) label 변수에 리턴함
//  // label은 해당 문자열을 다시 title에 줌
//  // printf = 문자열을 만들어서 출력한다
//  // format = 문자열을 만들어서 리턴한다
//  label = String.format("내용:(%s)?", board.content);
//  String content = Prompt.inputString(label);
//
//  String input = Prompt.inputString("정말 변경하시겠습니까?(y/N)");
//  if (input.equalsIgnoreCase("n") || input.length() == 0) { // equalsIgnoreCase = 대소문자 구분 없이 비교하고 출력하라
//    System.out.println("게시글 변경을 취소하였습니다."); // 또는 (input.length() == 0)그냥 엔터를 치거나 대문자 N을 쳤을 때 no로 처리하겠다
//    return;
//  }
//  // yes인 경우에는 아래와 같이 해당 내용을 변경한다
//  board.title = title; // board에 입력된 title값을 사용자가 입력한 title 값으로 바꾼다
//  board.content = content; // board에 입력된 content값을 사용자가 입력한 content 값으로 바꾼다
//  System.out.println("게시글을 변경하였습니다."); // 바꾼 뒤 게시글을 변경하였습니다 출력
//
//}




