package lecture2.sample2;

public class Main {

    public static void main(String[] args) {
        Bull minos0 = new Minotaurus();
        Human minos1 = new Minotaurus();
        Minotaurus mines = new Minotaurus();
        Human man1 = new Man();
        Bull ox2 = new Ox();
        Bull[] allBulls = {ox2, minos0, mines};
        Human[] allHumans = {man1, mines, minos1};
    }

    private static class Minotaurus implements Human, Bull {
        @Override
        public void walk() {
            System.out.println("Walks on two legs");
        }

        @Override
        public void talk() {
            System.out.println("Asks you a riddle");
        }
    }
}
