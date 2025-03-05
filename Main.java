public class Main {

    public static void main(String[] args) {
        VehicleController vc = new VehicleController();
        // Start a new view and send a reference of self
        vc.vehicleModel.frame = new VehicleView("CarSim 1.0", vc);

        // Start the timer
        vc.vehicleModel.timer.start();
    }
}
