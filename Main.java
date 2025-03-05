public class Main {

    //Generalisera och kalla denna typ "addCars"?

    public static void main(String[] args) {
        VehicleController vc = new VehicleController();
        // Start a new view and send a reference of self
        vc.vehicleManager.frame = new VehicleView("CarSim 1.0", vc);

        Vehicle[] cars = {
                new Volvo240(), new Saab95(), new ScaniaTruck(), new Volvo240(), new Saab95(), new ScaniaTruck(), new Volvo240()
        };

        int yPos = 0;
        for (Vehicle car : cars) {
            car.setPosition(0, yPos);
            vc.vehicleManager.vehicles.add(car);
            vc.vehicleManager.frame.drawPanel.addVehicle(car, 0, yPos);
            yPos += 100;
        }

        // Start the timer
        vc.vehicleManager.timer.start();
    }

}
