package dev.pranavtech.week5;
class Greeting implements Runnable {
    private String message;

    public Greeting(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i+": "+message);
            try {
                Thread.sleep(1000); // Sleep for 1000 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Greeting hello = new Greeting("Hello");
        Greeting bula = new Greeting("Bula");

        Thread t1 = new Thread(hello);
        Thread t2 = new Thread(bula);

        t1.start(); // Start the first thread
        t2.start(); // Start the second thread
    }
}
