import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;

import java.util.HashMap;
import java.util.logging.LogManager;


public class Main {
    private static HashMap<Integer,Integer> keyMap = new HashMap<Integer, Integer>();
    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
            LogManager.getLogManager().reset();
            GlobalScreen.getInstance().addNativeKeyListener(new GlobalKeyListener(new Callback<Integer>() {
                @Override
                public void callback(Integer keyCode) {
                    int currentValue = 0;
                    if (keyMap.containsKey(keyCode)){
                        currentValue = keyMap.get(keyCode);
                    }
                    keyMap.put(keyCode,currentValue+1);
                    System.out.println(keyCode);
                }
            }));
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        HeatMapFrame p = new HeatMapFrame(keyMap);
        p.setVisible(true);
        System.out.println("Hello World!");

    }

}
