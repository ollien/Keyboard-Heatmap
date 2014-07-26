import javax.swing.*;
import java.util.HashMap;

/**
 * Created by Nick on 7/26/14.
 */
public class HeatMapFrame extends JFrame {
    HeatMapFrame(HashMap<Integer,Integer> data){
        this.add(new HeatMapPanel());
    }
}
