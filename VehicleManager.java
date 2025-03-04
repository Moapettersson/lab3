import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehicleManager {
    // The frame that represents this instance View of the MVC pattern
    VehicleView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Vehicle> toRemove = new ArrayList<>();
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    CarWorkshop<Volvo240> cwsVolvo = new CarWorkshop<Volvo240>(6);
    protected Timer timer = new Timer(delay, new TimerListener());
    // The delay (ms) corresponds to 20 updates a sec (hz)
    //methods:


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
                        toRemove.add(vehicle);
                    }
                }

                frame.drawPanel.moveit(vehicle, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
            vehicles.removeAll(toRemove);
            toRemove.clear();
        }
    }
}
