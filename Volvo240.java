import java.awt.*;

public class Volvo240 extends Vehicle {

    public final static double trimFactor = 1.25;
    
    public Volvo240(){
        super("Volvo240", 4, 100, 180, Color.black);
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
