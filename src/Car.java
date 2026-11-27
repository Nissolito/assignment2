import java.awt.Color;

public abstract class Car implements Movable {
    private final int nrDoors;
    private final double enginePower;
    private double currentSpeed;
    private Color color;
    private final String modelName;

    private double x;
    private double y;
    private int direction;

    public Car(int nrDoors, double enginePower, Color color, String modelName,int x,int y) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getModelName() {
        return modelName;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    protected abstract double speedFactor();

     protected void incrementSpeed(double amount) {
        currentSpeed += (amount > 0 && amount <=1) ? speedFactor() * amount : 0;
        if (currentSpeed > enginePower) {
            currentSpeed = enginePower;
        }
    }

    protected void decrementSpeed(double amount) {
        currentSpeed -= (amount > 0 && amount <=1) ? speedFactor() * amount : 0;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    public void gas(double amount) {
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        decrementSpeed(amount);
    }

    public void hitBorder(int panelWidth, int panelHeight) {
        if ((x < 0 && direction == 180) || (x > panelWidth - 115 && direction == 0) || (y < 0 && direction == 270) || (y > panelHeight - 55 && direction == 90)){
            stopEngine();
            turnLeft();
            turnLeft();
            startEngine();
        }
    }
    @Override 
    public void move(){
        switch (direction) {
            case 0 -> x += currentSpeed;
            case 90 -> y += currentSpeed;
            case 180 -> x -= currentSpeed;
            case 270 -> y -= currentSpeed;
            default -> {
                x += Math.cos(Math.toRadians(direction)) * currentSpeed;
                y += Math.sin(Math.toRadians(direction)) * currentSpeed;
            }}}

    @Override 
    public void turnRight(){
        direction += 90;
        if (direction >= 360) {
            direction -= 360;
        }
    } 
    
    @Override
    public void turnLeft(){
        direction -= 90;
        if (direction < 0) {
            direction += 360;
        }
    }
    
}
