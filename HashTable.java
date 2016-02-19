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
    System.out.println("bucket: " + bucket + " name: " + name + " score: " + score);
    table[bucket].addData(name, score);
  }

  public int collisionCount() {
    int total = 0;

    for (int i = 0; i < tableSize; i++) {
      if (table[i] == null) continue;

      // get collisions from each set and add to total
      total +=  table[i].collisions();
    }
    return total;
  }
}
