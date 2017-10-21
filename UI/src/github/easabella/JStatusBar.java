package github.easabella;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

import static java.awt.FlowLayout.LEFT;

/**
 * Created by Easabella.
 */
public class JStatusBar extends  JPanel{
    JLabel label = new JLabel(" ");
    JLabel label2 = new JLabel(" ");
    JLabel label3 = new JLabel(" ");
    JLabel label4 = new JLabel(" ");


    public JStatusBar() {

        setLayout(new FlowLayout(LEFT));
        setBorder(new BevelBorder(BevelBorder.RAISED));
        add(label);
        add(new JSeparator(SwingConstants.VERTICAL));
        add(label2);add(new JSeparator(SwingConstants.VERTICAL));
    }

    public void setPositionInfo(Pos pos){
        label.setText( String.format("(%d,%d)", pos.x, pos.y));
    }

    public void setRatioInfo(int ratio){
        label2.setText( ((Integer)ratio).toString() + "X");
    }
}