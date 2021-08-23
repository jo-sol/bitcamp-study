// 제네릭(generic) 적용 전 - Object를 이용한 다형적 변수 사용 // Exam0210 코드의 간편화
package com.eomcs.generic.ex01;

import java.util.Calendar;
import java.util.Date;

public class Exam0110 {

  public static Object echo(Object obj) {
    return obj;
  }

  public static void main(String[] args) {

    // echo() 리턴 타입이 Object이기 때문에 String 레퍼런스로 바로 받을 수 없다.
    // => 해결책? 형변환 해야 한다.
    //
    //    String obj1 = echo(new String("Hello")); // 컴파일 오류!
    Object obj1 = echo(new String("Hello")); // Ok!
    String obj2 = (String) echo(new String("Hello"));

    // 잘못된 형변환은 컴파일러는 속일 수 있을 지라도, runtime 에서는 오류를 발생시킨다.
    //Integer obj3 = (Integer) echo(new String("Hello")); // 실행 오류!

    Date obj4 = (Date) echo(new Date());

    Calendar obj5 = (Calendar) echo(Calendar.getInstance());
    // 어떤 클래스의 스태틱 메서드를 생성해서 코드를 만든다면 복잡하다는 뜻
    // 메서드 안에 메서드를 호출하여 감춰놓음 => 캡슐화시킴
  }

}
