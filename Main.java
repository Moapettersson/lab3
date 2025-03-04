public class Main {


    public static void main(String[] args) {
        VehicleController vc = new VehicleController();
        vc.vehicleManager.vehicles.add(new Volvo240());
        vc.vehicleManager.vehicles.get(0).setPosition(0,0);
        vc.vehicleManager.vehicles.add(new Saab95());
        vc.vehicleManager.vehicles.get(1).setPosition(0,100);
        vc.vehicleManager.vehicles.add(new ScaniaTruck());
        vc.vehicleManager.vehicles.get(2).setPosition(0,200);

        // Start a new view and send a reference of self
        vc.vehicleManager.frame = new VehicleView("CarSim 1.0", vc);

        // Start the timer
        vc.vehicleManager.timer.start();
    }

}
