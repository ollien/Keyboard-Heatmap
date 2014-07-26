import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import java.util.HashMap;


public class Main {
    private static HashMap<Integer,Integer> keyMap = new HashMap<Integer, Integer>();
    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.getInstance().addNativeKeyListener(new GlobalKeyListener(new Callback<Integer>() {
                @Override
                public void callback(Integer keyCode) {
                    int currentValue = 0;
                    if (keyMap.containsKey(keyCode)){
                        currentValue = keyMap.get(keyCode);
                    }
                    keyMap.put(keyCode,currentValue+1);
//                    System.out.println(keyCode);
                }
            }));
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        HeatMapFrame p = new HeatMapFrame(keyMap);
        p.pack();
        p.setVisible(true);
        System.out.println("Hello World!");

    }

}
