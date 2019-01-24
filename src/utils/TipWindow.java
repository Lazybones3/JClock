package utils;

import javax.swing.*;
import java.awt.*;

public class TipWindow extends JDialog {
    private static final long serialVersionUID = 8541659783234673950L;
    private static Dimension dim;
    private int x, y;
    private int width, height;
    private static Insets screenInsets;

    public TipWindow(int width, int height) {
        this.width = width;
        this.height = height;
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        x = (int) (dim.getWidth() - width -3);
        y = (int) (dim.getHeight() - screenInsets.bottom -3);
        initComponents();
    }

    private void initComponents() {
        this.setSize(width, height);
        this.setLocation(x, y);
        this.setBackground(Color.black);
    }

    public void run() {
        for (int i = 0; i <= height; i += 10){
            try {
                this.setLocation(x, y - i);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //让消息提示框6秒后消失
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        close();
    }

    public void close() {
        x = this.getX();
        y = this.getY();
        int ybottom = (int) (dim.getHeight() - screenInsets.bottom);
        for (int i = 0; i <= ybottom - y; i += 10) {
            try {
                setLocation(x, y+i);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dispose();
    }
}
