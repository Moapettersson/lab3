public class CargoTruck {

    private int min;
    private int max;
    private int TruckBedAngle = 0;

    public CargoTruck(int min, int max) {
        this.min = min;
        this.max = max;
    }
    public int getAngle() {return TruckBedAngle;}

    public int getMax() {return this.max;}

    public int getMin() {return this.min;}

    public void setAngle(int angle) {
        if(angle >= this.min && angle <= this.max){
            TruckBedAngle = angle;
        }
    }
}
