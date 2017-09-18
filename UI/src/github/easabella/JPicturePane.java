package github.easabella;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Easabella.
 */
public class JPicturePane extends JPanel {

    Image image = null;

    public Image getImage() {
        return image;
    }

    public void setPicture(String picFileName) {
        try {
            image = ImageIO.read(new File(picFileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {

            int w = getWidth();
            int h = getHeight();

            int iw = image.getWidth(null);
            int ih = image.getHeight(null);

            if (iw > w) {
                iw = w;
                ih = h*iw/w;
            } else if (ih > h) {
                ih = h;
                iw = w*ih/h;
            }

            g.drawImage(image, 0, 0, iw, ih, null);

        }
    }

}
