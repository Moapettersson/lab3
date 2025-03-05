import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CreateVehicle {

    private static final ArrayList<Vehicle> typeOfVehicles = new ArrayList<>(
            Arrays.asList(new Volvo240(), new Saab95(), new ScaniaTruck()));

    /* public static Vehicle createRandomVehicle() {
        Random rand = new Random();
        int randIndex = rand.nextInt(typeOfVehicles.size());
        return typeOfVehicles.get(randIndex);
        */
    public static Vehicle createRandomVehicle() {
        Random rand = new Random();
        int randomChoice = rand.nextInt(3);  // 0, 1, eller 2
        switch (randomChoice) {
            case 0:
                return new Volvo240();
            case 1:
                return new Saab95();
            case 2:
                return new ScaniaTruck();
            default:
                return new Volvo240();  // fallback
        }
    }
}

