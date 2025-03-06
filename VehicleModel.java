import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

public class VehicleModel {
    VehicleView frame;
    public Stack<Vehicle> vehicles = new Stack<>();
    ArrayList<Vehicle> toRemove = new ArrayList<>();
    private final int delay = 50;
    CarWorkshop<Volvo240> cwsVolvo = new CarWorkshop<>(6);
    protected Timer timer = new Timer(delay, new TimerListener());

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());

                if (x < 0 || x > 1400 || y < 0 || y > 650) {
                    //vehicle.stopEngine();
                    vehicle.turnLeft();
                    vehicle.turnLeft();
                    //vehicle.startEngine();
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
}
