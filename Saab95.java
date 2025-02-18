import java.awt.*;


public class Saab95 extends Vehicle {

    private boolean turboOn;

    
    public Saab95(){
        super("Saab95", 2, 125, "North", Color.red);
	    turboOn = false;
        stopEngine();
    }

    private void setTurboOn(){
        turboOn = true;
    }

    private void setTurboOff(){
	    turboOn = false;
    }

    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
