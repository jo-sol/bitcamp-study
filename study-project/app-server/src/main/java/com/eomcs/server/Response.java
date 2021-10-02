package com.eomcs.server;

// 역할
// - 클라이언트에게 응답할 정보를 보관하는 일을 한다.
public class Response {

  public static final String SUCCESS = "success";
  public static final String FAIL = "fail";

  String status;
  Object value;

  public Response() {}
  // => 아래 파라미터 들어가는 걸 하나 만들면 기본 생성자는 이렇게 빈값으로 둬야 한다
  // => 기존 생성자가 있으면 다른 생성자를 추가할 수 없기 때문

  public Response(String status, Object value) {
    this.status = status;
    this.value = value;
  }

  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public Object getValue() {
    return value;
  }
  public void setValue(Object value) {
    this.value = value;
  }
}
