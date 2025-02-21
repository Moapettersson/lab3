import java.awt.*;


public class Saab95 extends Vehicle {

    private boolean turboOn;

    
    public Saab95(){
        super("Saab95", 2, 125, 180, Color.red);
	    turboOn = false;
        stopEngine();
        this.x = x;
        this.y = y;
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }


    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
