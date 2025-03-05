import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CreateVehicle {

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

