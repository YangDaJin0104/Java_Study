import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄 입력 받기
        int a1 = scanner.nextInt();
        int a0 = scanner.nextInt();

        // 두 번째 줄 입력 받기
        int c = scanner.nextInt();

        // 세 번째 줄 입력 받기
        int n0 = scanner.nextInt();

        // 조건 확인
        if ((a1 - c) * n0 + a0 <= 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        scanner.close();
    }
}
