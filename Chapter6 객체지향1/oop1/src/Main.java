/*
- 클래스의 정의 : 객체를 정의해 놓은 것
- 클래스의 용도 : 객체를 생성하는데 사용
- 인스턴스 : 클래스로부터 객체를 만드는 과정을 클래스의 인스턴스화 라고 한다.

*/
class Main {
    public static void main(String[] args) {
        // TV인스턴스를 참조하기 위한 변수 t 선언
        Tv t;
        // TV인스턴스 생성
        t = new Tv();
        // Tv인스턴스의 멤버변수 channel의 값을 7로 한다.
        t.channel = 7;
        // Tv인스턴스의 메서드 channelDown()을 호출
        t.channelDown();
        System.out.println(t.channel);
    }
}

class Tv {
    // Tv의 속성(멤버 변수)
    String color;
    boolean power;
    int channel;

    // Tv의 기능(메서드)
    void power() {power = !power;}
    void channelUp() {++channel;}
    void channelDown() {--channel;}
}