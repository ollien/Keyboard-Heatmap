
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Nick on 7/26/14.
 */
public class HeatMapPanel extends JPanel {
    HashMap<Integer,Integer> data;
    HeatMapPanel(HashMap<Integer,Integer> data){
        this.data = data;
    }
    //This function will take all the totals, and calculate them out of 255, which will be the Red value in the color code for the heatmap. The RGB values will be R,0,0
    private HashMap<Integer,Integer> calculatePercentages(){
        HashMap<Integer,Integer> tempData = new HashMap<Integer, Integer>();
        int maxValue = getLargestKey();
        for (int keyCode : data.keySet()){
//            Calculate the proportion
//            keyCode     x
//            -------- = ---
//            maxValue   255
//            Which solves to keyCode*255 = maxValue*x
//            Which isolated is equal to (keyCode*255)/maxValue
            int value = keyCode*255/maxValue;
            tempData.put(keyCode,value);
        }
        return tempData;
    }
    //Returns the percentage for the key with the largest value
    private int getLargestKey(){
        int max = 0;
        for (int value : data.values()){
            if (value>max)
                max = value;
        }
        return max;
    }
    @Override
    public void paint(Graphics g){
        data = calculatePercentages();

        //Escape key
//        g.setColor(new Color())
        g.fillRect(0, 0, 30, 30);

        //Leave a 30 pixel space for the space between the escape key and the f row
        //F row and print screen and scrlk and pause/break
        for (int i=0; i<15; i++){
            
        }

    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(900,256);
    }
}
