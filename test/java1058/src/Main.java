import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사람 수 N입력
        int N = scanner.nextInt();
        scanner.nextLine(); // 개행문자 처리

        // 친구 관계를 저장할 2차원 배열
        char[][] friend = new char[N][N];

        // 각 사람의 친구 관계를 입력받아 배열에 저장
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            friend[i] = line.toCharArray();
        }
        // 가장 유명한 사람의 2-친구 수를 저장할 변수 초기화
        int maxFamousCount = 0;

        // 각 사람마다 2-친구 수를 계산
        for (int i = 0; i < N; i++) {
            boolean[] isFriend = new boolean[N];
            int cnt = 0;

            // 직접 친구들을 체크하고 count 증가
            for (int j = 0; j < N; j++) {
                if (friend[i][j] == 'Y') {
                    isFriend[j] = true; // j는 i의 직접 친구
                    cnt++;
                }
            }
            // 직접 친구들의 친구들을 체크하여 2-친구를 찾음
            for (int j = 0; j < N; j++) {
                if (friend[i][j] == 'Y') { // j가 i의 직접 친구인 경우
                    for (int k = 0; k < N; k++) {
                        if (friend[j][k] == 'Y' && i != k && !isFriend[k]) {
                            // k가 j의 친구이고, i 자신이 아니며, 아직 체크되지 않은 경우
                            isFriend[k] = true; // k는 i의 2-친구
                            cnt++;
                        }
                    }
                }
            }
            maxFamousCount = Math.max(maxFamousCount, cnt); // 현재 사람의 2-친구 수가 최대값인지 확인하여 갱신
        }
        System.out.println(maxFamousCount); // 가장 유명한 사람의 2-친구 수를 출력
    }
}