package sem5.hw5;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {

    static AtomicInteger table = new AtomicInteger();  // стол: 0 - свободно, 1 - занято
    static Random rand = new Random();

    public static void main(String[] args) {

        System.out.println("Main thread started...");
        for (int i = 1; i < 6; i++) {
            new Philosophers("Philosopher" + i).start();
        }
        System.out.println("Main thread finished...");
    }
}