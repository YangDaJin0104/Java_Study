import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    // Cell 클래스 정의: 각 칸의 위치와 높이를 저장하며, 우선순위 큐에서 사용하기 위해 Comparable 인터페이스를 구현
    static class Cell implements Comparable<Cell> {
        int x, y, height;

        // Cell 클래스의 생성자
        Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        // 우선순위 큐에서 사용하기 위해 높이를 기준으로 비교하는 메소드
        @Override
        public int compareTo(Cell other) {
            return this.height - other.height;
        }
    }

    // 4방향 탐색을 위한 배열
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 행의 수 입력
        int M = sc.nextInt(); // 열의 수 입력
        int[][] height = new int[N][M]; // 땅의 높이를 저장할 배열 초기화

        // 땅의 높이 입력
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                height[i][j] = line.charAt(j) - '0';
            }
        }

        // 물이 고일 수 있는 양 계산 후 출력
        System.out.println(trapWater(height, N, M));
    }

    // 물의 양을 계산하는 함수
    public static int trapWater(int[][] height, int N, int M) {
        if (N <= 2 || M <= 2) return 0; // 경계 조건: 행이나 열이 2 이하인 경우 물이 고일 수 없으므로 0 반환

        PriorityQueue<Cell> pq = new PriorityQueue<>(); // 우선순위 큐 초기화
        boolean[][] visited = new boolean[N][M]; // 방문 여부를 저장할 배열 초기화

        // 테두리의 칸들을 우선순위 큐에 추가하고 방문 처리
        for (int i = 0; i < N; i++) {
            pq.add(new Cell(i, 0, height[i][0]));
            pq.add(new Cell(i, M - 1, height[i][M - 1]));
            visited[i][0] = true;
            visited[i][M - 1] = true;
        }

        for (int j = 0; j < M; j++) {
            pq.add(new Cell(0, j, height[0][j]));
            pq.add(new Cell(N - 1, j, height[N - 1][j]));
            visited[0][j] = true;
            visited[N - 1][j] = true;
        }

        int water = 0; // 고일 수 있는 물의 양 초기화

        // 우선순위 큐가 빌 때까지 반복
        while (!pq.isEmpty()) {
            Cell cell = pq.poll(); // 큐에서 높이가 가장 낮은 셀을 꺼냄

            // 4방향으로 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cell.x + dx[i];
                int ny = cell.y + dy[i];

                // 범위 내에 있고 방문하지 않은 경우
                if (nx > 0 && nx < N - 1 && ny > 0 && ny < M - 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true; // 방문 처리
                    // 현재 셀과 인접한 셀의 높이 차이를 계산하여 물의 양을 더함
                    water += Math.max(0, cell.height - height[nx][ny]);
                    // 인접한 셀을 우선순위 큐에 추가 (높이는 현재 셀과 인접한 셀 중 더 높은 값)
                    pq.add(new Cell(nx, ny, Math.max(height[nx][ny], cell.height)));
                }
            }
        }

        return water; // 총 물의 양 반환
    }
}
