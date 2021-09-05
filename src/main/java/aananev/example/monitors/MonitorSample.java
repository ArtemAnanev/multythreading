package aananev.example.monitors;

public class MonitorSample {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.printf("Поток %s начал работу\n", Thread.currentThread().getName());
            System.out.print("Обращаюсь к synchronizedMethod()\n");
            synchronizedMethod();
            System.out.printf("Поток %s закончил работу\n", Thread.currentThread().getName());
        };

        Thread myThread1 = new Thread(runnable, "Thread1");
        Thread myThread2 = new Thread(runnable, "Thread2");
        myThread1.start();
        myThread2.start();
    }

    private synchronized static void synchronizedMethod() {
        try {
            System.out.printf("С synchronizedMethod работает поток: %s\n", Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.printf("С synchronizedMethod работает поток: %s\n", Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
