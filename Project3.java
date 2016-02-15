import java.io.*;
import java.util.*;

class Project3 {
  public static void main(String args[]) throws IOException {
    if (args.length < 1) {
      System.out.println("Error: Directory name is missing.");
      System.out.println("Usage: java scoreProcess directory_name");
      return;
    }
    File directory = new File(args[0]);
    File[] files = directory.listFiles();

    File file;
    Scanner input;

    // process the argument stores in args
    for (int i = 0; i < files.length; i++) {
      input = new Scanner(files[i]);

      System.out.println("Current file name: " + files[i].getName());

      String key;
      Double value;
      while (input.hasNext()) {
        key = "";
        while (!input.hasNextDouble()) {
          key += input.next() + " ";
        }
        value = new Double(input.next());
        System.out.println("Key: " + key + " Value: " + value);
      }
    }
  }
}
