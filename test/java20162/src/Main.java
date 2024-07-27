import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력받기
        int N = sc.nextInt();
        int[] snacks = new int[N];

        for (int i = 0; i < N; i++) {
            snacks[i] = sc.nextInt();
        }

        // DP 배열을 선언하여 i번째 날까지의 최대 만족도를 저장
        int[] dp = new int[N];
        dp[0] = snacks[0];  // 첫 번째 날의 만족도는 첫 번째 간식의 평점

        // 각 날마다 간식을 먹는 경우와 먹지 않는 경우를 고려하여 DP 배열을 갱신
        for (int i = 1; i < N; i++) {
            dp[i] = snacks[i];  // 기본적으로 현재 간식의 평점을 설정

            for (int j = 0; j < i; j++) {
                // 이전 간식의 평점이 현재 간식의 평점보다 낮은 경우에만 먹을 수 있다.
                if (snacks[j] < snacks[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + snacks[i]);
                }
            }
        }

        // 최대 만족도를 찾기 위해 DP 배열을 탐색
        int maxSatisfaction = 0;
        for (int i = 0; i < N; i++) {
            maxSatisfaction = Math.max(maxSatisfaction, dp[i]);
        }

        // 결과 출력
        System.out.println(maxSatisfaction);
        sc.close();
    }
}
