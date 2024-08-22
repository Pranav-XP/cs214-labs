package dev.pranavtech.week5;

class Producer implements Runnable {
    private final Object lock;

    public Producer(Object homework) {
        this.lock = homework;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("Student is solving...");
            try {
                // Simulate work with sleep
                Thread.sleep(2000); // 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Student is done. Notifying teacher...");
            lock.notify(); // Notify the consumer that work is done
        }
    }
}

class Consumer implements Runnable {
    private final Object lock;

    public Consumer(Object homework) {
        this.lock = homework;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("Teacher has given homework to student...");
            try {
                lock.wait(); // Wait for the producer to notify
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Teacher has recieved homework. Marking...");
        }
    }
}

public class ThreadMedium {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object(); // Shared lock object

        Thread producerThread = new Thread(new Producer(lock));
        Thread consumerThread = new Thread(new Consumer(lock));

        consumerThread.start(); // Start the consumer first
        Thread.sleep(100); // Ensure consumer starts waiting before producer starts
        producerThread.start(); // Start the producer

        producerThread.join(); // Wait for producer to finish
        consumerThread.join(); // Wait for consumer to finish
    }
}
