package github.easabella;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by Easabella.
 */
public class JPictureObserver extends JPanel{
    JPicturePane observedPane;
    Image orignalImage;
    int x;
    int y;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        if (orignalImage != null) {

            int w = getWidth();
            int h = getHeight();

            int iw = orignalImage.getWidth(null);
            int ih = orignalImage.getHeight(null);


            int offx = -x * ( iw - w) / w + w/2;
            int offy = -y * ( ih - h) / h + h/2;

            g.drawImage(orignalImage, offx, offy, iw, ih, null);

        }

        //g.drawString(x+" , "+y, 20, 20);
    }

    public void setObservedPane(JPicturePane observedPane) {

        this.observedPane = observedPane;
        this.orignalImage = observedPane.getImage();

        observedPane.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                JPictureObserver.this.updateUI();
            }
        });
    }


}

