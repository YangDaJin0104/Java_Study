import javax.swing.text.Style;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr[][] = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int arr2[][] = {{10, 20, 30,}, {40, 50, 60}}; // new int 생략가능

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("arr3[%d][%d] = %d%n", i,j,arr[i][j]);
            }
        }
    }
}