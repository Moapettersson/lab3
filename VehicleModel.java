import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class VehicleModel {
    VehicleView frame;
    protected Stack<Vehicle> vehicles = new Stack<>();
    ArrayList<Vehicle> toRemove = new ArrayList<>();
    private final int delay = 50;
    CarWorkshop<Volvo240> cwsVolvo = new CarWorkshop<>(6);
    protected Timer timer = new Timer(delay, new TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());

                if (x < 0 || x > 1400 || y < 0 || y > 650) {
                    vehicle.turnLeft();
                    vehicle.turnLeft();
                }

                if (Math.abs(vehicle.getX() - 300) < 15 && Math.abs(vehicle.getY() - 300) < 15) {
                    if (vehicle instanceof Volvo240 volvo240) {
                        cwsVolvo.turnInCar(volvo240);
                        frame.drawPanel.removeVehicle(vehicle);
                        toRemove.add(vehicle);

                    }

                }

                frame.drawPanel.moveit(vehicle, x, y);

                frame.drawPanel.repaint();
            }
            vehicles.removeAll(toRemove);
            toRemove.clear();
        }
    }

    void gasLogic(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.gas(gas);
        }
    }

    void brakeLogic(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.brake(brake);
        }
    }

    void stopLogic() {
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.stopEngine();
        }
    }

    void startLogic() {
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.startEngine();
        }
    }

    void turnLeftLogic() {
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.turnLeft();
        }
    }

    void turnRightLogic() {
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.turnRight();
        }
    }

    void turboOnLogic() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void turboOffLogic() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void liftBedLogic(int amount) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof ScaniaTruck) {
                ((ScaniaTruck) vehicle).raiseTruckBed(amount);
            }
        }
    }

    void lowerBedLogic(int amount) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof ScaniaTruck) {
                ((ScaniaTruck) vehicle).lowerTruckBed(amount);
            }
        }
    }

    void createVehicleLogic() {
        if (vehicles.size() <= 9) {
            Vehicle newVehicle = CreateVehicle.createRandomVehicle();
            vehicles.push(newVehicle);

            int randx = new Random().nextInt(1000);
            int randy = new Random().nextInt(400);

            newVehicle.setPosition(randx, randy);
            frame.drawPanel.addVehicle(vehicles.peek(), randx, randy);
        }
    }

    void removeVehicleLogic() {
        if (!vehicles.isEmpty()) {
            Vehicle vehicleToRemove = vehicles.pop();
            frame.drawPanel.removeVehicle(vehicleToRemove);
        }
    }
}

