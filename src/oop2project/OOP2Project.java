package oop2project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The main runner class
 * @author David
 */
public class OOP2Project {
    private AdvisorFacade advisor;
    private AdvisingGUI gui;
    
    public OOP2Project(String filePath) {
        this.advisor = new Advisor(filePath);
        this.gui = new AdvisingGUI(advisor);
        this.gui.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello World!");
        new OOP2Project("src\\oop2project\\catalog.txt");
    }
    
}
