import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력받기
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        // 팩토리얼 값을 저장할 변수 초기화
        long factorial = 1;

        // 1부터 N까지의 수를 반복하여 각 수를 factorial변수에 곱한다.
        for (int i = 1; i <= N; i++) {
            factorial *= i;
        }

        System.out.println(factorial);
    }
}