class HashTable {
  int tableSize;
  int collisions;
  Set[] table;

  public HashTable(int size) {
    tableSize = size;
    collisions = 0;
    table = new Set[size];
  }

  public int hashCode(String s) {
    int h = 0;
    for (int i = 0; i < s.length(); i++) {
      h = (h << 5) | (h >>> 27);
      h += (int) s.charAt(i);
    }
    return compress(h);
  }

  public int compress(int h) {
    if (h < 0) {
      h = -h;
    }
    return h % tableSize;
  }

  public void addToHashTable(String name, Double score) {
    int bucket = hashCode(name);
    if (table[bucket] == null) {
      table[bucket] = new Set();
    }
    table[bucket].addData(name, score);
  }
}
