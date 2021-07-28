package com.eomcs.oop.ex05.a;

public class Car {

  public String model;
  public String maker;
  public int capacity;

  public Car() {}

  public Car(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  public void run() {
    System.out.println("달린다!");
  }
}

// 생성자가 하나라도 없으면 컴파일러가 만들어 주지만,
// 생성자가 하나라도 존재한다면 컴파일러가 추가해 주지 않음
