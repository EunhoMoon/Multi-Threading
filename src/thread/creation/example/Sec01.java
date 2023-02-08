package thread.creation.example;

/**
 * 스레드 생성 - 스레드의 기능과 디버깅
 */
public class Sec01 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 새 스레드에서 실행할 코드
                System.out.println("스레드 시작 : " + Thread.currentThread().getName());
                System.out.println("현재 스레드의 우선순위 : " + Thread.currentThread().getPriority());
                throw new RuntimeException("에러 메세지");
            }
        });

        thread.setName("New Thread");

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            /** 전체 스레드에 해당되는 예외 핸들러 지정
             * - 스레드 내에서 발생한 예외가 어디에서도 캐치되지 않으면 핸들러 호출
             */
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("예외 발생! " + t.getName() + " : " + e.getLocalizedMessage());
            }
        });

        thread.setPriority(Thread.MAX_PRIORITY);    // 우선순위 지정

        System.out.println("thread : " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start(); // JVM이 새 스레드를 생성해 운영 체제에 전달
        System.out.println("thread : " + Thread.currentThread().getName() + " after starting a new thread");

        Thread.sleep(10000);    // 지정 시간이 지날 때 까지 해당 스레드를 스케쥴링하지 말라고 운영체제에 지시

        /**
         * thread : main before starting a new thread   // main 스레드 실행
         * thread : main after starting a new thread    // 새 스레드가 생성되기 까진 시간이 필요, 따라서 새 스레드가 아닌 main 스레드 실행
         * 스레드 시작 : New Thread                        // 새 스레드 실행
         * 현재 스레드의 우선순위 : 10
         *
         * Process finished with exit code 0
         */
    }

}
