import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;

import java.util.HashMap;
import java.util.logging.LogManager;


public class Main {
    private static HashMap<Integer,Integer> keyMap = new HashMap<Integer, Integer>();
    private static boolean disableSpace = false;
    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
            LogManager.getLogManager().reset();
            ApplicationFrame frame = new ApplicationFrame(new Callback<Boolean>() {
                @Override
                public void callback(Boolean spaces) {
                    disableSpace = spaces;
                    GlobalScreen.getInstance().addNativeKeyListener(new GlobalKeyListener(new Callback<Integer>() {
                        @Override
                        public void callback(Integer keyCode) {
                            int currentValue = 0;
                            if (keyMap.containsKey(keyCode)){
                                if (disableSpace && keyCode!=NativeKeyEvent.VC_SPACE)
                                    currentValue = keyMap.get(keyCode);
                                else if (!disableSpace)
                                    currentValue = keyMap.get(keyCode);
                            }
                            keyMap.put(keyCode,currentValue+1);
                            System.out.println(keyCode);
                        }
                    }));
                }
            },
            new Callback<Void>() {
                @Override
                public void callback(Void aVoid) {
                    HeatMapFrame p = new HeatMapFrame(keyMap);
                    p.setVisible(true);
                }
            });
            frame.setVisible(true);
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

        System.out.println("Hello World!");

    }

}
