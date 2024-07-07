import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 2차원 배열로 단어와 그 뜻을 저장
        String words[][] = {
                {"chair", "의자"},
                {"book", "책"},
                {"apple", "사과"}
        };

        Scanner scanner = new Scanner(System.in);

        // 사용자에게 단어의 뜻을 묻는 퀴즈
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%d. %s의 뜻은? ", i+1, words[i][0]);

            // 사용자로부터 입력을 받음
            String temp = scanner.nextLine();

            // 정답 확인
            if (temp.equals(words[i][1])) {
                System.out.printf("정답입니다.%n%n");
            } else {
                System.out.printf("틀렸습니다. 정답은 %s입니다. %n%n", words[i][1]);
            }
        }
    }
}
