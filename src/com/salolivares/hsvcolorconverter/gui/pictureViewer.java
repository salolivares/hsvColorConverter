package com.salolivares.hsvcolorconverter.gui;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class pictureViewer extends JFrame {
    BufferedImage image;
    imageCanvas canvas;
    AffineTransform at;
    Point2D point;
    JSlider slider;

    pictureViewer(File file){
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        canvas = new imageCanvas();
        panningHandler p = new panningHandler();
        canvas.addMouseListener(p);
        canvas.addMouseMotionListener(p);
        canvas.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Zoom handling
        slider = new JSlider(JSlider.HORIZONTAL, 0, 300, 100);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new scaleHandler());
    }

    public void openPictureViewer(){
        JFrame frame = new JFrame();
        frame.getContentPane().add(slider, BorderLayout.NORTH);
        frame.getContentPane().add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public class imageCanvas extends JComponent {
        double translateX, translateY, scale;

        imageCanvas(){
            translateX = 0;
            translateY = 0;
            scale = 0;
        }

        // Override paintComponent to add custom features
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D)g;
            AffineTransform st = g2.getTransform();

            // Blank screen
            g2.setColor(Color.WHITE);
            g2.fillRect(0,0,getWidth(),getHeight());

            at = new AffineTransform(st);

            // Zooming transform
            at.translate(getWidth()/2, getHeight()/2);
            at.scale(scale, scale);
            at.translate(-getWidth(),-getHeight());

            // Panning transform
            at.translate(translateX, translateY);

            g2.setTransform(at);

            // Draw image
            g2.drawImage(image, 0, 0, null);

            g2.setTransform(st);
        }

        public Dimension getPreferredSize(){
            return new Dimension(500, 500);
        }
    }

    class panningHandler implements MouseListener, MouseMotionListener {
        double rX, rY;
        AffineTransform it;

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        // Save starting point
        @Override
        public void mousePressed(MouseEvent e){
            try{
                point = at.inverseTransform(e.getPoint(), null);
            } catch (NoninvertibleTransformException te){
                te.printStackTrace();
            }

            rX = point.getX();
            rY = point.getY();
            it = at;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e){
            try{
                point = it.inverseTransform(e.getPoint(), null);
            } catch(NoninvertibleTransformException te){
                te.printStackTrace();
            }

            double dX = point.getX() - rX;
            double dY = point.getY() - rY;

            rX = point.getX();
            rY = point.getY();

            canvas.translateX += dX;
            canvas.translateY += dY;

            canvas.repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    class scaleHandler implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider slider = (JSlider)e.getSource();
            int zoomPercent = slider.getValue();
            canvas.scale = Math.max(0.00001, zoomPercent / 100.0 );
            canvas.repaint();
        }
    }

}
