// 버퍼 사용 후 - 데이터 읽는데 걸린 시간 측정
package com.eomcs.io.ex06;

import java.io.FileInputStream;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/jls11.pdf");

    byte[] buf = new byte[8192]; // 보통 8KB 정도 메모리를 준비한다.
    int len = 0;

    long startTime = System.currentTimeMillis(); // 밀리초

    int callCount = 0;
    while ((len = in.read(buf)) != -1) {
      callCount++; // 파일을 끝까지 읽는다.
    }

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);
    System.out.println(callCount);
    in.close();
  }

}

// * 속도가 왜 빠른가?
// ex. 1번한테 10번 동안 펜 가지고 오라고 시킴
// ex. 2번한테 한 번에 펜 열 개 가지고 오라고 시킴
// => 한 번에 열 개를 가지고 오는 것보다 왕복하는 데 시간이 더 걸림