public class Main {

    public static void main(String[] args) {
        VehicleController vc = new VehicleController();
        vc.vehicleModel.frame = new VehicleView("CarSim 1.0", vc);
        vc.vehicleModel.timer.start();
    }
}
