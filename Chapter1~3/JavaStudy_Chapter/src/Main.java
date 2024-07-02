public class Main {
    public static void main(String[] args) {
        int i = 10;
        float f = 3.14f;
        double d = 1.23456789;
        char c = 'A';
        String s = "ABC";

        System.out.printf("i = %d%n", i); // %n = 줄바꿈
        System.out.printf("f = %f%n", f);
        System.out.printf("d = %f%n", d); // 마지막 자리 반올림됨
        System.out.printf("c = %c%n", c);
        System.out.printf("s = %s%n", s);
    }
}