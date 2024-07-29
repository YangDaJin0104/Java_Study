import java.util.Scanner;

public class Main {
    // 전역 변수 선언
    static int N; // 숫자의 개수
    static int[] numbers; // 입력된 숫자 배열
    static int[] operators = new int[4]; // 연산자 개수 배열 (덧셈, 뺄셈, 곱셈, 나눗셈 순)
    static int maxResult = Integer.MIN_VALUE; // 최대 결과값을 저장할 변수
    static int minResult = Integer.MAX_VALUE; // 최소 결과값을 저장할 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 숫자의 개수 입력
        N = sc.nextInt();
        numbers = new int[N]; // 숫자 배열 초기화

        // 숫자 입력
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        // 연산자 개수 입력
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        // 백트래킹 시작, 첫 번째 숫자부터 시작
        backtrack(numbers[0], 1);

        // 결과 출력
        System.out.println(maxResult); // 최대 결과값 출력
        System.out.println(minResult); // 최소 결과값 출력

        sc.close(); // 스캐너 닫기
    }

    // 백트래킹 함수
    private static void backtrack(int currentResult, int index) {
        // 모든 숫자를 다 사용한 경우 결과값 갱신
        if (index == N) {
            maxResult = Math.max(maxResult, currentResult); // 최대값 갱신
            minResult = Math.min(minResult, currentResult); // 최소값 갱신
            return;
        }

        // 가능한 모든 연산자 사용
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) { // 연산자가 남아 있는 경우
                operators[i]--; // 연산자 사용
                switch (i) {
                    case 0: // 덧셈
                        backtrack(currentResult + numbers[index], index + 1);
                        break;
                    case 1: // 뺄셈
                        backtrack(currentResult - numbers[index], index + 1);
                        break;
                    case 2: // 곱셈
                        backtrack(currentResult * numbers[index], index + 1);
                        break;
                    case 3: // 나눗셈
                        backtrack(currentResult / numbers[index], index + 1);
                        break;
                }
                operators[i]++; // 연산자 복구
            }
        }
    }
}
