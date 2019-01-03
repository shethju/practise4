package array;

//"static void main" must be defined in a public class.
public class ArrayBasics2 {
 private static void printArray(int[][] a) {
     for (int i = 0; i < a.length; ++i) { // a.length
         System.out.println(a[i]);
     }
     for (int i = 0; i < a.length; ++i) {
         for (int j = 0; a[i] != null && j < a[i].length; ++j) { // a[i].length
             System.out.print(a[i][j] + " ");
         }
         System.out.println();
     }
 }
 public static void main(String[] args) {
     System.out.println("Example I:");
     int[][] a = new int[2][5];
     printArray(a);
     System.out.println("Example II:");
     int[][] b = new int[2][];
     printArray(b); // other values are null
     System.out.println("Example III:");
     b[0] = new int[3]; // the array is initialized to 0
     b[1] = new int[5];
     printArray(b);
 }
}