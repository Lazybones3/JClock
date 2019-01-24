package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InfoUtil {
    private TipWindow tw = null;
    private JPanel headPan = null;
    private JPanel feaPan = null;
    private JPanel btnPan = null;
    private JLabel title = null;
    private JLabel head = null;
    private JLabel close = null;
    private JTextArea feature = null;
    private JScrollPane jfeaPan = null;
    private JButton sure = null;
    private String titleT = null;
    private String word = null;
    private Desktop desktop = null;

    public void init() {
        tw = new TipWindow(300, 180);
        headPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        feaPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        btnPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        title = new JLabel("你好，我是个闹钟");
        head = new JLabel(titleT);
        close = new JLabel("x");
        feature = new JTextArea(word);
        jfeaPan = new JScrollPane(feature);
        sure = new JButton("确认");
        sure.setHorizontalAlignment(SwingConstants.CENTER);

        //设置提示框的边框，宽度和颜色
        tw.getRootPane().setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.white));
        title.setPreferredSize(new Dimension(260, 26));
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setFont(new Font("宋体", Font.PLAIN, 12));
        title.setForeground(Color.black);

        close.setFont(new Font("Arial", Font.BOLD, 15));
        close.setPreferredSize(new Dimension(20,20));
        close.setVerticalTextPosition(JLabel.CENTER);
        close.setHorizontalTextPosition(JLabel.CENTER);
        close.setCursor(new Cursor(12));
        close.setToolTipText("关闭");

        head.setPreferredSize(new Dimension(250, 35));
        head.setVerticalTextPosition(JLabel.CENTER);
        head.setHorizontalTextPosition(JLabel.CENTER);
        head.setFont(new Font("宋体", Font.PLAIN, 14));
        head.setForeground(Color.black);

        feature.setEditable(false);
        feature.setForeground(Color.BLACK);
        feature.setFont(new Font("宋体", Font.PLAIN, 13));
        feature.setBackground(new Color(255, 255, 255));
        //文本域自动换行
        feature.setLineWrap(true);

        jfeaPan.setPreferredSize(new Dimension(260, 100));
        jfeaPan.setBorder(null);
        jfeaPan.setBackground(Color.black);
        tw.setBackground(Color.white);

        //为了隐藏文本域，加个空JLabel将它挤下去
        JLabel jsp = new JLabel();
        jsp.setPreferredSize(new Dimension(300, 15));

        sure.setPreferredSize(new Dimension(60, 30));
        //设置标签鼠标手性
        sure.setCursor(new Cursor(12));
        //设置button外观
        sure.setContentAreaFilled(false);
        sure.setBorder(BorderFactory.createRaisedBevelBorder());
        sure.setBackground(Color.gray);

        headPan.add(head);
        headPan.add(close);

        feaPan.add(jsp);
        feaPan.add(jfeaPan);

        btnPan.add(sure);

        headPan.setBackground(new Color(104, 141, 177));
        feaPan.setBackground(Color.white);
        btnPan.setBackground(Color.white);

        tw.add(headPan, BorderLayout.NORTH);
        tw.add(feaPan, BorderLayout.CENTER);
        tw.add(btnPan, BorderLayout.SOUTH);
    }

    public void handle() {
        //为更新按钮增加相应事件
        desktop = Desktop.getDesktop();
        sure.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //跳转到网页
                //desktop.browse(new URI("https://www.baidu.com"));
                tw.close();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                sure.setBorder(BorderFactory.createLineBorder(Color.gray));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sure.setBorder(null);
            }
        });
        //关闭按钮事件
        close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tw.close();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                sure.setBorder(BorderFactory.createLineBorder(Color.gray));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sure.setBorder(null);
            }
        });
    }

    public void show(String titleT, String word) {
        this.titleT = titleT;
        this.word = word;
        init();
        handle();
        tw.setAlwaysOnTop(true);
        tw.setUndecorated(true);
        tw.setResizable(false);
        tw.setVisible(true);
        tw.run();
    }

    public void close() {
        tw.close();
    }
}
