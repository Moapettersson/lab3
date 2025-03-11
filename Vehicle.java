import java.awt.*;

public abstract class Vehicle implements movable {

    protected int nrDoors;
    protected double enginePower;
    private double currentSpeed;
    private Color color;
    protected String modelName;


    protected double x;
    protected double y;
    protected int direction;

    public Vehicle(String modelName, int nrDoors, int enginePower, int direction, Color color) {
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.direction = direction;
        this.color = color;
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

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    private void setDirection(int dir) {
        direction = dir;
    }

    public int getDirection() {
        return direction;
    }

    abstract protected double speedFactor();

    public double getX() { return x; }

    public double getY() { return y; }

    public void setPosition(double xChange, double yChange) {
        x = xChange;
        y = yChange;
    }

    public void addPosition(double xChange, double yChange) {
        x += xChange;
        y += yChange;
    }

    public void move() {
        switch (direction) {
            case 180:
                y += currentSpeed;
                break;
            case 270:
                x += currentSpeed;
                break;
            case 0:
                y -= currentSpeed;
                break;
            case 90:
                x -= currentSpeed;
                break;
        }

    }

    public void turnLeft() {
        if (direction == 270) {
            setDirection(0);
        } else {
            direction += 90;
        }
    }

    public void turnRight() {
        if (direction == 0) {
            setDirection(270);
        } else {
            direction -= 90;
        }
    }

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException();
        }
    }
}