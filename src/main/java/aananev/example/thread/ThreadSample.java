package aananev.example.thread;

public class ThreadSample {
    public static void main(String[] args) {
        System.out.println("Поток main начал работать");

        Runnable runnable = () -> {

            System.out.printf("Я буду работать в потоке %s 1 секунду\n",
                    Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }

            System.out.printf("Поток закончил %s работу\n",
                    Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable, "ThreadWithRunnable");
        thread.start();

        System.out.println("Поток main закончил работать");
    }
}
