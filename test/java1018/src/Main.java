import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 보드의 크기 입력
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        // 보드 상태 입력
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = scanner.nextLine().toCharArray();
        }

        // 최소 다시 칠하기 횟수를 저장할 변수
        int minRepaint = Integer.MAX_VALUE;

        // 가능한 모든 8x8 부분을 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; i <= M - 8; j++) {
                minRepaint = Math.min(minRepaint, getMinRepaintCount(board, i, j));
            }
        }

        // 결과 출력
        System.out.println(minRepaint);

        scanner.close();
    }

    // 해당 위치에서 8x8 체스판의 다시 칠하기 횟수를 계산하는 함수
    private static int getMinRepaintCount(char[][] board, int startX, int startY) {
        // 두 가지 체스판 패턴을 기준으로 비교
        String[] pattern1 = {
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW"
        };

        String[] pattern2 = {
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB"
        };

        int count1 = 0;
        int count2 = 0;

        // 8x8 크기의 부분을 탐색하며 두 패턴과 비교
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[startX + i][startY + j] != pattern1[i].charAt(j)) {
                    count1++;
                }
                if (board[startX + i][startY + j] != pattern2[i].charAt(j)) {
                    count2++;
                }
            }
        }

        // 두 패턴 중 적게 다시 칠해야 하는 횟수 반환
        return Math.min(count1, count2);
    }
}
