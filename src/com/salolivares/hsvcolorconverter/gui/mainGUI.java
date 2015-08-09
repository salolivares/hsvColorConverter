package com.salolivares.hsvcolorconverter.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

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

        //set icon
        try {
            setIconImage(ImageIO.read(new File("res/icon.png")));
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }

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
        JMenu helpMenu = new JMenu("Help");
        JMenuItem exitLabel = new JMenuItem("Exit");
        JMenuItem openLabel = new JMenuItem("Open");
        JMenuItem aboutLabel = new JMenuItem("About");

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
        aboutLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }
        });

        // add labels to menu
        fileMenu.add(openLabel);
        fileMenu.addSeparator();
        fileMenu.add(exitLabel);
        helpMenu.add(aboutLabel);

        //add to frame
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }
}
