import java.awt.Color;

public class Volvo240 extends Car {
    private static final double TRIM_FACTOR = 1.25;

    public Volvo240(int x, int y) {
        super(4, 100, Color.black, "Volvo240",x,y);
    }
    public Volvo240(){
        this(0,0);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * TRIM_FACTOR;
    }
}
