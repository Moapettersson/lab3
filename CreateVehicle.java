import java.util.Random;

public class CreateVehicle {

    protected static Vehicle createRandomVehicle() {
        Random rand = new Random();
        int randomChoice = rand.nextInt(3);
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

