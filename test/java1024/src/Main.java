import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N과 L을 입력받음
        long N = scanner.nextLong();
        int L = scanner.nextInt();

        // 결과를 저장할 변수
        boolean result = false;

        // L의 최소값부터 100까지 반복
        for (int len = L; len <= 100; len++) {
            // (len - 1) * len / 2는 첫번째 숫자가 0일 때 수열의 합이 len이 되는 경우
            long tmp = N - (len - 1) * len / 2;

            // tmp가 len의 배수인지 확인
            if (tmp % len == 0) {
                long num = tmp / len;
                if (num >= 0) {
                    result = true;

                    // 결과 수열 출력
                    for (int i = 0; i < len; i++) {
                        System.out.print(num + i + " ");
                    }
                    System.out.println();
                    break; // 수열을 찾으면 반복 종료
                }
            }
        }

        // 수열을 찾지 못했을 경우 -1 출력
        if (!result) {
            System.out.println(-1);
        }

        scanner.close();
    }
}
