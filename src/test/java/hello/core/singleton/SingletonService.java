package hello.core.singleton;

public class SingletonService {
    //JVM이 뜰때 static이 붙어있으면 해당 코드를 내부적으로 실행
    //static 영역에 존재, 클래스 소속이기에 인스턴스들이 공유
    private static final SingletonService instance = new SingletonService();

    //외부에서 생성하지 못하도록 private 생성자
    private SingletonService() {
    }

    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체의 로직을 호출");
    }
}
