package github.easabella;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by Easabella.
 */
public class MonitorCenter extends JPanel {

    private boolean isPosFixed = false;
    private int posX = -1;
    private int posY = -1;

    public int getRatio() {
        return ratio;
    }

    private int ratio = 1;

    private void setRatio(int r) {
        ratio = r;

        if (ratio < 1) {
            ratio = 1;
        }
        if (ratio > 256) {
            ratio = 256;
        }
    }

    private ArrayList<JPanelPictureOutline> lstPanelOutline = new ArrayList<>();
    private ArrayList<JPanelPictureDetail> lstPanelDetail = new ArrayList<>();

    KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {

           /* if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_UP) {
                setRatio(ratio * 2);
            } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_DOWN) {
                setRatio(ratio / 2);
            } else*/ if (e.getKeyCode() == KeyEvent.VK_UP) {
                posY--;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                posY++;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                posX--;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                posX++;
            }
            updateUI_lstPanelOutline();
            updateUI_lstPanelDetail();
        }
    };

    MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isRightMouseButton(e)) {
                isPosFixed = false;
            } else {
                isPosFixed = true;
                posX = e.getX();
                posY = e.getY();
            }

            updateUI_lstPanelOutline();
            updateUI_lstPanelDetail();
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            if (e.getWheelRotation() < 0) {
                setRatio(ratio * 2);
            } else {
                setRatio(ratio / 2);
            }

            updateUI_lstPanelDetail();

        }

        @Override
        public void mouseMoved(MouseEvent e) {

            if (isPosFixed()) {
                return;
            }
            posX = e.getX();
            posY = e.getY();


            updateUI_lstPanelOutline();
            updateUI_lstPanelDetail();
        }
    };

    private void updateUI_lstPanelOutline() {
        for (JPanelPictureOutline p : lstPanelOutline) {
            p.updateUI();
        }
    }

    private void updateUI_lstPanelDetail() {
        for (JPanelPictureDetail p : lstPanelDetail) {
            p.updateUI();
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    private void addPairOfPanel(JPanelPictureOutline panelOutLine, JPanelPictureDetail panelDetail) {
        lstPanelOutline.add(panelOutLine);
        lstPanelDetail.add(panelDetail);

        panelOutLine.addMouseListener(mouseAdapter);
        panelOutLine.addMouseMotionListener(mouseAdapter);

    }


    public MonitorCenter() {
        setFocusable(true);
        requestFocusInWindow();

        addMouseWheelListener(mouseAdapter);
        addKeyListener(keyAdapter);

        JPanelPictureOutline panelPicOutline1 = new JPanelPictureOutline(this);
        JPanelPictureOutline panelPicOutline2 = new JPanelPictureOutline(this);
        JPanelPictureDetail panelPicDetail1 = new JPanelPictureDetail(this, panelPicOutline1);
        JPanelPictureDetail panelPicDetail2 = new JPanelPictureDetail(this, panelPicOutline2);

        panelPicOutline1.setPicture("E:\\git_image\\bmp\\big.bmp");
        //panelPicOutline2.setPicture("E:\\git_image\\bmp\\big.bmp");

        addPairOfPanel(panelPicOutline1, panelPicDetail1);
        addPairOfPanel(panelPicOutline2, panelPicDetail2);


        Panel panel = new Panel();
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        JButton btn = new JButton("Open");
        add(btn, BorderLayout.NORTH);
        btn.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser();
            if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                //解释下这里,弹出个对话框,可以选择要上传的文件,如果选择了,就把选择的文件的绝对路径打印出来,有了绝对路径,通过JTextField的settext就能设置进去了,那个我没写
                String path = jfc.getSelectedFile().getAbsolutePath();
                System.out.println();
                panelPicOutline1.setPicture(path);
                panelPicOutline2.setPicture(path);

                updateUI();
            }
        });


        panel.setLayout(new GridLayout(2, lstPanelOutline.size()));
        for (JPanelPictureOutline p : lstPanelOutline) {
            panel.add(p);
        }

        for (JPanelPictureDetail p : lstPanelDetail) {
            panel.add(p);
        }
    }

    public boolean isPosFixed() {
        return isPosFixed;
    }
}