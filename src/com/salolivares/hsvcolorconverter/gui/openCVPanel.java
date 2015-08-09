package com.salolivares.hsvcolorconverter.gui;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class openCVPanel extends AbstractColorChooserPanel implements ActionListener {
    private float h,s,v = 0;
    private double nH, nS, nV = 0;
    private int r,g,b = 0;
    private float[] hsv = new float[3];

    JLabel hLabel = new JLabel("Hue: ");
    JLabel sLabel = new JLabel("Saturation: ");
    JLabel vLabel = new JLabel("Value: ");

    JTextField hField = new JTextField(""+h);
    JTextField sField = new JTextField(""+s);
    JTextField vField = new JTextField(""+v);
    /**
     * Every time the user switches to the openCV HSV panel the values
     * update their value according to the user selected color
     *
     */
    @Override
    public void updateChooser() {
        Color color = getColorFromModel();

        r = color.getRed();
        g = color.getGreen();
        b = color.getBlue();

        Color.RGBtoHSB(r,g,b,hsv);

        h = hsv[0] * 360;
        s = hsv[1];
        v = hsv[2];

        nH = Math.round((double)h/2);
        nS = s*255;
        nV = v*255;

        hField.setText(""+nH);
        sField.setText(""+nS);
        vField.setText(""+nV);

    }

    /**
     * Defines the panel layout
     */
    @Override
    protected void buildChooser() {
        setLayout(new GridLayout(3,2));

        add(hLabel);
        add(hField);
        add(sLabel);
        add(sField);
        add(vLabel);
        add(vField);
    }

    @Override
    public String getDisplayName() {
        return "OpenCV HSV Values";
    }

    @Override
    public Icon getSmallDisplayIcon() {
        return null;
    }

    @Override
    public Icon getLargeDisplayIcon() {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
