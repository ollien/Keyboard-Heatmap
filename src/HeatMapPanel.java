import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nick on 7/26/14.
 */
public class HeatMapPanel extends JPanel {
    BufferedImage image;

    HeatMapPanel(){
        try {
            image = ImageIO.read(new File("keyboard.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(image,0,0,null);
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(747,213);
    }
}
