package aananev.example.thread;

public class MyCustomThreadWithRunnable implements Runnable{
    @Override
    public void run() {
        System.out.printf("Я буду работать в потоке %s 1 секунду\n",
                Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }

        System.out.printf("Поток закончил %s работу\n",
                Thread.currentThread().getName());
    }
}
