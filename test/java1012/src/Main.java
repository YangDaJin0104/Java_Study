import java.util.Scanner;

public class Main {

    // 배추밭을 나타내는 2차원 배열
    private static int[][] field;
    // 방문 여부를 기록하는 2차원 배열
    private static boolean[][] visited;
    // 상하좌우 네 방향을 나타내는 배열
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    // 배추밭의 가로길이(M), 세로길이(N), 배추의 개수(K)
    private static int M, N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스의 개수를 입력받음
        int T = sc.nextInt();

        // 각 테스트 케이스를 처리
        for (int t = 0; t < T; t++) {
            // 배추밭의 가로길이(M), 세로길이(N), 배추의 개수(K)를 입력받음
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            // 배추밭과 방문 배열을 초기화
            field = new int[N][M];
            visited = new boolean[N][M];

            // 배추의 위치를 입력받아 배추밭에 설정
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[y][x] = 1;
            }

            // 필요한 지렁이 수를 세기 위한 변수
            int wormCount = 0;
            // 배추밭을 순회하며 DFS 수행
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 배추가 심어져 있고 방문하지 않은 경우
                    if (field[i][j] == 1 && !visited[i][j]) {
                        // DFS를 통해 인접한 배추를 모두 방문
                        dfs(i, j);
                        // 독립된 배추 영역이므로 지렁이 수 증가
                        wormCount++;
                    }
                }
            }

            // 각 테스트 케이스의 결과 출력
            System.out.println(wormCount);
        }

        // 입력 스트림 닫기
        sc.close();
    }

    // DFS를 통해 인접한 배추를 모두 방문하는 함수
    private static void dfs(int y, int x) {
        // 현재 위치를 방문했음을 표시
        visited[y][x] = true;

        // 네 방향으로 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 이동한 위치가 배추밭을 벗어나지 않고, 배추가 심어져 있으며, 방문하지 않은 경우
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && field[ny][nx] == 1 && !visited[ny][nx]) {
                // 재귀적으로 DFS를 호출하여 인접한 배추 방문
                dfs(ny, nx);
            }
        }
    }
}
