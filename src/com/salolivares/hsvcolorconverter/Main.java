package com.salolivares.hsvcolorconverter;
import com.salolivares.hsvcolorconverter.gui.*;

import java.awt.*;

class Main {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainGUI gui = new mainGUI();
                gui.createWindow();
            }
        });
    }

    //private constructor so class cannot be instantiated by outside classes
    private Main(){
    }
}
