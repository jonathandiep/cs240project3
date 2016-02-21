import java.util.ArrayList;

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
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
    size++;
    return true;
  }

  public int collisions() {
    ArrayList<String> names = new ArrayList<String>();
    Node temp = head;

    while (temp != null) {
      if (!names.contains(temp.name)) names.add(temp.name);

      temp = temp.next;
    }
    return names.size() - 1;
  }

  public int names() {
    ArrayList<String> names = new ArrayList<String>();
    Node temp = head;

    while (temp != null) {
      if (!names.contains(temp.name)) names.add(temp.name);

      temp = temp.next;
    }
    return names.size();
  }

  public int countName(String s) {
    Node temp = head;
    int count = 0;

    while (temp != null) {
      if (s.equals(temp.name)) count++;

      temp = temp.next;
    }
    return count;
  }

  public Double totalScores(String s) {
    Node temp = head;
    Double count = 0.0;

    while (temp != null) {
      if (s.equals(temp.name)) count += temp.score;

      temp = temp.next;
    }
    return count;
  }

  public Double avgOfName(String s) {
    return (Double) totalScores(s) / countName(s);
  }

  /*
  public Average avgOfName(String name) {
    Double total = 0.0;
    int count = 0;
    Node temp = head;

    while (temp != null) {
      if (temp.name.equals(name)) {
        total += temp.score;
        count++;
      }

      temp = temp.next;
    }
    Double avg = total / count;
    return new Average(avg, count);
  }

  class Average {
    Double average;
    int count;

    public Average(Double d, int c) {
      average = d;
      count = c;
    }
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
