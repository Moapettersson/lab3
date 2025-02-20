import java.util.List;
import java.util.ArrayList;

public class CarWorkshop <T extends Vehicle>{
    private int capacity;
    private int nrCars = 0;
    private List<T> vehicles = new ArrayList<>();

    public CarWorkshop(int capacity) {
        this.capacity = capacity;
    }

    public void turnInCar(T vehicle) {
        if (nrCars < this.capacity) {
            vehicles.add(vehicle);
            nrCars += 1;
        } else {
            throw new IllegalArgumentException("The workshop is at full capacity.");
        }
    }

    public T removeVehicle (int index) {
        T removedVehicle = null;
        if (index >= 0 && index < vehicles.size()){
            removedVehicle = vehicles.get(index);
            vehicles.remove(index);
            nrCars -= 1;
            return removedVehicle;
        }
        else{ throw new IllegalArgumentException("Wrong index");
        }
    }

    public int getNrCars() {
        return nrCars;
    }
}