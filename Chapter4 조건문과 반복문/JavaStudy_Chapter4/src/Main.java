import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 블록의 가로 길이와 세로 길이를 입력
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        // 상점의 개수를 입력.
        int numStores = scanner.nextInt();

        // 상점들의 위치를 저장할 2차원 배열을 선언
        int[][] stores = new int[numStores][2];
        for (int i = 0; i < numStores; i++) {
            // 각 상점의 위치를 입력받아 배열에 저장
            stores[i][0] = scanner.nextInt(); // 방향 (1: 북쪽, 2: 남쪽, 3: 서쪽, 4: 동쪽)
            stores[i][1] = scanner.nextInt(); // 거리 (각 방향 기준 왼쪽 또는 위쪽부터의 거리)
        }

        // 동근이의 위치를 입력
        int donggeunDirection = scanner.nextInt();
        int donggeunDistance = scanner.nextInt();

        // 동근이의 위치를 직사각형 경계의 특정 지점으로 변환
        int donggeunPosition = getPosition(donggeunDirection, donggeunDistance, width, height);

        // 동근이와 각 상점 간의 최단 거리 합을 저장할 변수
        int totalDistance = 0;

        // 각 상점의 위치와 동근이의 위치 간의 거리를 계산
        for (int i = 0; i < numStores; i++) {
            // 각 상점의 위치를 직사각형 경계의 특정 지점으로 변환
            int storePosition = getPosition(stores[i][0], stores[i][1], width, height);

            // 시계방향 거리와 반시계방향 거리 중 작은 값을 선택
            int distance = Math.abs(donggeunPosition - storePosition);
            totalDistance += Math.min(distance, 2 * (width + height) - distance);
        }

        // 최단 거리의 합을 출력
        System.out.println(totalDistance);

        scanner.close();
    }

    // 주어진 방향과 거리로부터 직사각형 경계의 특정 지점으로 변환하는 메소드
    private static int getPosition(int direction, int distance, int width, int height) {
        switch (direction) {
            case 1:
                // 북쪽 (1): 왼쪽에서부터의 거리
                return distance;
            case 2:
                // 남쪽 (2): 가로 길이 + 오른쪽에서부터의 거리
                return width + height + (width - distance);
            case 3:
                // 서쪽 (3): 2 * 가로 길이 + 위쪽에서부터의 거리
                return 2 * (width + height) - distance;
            case 4:
                // 동쪽 (4): 가로 길이 + 위쪽에서부터의 거리
                return width + distance;
            default:
                // 유효하지 않은 방향인 경우 예외를 발생시킨다.
                throw new IllegalArgumentException("Invalid direction");
        }
    }
}
