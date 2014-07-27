import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nick on 7/26/14.
 */
public class ApplicationFrame extends JFrame {
    private JButton startButton = new JButton();
    private JButton endButton = new JButton();
    private JCheckBox disableSpaces = new JCheckBox();
    private Callback<Boolean> startCallback;
    private Callback<Void> endCallback;
    ApplicationFrame(Callback<Boolean> startCallback,Callback<Void> endCallback){
        this.setLayout(new FlowLayout());
        startButton.setText("Start");
        this.startCallback = startCallback;
        this.endCallback = endCallback;
        disableSpaces.setText("Disable listening for spaces.");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ApplicationFrame.this.startCallback.callback(isSpacesDisabled());
                ApplicationFrame.this.startButton.setEnabled(false); //This disables it so you can't add multiple listeners
                ApplicationFrame.this.disableSpaces.setEnabled(false);
            }
        });
        endButton.setText("End");
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ApplicationFrame.this.endCallback.callback(null);
                ApplicationFrame.this.setVisible(false);
                ApplicationFrame.this.startButton.setEnabled(false); //This disables it so you can't add multiple listeners
                ApplicationFrame.this.dispose();
            }
        });
        this.add(startButton);
        this.add(disableSpaces);
        this.add(endButton);
        this.pack();
    }
    public boolean isSpacesDisabled(){
        return disableSpaces.isSelected();
    }
}
