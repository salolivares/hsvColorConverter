package com.salolivares.hsvcolorconverter.gui;

import javax.swing.*;
import java.awt.*;

public class mainGUI {

    /**
     * method outside classes use to create the color picker frame
     */
    public void createWindow(){
        /**
        Declare all JComponents that are being used
         */
        JFrame mainFrame = new JFrame("Color Code Converter for OpenCV");
        JPanel colorPicker = new JPanel(new BorderLayout());
        JColorChooser colorC = new JColorChooser(Color.BLUE);
        openCVPanel openCV = new openCVPanel();

        //Customize the stock java colorpicker
        colorC.setBorder(BorderFactory.createTitledBorder("Choose Color"));
        colorC.addChooserPanel(openCV);

        // add to panel
        colorPicker.add(colorC, BorderLayout.PAGE_END);

        // customize jframe behavior
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setContentPane(colorPicker);
        mainFrame.pack();
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }
}
