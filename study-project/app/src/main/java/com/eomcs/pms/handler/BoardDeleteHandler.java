package com.eomcs.pms.handler; 

import java.util.List;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardDeleteHandler extends AbstractBoardHandler {

  // 생성자 >> 부모 클래스에서 List 객체를 받는 생성자를 호출하기
  public BoardDeleteHandler(List<Board> boardList) {
    super(boardList);
  }

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    if (board.getWriter().getNo() != AuthLoginHandler.getLoginUser().getNo()) {
      System.out.println("삭제 권한이 없습니다.");
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
  // findBy는 부모 클래스에 있기 때문에 여기에서 만들 필요 없음!
}
// 위의 for (:)문 코드는 컴파일할 때 다음 코드로 변경된다.
// Iterator<Board> boards = boardList.iterator();
// while (boars.hasNext()) {
//   Board board = board.next();
//   if (board.getNo == no) {
//     return board;
//   }
// }







