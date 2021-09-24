package com.eomcs.context;
// Application 환경에 관련해서 보고를 받는 Listener

import java.util.Map;

// 규칙
// - 애플리케이션이 시작하거나 종료할 때 호출할 리스너(옵저버)의 메서드를 정의한다.
//
public interface ApplicationContextListener {
  void contextInitialized(Map<String,Object> params); // 애플리케이션이 시작한 후 즉시 호출된다.
  void contextDestroyed(Map<String,Object> params); // 애플리케이션이 종료한 후 즉시 실행된다.

}
