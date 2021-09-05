package aananev.example.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);//кол-во потоков разрешенным работать
        Runnable runnable = () -> {
            try {
                System.out.printf("Поток: %s запрашивает доступ к someMethod.\n", Thread.currentThread().getName());
                semaphore.acquire();//уменьшает счутчик на 1
                someMethod();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            semaphore.release(); //увеличивает счетчик на 1
        };

        Thread myThread1 = new Thread(runnable, "Thread1");
        Thread myThread2 = new Thread(runnable, "Thread2");
        Thread myThread3 = new Thread(runnable, "Thread3");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }

    private static void someMethod() {
        try {
            System.out.printf("С someMethod работает поток: %s\n", Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
