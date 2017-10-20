package github.easabella;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Easabella.
 */
public class JButtonOpenFile extends JButton{

    public JButtonOpenFile(String text, JPanelPictureBase panel){

        super(text);

        addActionListener(e -> {
            JFileChooser jfc = new JFileChooser();
            jfc.setCurrentDirectory(new File("."));
            if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                String path = jfc.getSelectedFile().getAbsolutePath();
                System.out.println();
                panel.setPicture(path);

                panel.updateUI();
            }
        });
    }
}
