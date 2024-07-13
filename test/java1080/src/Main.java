import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();  // 버퍼 비우기

        // 행렬 A 입력
        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }

        // 행렬 B 입력
        int[][] B = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = line.charAt(j) - '0';
            }
        }

        // 연산 횟수 계산
        int result = solve(N, M, A, B);
        System.out.println(result);
    }

    public static int solve(int N, int M, int[][] A, int[][] B) {
        int count = 0;

        // 3x3 부분 행렬을 뒤집는 연산 수행
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (A[i][j] != B[i][j]) {
                    flip(A, i, j);
                    count++;
                }
            }
        }

        // 변환이 완료되었는지 확인
        if (isSame(N, M, A, B)) {
            return count;
        } else {
            return -1;
        }
    }

    // 3x3 부분 행렬 뒤집기
    public static void flip(int[][] A, int x, int y) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                A[x + i][y + j] = 1 - A[x + i][y + j];
            }
        }
    }

    // 두 행렬이 같은지 확인
    public static boolean isSame(int N, int M, int[][] A, int[][] B) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
