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
      System.out.println(files[i].getName() + " " + lnr.getLineNumber());
      if (lnr.getLineNumber() > hashTableSize) {
        hashTableSize = lnr.getLineNumber();
      }
    }

    hashTableSize = (int) Math.ceil(hashTableSize * 1.25);
    System.out.println("\nSize of table: " + hashTableSize);

    Set[] hashTable = new Set[hashTableSize];
    hashTable[0] = new Set();
    hashTable[0].addData("asdf", 10.01);
    System.out.println(Arrays.toString(hashTable));

    // process the argument stores in args
    for (int i = 0; i < files.length; i++) {
      input = new Scanner(files[i]);

      System.out.println("\nCurrent file name: " + files[i].getName());

      String key;
      Double value;
      while (input.hasNext()) {
        key = "";
        while (!input.hasNextDouble()) {
          key += input.next() + " ";
        }
        key = key.trim();
        value = new Double(input.next());
        System.out.println("Key: " + key + " Value: " + value);
      }

    }

  }
}
