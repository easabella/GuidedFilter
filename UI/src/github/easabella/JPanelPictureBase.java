package github.easabella;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Easabella.
 */
public class JPanelPictureBase extends JPanel{
    protected Image image = null;

    public JPanelPictureBase() {
        //setBorder(new LineBorder(Color.RED, 2));
    }

    public void setPicture(String picFileName) {
        try {
            image = ImageIO.read(new File(picFileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
