import java.util.*;

class HashTable {
  int tableSize;
  int collisions;
  Set[] table;
  ArrayList<String> nameList;
  ArrayList<Name> minScore = new ArrayList<Name>();
  ArrayList<Name> maxScore = new ArrayList<Name>();

  public HashTable(int size) {
    tableSize = size;
    collisions = 0;
    table = new Set[size];
    nameList = new ArrayList<String>();
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
    if (h < 0) h = -h;

    return h % tableSize;
  }

  public void addToHashTable(String name, Double score) {
    int bucket = hashCode(name);
    if (table[bucket] == null) table[bucket] = new Set();

    System.out.println("bucket: " + bucket + " name: " + name + " score: " + score);
    table[bucket].addData(name, score);

    if (!nameList.contains(name)) nameList.add(name);
  }

  public int collisionCount() {
    int total = 0;

    for (int i = 0; i < tableSize; i++) {
      if (table[i] == null) continue;

      total +=  table[i].collisions();
    }
    return total;
  }

  public int totalNameCount() {
    int total = 0;

    for (int i = 0; i < tableSize; i++) {
      if (table[i] == null) continue;

      total += table[i].names();
    }
    return total;
  }

  public void avgOfEachPlayer() {
    for (int i = 0; i < nameList.size(); i++) {
      int bucket = hashCode(nameList.get(i));
      Double score = table[bucket].totalScores(nameList.get(i));
      int count = table[bucket].countName(nameList.get(i));

      //System.out.println(nameList.get(i) + ": " + table[bucket].avgOfName(nameList.get(i)));
      if (minScore.size() == 0) {
        minScore.add(new Name(nameList.get(i), score, count));
        maxScore.add(new Name(nameList.get(i), score, count));
      } else if (table[bucket].avgOfName(nameList.get(i)) < minScore.get(0).avg) {
        minScore = new ArrayList<Name>();
        minScore.add(new Name(nameList.get(i), score, count));
      } else if (table[bucket].avgOfName(nameList.get(i)) > maxScore.get(0).avg) {
        maxScore = new ArrayList<Name>();
        maxScore.add(new Name(nameList.get(i), score, count));
      } else if (table[bucket].avgOfName(nameList.get(i)).equals(minScore.get(0).avg)) {
        minScore.add(new Name(nameList.get(i), score, count));
      } else if (table[bucket].avgOfName(nameList.get(i)).equals(maxScore.get(0).avg)) {
        maxScore.add(new Name(nameList.get(i), score, count));
      }
    }
  }

  class Name {
    String name;
    Double totalScore;
    int count;
    Double avg;

    public Name(String n, Double ts, int c) {
      name = n;
      totalScore = ts;
      count = c;
      avg = (Double) ts / c;
    }
  }

}
