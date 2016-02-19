import java.io.*;
import java.util.*;

class Project3 {

  public static void main(String args[]) throws IOException {
    if (args.length < 1) {
      System.out.println("Error: Directory name is missing.");
      System.out.println("Usage: java Project3 directory_name");
      return;
    }
    File directory = new File(args[0]);
    File[] files = directory.listFiles();

    File file;
    Scanner input;
    LineNumberReader lnr;
    int hashTableSize = 0;

    // create size of hash table (size is 25% bigger than the file with the most lines)
    for (int i = 0; i < files.length; i++) {
      lnr = new LineNumberReader(new FileReader(new File(directory + "/" + files[i].getName())));
      lnr.skip(Long.MAX_VALUE);
      //System.out.println(files[i].getName() + " " + lnr.getLineNumber());
      if (lnr.getLineNumber() > hashTableSize) {
        hashTableSize = lnr.getLineNumber();
      }
    }
    hashTableSize = (int) Math.ceil(hashTableSize * 1.25);
    HashTable hTable = new HashTable(hashTableSize);


    // process the argument stores in args
    for (int i = 0; i < files.length; i++) {
      input = new Scanner(files[i]);
      String name;
      Double score;

      System.out.println("\nCurrent file name: " + files[i].getName());

      while (input.hasNext()) {
        name = "";
        while (!input.hasNextDouble()) {
          name += input.next() + " ";
        }
        name = name.trim();
        score = new Double(input.next());
        System.out.println("Name: " + name + " Score: " + score);
        hTable.addToHashTable(name, score);
      }
    }

    System.out.println("final: " + Arrays.toString(hTable.table));
    System.out.println("# of collisions: " + hTable.collisionCount());
    System.out.println("Size of table: " + hTable.tableSize);
  }
}
