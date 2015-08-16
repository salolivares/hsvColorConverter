package com.salolivares.hsvcolorconverter.gui;

import javax.swing.*;
import java.awt.*;

public class openCVPanel extends JPanel {
    private JLabel hLabel;
    private JLabel sLabel;
    private JLabel vLabel;

    private JTextField hField;
    private JTextField sField;
    private JTextField vField;


    openCVPanel(){
        hLabel = new JLabel("Hue: ");
        sLabel = new JLabel("Saturation: ");
        vLabel = new JLabel("Value: ");

        hField = new JTextField("");
        sField = new JTextField("");
        vField = new JTextField("");

        updateColor(0,0,0);

        setBorder(BorderFactory.createTitledBorder("OpenCV Color Values"));

        add(hLabel);
        add(hField);
        add(sLabel);
        add(sField);
        add(vLabel);
        add(vField);
    }

    public void updateColor(double h, double s, double v){
        hField.setText(""+h);
        sField.setText(""+s);
        vField.setText(""+v);
    }
}
