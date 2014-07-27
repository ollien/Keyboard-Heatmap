import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

/**
 * Created by Nick on 7/26/14.
 */
public class HeatMapFrame extends JFrame {
    boolean secondClick = false;
    int lastX;
    int lastY;
    HeatMapFrame(HashMap<Integer,Integer> data){
        //Dear lord this is a hacky way of adding a border around my panel.
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20,20,20,20));
        HeatMapPanel hp = new HeatMapPanel(data);
        panel.add(hp);
        this.add(panel);
        this.pack();
    }
}
