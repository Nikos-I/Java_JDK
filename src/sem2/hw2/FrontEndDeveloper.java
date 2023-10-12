package sem2.hw2;

public class FrontEndDeveloper extends Developer{

    @Override
    void drinkCoffee() {
        System.out.println("ein Prosit!");
    }

    @Override
    void smoke() {
        System.out.println("Пых-пых!");
    }

    @Override
    void developGUI() {
        System.out.println("Разрабатываем морду проги!");
    }

    @Override
    public void writeFrontEndCode() {
        System.out.println("Кодим!");
    }
}
