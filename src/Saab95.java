import java.awt.Color;

public class Saab95 extends Car {
    private boolean turboOn;

    public Saab95(int x, int y) {
        super(2, 125, Color.red, "Saab95",x,y);
    }
    public Saab95(){
        this(0,0);
    }
    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    protected double speedFactor() {
        double turboFactor = turboOn ? 1.3 : 1.0;
        return getEnginePower() * 0.01 * turboFactor;
    }
}
