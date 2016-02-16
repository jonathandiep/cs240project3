class Node {
  String name;
  Double score;
  Node next;

  public Node(String na, Double s, Node n) {
    name = na;
    score = s;
    next = n;
  }

  public String getName() {
    return name;
  }

  public Double getScore() {
    return score;
  }

  public Node getNext() {
    return next;
  }

  public void setData(String newName, Double newScore) {
    name = newName;
    score = newScore;
  }

  public void setNext(Node newNext) {
    next = newNext;
  }
}
