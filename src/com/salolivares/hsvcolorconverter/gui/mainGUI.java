package com.salolivares.hsvcolorconverter.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        createMenuBar();

        // Customize the stock java color picker
        colorC.setBorder(BorderFactory.createTitledBorder("Choose Color"));
        colorC.addChooserPanel(openCV);

        // add openCV panel to color picker panel
        colorPicker.add(colorC, BorderLayout.PAGE_END);

        // add color picker
        add(colorPicker, BorderLayout.PAGE_END);

        // customize JFrame behavior
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void createMenuBar(){
        // Declare JComponents used
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitLabel = new JMenuItem("Exit");
        JMenuItem openLabel = new JMenuItem("Open");

        // add action listeners to labels
        openLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }
        });
        exitLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.exit(0);
            }
        });

        // add labels to file menu
        fileMenu.add(openLabel);
        fileMenu.addSeparator();
        fileMenu.add(exitLabel);

        //add to frame
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }
}
