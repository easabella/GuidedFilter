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

        //JPanel panelMain = new JPanel();
        super(new BorderLayout());
        setPreferredSize(new Dimension(200, 0));
        setBorder(new BevelBorder(BevelBorder.RAISED));

        String str1[] = {"请选择", "模糊", "锐化", "去雾"};
        JComboBox jComboBox = new JComboBox(str1);
        jComboBox.setBackground(Color.WHITE);
        add(jComboBox, BorderLayout.NORTH);


        JPanel panelBig = new JPanel(new GridLayout(10, 2));
        add(panelBig, BorderLayout.CENTER);


        java.util.List<String> lst = Arrays.asList("r", "delta", "w(omega)", "xxx");

        for (String aLst : lst) {
            JLabel label = new JLabel(aLst);
            label.setHorizontalAlignment(JLabel.RIGHT);
            panelBig.add(label);

            JTextField textField = new JTextField("0");
            textField.setHorizontalAlignment(JTextField.RIGHT);
            panelBig.add(textField);
            //panelBtn.add(new JButton(Integer.toString(i)));

        }

        for (int i = 1; i <= 20-lst.size()*2-1; i++){
            panelBig.add(new JLabel(""));
        }

        panelBig.add(new JButton("Start"));

    }

}
