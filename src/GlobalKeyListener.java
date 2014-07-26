/**
 * Created by Nick on 7/26/14.
 */
import org.jnativehook.keyboard.*;
public class GlobalKeyListener implements NativeKeyListener{
    Callback<Integer> c;
    public GlobalKeyListener(Callback<Integer> c){
        this.c = c;
    }
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        c.callback(nativeKeyEvent.getKeyCode());
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }
}
