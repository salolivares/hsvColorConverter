package com.salolivares.hsvcolorconverter.gui;

import javax.swing.*;
import java.awt.*;

public class mainGUI extends JFrame{

    public mainGUI(){
        super("Color Code Converter for OpenCV");
        initUI();
    }

    private void initUI(){
        // Declare all JComponents that are being used
        JPanel colorPicker = new JPanel(new BorderLayout());
        JColorChooser colorC = new JColorChooser(Color.BLUE);
        openCVPanel openCV = new openCVPanel();

        // Create menu bar

        // Customize the stock java color picker
        colorC.setBorder(BorderFactory.createTitledBorder("Choose Color"));
        colorC.addChooserPanel(openCV);

        // add openCV panel to color picker panel
        colorPicker.add(colorC, BorderLayout.PAGE_END);

        // add color picker
        add(colorPicker, BorderLayout.PAGE_END);

        // customize jframe behavior
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
