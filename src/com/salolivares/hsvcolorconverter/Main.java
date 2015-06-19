package com.salolivares.hsvcolorconverter;
import com.salolivares.hsvcolorconverter.gui.*;

/**
 * Created by Jonathan on 6/16/2015.
 */
class Main {
    public static void main(String[] args){
        mainGUI gui = new mainGUI();
        gui.createWindow();
    }

    /**
     * private constructor so class cannot be instantiated by outside classes
     */
    private Main(){
    }
}
