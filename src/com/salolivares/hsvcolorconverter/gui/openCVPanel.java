package com.salolivares.hsvcolorconverter.gui;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class openCVPanel extends AbstractColorChooserPanel implements ActionListener {
    float h,s,v = 0;
    double nH, nS, nV = 0;
    int r,g,b = 0;
    float[] hsv = new float[3];

    JLabel hLabel = new JLabel("Hue: " + h);
    JLabel sLabel = new JLabel("Saturation: " + s);
    JLabel vLabel = new JLabel("Value: " + v);

    /**
     * Every time the user switches to the openCV HSV panel the values
     * update their value according to the user selected color
     *
     * TODO:
     *   - correct the algorithm to convert the color codes to openCV HSV
     */
    @Override
    public void updateChooser() {
        Color color = getColorFromModel();

        r = color.getRed();
        g = color.getGreen();
        b = color.getBlue();

        Color.RGBtoHSB(r,g,b,hsv);

        h = hsv[0] * 360;
        s = hsv[1] * 100;
        v = hsv[2] * 100;

        nH = Math.round((double)h/2);
        nS = Math.round((double)s*2 + 25);
        nV = Math.round((double)v*2 + 25);

        hLabel.setText("Hue: " + nH);
        sLabel.setText("Saturation: " + nS);
        vLabel.setText("Value: " + nV);

    }

    /**
     * Defines the panel layout
     */
    @Override
    protected void buildChooser() {
        setLayout(new GridLayout(3,1));

        add(hLabel);
        add(sLabel);
        add(vLabel);
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
