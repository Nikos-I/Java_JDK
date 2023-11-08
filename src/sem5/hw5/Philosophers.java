package sem5.hw5;

import static sem5.hw5.Program.rand;
import static sem5.hw5.Program.table;

class Philosophers extends Thread {

    boolean predState;          // перед этим: true = обедал, false - думал

    Philosophers(String name) {
        super(name);
    }

    public void run() {

        int count = 0;
        predState = false;
        try {
            while (count < 3) {
                if (!predState) {
                    System.out.printf("Философ %s думает\n", this.getName());
                }
                if (table.get() == 0) {
                    table.set(1);
                    predState = true;
                    System.out.printf("Философ %s ------------- обедает\n", this.getName());
                    Thread.sleep(500);
                    count++;
                    predState = false;
                    table.set(0);
                    Thread.sleep(rand.nextInt(1000));
                } else {
                    predState = true;
                }
            }
        } catch (InterruptedException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }
}

