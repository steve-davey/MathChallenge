import java.util.*;
// import java.io.*;

public class MathChallenge {

  public static void swap(char ar[], int a, int b) {
    char temp = ar[a];
    ar[a] = ar[b];
    ar[b] = temp;
  }

  static void findNext(char ar[], int n) {
    int a;
    for (a = n - 1; a > 0; a--) {
      if (ar[a] > ar[a - 1]) {
        break;
      }
    }

    if (a == 0) {
      System.out.println("This is already the highest possible number with these digits");
    } else {
      int x = ar[a - 1], min = a;
      for (int b = a + 1; b < n; b++) {
        if (ar[b] > x && ar[b] < ar[min]) {
          min = b;
        }
      }

      swap(ar, a - 1, min);
      Arrays.sort(ar, a, n);
      for (a = 0; a < n; a++)
        System.out.print(ar[a]);
    }
  }

  public static void main(String[] args) {

    try (Scanner in = new Scanner(System.in)) {
      System.out.println("Enter number");
      String str = in.nextLine();
      char[] charArray = str.toCharArray();
      int len = charArray.length;
      findNext(charArray, len);
    }
  }
}