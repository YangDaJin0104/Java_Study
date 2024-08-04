import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄에서 a1과 a0를 입력받기
        int a1 = scanner.nextInt();
        int a0 = scanner.nextInt();

        // 두 번째 줄에서 상수 c를 입력받기
        int c = scanner.nextInt();

        // 세 번째 줄에서 n0를 입력받기
        int n0 = scanner.nextInt();

        // 조건 확인
        // n이 n0 이상일 때 모든 n에 대해 a1 * n + a0 <= c * n이 성립하는지 확인
        boolean satisfiesCondition = true; // 조건을 만족하는지 여부를 저장하는 변수
        for (int n = n0; n <= 100; n++) { // n0부터 100까지 모든 n에 대해 확인
            if (a1 * n + a0 > c * n) { // f(n) = a1 * n + a0가 c * n보다 크다면
                satisfiesCondition = false;
                break;
            }
        }

        // 조건을 만족하면 1을 출력, 그렇지 않으면 0을 출력
        if (satisfiesCondition) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        scanner.close();
    }
}
