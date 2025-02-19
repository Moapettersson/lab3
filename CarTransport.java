import java.awt.*;
import java.util.Stack;

public class CarTransport extends Vehicle {

    protected CargoTruck CargoTruck;
    private int loadCapacity;
    protected Stack<Vehicle> cargo = new Stack<>();



    public CarTransport(int loadCapacity) {
        super ("Biltransport", 2, 175,180, Color.red);
        CargoTruck = new CargoTruck(0,1);
        this.loadCapacity = loadCapacity;
    }


    protected void raiseTruckBed(){
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException
                    ("Truck must be stationary to raise or lower the truckbed");
        } else if (CargoTruck.getAngle() == CargoTruck.getMin()){
            CargoTruck.setAngle(CargoTruck.getMax());
        } else {
            throw new IllegalStateException
                    ("Truckbed is already raised");
        }
    }

    protected void lowerTruckBed() {
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException
                    ("Truck must be stationary to raise or lower the truckbed");
        } else if (CargoTruck.getAngle() == CargoTruck.getMax()) {
            CargoTruck.setAngle(CargoTruck.getMin());
        } else {
            throw new IllegalStateException
                    ("Truckbed is already lowered");
        }
    }

    protected void loadCar(Vehicle car) {
        if (getCurrentSpeed() > 0 || CargoTruck.getAngle() != 0) {
            throw new IllegalStateException(
                    "Truck must be both stationary and with the truckbed lowered to load cars.");
        } else if (Math.abs(getX() - car.getX()) >= 10 && Math.abs(getY() - car.getY()) >= 10) {
            throw new IllegalStateException(
                    "Car must be within 10 meters of the truck to be loaded.");
        } else if (car instanceof CarTransport) {
            throw new IllegalArgumentException(
                    "Cannot load vehicle transports");
        } else {
            if (cargo.size() < this.loadCapacity) {
                cargo.push(car);
            }
        }
    }

    protected void unLoadCar() {
        if (getCurrentSpeed() > 0 && CargoTruck.getAngle() != 0) {
            throw new IllegalStateException(
                    "Truck must be both stationary and with the truckbed lowered to load cars.");
        } else {
            cargo.pop().addPosition(5, 5);

        }
    }

    @Override
    public void move() {
        if (CargoTruck.getAngle() == 0) {
            super.move();
            for (int i=0; i<cargo.size(); i++) {
                cargo.get(i).setPosition(getX(), getY());
            }
        }

    }

    @Override
    protected double speedFactor() { return enginePower * 0.01;}
}