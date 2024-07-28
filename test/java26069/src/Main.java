import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        // 사람 간의 만남 네트워크를 저장할 맵 생성
        Map<String, Set<String>> danceNetwork = new HashMap<>();

        // 만남 기록을 입력 받아서 네트워크를 구축
        for (int i = 0; i < N; i++) {
            String A = sc.next(); // 첫 번째 사람 이름
            String B = sc.next(); // 두 번째 사람 이름
            sc.nextLine(); // 개행 문자 처리

            // 각 사람의 이름을 키로 사용하여, 만난 사람들의 집합을 값으로 저장
            danceNetwork.putIfAbsent(A, new HashSet<>());
            danceNetwork.putIfAbsent(B, new HashSet<>());

            // A와 B가 만났음을 기록
            danceNetwork.get(A).add(B);
            danceNetwork.get(B).add(A);
        }

        // 무지개 댄스를 추고 있는 사람들을 저장할 집합 생성
        Set<String> dancingPeople = new HashSet<>();
        // BFS를 위한 큐 생성
        Queue<String> queue = new LinkedList<>();

        // 초기 무지개 댄스를 추는 사람 설정 (총총이)
        String initialDancer = "ChongChong";
        dancingPeople.add(initialDancer);
        queue.add(initialDancer);

        // BFS를 통해 무지개 댄스 전파
        while (!queue.isEmpty()) {
            String current = queue.poll(); // 큐에서 현재 사람을 꺼냄

            // 현재 사람이 만난 모든 이웃들을 확인
            for (String neighbor : danceNetwork.getOrDefault(current, Collections.emptySet())) {
                // 이웃이 아직 무지개 댄스를 추고 있지 않으면
                if (!dancingPeople.contains(neighbor)) {
                    dancingPeople.add(neighbor); // 이웃도 무지개 댄스를 추게 됨
                    queue.add(neighbor); // 이웃을 큐에 추가하여 계속 전파
                }
            }
        }

        // 마지막 기록 이후 무지개 댄스를 추는 사람의 수를 출력
        System.out.println(dancingPeople.size());
    }
}
