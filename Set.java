class Set {
  private Node head;
  private int size;

  public Set() {
    head = new Node(null, null, null);
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean addData(String name, Double score) {
    Node newNode = new Node(name, score, null);
    if (size == 0) {
      head = newNode;
    } else {
      Node temp = head;
      System.out.println("head: " + temp.name);
      while (temp.next != null) {
        System.out.println("while temp: " + temp.name + temp.score);
        temp = temp.next;
      }
      temp.next = newNode;
    }
    size++;
    return true;
  }

  /*
  public Double avgScore(String name) {

  }
  */
  private static class Node {
    String name;
    Double score;
    Node next;

    public Node(String na, Double s, Node n) {
      name = na;
      score = s;
      next = n;
    }

  }

}
