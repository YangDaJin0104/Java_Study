import java.util.Scanner;

public class Main {

    // 최대공약수를 구하는 함수 (유클리드 호제법 사용)
    public static long gcd(long a, long b) {
        // b가 0이 될 때까지 반복
        while (b != 0) {
            long temp = b;
            b = a % b;  // a를 b로 나눈 나머지를 b에 할당
            a = temp;   // 이전 b 값을 a에 할당
        }
        return a;  // b가 0이 되면 a는 최대공약수
    }

    // 최소공배수를 구하는 함수
    public static long lcm(long a, long b) {
        return a * (b / gcd(a, b));  // a와 b의 곱을 최대공약수로 나눈 값이 최소공배수
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 두 개의 정수를 입력 받음
        long a = scanner.nextLong();  // 첫 번째 정수
        long b = scanner.nextLong();  // 두 번째 정수

        // 최소공배수를 계산하여 출력
        System.out.println(lcm(a, b));

        scanner.close();  // 스캐너 닫기
    }
}
