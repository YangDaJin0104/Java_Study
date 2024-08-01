/*
- 클래스의 정의 : 객체를 정의해 놓은 것
- 클래스의 용도 : 객체를 생성하는데 사용
- 인스턴스 : 클래스로부터 객체를 만드는 과정을 클래스의 인스턴스화 라고 한다. 인스턴스는 참조변수를 통해서만 다룰 수 있으며, 참조변수 타입은 인스턴스의 타입과 일치해야한다.
*//*

class Main {
    public static void main(String[] args) {
        // TV인스턴스를 참조하기 위한 변수 t 선언, 메모리에 참조변수 t를 위한 공간이 마련
        Tv t;
        // TV인스턴스 생성, 연산자 new에 의해 Tv클래스의 인스턴스가 메모리의 빈 공간에 생성.
        // 그 다음에는 대입연산자에 의해서 생성된 객체의 주소값이 참조변수 t에 저장.
        // 이제는 참조변수 t를 통해 Tv인스턴스에 접근할 수 있다. 인스턴스를 다루기 위해서는 참조변수가 반드시 필요
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
}*/
/*
- 인스턴스 변수 : 클래스 영역에 선언되며, 인스턴스를 생성할 때 만들어진다. 인스턴스마다 별도의 저장공간을 가지므로 서로 다른 값을 가질 수 있다.
    인스턴스마다 고유한 상태를 유지해야하는 속성의 경우, 인스턴스 변수로 선언한다.
- 클래스 변수 : 인스턴스 변수 앞에 static을 붙이면 클래스 변수가 된다. 클래스 변수는 모든 인스턴스가 공통된 저장공간(변수)를 공유하게 된다.
    한 클래스의 모든 인스턴스들이 공통적인 값을 유지해야하는 속성의 경우, 클래스 변수로 선언해야한다.
*/
/*
class Main {
    public static void main(String[] args) {
        // 클래스 변수(static 변수)는 객체 생성 없이 '클래스이름.클래스변수'로 직접 사용 가능
        System.out.println("Card.width = " + Card.width);
        System.out.println("Card.height = " + Card.height);

        Card c1 = new Card();
        c1.kind = "Heart";
        c1.num = 8;

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.num = 10;

        System.out.println("c1" + c1.kind + "," + c1.num + "이며, 크기는 (" + c1.width + "," + c1.height + ")");
        System.out.println("c2" + c2.kind + "," + c2.num + "이며, 크기는 (" + c2.width + "," + c2.height + ")");
        System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다");
        // 클래스 변수 값을 변경
        c1.width = 50;
        c1.height = 80;

        // Card인스턴스인 c1과c2는 클래스 변수인 width와 height를 공유하기 때문에, c1의 width와 height를 변경하면 c2의 width와 heigth값도 변경된다.
        System.out.println("c1" + c1.kind + "," + c1.num + "이며, 크기는 (" + c1.width + "," + c1.height + ")");
        System.out.println("c2" + c2.kind + "," + c2.num + "이며, 크기는 (" + c2.width + "," + c2.height + ")");
    }
}

class Card {
    String kind;
    int num;
    static int width = 100;
    static int height = 200;
}*/
/*
- 메서드 : 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것
*/
class Main {
    public static void main(String[] args) {
        Math  mt = new Math(); // 인스턴스 생성
        long result1 = mt.add(5L, 3L); // 메서드 호출
        long result2 = mt.sub(5L, 3L);
        long result3 = mt.multiply(5L, 3L);
        double result4 = mt.div(5L, 3L);

        System.out.println("add : " + result1);
        System.out.println("subtract : " + result2);
        System.out.println("multiply : " + result3);
        System.out.println("divide : " + result4);

    }
}

class Math{
    long add(long a, long b) {
        long result = a + b;
        return result; // retrun a+b;
    }

    long sub(long a, long b) {
        return a - b;
    }

    long multiply(long a, long b) {
        return a * b;
    }

    double div(double a, double b) {
        return a / b;
    }
}