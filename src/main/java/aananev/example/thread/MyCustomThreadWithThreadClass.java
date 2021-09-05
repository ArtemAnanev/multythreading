package aananev.example.thread;

public class MyCustomThreadWithThreadClass extends Thread{

    MyCustomThreadWithThreadClass(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.printf("Я буду работать в потоке %s 1 секунду\n",Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }

        System.out.printf("Поток %s закончил работу \n", Thread.currentThread().getName());
    }
}
