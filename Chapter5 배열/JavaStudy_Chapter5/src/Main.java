import javax.swing.text.Style;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr1[] = new int[10];
        int arr2[] = new int[20];
        int arr3[] = new int[]{100, 95, 90, 80, 70, 60};
        char arr4[] = {'a', 'b', 'c', 'd'};

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i + 10;
            System.out.print(arr1[i] + ","); //10,11,12,13,14,15,16,17,18,19,
        }

        System.out.println();

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (Math.random() * 10 + 1);
        }

        System.out.println(Arrays.toString(arr2)); //[7, 3, 3, 3, 8, 3, 3, 6, 10, 3, 7, 1, 4, 10, 6, 8, 3, 3, 4, 1]
        System.out.println(Arrays.toString(arr3)); //[100, 95, 90, 80, 70, 60]
        System.out.println(Arrays.toString(arr4)); //[a, b, c, d]

        System.out.println(arr1); //[I@568db2f2, 실행될때마다 바뀜
        System.out.println(arr4); //abcd
    }
}