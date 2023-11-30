package sem6.hw6;

public class GameSteps {
    int step;
    int door;
    int result;

    public GameSteps(int step, int door, int result) {
        this.step=step;
        this.door=door;
        this.result=result;

    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step=step;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door=door;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result=result;
    }
}
