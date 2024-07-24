import java.util.Scanner;

public class Main {
    // 저장 횟수를 추적하기 위한 변수
    static int saveCount = 0;
    // K 번째 저장되는 수를 저장할 변수
    static int result = -1;
    // K 값을 저장할 변수
    static int K;
    // 병합 정렬에 사용할 임시 배열
    static int[] tmp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 배열 크기 N과 저장 횟수 K 입력받기
        int N = scanner.nextInt();
        K = scanner.nextInt();

        int[] A = new int[N];

        // 배열 A의 원소들 입력받기
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        scanner.close();

        // 임시 배열 초기화
        tmp = new int[N];

        // 병합 정렬 수행
        mergeSort(A, 0, N - 1);

        // 결과 출력
        System.out.println(result);
    }

    // 병합 정렬 함수
    public static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    // 병합 함수
    public static void merge(int[] A, int p, int q, int r) {
        int i = p, j = q + 1, t = 0;

        // 두 부분 배열을 병합
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        // 왼쪽 배열 부분이 남은 경우
        while (i <= q) {
            tmp[t++] = A[i++];
        }

        // 오른쪽 배열 부분이 남은 경우
        while (j <= r) {
            tmp[t++] = A[j++];
        }

        t = 0;
        i = p;

        // 결과를 A[p..r]에 저장
        while (i <= r) {
            A[i] = tmp[t++];
            saveCount++;
            // 저장 횟수가 K에 도달하면 해당 값을 result에 저장
            if (saveCount == K) {
                result = A[i];
                return;
            }
            i++;
        }
    }
}
