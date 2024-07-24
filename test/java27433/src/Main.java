import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력받기
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        // 팩토리얼 값을 계산하여 변수에 저장
        long factorial = factorial(N);

        System.out.println(factorial);
    }

    // 팩토리얼을 계산하는 재귀 함수
    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            // 재귀 호출을 통해 n*(n-1)! 계산
            return n * factorial(n - 1);
        }
    }
}