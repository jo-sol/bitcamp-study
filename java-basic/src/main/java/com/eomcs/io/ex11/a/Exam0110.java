// 인스턴스 입출력 - DataOutputStream으로 인스턴스 출력하기
package com.eomcs.io.ex11.a;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    FileOutputStream fileOut = new FileOutputStream("temp/member.data");
    DataOutputStream out = new DataOutputStream(fileOut);

    Member member = new Member();
    member.name = "AB가각간";
    member.age = 27;
    member.gender = true;

    out.writeUTF(member.name);
    out.writeInt(member.age);
    out.writeBoolean(member.gender);

    out.close();
    System.out.println("데이터 출력 완료!");
  }

}


// 데코레이터 패턴으로 기능을 구조화시키면
// 기능을 뗐다 붙였다가 용이해진다
// 자바에서 제공하는 스트링 패턴을 알고 봤더니
// 데코레이터 패턴이 적용된 것이구나~ 알게 됐다