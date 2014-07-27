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
        HeatMapPanel hp = new HeatMapPanel(data);
        this.add(hp);
        this.pack();
    }
}
