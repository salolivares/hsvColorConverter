package com.salolivares.hsvcolorconverter.gui;

import javax.swing.*;
import java.awt.*;

public class openCVPanel extends JPanel {
    JLabel hLabel;
    JLabel sLabel;
    JLabel vLabel;

    JTextField hField;
    JTextField sField;
    JTextField vField;

    openCVPanel(){
        hLabel = new JLabel("Hue: ");
        sLabel = new JLabel("Saturation: ");
        vLabel = new JLabel("Value: ");

        hField = new JTextField("");
        sField = new JTextField("");
        vField = new JTextField("");

        updateColor(0,0,0);

        setLayout(new GridLayout(3,2));

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
