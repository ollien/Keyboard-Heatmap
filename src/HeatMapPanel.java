
import javax.swing.*;
import java.awt.*;
import org.jnativehook.keyboard.NativeKeyEvent;
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
//        data.put(NativeKeyEvent.VK_F1,50);
//        data.put(NativeKeyEvent.VK_F2,100);
//        data.put(NativeKeyEvent.VK_F3,300);
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
        colorCode = getColorCode(NativeKeyEvent.VK_ESCAPE);
        System.out.println(colorCode);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(0, 0, 30, 30);

        //Leave a 35 pixel space for the space between the escape key and the f row
        //F row and print screen
        for (int i=0; i<12; i++){
            colorCode = getColorCode(NativeKeyEvent.VK_F1+i);
            g.setColor(new Color(colorCode,0,0));
            //i+2 so the x value will never be 0, and we actually skip a space. A bit hacky, but it works.
            g.fillRect((i+2)*35, 0, 30,30);
        }
        //This is for the `/~ key, why the fuck java calls it VK_BACK_QUOTE is beyond me...
        colorCode = getColorCode(NativeKeyEvent.VK_BACK_QUOTE);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(0,35,30,30);
        //Now for the numbers 1-9 0 has to be separate since it has a keyCode value below any of the numbers and it has to be special.
        for(int i=0; i<9; i++){
            colorCode = getColorCode(NativeKeyEvent.VK_1+i);
            g.setColor(new Color(colorCode,0,0));
            //i+1 so the x vealue will never be 0, and we skip the space where the grave key is.
            g.fillRect((i+1)*35,35, 30,30);
        }
        colorCode = getColorCode(NativeKeyEvent.VK_0);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(350,35,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_MINUS);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(385,35,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_PLUS);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(420,35,30,30);

        //Backspace has to be two keys wide.
        colorCode = getColorCode(NativeKeyEvent.VK_BACK_SPACE);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(455,35,60,30);

        //Adding insert, home, and page up
        colorCode = getColorCode(NativeKeyEvent.VK_INSERT);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(535,35,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_HOME);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(570,35,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_PAGE_UP);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(605,35,30,30);

        //Top row of numpad
        colorCode = getColorCode(NativeKeyEvent.VK_NUM_LOCK);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect (650,35,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_DIVIDE);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(685,35,30,30);
        colorCode = getColorCode(NativeKeyEvent.VK_MULTIPLY);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(720,35,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_SUBTRACT);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(755,35,30,30);

        //The Tab QWERTY row
        colorCode = getColorCode(NativeKeyEvent.VK_TAB);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(0,70,42,30);

        colorCode = getColorCode(NativeKeyEvent.VK_Q);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(47,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_W);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(82,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_E);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(117,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_R);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(152,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_T);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(187,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_Y);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(222,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_U);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(257,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_I);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(292,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_O);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(327,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_P);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(362,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_OPEN_BRACKET);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(397,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_CLOSE_BRACKET);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(432,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_BACK_SLASH);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(467,70,48,30);

        //Delete end and Page Down
        colorCode = getColorCode(NativeKeyEvent.VK_DELETE);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(535,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_END);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(570,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VK_PAGE_DOWN);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(605,70,30,30);

        //Numpad row 2
        for (int i=0; i<3; i++){
            colorCode = getColorCode(NativeKeyEvent.VK_NUMPAD7+i);
            g.setColor(new Color(colorCode,0,0));
            g.fillRect(650+i*35,70,30,30);
        }
        //Numpad + button, this has to be 2 times the height of a normal key
        colorCode = getColorCode(NativeKeyEvent.VK_ADD);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(755,70,30,60);


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
