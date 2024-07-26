import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        // 문자열에서 'a'의 개수를 센다.
        int aCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                aCount++;
            }
        }

        // 만약 'a'가 없거나 문자열 전체가 'a'로만 이루어져 있다면 교환이 필요 없음
        if (aCount == 0 || aCount == n) {
            System.out.println(0);
            return;
        }

        // 원형 문자열 처리를 위해 문자열을 두 번 이어붙인다.
        String doubled = s + s;

        // Step 3: 길이가 aCount인 모든 연속 부분 문자열에서 'b'의 개수를 센다.
        int minBCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int bCount = 0;
            for (int j = 0; j < aCount; j++) {
                if (doubled.charAt(i + j) == 'b') {
                    bCount++;
                }
            }
            minBCount = Math.min(minBCount, bCount);
        }

        // 필요한 최소 교환 횟수를 출력
        System.out.println(minBCount);
    }
}
