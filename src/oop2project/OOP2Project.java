/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
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
