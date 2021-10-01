package com.eomcs.pms;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import com.eomcs.pms.table.BoardTable;
import com.eomcs.pms.table.MemberTable;
import com.eomcs.pms.table.ProjectTable;
import com.eomcs.server.DataProcessor;
import com.eomcs.server.RequestProcessor;

public class ServerApp {

  public static void main(String[] args) throws Exception {
    System.out.println("[PMS 서버]");

    System.out.println("서버 실행중");
    ServerSocket serverSocket = new ServerSocket(8888);

    // RequestProcessor 가 사용할 DataProcessor 맵 준비
    HashMap<String,DataProcessor> dataProcessorMap = new HashMap<String,DataProcessor>();

    // => 데이터 처리 담당자를 등록한다.
    dataProcessorMap.put("board.", new BoardTable());
    dataProcessorMap.put("member.", new MemberTable());
    dataProcessorMap.put("project.", new ProjectTable());

    while (true) {
      Socket socket = serverSocket.accept();
      System.out.println("클라이언트와 접속");

      // RequestProcessor에게 dataProcessorMap를 넘겨준다. => 야~ 일해~
      // 1) 새 실행 흐름 생성
      RequestProcessor requestProcessor = new RequestProcessor(socket, dataProcessorMap);

      // 2) 새로 생성한 실행 흐름을 시작시킨다.
      // => run()이 호출될 것이다.
      // => 시작 시킨 후 즉시 리턴한다.
      //    즉 새로 생성한 실행 흐름이 종료될 때까지 기다리지 않는다.
      // 야! 시작해! > 다음 // 야! 실행해! > 다음 // 야! 시작해! > 다음 // 반복
      // => 동시 접속을 실행하는 방법이다.
      requestProcessor.start();
      // => 내부적으로 run() 메서드를 실행시킨다.

      // 2번은 한 번만 실행되기 때문에,
      // new RequestProcessor(socket, dataProcessorMap).start(); 로 해도 된다.

    }

    //    System.out.println("서버 종료");
    //    serverSocket.close();
  }
}
