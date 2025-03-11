public class VehicleController {

    protected VehicleModel vehicleModel;

    protected VehicleController() {
        this.vehicleModel = new VehicleModel();
    }

    void gas(int amount) {
        vehicleModel.gasLogic(amount);
    }

    void brake(int amount) {
        vehicleModel.brakeLogic(amount);
    }

    void stop() {
        vehicleModel.stopLogic();
    }

    void start() {
        vehicleModel.startLogic();
    }

    void turnLeft() {
        vehicleModel.turnLeftLogic();
    }

    void turnRight() {
        vehicleModel.turnRightLogic();
    }

    void turnOnTurbo(){
        vehicleModel.turboOnLogic();
    }

    void turnOffTurbo(){
        vehicleModel.turboOffLogic();
    }

    void liftBed(int amount) {
        vehicleModel.liftBedLogic(amount);
    }

    void lowerBed(int amount) {
        vehicleModel.lowerBedLogic(amount);
    }

    void createVehicle() {
        vehicleModel.createVehicleLogic();
    }

    void removeVehicle() {
        vehicleModel.removeVehicleLogic();
    }
}



