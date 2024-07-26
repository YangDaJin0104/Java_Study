import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader를 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받기
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        // 듣도 못한 사람의 명단을 저장할 Set
        Set<String> unheard = new HashSet<>();

        // 듣도 못한 사람의 명단을 입력받아 Set에 저장
        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        // 듣보잡을 저장할 TreeSet(TreeSet은 자동으로 정렬)
        Set<String> unheardUnseen = new TreeSet<>();

        // 보도 못한 사람의 명단을 입력받아 듣도 못한 사람 명단에 있는지 확인
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) {
                unheardUnseen.add(name);
            }
        }

        System.out.println(unheardUnseen.size());

        // 듣보잡 명단을 사전순으로 출력
        for (String name : unheardUnseen) {
            System.out.println(name);
        }
    }
}
