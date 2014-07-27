
import javax.swing.*;
import java.awt.*;
import org.jnativehook.keyboard.NativeKeyEvent;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Nick on 7/26/14.
 */
public class HeatMapPanel extends JComponent {
    HashMap<Integer,Integer> data;
    HeatMapPanel(HashMap<Integer,Integer> data){
        this.data = data;
        //Debug data
//        data.put(NativeKeyEvent.VC_F1,50);
//        data.put(NativeKeyEvent.VC_F2,100);
//        data.put(NativeKeyEvent.VC_F3,300);
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
        colorCode = getColorCode(NativeKeyEvent.VC_ESCAPE);
        System.out.println(colorCode);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(0, 0, 30, 30);

        //Leave a 35 pixel space for the space between the escape key and the f row
        //F row and print screen
        for (int i=0; i<12; i++){
            colorCode = getColorCode(NativeKeyEvent.VC_F1+i);
            g.setColor(new Color(colorCode,0,0));
            //i+2 so the x value will never be 0, and we actually skip a space. A bit hacky, but it works.
            g.fillRect((i+2)*35, 0, 30,30);
        }
        //This is for the `/~ key, why the fuck java calls it VC_BACKQUOTE is beyond me...
        colorCode = getColorCode(NativeKeyEvent.VC_BACKQUOTE);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(0,35,30,30);
        //Now for the numbers 1-9 0 has to be separate since it has a keyCode value below any of the numbers and it has to be special.
        for(int i=0; i<9; i++){
            colorCode = getColorCode(NativeKeyEvent.VC_1+i);
            g.setColor(new Color(colorCode,0,0));
            //i+1 so the x vealue will never be 0, and we skip the space where the grave key is.
            g.fillRect((i+1)*35,35, 30,30);
        }
        colorCode = getColorCode(NativeKeyEvent.VC_0);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(350,35,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_MINUS);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(385,35,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_EQUALS);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(420,35,30,30);

        //Backspace has to be two keys wide.
        colorCode = getColorCode(NativeKeyEvent.VC_BACKSPACE);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(455,35,60,30);

        //Adding insert, home, and page up
        colorCode = getColorCode(NativeKeyEvent.VC_INSERT);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(535,35,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_HOME);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(570,35,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_PAGE_UP);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(605,35,30,30);

        //Top row of numpad
        colorCode = getColorCode(NativeKeyEvent.VC_NUM_LOCK);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect (650,35,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_KP_DIVIDE);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(685,35,30,30);
        colorCode = getColorCode(NativeKeyEvent.VC_KP_MULTIPLY);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(720,35,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_KP_SUBTRACT);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(755,35,30,30);

        //The Tab QWERTY row
        colorCode = getColorCode(NativeKeyEvent.VC_TAB);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(0,70,42,30);

        colorCode = getColorCode(NativeKeyEvent.VC_Q);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(47,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_W);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(82,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_E);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(117,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_R);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(152,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_T);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(187,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_Y);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(222,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_U);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(257,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_I);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(292,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_O);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(327,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_P);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(362,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_OPEN_BRACKET);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(397,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_CLOSE_BRACKET);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(432,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_BACK_SLASH);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(467,70,48,30);

        //Delete end and Page Down
        colorCode = getColorCode(NativeKeyEvent.VC_DELETE);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(535,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_END);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(570,70,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_PAGE_DOWN);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(605,70,30,30);

        //Numpad row 2
        for (int i=0; i<3; i++){
            colorCode = getColorCode(NativeKeyEvent.VC_KP_7+i);
            g.setColor(new Color(colorCode,0,0));
            g.fillRect(650+i*35,70,30,30);
        }
        //Numpad + button, this has to be 2 times the height of a normal key
        colorCode = getColorCode(NativeKeyEvent.VC_KP_ADD);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(755,70,30,65);

        //Now we begin the third row
        colorCode = getColorCode(NativeKeyEvent.VC_CAPS_LOCK);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(0,105,54,30);

        colorCode = getColorCode(NativeKeyEvent.VC_A);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(59,105,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_S);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(94,105,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_D);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(129,105,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_F);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(164,105,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_G);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(199,105,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_H);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(234,105,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_J);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(269,105,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_K);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(304,105,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_L);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(339,105,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_SEMICOLON);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(374,105,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_QUOTE);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(409,105,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_ENTER);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(444,105,71,30);

        colorCode = getColorCode(NativeKeyEvent.VC_ENTER);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(444,105,71,30);

        //Numpad row 3!
        for (int i=0; i<3; i++){
            colorCode = getColorCode(NativeKeyEvent.VC_KP_4+i);
            g.setColor(new Color(colorCode,0,0));
            g.fillRect(650+i*35,105,30,30);
        }

        //Time for row 4, let's do this.

        colorCode = getColorCode(NativeKeyEvent.VC_SHIFT_L);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(0,140,66,30);

        colorCode = getColorCode(NativeKeyEvent.VC_Z);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(71,140,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_X);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(106,140,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_C);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(141,140,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_V);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(176,140,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_B);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(211,140,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_N);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(246,140,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_M);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(281,140,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_COMMA);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(316,140,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_PERIOD);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(351,140,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_SLASH);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(386,140,30,30);

        colorCode = getColorCode(NativeKeyEvent.VC_SHIFT_R);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(421,140,94,30);

        colorCode = getColorCode(NativeKeyEvent.VC_UP);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(570,140,30,30);

        //Numpad row 4
        for (int i=0; i<3; i++){
            colorCode = getColorCode(NativeKeyEvent.VC_KP_1+i);
            g.setColor(new Color(colorCode,0,0));
            g.fillRect(650+i*35,140,30,30);
        }

        //For some reason the enter key shows a keycode of 0, rather than any other functional keycode. KEY_LOCATION_UNKOWN is 0, so I set it to that.
        colorCode = getColorCode(NativeKeyEvent.KEY_LOCATION_UNKNOWN);
        g.setColor(new Color(colorCode,0,0));
        g.fillRect(755,140,30,65);



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
