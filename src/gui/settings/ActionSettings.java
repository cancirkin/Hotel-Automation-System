package gui.settings;

import javax.swing.JFrame;


public class ActionSettings {
    
    public static void setVisible(JFrame oldFrame, JFrame newFrame){
    oldFrame.setVisible(false);
    newFrame.setVisible(true);
    }   
}

