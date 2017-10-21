package github.easabella;


import javax.swing.*;
import java.awt.*;


/**
 * Created by Easabella.
 */
public class PosMapping {



    public static void drawImage_FitMode(Graphics g, Image image, JComponent window){
        int w = window.getWidth();   //window w
        int h = window.getHeight();  //window h

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

    public static Pos posWindow2posImage(int X, int Y, Image image, JComponent window){
        int w = window.getWidth();   //window w
        int h = window.getHeight();  //window h

        int iw = image.getWidth(null);   // image w
        int ih = image.getHeight(null);  // image h

        double ratio_w = (double) w / iw;
        double ratio_h = (double) h / ih;

        double ratio = (ratio_h < ratio_w)? ratio_h : ratio_w;

        int centerX = w/2;
        int centerY = h/2;

        int diffX = X - centerX;
        int diffY = Y - centerY;

        int posImageX = iw/2 + (int)(diffX / ratio);
        int posImageY = ih/2 + (int)(diffY / ratio);

        return new Pos(posImageX, posImageY);
    }

    public static void drawImage_SpecialPosAsCenterMode(Graphics g, Image image, JComponent window,
                                                int posX, int posY, int amplificationFactor){
        int w = window.getWidth();
        int h = window.getHeight();



        if (image != null) {
            int iw = image.getWidth(null)*amplificationFactor;
            int ih = image.getHeight(null)*amplificationFactor;

            Pos posImage = posWindow2posImage(posX, posY, image, window);
            posImage.mul(amplificationFactor);

            int offx = -posImage.x + w /2; //-posImage.x * iw / w + w/2;
            int offy = -posImage.y + h /2; //-posImage.y * ih / h + h/2;

            g.drawImage(image, offx, offy, iw, ih, null);

        }
    }
}
