package com.eomcs.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import com.eomcs.pms.table.JsonDataTable;
import com.google.gson.Gson;

// 역할
// - 클라이언트와 통신하는 일을 담당한다.
// - 클라이언트 요청이 들어오면 그 요청을 처리할 객체를 찾아 실행하는 일을 한다.
// - 클라이언트 요청 정보를 객체에 보관하고, 응답 기능을 수행할 객체를 만드는 일을 한다.
// 
public class RequestProcessor extends Thread {
  Socket socket;
  PrintWriter out;
  BufferedReader in; 

  Map<String,DataProcessor> dataProcessorMap;

  public RequestProcessor(Socket socket, Map<String,DataProcessor> dataProcessorMap) throws Exception {
    this.socket = socket;
    this.dataProcessorMap = dataProcessorMap; // 이렇게 하면 얘는 종속되지 않음
  }

  @Override
  public void run() { // 그림 꼭 같이 보기!!
    // 강사님! 위에 있는 socket을 그냥 쓰면 되지 왜 굳이 여기에 선언을 해 줍니까?
    // try() {} 안에 선언을 해 줘야만 자동으로 autoClose 를 해 주기 때문
    // this.socket(및 다른 것들)은 try() {} 변수 안에 속한 게 아니기 때문에 자동으로 close()를 호출해 주지 않음
    // 따라서 그 안에 따로 선언을 해 줘야만 close()가 호출됨
    // *** try(){} 변수에 대해서만 자동으로 autoClose 해 줌
    try (Socket socket = this.socket;
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
      // 데이터 처리 담당자의 이름 목록 가져오기
      Set<String> dataProcessorNames = dataProcessorMap.keySet();

      String command = in.readLine();
      Request request = new Request(command, in.readLine());
      Response response = new Response();

      if (command.equalsIgnoreCase("quit")) {
        response.setStatus(Response.SUCCESS);
        response.setValue("goodbye");
        sendResult(response, out);
        return;
      } 

      // 명령어에 해당하는 데이터 처리 담당자를 찾는다.
      DataProcessor dataProcessor = null;
      for (String dataProcessorName : dataProcessorNames) {
        if (command.startsWith(dataProcessorName)) {
          dataProcessor = dataProcessorMap.get(dataProcessorName);
          break;
        }
      }

      if (dataProcessor != null) { // 명령어에 해당하는 데이터 처리 담당자가 있으면 실행
        dataProcessor.execute(request, response);

      } else {
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령어를 처리할 수 없습니다.");
      }

      sendResult(response, out); // 클라이언트에게 실행 결과를 보낸다.

      saveData();

      System.out.println("클라이언트와 접속 종료!");

    } catch (Exception e) {
      System.out.println("클라이언트 요청 처리 중 오류 발생!");
    }
  }

  private void saveData() throws Exception {
    // => 데이터를 파일에 저장한다.
    Collection<DataProcessor> dataProcessors = dataProcessorMap.values();
    for (DataProcessor dataProcessor : dataProcessors) {
      if (dataProcessor instanceof JsonDataTable) {
        // 만약 데이터 처리 담당자가 JsonDataTable 의 자손이라면,
        ((JsonDataTable<?>)dataProcessor).save();
      }
    }
  }

  private void sendResult(Response response, PrintWriter out) throws Exception {
    // Response 객체에 보관된 실행 결과를 클라이언트에게 보낸다.
    out.println(response.status);
    if (response.getValue() != null) {
      out.println(new Gson().toJson(response.getValue()));
    } else {
      out.println();
    }
    out.flush();
  }

}
