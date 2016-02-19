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
