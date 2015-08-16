package com.salolivares.hsvcolorconverter.gui;

import com.salolivares.hsvcolorconverter.util.isOpen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class mainGUI extends JFrame{

    private JFileChooser fc;
    private File file;
    private pictureViewer pv;
    private isOpen pvIsOpen;
    private JColorChooser colorC;
    private Color initialColor;

    public mainGUI(){
        super("Color Code Converter for OpenCV");
        initialColor = Color.BLUE;
        initUI();
    }

    /**
     * TODO: Add a panel showing current hsv values so you don't have to go back and forth
     */
    private void initUI(){
        JPanel colorPicker = new JPanel(new BorderLayout());
        colorC = new JColorChooser(initialColor);
        openCVPanel oPV = new openCVPanel();
        openCVChooserPanel openCV = new openCVChooserPanel(oPV);
        pvIsOpen = isOpen.NO;
        pv = new pictureViewer(this);

        createMenuBar();
        colorC.setBorder(BorderFactory.createTitledBorder("Choose Color"));
        colorC.addChooserPanel(openCV);
        colorPicker.add(colorC, BorderLayout.PAGE_END);
        add(colorPicker, BorderLayout.PAGE_START);
        add(oPV, BorderLayout.PAGE_END);

        try {
            setIconImage(ImageIO.read(new File("res/icon.png")));
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }

        // Customize JFrame behavior
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem exitLabel = new JMenuItem("Exit");
        JMenuItem openLabel = new JMenuItem("Open");
        JMenuItem aboutLabel = new JMenuItem("About");
        JMenuItem userguideLabel = new JMenuItem("User Guide");

        openLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(fc == null){
                    fc = new JFileChooser();

                    // Add custom file filter
                    fc.addChoosableFileFilter(new ImageFilter());
                    fc.setAcceptAllFileFilterUsed(false);

                    // Add preview pane
                    fc.setAccessory(new ImagePreview(fc));
                }

                int returnVal = fc.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    file = fc.getSelectedFile();
                    pv.openPictureViewer(file);
                    System.out.print("Opening: " + file.getName() + ".\n");
                } else {
                    System.out.print("Open command cancelled by user.\n");
                }

                // Reset file choose for next time file chooser is open
                fc.setSelectedFile(null);
            }
        });
        exitLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.exit(0);
            }
        });
        aboutLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }
        });

        fileMenu.add(openLabel);
        fileMenu.addSeparator();
        fileMenu.add(exitLabel);
        helpMenu.add(userguideLabel);
        helpMenu.add(aboutLabel);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }

    public isOpen getPvIsOpen() {
        return pvIsOpen;
    }

    public void setPvIsOpen(isOpen pvIsOpen) {
        this.pvIsOpen = pvIsOpen;
    }

    public void setColorForChooser(Color color){
        colorC.setColor(color);
    }
}
