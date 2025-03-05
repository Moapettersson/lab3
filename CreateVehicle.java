import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CreateVehicle {

    private static final ArrayList<Vehicle> typeOfVehicles = new ArrayList<>(
            Arrays.asList(new Volvo240(), new Saab95(), new ScaniaTruck()));

    public static Vehicle createRandomVehicle() {
        Random rand = new Random();
        int randIndex = rand.nextInt(typeOfVehicles.size());
        return typeOfVehicles.get(randIndex);
    }
}
