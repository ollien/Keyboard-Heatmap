import javax.swing.*;
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
        this.add(new HeatMapPanel(data));
        this.pack();
    }
}
