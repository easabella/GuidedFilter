package github.easabella;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Easabella.
 */
public class JPanelPictureOutline extends JPanelPictureBase {
    MonitorCenter monitorCenter;

    public JPanelPictureOutline(MonitorCenter monitorCenter) {
        this.monitorCenter = monitorCenter;

        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton btn = new JButtonOpenFile("Open", this);
        add(btn);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {

            PosMapping.drawImage_FitMode(g, image, this);

        }

        {
            int x = monitorCenter.getPosX();
            int y = monitorCenter.getPosY();
            g.drawLine(x, y - 5, x, y + 5);
            g.drawLine(x - 5, y, x + 5, y);
        }
    }

}
