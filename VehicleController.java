/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

import java.util.Random;

public class VehicleController {
    // member fields:
    protected VehicleModel vehicleModel;

    Random rand = new Random();
    int randx = rand.nextInt(1400);
    int randy = rand.nextInt(650);


    public VehicleController() {
        this.vehicleModel = new VehicleModel();
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicleModel.vehicles
        ) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicleModel.vehicles
        ) {
            vehicle.brake(brake);
        }
    }
    void stop() {
        for (Vehicle vehicle : vehicleModel.vehicles
        ) {
            vehicle.stopEngine();
        }
    }

    void start() {
        for (Vehicle vehicle : vehicleModel.vehicles
        ) {
            vehicle.startEngine();
        }
    }

    void turnLeft() {
        for (Vehicle vehicle : vehicleModel.vehicles
        ) {
            vehicle.turnLeft();
        }
    }

    void turnRight() {
        for (Vehicle vehicle : vehicleModel.vehicles
        ) {
            vehicle.turnRight();
        }
    }
    void turnOnTurbo(){
        for (Vehicle vehicle : vehicleModel.vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }
    void turnOffTurbo(){
        for (Vehicle vehicle : vehicleModel.vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void liftBed(int amount) {
        for (Vehicle vehicle : vehicleModel.vehicles) {
            if (vehicle instanceof ScaniaTruck) {
                ((ScaniaTruck) vehicle).raiseTruckBed(amount);
            }
        }
    }


    void lowerBed(int amount) {
        for (Vehicle vehicle : vehicleModel.vehicles) {
            if (vehicle instanceof ScaniaTruck) {
                ((ScaniaTruck) vehicle).lowerTruckBed(amount);
            }
        }
    }

    void createVehicle() {
        if (vehicleModel.vehicles.size() <= 9) {
            Vehicle newVehicle = CreateVehicle.createRandomVehicle();
            vehicleModel.vehicles.push(newVehicle);
            vehicleModel.frame.drawPanel.addVehicle(vehicleModel.vehicles.peek(), randx, randy);
        }
    }

    void removeVehicle() {
        if (!vehicleModel.vehicles.isEmpty()){
            vehicleModel.vehicles.pop();
        }
    }


}



