package thread.creation.example;

/**
 * 스레드 생성 - 스레드 상속
 */
public class Sec02 {

    public static void main(String[] args) {
        Thread thread = new NewThread();

        thread.start();
    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("새로운 쓰레드 : " + this.getName());
            // static Thread 객체가 아닌 상속을 통해 직접적으로 연관된 메서드를 사용할 수 있다.
        }
    }

}