package com.eomcs.pms0802.menu;

import com.eomcs.pms.handler.MemberHandler;

public class MemberUpdateMenu extends Menu {

  MemberHandler memberHandler;

  public MemberUpdateMenu(MemberHandler memberHandler) {
    super("변경");
    this.memberHandler = memberHandler;
  }

  @Override
  public void execute() {
    memberHandler.update(); // 해당 Menu를 선택하면 boardHandler.add() 호출

  }
}
