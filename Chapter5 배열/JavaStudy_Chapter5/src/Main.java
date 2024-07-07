import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int score[];
        score = new int[10];

        for (int i = 0; i < score.length; i++) {
            score[i] = i * 10 + 100;
            System.out.print(score[i] + ","); //100,110,120,130,140,150,160,170,180,190,
        }
        System.out.println();
        System.out.print(Arrays.toString(score)); //[100, 110, 120, 130, 140, 150, 160, 170, 180, 190]
    }
}

/*

*/