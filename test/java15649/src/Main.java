import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] sequence;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // N값 입력받기
        M = sc.nextInt(); // M값 입력받기

        sequence = new int[M]; // 길이가 M인 수열 배열 초기화
        used = new boolean[N + 1]; // 숫자 사용 여부를 체크하는 배열 초기화 (1부터 N까지 사용하기 위해 N+1 크기로 설정)

        generatePermutations(0); // 백트래킹 함수 호출, 초기 depth는 0

        sc.close();
    }

    // 백트래킹을 통해 순열을 생성하는 함수
    private static void generatePermutations(int depth) {
        if (depth == M) { // depth가 M에 도달하면 수열 완성
            for (int i = 0; i < M; i++) {
                System.out.print(sequence[i] + " "); // 수열 출력
            }
            System.out.println(); // 줄바꿈
            return; // 함수 종료
        }

        for (int i = 1; i <= N; i++) { // 1부터 N까지의 숫자에 대해
            if (!used[i]) { // 사용되지 않은 숫자라면
                used[i] = true; // 숫자 사용 표시
                sequence[depth] = i; // 현재 depth에 해당 숫자 배치
                generatePermutations(depth + 1); // 다음 depth로 이동하여 재귀 호출
                used[i] = false; // 재귀 호출이 끝난 후 숫자 사용 표시 해제 (백트래킹)
            }
        }
    }
}
