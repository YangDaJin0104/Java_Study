import java.util.Scanner;

public class Main {
    static int N; // 수의 갯수
    static int[] numbers; // 수열을 저장하는 배열
    static int[] operators; // 연산자의 개수를 저장하는 배열
    static int maxValue = Integer.MIN_VALUE; // 가능한 수식의 최대값
    static int minValue = Integer.MAX_VALUE; // 가능한 수식의 최소값

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 수 갯수 입력
        N = scanner.nextInt();
        numbers = new int[N];

        // 수열 입력
        for (int i = 0; i < N; i++){
            numbers[i] = scanner.nextInt();
        }

        // 연산자의 갯수 입력(덧셈, 뺄셈, 곱셈, 나눗셈 순)
        operators = new int[4];
        for (int i = 0; i < 4; i++){
            operators[i] = scanner.nextInt();
        }

        scanner.close();

        // 백트래킹을 이용한 계산 시작
        calculate(numbers[0], 1);

        // 최댓값과 최솟값 출력
        System.out.println(maxValue);
        System.out.println(minValue);
    }


    // 백트래킹을 이용한 계산 함수
    private static void calculate(int current, int index){
        // 최댓값과 최솟값 갱신
        if (index == N) {
            maxValue = Math.max(maxValue, current);
            minValue = Math.min(minValue, current);
            return;
        }
        // 4가지 연산자에 대해 순회(덧셈, 뺄셈, 곱셈, 나눗셈 순)
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                // 연산자에 따르 계산 수행 및 다음 단계로 재귀 호출
                switch (i) {
                    case 0:  // 덧셈
                        calculate(current + numbers[index], index + 1);
                        break;
                    case 1:  // 뺄셈
                        calculate(current - numbers[index], index + 1);
                        break;
                    case 2:  // 곱셈
                        calculate(current * numbers[index], index + 1);
                        break;
                    case 3:  // 나눗셈
                        if (current < 0) {
                            calculate(-(-current / numbers[index]), index + 1);
                        } else {
                            calculate(current / numbers[index], index + 1);
                        }
                        break;
                }

                operators[i]++; // 연산자를 사용하고 다시 복구
            }
        }
    }
}
