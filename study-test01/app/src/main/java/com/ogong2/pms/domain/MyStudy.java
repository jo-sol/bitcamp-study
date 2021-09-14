package com.ogong2.pms.domain;

import java.util.List;
import com.ogong.pms.domain.Calender;
import com.ogong.pms.domain.FreeBoard;
import com.ogong.pms.domain.Study;

public class MyStudy {


  private Study myStudyTitle;
  private List<Calender> myStudyCalender; 
  private List<FreeBoard> myStudyFreeBoard;

  @Override
  public String toString() {
    return "MyStudy [myStudyTitle=" + myStudyTitle + ", myStudyCalender=" + myStudyCalender
        + ", myStudyFreeBoard=" + myStudyFreeBoard + "]";
  }

  public Study getMyStudyTitle() {
    return myStudyTitle;
  }

  public void setMyStudyTitle(Study myStudyTitle) {
    this.myStudyTitle = myStudyTitle;
  }

  public List<Calender> getMyStudyCalender() {
    return myStudyCalender;
  }

  public void setMyStudyCalender(List<Calender> myStudyCalender) {
    this.myStudyCalender = myStudyCalender;
  }

  public List<FreeBoard> getMyStudyFreeBoard() {
    return myStudyFreeBoard;
  }

  public void setMyStudyFreeBoard(List<FreeBoard> myStudyFreeBoard) {
    this.myStudyFreeBoard = myStudyFreeBoard;
  }


}
