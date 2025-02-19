import java.awt.*;

public class ScaniaTruck extends Vehicle {

    protected CargoTruck CargoTruck;

    public ScaniaTruck(int x, int y){
        super("Scania", 2, 175, 180, Color.blue);
        CargoTruck = new CargoTruck(0, 70);
        stopEngine();
        this.x = x;
        this.y = y;
    }

    protected void raiseTruckBed(int degrees) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException("Truck must be stationary to raise or lower the truckbed");
        } if (degrees < 0 || degrees > 70){
            throw new IllegalArgumentException("Invalid integer. Must be within the limits 0-70");
        } else if (CargoTruck.getAngle() + degrees >= 70) {
            CargoTruck.setAngle(70);
            System.out.println(CargoTruck.getAngle());
        } else {
            CargoTruck.setAngle(degrees);
            System.out.println(CargoTruck.getAngle());
        }
    }

    protected void lowerTruckBed(int degrees) {
        if (getCurrentSpeed() > 0){
            throw new IllegalStateException("Truck must be stationary to raise or lower the truckbed");
        } else if (degrees < 0 || degrees > 70){
            throw new IllegalArgumentException("Invalid integer. Must be within the limits 0-70");
        } else if (CargoTruck.getAngle() + degrees <= 0) {
            CargoTruck.setAngle(0);
            System.out.println(CargoTruck.getAngle());
        } else {
            CargoTruck.setAngle(degrees);
            System.out.println(CargoTruck.getAngle());
        }
    }

    @Override
    public void move() {
        if (CargoTruck.getAngle() == 0) {
        super.move();
        }

    }

    @Override
    protected double speedFactor() {return enginePower * 0.01;}

}