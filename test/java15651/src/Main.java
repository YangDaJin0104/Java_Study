import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] sequence;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // N값 입력받기
        M = sc.nextInt(); // M값 입력받기

        sequence = new int[M]; // 길이가 M인 수열 배열 초기화

        generateSequences(0); // 백트래킹 함수 호출, 초기 depth는 0

        sc.close(); // Scanner 닫기
    }

    // 백트래킹을 통해 중복 순열을 생성하는 함수
    private static void generateSequences(int depth) {
        if (depth == M) { // depth가 M에 도달하면 수열 완성
            for (int i = 0; i < M; i++) {
                System.out.print(sequence[i] + " "); // 수열 출력
            }
            System.out.println(); // 줄바꿈
            return; // 함수 종료
        }

        for (int i = 1; i <= N; i++) { // 1부터 N까지의 숫자에 대해
            sequence[depth] = i; // 현재 depth에 해당 숫자 배치
            generateSequences(depth + 1); // 다음 depth로 이동하여 재귀 호출
        }
    }
}
