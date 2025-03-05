import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CreateVehicle {

    ArrayList<Vehicle> typeOfVehicle = new ArrayList<>
            (Arrays.asList(new Volvo240(), new Saab95(), new ScaniaTruck()));
    VehicleController vc = new VehicleController();

    public void createVolvo() {
        vc.vehicleModel.vehicles.push(new Volvo240());
    }

    public void createSaab() {
        vc.vehicleModel.vehicles.push(new Saab95());
    }

    public void createScaniaTruck() {
        vc.vehicleModel.vehicles.push(new ScaniaTruck());
    }

    public void createRandomVehicle() {
        Random rand = new Random();
        int rand_index = rand.nextInt(3);
        vc.vehicleModel.vehicles.push(typeOfVehicle.get(rand_index));
    }
}