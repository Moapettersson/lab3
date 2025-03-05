import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawPanel extends JPanel {

    private final Map<Vehicle, Point> vehiclePositions = new HashMap<>();
    private final Map<Class<? extends Vehicle>, BufferedImage> vehicleImages = new HashMap<>();
    private BufferedImage volvoWorkshopImage;
    private final Point volvoWorkshopPoint = new Point(300, 300);

    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        loadImages();
    }

    private void loadImages() {
        try {
            vehicleImages.put(Volvo240.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            vehicleImages.put(Saab95.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            vehicleImages.put(ScaniaTruck.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addVehicle(Vehicle vehicle, int x, int y) {
        vehiclePositions.put(vehicle, new Point(x, y));

        // Debugging: Skriv ut vilken bil som lades till och dess position
        // System.out.println("Added vehicle: " + vehicle.getClass().getSimpleName() + " at position: " + x + ", " + y);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehiclePositions.remove(vehicle);
    }

    public void moveit(Vehicle vehicle, int x, int y) {
        if (vehiclePositions.containsKey(vehicle)) {
            vehiclePositions.get(vehicle).setLocation(x, y);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Debugging: Skriv ut alla bilar och deras positioner
        // System.out.println("Drawing cars:");
        for (Map.Entry<Vehicle, Point> entry : vehiclePositions.entrySet()) {
            // System.out.println("Vehicle: " + entry.getKey().getClass().getSimpleName() + ", Position: " + entry.getValue());

            BufferedImage img = vehicleImages.get(entry.getKey().getClass());
            if (img != null) {
                g.drawImage(img, entry.getValue().x, entry.getValue().y, null);
            }
        }

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}