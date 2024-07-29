import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] sequence;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // N값 입력받기
        M = sc.nextInt(); // M값 입력받기

        sequence = new int[M]; // 길이가 M인 수열 배열 초기화
        sb = new StringBuilder(); // StringBuilder 초기화

        generateSequences(1, 0); // 백트래킹 함수 호출, 초기 시작 숫자는 1, depth는 0

        System.out.print(sb.toString()); // 모든 결과 한 번에 출력

        sc.close(); // Scanner 닫기
    }

    // 백트래킹을 통해 비내림차순 중복 수열을 생성하는 함수
    private static void generateSequences(int start, int depth) {
        if (depth == M) { // depth가 M에 도달하면 수열 완성
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" "); // 수열을 StringBuilder에 추가
            }
            sb.append("\n"); // 줄바꿈 추가
            return; // 함수 종료
        }

        for (int i = start; i <= N; i++) { // 시작 숫자부터 N까지의 숫자에 대해
            sequence[depth] = i; // 현재 depth에 해당 숫자 배치
            generateSequences(i, depth + 1); // 다음 depth로 이동하여 재귀 호출, 다음 시작 숫자는 현재 숫자 이상
        }
    }
}
