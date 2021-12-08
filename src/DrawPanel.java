import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

import static java.lang.System.out;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    ArrayList<BufferedImage> vehicleImages = new ArrayList<BufferedImage>();
    Map<String, Integer> vehiclesDict = new HashMap<>();
    Point[] vehiclePositions = new Point[3];

    // To keep track of a singel cars position
    //Point volvoPoint = new Point();

    /*
    // TODO: Make this genereal for all cars
    void moveit(int x, int y){
        volvoPoint.x = x;
        volvoPoint.y = y;
    }*/

    void moveit(Vehicle vehicle, int x, int y){
        vehiclePositions[vehiclesDict.get(vehicle.getModelName())] = new Point(x, y);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        vehiclePositions[0] = new Point(0,0);
        vehiclePositions[1] = new Point(0,100);
        vehiclePositions[2] = new Point(0,200);

        vehiclesDict.put("Volvo240", 0);
        vehiclesDict.put("Saab95", 1);
        vehiclesDict.put("Scania", 2);

        // Print an error message in case file is not found with a try/catch block
        try {
            vehicleImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            vehicleImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            vehicleImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        //int i = 0;
        for (BufferedImage vehicleImage: vehicleImages) {
            super.paintComponent(g);
            g.drawImage(vehicleImages.get(0), (int) vehiclePositions[0].getX(), (int) vehiclePositions[0].getY(), null); // see javadoc for more info on the parameters
            g.drawImage(vehicleImages.get(1), (int) vehiclePositions[1].getX(), (int) vehiclePositions[1].getY(), null); // see javadoc for more info on the parameters
            g.drawImage(vehicleImages.get(2), (int) vehiclePositions[2].getX(), (int) vehiclePositions[2].getY(), null); // see javadoc for more info on the parameters
            //i++;
        }
    }
}
