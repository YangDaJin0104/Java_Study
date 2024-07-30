import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // 전역 변수 선언
    static int N, M; // N: 행의 수, M: 열의 수
    static int[][] height; // 땅의 높이를 저장하는 2차원 배열
    static boolean[][] visited; // 방문 여부를 저장하는 2차원 배열
    static int[] dx = {0, 1, 0, -1}; // 4방향 탐색을 위한 x방향 배열
    static int[] dy = {1, 0, -1, 0}; // 4방향 탐색을 위한 y방향 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 행의 수 입력
        M = sc.nextInt(); // 열의 수 입력
        height = new int[N][M]; // 땅의 높이를 저장할 배열 초기화
        visited = new boolean[N][M]; // 방문 여부를 저장할 배열 초기화

        // 땅의 높이 입력
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                height[i][j] = line.charAt(j) - '0';
            }
        }

        // 계산 결과 출력
        System.out.println(calculateWater());
    }

    // 물의 양을 계산하는 함수
    public static int calculateWater() {
        // BFS로 테두리의 물이 새어나가는 부분을 먼저 탐색
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 테두리에 있는 칸들을 큐에 추가하고 방문 처리
                if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // 큐가 빌 때까지 BFS 탐색
        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); // 큐에서 꺼낸 현재 위치
            int x = cur[0], y = cur[1];

            // 4방향으로 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 내에 있고 방문하지 않았으며, 현재 높이보다 낮거나 같은 경우
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && height[nx][ny] <= height[x][y]) {
                    visited[nx][ny] = true; // 방문 처리
                    queue.add(new int[]{nx, ny}); // 큐에 추가
                }
            }
        }

        // 내부의 물이 고일 수 있는 공간을 계산
        int water = 0;
        for (int i = 1; i < N - 1; i++) { // 테두리를 제외한 내부 탐색
            for (int j = 1; j < M - 1; j++) {
                if (!visited[i][j]) { // 방문하지 않은 칸
                    int minHeight = 9; // 최소 높이를 9로 초기화 (높이 최대값)
                    for (int k = 0; k < 4; k++) { // 4방향 탐색
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        minHeight = Math.min(minHeight, height[nx][ny]); // 주변 칸의 최소 높이 찾기
                    }
                    if (minHeight > height[i][j]) { // 현재 칸이 주변 칸보다 낮다면
                        water += (minHeight - height[i][j]); // 물의 양 계산
                    }
                    visited[i][j] = true; // 방문 처리
                }
            }
        }

        return water; // 총 물의 양 반환
    }
}
