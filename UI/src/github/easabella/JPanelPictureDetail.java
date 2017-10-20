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
            /*
            int iw = image.getWidth(null)*ratio;
            int ih = image.getHeight(null)*ratio;

            int offx = -x * iw / w + w/2;
            int offy = -y * ih / h + h/2;

            g.drawImage(image, offx, offy, iw, ih, null);
            */

            PosMapping.drawImage_SpecialPosAsCenterMode(g, image, this, monitorCenter.getPosX(), monitorCenter.getPosY(), monitorCenter.getRatio());

        }

//        Graphics2D g2d = (Graphics2D) g;
//        Stroke dash = new BasicStroke(
//        2.5f, BasicStroke.CAP_BUTT,
//                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 15, 10, },
//                0f);
//
//        g2d.setStroke(dash);
//        g2d.setColor(Color.red);

        int redis = (w > h) ? (h/4) : (w/4);

        g.drawLine(w/2, h/2-redis, w/2, h/2+redis);
        g.drawLine(w/2 - redis, h/2, w/2+redis, h/2);

        g.drawString(String.format("(%d,%d) %dx", x, y, ratio), 20, 20);
    }

}

