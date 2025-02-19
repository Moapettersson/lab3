import java.awt.*;

public class Volvo240 extends Vehicle {

    public final static double trimFactor = 1.25;
    
    public Volvo240(int x, int y){
        super("Volvo240", 4, 100, "North", Color.black);
        stopEngine();
        this.x = x;
        this.y = y;
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
