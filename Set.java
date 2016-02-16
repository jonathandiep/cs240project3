class Set {
  private Node head;
  private int size;

  public Set() {
    head = new Node(null, null, null);
    size = 0;
  }

  public boolean addData(String name, Double score) {
    Node newNode = new Node(name, score, null);
    if (size == 0) {
      head = newNode;
    } else {
      Node temp = head;
      while (temp != null) {
        temp = temp.getNext();
      }
      temp.setNext(newNode);
    }
    size++;
    return true;
  }

  /*
  public boolean addElement(Object data) {
    if (contain(data) || data.equals("")) { return false; }

    Node newNode = new Node(data, null);

    if (size == 0) {
      head.setNext(newNode);
    } else {
      Node temp = head;
      while (temp.getNext() != null) {
        temp = temp.getNext();
      }
      temp.setNext(newNode);
    }
    size++;
    return true;
  }
  */
}
