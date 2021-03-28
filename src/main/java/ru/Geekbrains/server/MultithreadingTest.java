package ru.Geekbrains.server;

public class MultithreadingTest {
    private final Object monitor = new Object();
    private static volatile char key = 'A';

    public static void main(String[] args) {
        MultithreadingTest mt = new MultithreadingTest();
        Thread t1 = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    mt.printA();
                }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                mt.printB();
            }
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                mt.printC();
            }
        });
        t3.start();
    }

    private void printA() {
        try {
            synchronized (monitor) {
                while (key != 'A') {
                    monitor.wait();
                }
                System.out.print("A");
                key = 'B';
                monitor.notifyAll();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void printB() {
        try {
            synchronized (monitor) {
                while (key != 'B') {
                    monitor.wait();
                }
                System.out.print("B");
                key = 'C';
                monitor.notifyAll();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void printC() {
        try {
            synchronized (monitor) {
                while (key != 'C') {
                    monitor.wait();
                }
                System.out.print("C");
                key = 'A';
                monitor.notifyAll();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
