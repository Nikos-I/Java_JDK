package sem2.hw2;

public class Main {
    public static void main(String[] args) {
        FullStackProgrammer programmer = new FullStackProgrammer();
        programmer.writeBackEndCode();
        programmer.writeFrontEndCode();
        FrontEndDeveloper frontEndDeveloper = new FrontEndDeveloper();
        frontEndDeveloper.drinkCoffee();
        frontEndDeveloper.smoke();
        frontEndDeveloper.developGUI();
        frontEndDeveloper.writeFrontEndCode();
    }
}
