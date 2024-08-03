import java.util.Scanner;

public class Main {
    // 메모이제이션을 위한 배열을 선언
    static int[][][] memo = new int[21][21][21];

    // w 함수를 정의합니다.
    public static int w(int a, int b, int c) {
        // a, b, c가 0 이하일 경우, 1을 반환
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        // a, b, c가 20 초과일 경우, w(20, 20, 20)을 반환
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }
        // 메모이제이션 배열에 값이 이미 저장되어 있으면, 그 값을 반환
        if (memo[a][b][c] != 0) {
            return memo[a][b][c];
        }
        // a < b < c 일 경우의 재귀 호출
        if (a < b && b < c) {
            memo[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            // 그 외의 경우의 재귀 호출
            memo[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
        // 계산된 값을 반환합니다.
        return memo[a][b][c];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            // 입력이 -1 -1 -1이면 프로그램을 종료
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            // 출력
            System.out.printf("w(%d, %d, %d) = %d%n", a, b, c, w(a, b, c));
        }
        scanner.close();
    }
}
