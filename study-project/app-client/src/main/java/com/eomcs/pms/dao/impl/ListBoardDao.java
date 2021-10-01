package com.eomcs.pms.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms.dao.BoardDao;
import com.eomcs.pms.domain.Board;

// 역할
// - 게시글 데이터를 컬렉션 객체를 이용하여 관리한다.
// 
public class ListBoardDao implements BoardDao {
  List<Board> list = new ArrayList<>();

  @Override
  public void insert(Board board) throws Exception { // 게시글에 추가 좀 해 줄래?
    list.add(board);
  }

  @Override
  public List<Board> findAll() throws Exception { // 게시글 목록 좀 줄래?
    return list;
  }

  @Override
  public List<Board> findByKeyword(String keyword) throws Exception { // 게시글 목록 좀 줄래?
    ArrayList<Board> result = new ArrayList<>();
    for (Board b : list) {
      if (b.getTitle().equalsIgnoreCase(keyword) ||
          b.getContent().equalsIgnoreCase(keyword) ||
          b.getWriter().getName().equalsIgnoreCase(keyword)) {
        result.add(b);
      }
    }
    return result;
  }

  @Override
  public Board findByNo(int no) throws Exception {
    for (Board b : list) {
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

  @Override
  public void update(Board board) throws Exception { // index를 가지고 update
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == board.getNo()) {
        list.set(i, board); // 기존의 객체 대신 파라미터로 받은 객체로 교체한 후 즉시 리턴
        return;
      }
    }
  }

  @Override
  public void delete(int no) throws Exception {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        list.remove(i); // i에 해당하는 객체 지워라
        return;
      }
    }
  }
}
