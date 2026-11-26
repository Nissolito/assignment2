import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    // Just a single image, TODO: Generalize
    private final ArrayList<BufferedImage> carImages = new ArrayList<>();
    // To keep track of a single car's position
    private final ArrayList<Point> carPoints = new ArrayList<>();
    // TODO: Make this general for all cars
    void moveit(int index, int x, int y) {
        carPoints.get(index).x = x;
        carPoints.get(index).y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel( int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block

    }
    void addCar(String modelName) {
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));
            carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+modelName+".jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        carPoints.add(new Point());
    }
    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < carImages.size(); i++) {
            Point p = carPoints.get(i);
            g.drawImage(carImages.get(i), p.x, p.y, null); // see javadoc for more info on the parameters
        }

    }
}
