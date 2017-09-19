package github.easabella;

import java.awt.*;

/**
 * Created by Easabella.
 */
public class JPanelPictureDetail extends JPanelPictureBase{
    MonitorCenter monitorCenter;
    JPanelPictureOutline panelPictureOutline;
    public JPanelPictureDetail(MonitorCenter monitorCenter, JPanelPictureOutline panelPictureOutline) {
        this.monitorCenter = monitorCenter;
        this.panelPictureOutline = panelPictureOutline;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        image = panelPictureOutline.image;

        int w = getWidth();
        int h = getHeight();

        int x = monitorCenter.getPosX();
        int y = monitorCenter.getPosY();

        if (x < 0) {
            x = w/2;
        }
        if (y < 0) {
            y = h/2;
        }

        int ratio = monitorCenter.getRatio();

        if (image != null) {
            int iw = image.getWidth(null)*ratio;
            int ih = image.getHeight(null)*ratio;

            int offx = -x * iw / w + w/2;
            int offy = -y * ih / h + h/2;

            g.drawImage(image, offx, offy, iw, ih, null);

        }

        g.drawLine(w/2, 0, w/2, h);
        g.drawLine(0, h/2, w, h/2);

        g.drawString(String.format("(%d,%d) %dx", x, y, ratio), 20, 20);
    }

}

