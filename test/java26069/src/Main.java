/*
BFS(너비 우선 탐색)를 사용하여 queue를 통해 무지개 댄스를 추는 사람을 전파하는 방식에서
각 만남 기록을 순차적으로 처리하면서, 한 사람이라도 무지개 댄스를 추고 있으면 만난 다른 사람도 무지개 댄스를 추게 되는 조건문 형식으로 변환
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 만남 기록의 수를 입력 받음
        sc.nextLine(); // 개행 문자 처리

        // 무지개 댄스를 추고 있는 사람들을 저장할 집합 생성
        Set<String> dancingPeople = new HashSet<>();
        dancingPeople.add("ChongChong"); // 초기 무지개 댄스를 추는 사람 설정 (총총이)

        // 만남 기록을 입력 받아서 처리
        for (int i = 0; i < N; i++) {
            String A = sc.next(); // 첫 번째 사람 이름
            String B = sc.next(); // 두 번째 사람 이름
            sc.nextLine(); // 개행 문자 처리

            // A나 B 중 한 명이 무지개 댄스를 추고 있다면, 다른 사람도 무지개 댄스를 추게 함
            if (dancingPeople.contains(A) || dancingPeople.contains(B)) {
                dancingPeople.add(A);
                dancingPeople.add(B);
            }
        }

        // 마지막 기록 이후 무지개 댄스를 추는 사람의 수를 출력
        System.out.println(dancingPeople.size());
    }
}
