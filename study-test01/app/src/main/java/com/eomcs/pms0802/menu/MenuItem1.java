package com.eomcs.pms0802.menu;

public class MenuItem1 extends Menu { 


  public MenuItem1(String title) {
    super(title);
  }

  @Override
  public void execute() {
    System.out.println("===>" + this.title);
  }

}
