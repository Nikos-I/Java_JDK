package sem2.hw2;

public class FullStackProgrammer implements BackEndProgramming, FrontEndProgramming {
    //JavaFX vs Swing
    @Override
    public void writeFrontEndCode() {
        System.out.println("Пишет фронтенд");
    }

    @Override
    public void writeBackEndCode() {
        System.out.println("Пишет бэкенд");
    }

}