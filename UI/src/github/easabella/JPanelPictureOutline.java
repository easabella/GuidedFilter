package github.easabella;

import java.awt.*;

/**
 * Created by Easabella.
 */
public class JPanelPictureOutline extends JPanelPictureBase {
    MonitorCenter monitorCenter;

    public JPanelPictureOutline(MonitorCenter monitorCenter) {
        this.monitorCenter = monitorCenter;
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
                ih = h * iw / w;
            } else if (ih > h) {
                ih = h;
                iw = w * ih / h;
            }

            g.drawImage(image, 0, 0, iw, ih, null);

        }

        /*if (monitorCenter.isPosFixed())*/ {
            int x = monitorCenter.getPosX();
            int y = monitorCenter.getPosY();
            g.drawLine(x, y - 5, x, y + 5);
            g.drawLine(x - 5, y, x + 5, y);
        }
    }

}
