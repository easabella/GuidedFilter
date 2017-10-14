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

            int w = getWidth();   //window w
            int h = getHeight();  //window h

            int iw = image.getWidth(null);   // image w
            int ih = image.getHeight(null);  // image h

            double ratio_w = (double) w / iw;
            double ratio_h = (double) h / ih;

            int showW = (ratio_w <= ratio_h) ? (w) : (iw * h / ih);
            int showH = (ratio_h <= ratio_w) ? (h) : (ih * w / iw);

            int offw = (w - showW) / 2;
            int offh = (h - showH) / 2;

            g.drawImage(image, offw, offh, showW, showH, null);

        }

        {
            int x = monitorCenter.getPosX();
            int y = monitorCenter.getPosY();
            g.drawLine(x, y - 5, x, y + 5);
            g.drawLine(x - 5, y, x + 5, y);
        }
    }

}
