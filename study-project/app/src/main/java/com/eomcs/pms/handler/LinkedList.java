package com.eomcs.pms.handler;

public class LinkedList extends List {

  static class Node {
    Object item;
    Node next;

    public Node(Object item) {
      this.item = item;
    }
  }

  Node head;
  Node tail;
  int size; // default가 0인 거 아니까

  public void add(Object item) {

    Node node = new Node(item);

    if (head == null) {
      tail = head = node;
    } else {
      // 기존에 tail이 가리키는 마지막 노드의 next 변수에 새 노드 주소를 저장한다.
      tail.next = node;

      // 새로 만든 노드를 마지막 노드로 설정한다. 
      tail = node;
    }

    size++;
  }

  public Object[] toArray() {
    // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만든다.
    Object[] arr = new Object[this.size]; // 1. 개수만큼 배열을 만들고

    Node node = head;

    for (int i = 0; i < size; i++) { // 0이 아니면 뭐가 있다는 뜻 // while문으로 사용하는 방법
      arr[i++] = node.item; // 2. node에 들어있는 board 객체를 배열에 담아서 i를 증가시키고
      node = node.next; // 3. 다음 node로 가서 그 주소를 현재 node에 담아서 반복 -> node가 null이 아닐 때까지
    } 
    return arr; // 새 배열을 리턴한다.
  }

  public boolean remove(Object item) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.item == item) { // 노드에 들어있는 객체와 같다면
        if (node == head) { // 삭제할 노드가 하필이면 첫 번째 노드라면,
          head = node.next; // head가 두 번째 노드를 가리키게 한다.
        } else { // 삭제할 노드가 첫 번째 노드가 아니라면,
          prev.next = node.next; // 이전 노드를 다음 노드와 연결한다.
        }

        node.next = null; // 삭제할 노드가 더이상 다음 노드를 가리키지 않게 한다.

        if (node == tail) { // 삭제할 노드가 마지막 노드라면
          tail = prev; // tail이 이전 노드를 가리키게 한다.
        }
        size--; // 삭제했으니까 사이즈는 여기에서 줄임
        return true; // 그리고 반복문을 나감 (삭제했다는 것)
      }

      // 현재 노드가 아니라면,
      prev = node; // 현재 노드를 prev 에 저장하고,
      node = node.next; // node 는 다음 노드를 가리킨다.
    }
    return false; // 그 밖에는 false // 반복문이 return할 때까지 못 찾았을 때 false
  }

}
