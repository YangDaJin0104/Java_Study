import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 배열의 크기 N을 입력 받음
        int N = scanner.nextInt();
        int[] arr = new int[N];

        // 배열의 원소들을 입력 받음
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // 배열을 정렬
        Arrays.sort(arr);

        // 필요한 최소 추가 원소의 수를 계산
        int min = Integer.MAX_VALUE;

        // 배열의 각 원소를 시작점으로 연속된 5개의 숫자를 찾음
        for (int i = 0; i < N; i++) {
            int end = arr[i] + 4;  // 연속된 5개의 숫자의 끝점
            int count = 0;
            for (int j = i; j < N; j++) {
                if (arr[j] <= end) {
                    count++;
                } else {
                    break;
                }
            }
            min = Math.min(min, 5 - count);
        }

        // 결과 출력
        System.out.println(min);
    }
}
