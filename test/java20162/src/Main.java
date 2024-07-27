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
        int[] dp = new int[N + 1];
        dp[0] = 0;  // 서울이가 간식을 먹지 않은 초기 상태의 만족도는 0

        // 각 날마다 간식을 먹는 경우와 먹지 않는 경우를 고려하여 DP 배열을 갱신
        for (int i = 1; i <= N; i++) {
            // i번째 날에 간식을 먹지 않는 경우, 전날까지의 최대 만족도를 그대로 가져온다.
            dp[i] = dp[i - 1];

            for (int j = 0; j < i; j++) {
                // 첫날이거나, i번째 날의 간식 평점이 이전에 먹었던 간식 평점보다 높은 경우에만 먹는다.
                if (j == 0 || snacks[i - 1] > snacks[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + snacks[i - 1]);
                }
            }
        }

        // 최대 만족도를 찾기 위해 DP 배열을 탐색
        int maxSatisfaction = 0;
        for (int i = 1; i <= N; i++) {
            maxSatisfaction = Math.max(maxSatisfaction, dp[i]);
        }

        // 결과 출력
        System.out.println(maxSatisfaction);
        sc.close();
    }
}
