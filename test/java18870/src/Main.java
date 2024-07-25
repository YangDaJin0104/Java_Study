import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 좌표의 개수를 읽어들임
        int N = Integer.parseInt(br.readLine());

        // 좌표를 읽어들여 배열에 저장
        String[] input = br.readLine().split(" ");
        int[] coordinates = new int[N];

        for (int i = 0; i < N; i++) {
            coordinates[i] = Integer.parseInt(input[i]);
        }

        // 원본 좌표 배열을 복사하고 정렬
        int[] sortedCoordinates = coordinates.clone();
        Arrays.sort(sortedCoordinates);

        // HashMap을 사용하여 압축된 값을 저장
        HashMap<Integer, Integer> compressionMap = new HashMap<>();
        int rank = 0;

        // 정렬된 배열을 순회하면서 각 좌표에 대해 압축된 값을 매핑
        for (int coord : sortedCoordinates) {
            if (!compressionMap.containsKey(coord)) { // 이미 압축된 값이 없는 경우에만 매핑
                compressionMap.put(coord, rank);
                rank++;
            }
        }

        // 압축된 좌표를 출력하기 위해 StringBuilder 사용
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; i++) {
            result.append(compressionMap.get(coordinates[i])).append(" ");
        }

        // 결과를 출력
        System.out.println(result.toString().trim());
    }
}
