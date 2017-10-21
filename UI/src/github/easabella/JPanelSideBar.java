package github.easabella;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.*;

/**
 * Created by Easabella.
 */
public class JPanelSideBar extends JPanel{

    public JPanelSideBar(){

        super(new GridLayout(10, 2));
        setPreferredSize(new Dimension(200, 0));
        setBorder(new BevelBorder(BevelBorder.RAISED));

        java.util.List<String> lst = Arrays.asList("r", "delta", "w(omega)");

        for (String aLst : lst) {
            JLabel label = new JLabel(aLst);
            label.setHorizontalAlignment(JLabel.RIGHT);
            add(label);

            JTextField textField = new JTextField("0");
            textField.setHorizontalAlignment(JTextField.RIGHT);
            add(textField);
            //panelBtn.add(new JButton(Integer.toString(i)));

        }

        for (int i = 1; i <= 20-lst.size()*2-1; i++){
            add(new JLabel(""));
        }

        add(new JButton("Start"));

    }

}
