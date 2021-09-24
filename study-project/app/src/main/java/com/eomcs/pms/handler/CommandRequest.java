package com.eomcs.pms.handler;

import java.util.HashMap;
import java.util.Map;

public class CommandRequest {

  // 커맨드 객체를 실행할 때 전달할 값을 담는 용도
  Map<String,Object> paramMap = new HashMap<>();

  // 커맨드 맵을 받는다.
  // - RequestDispatcher 를 생성할 때 사용한다.
  Map<String,Command> commandMap;

  public CommandRequest(Map<String,Command> commandMap) {
    this.commandMap = commandMap;
  }

  public void setAttribute(String name, Object value) {
    paramMap.put(name, value);
  }

  public Object getAttribute(String name) {
    return paramMap.get(name);
  }

  public RequestDispatcher getRequestDispatcher(String commandId) {
    Command command = commandMap.get(commandId); // CommandMap에서 commandId에 해당되는 걸 찾아서 command에 담고
    if (command == null) { // 커맨드가 해당되는 커맨드를 못 찾았으면 null 리턴
      return null;
    }
    return new RequestDispatcher(command);
  }

}
