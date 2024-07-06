import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int score = 0; // 점수 저장 변수
        char grade = ' '; // 학점 저장 변수

        System.out.println("점수를 입력하시오 : ");
        Scanner scanner = new Scanner(System.in);
        score = scanner.nextInt();

        if (score >= 90) { // score가 90보다 크거나 같으면 A
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else {
            grade = 'D';
        }

        System.out.println("학색의 학점은 " + grade + "입니다.");
    }
}