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

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (!secondClick) {
                    lastX = mouseEvent.getX();
                    lastY = mouseEvent.getY() - 20;
                    System.out.println(lastX+","+lastY);
                    secondClick=true;
                }
                else{
                    System.out.println(mouseEvent.getX() - lastX +","+ (mouseEvent.getY() - lastY - 20));
                    secondClick = false;
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
    }
}
