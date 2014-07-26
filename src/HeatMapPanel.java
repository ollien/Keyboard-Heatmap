
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
        //Debug data
        data.put(KeyEvent.VK_F1,50);
        data.put(KeyEvent.VK_F2,100);
        data.put(KeyEvent.VK_F3,300);
    }
    //This function will take all the totals, and calculate them out of 255, which will be the Red value in the color code for the heatmap. The RGB values will be R,0,0
    private HashMap<Integer,Integer> calculatePercentages(){
        HashMap<Integer,Integer> tempData = new HashMap<Integer, Integer>();
        int maxValue = getLargestKey();
        System.out.println(maxValue);
        for (int keyCode : data.keySet()){
            int keyValue = data.get(keyCode);
//            Calculate the proportion
//            keyValue     x
//            -------- = ---
//            maxValue   255
//            Which solves to keyCode*255 = maxValue*x
//            Which isolated is equal to (keyCode*255)/maxValue
            int value = keyValue*255/maxValue;
            System.out.println(value);
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
        int colorCode;
        data = calculatePercentages();
        //Escape key
        colorCode = getColorCode(KeyEvent.VK_ESCAPE);
        System.out.println(colorCode);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(0, 0, 30, 30);

        //Leave a 35 pixel space for the space between the escape key and the f row
        //F row and print screen
        for (int i=0; i<12; i++){
            colorCode = getColorCode(KeyEvent.VK_F1+i);
            g.setColor(new Color(colorCode,0,0));
            //i+2 so the x value will never be 0, and we actually skip a space. A bit hacky, but it works.
            g.fillRect((i+2)*35, 0, 30,30);
        }
        //This is for the `/~ key, why the fuck java calls it VK_BACK_QUOTE is beyond me...
        colorCode = getColorCode(KeyEvent.VK_BACK_QUOTE);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(0,35,30,30);
        //Now for the numbers 1-9 0 has to be separate since it has a keyCode value below any of the numbers and it has to be special.


    }
    private int getColorCode(int keyCode){
        if (data.containsKey(keyCode))
            return data.get(keyCode);
        else
            return 0;
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(900,256);
    }
}
