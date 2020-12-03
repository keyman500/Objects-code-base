/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2project;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author David
 */
public class OOP2Project {
    private CourseCatalog catalog;
    private Recommender recommender;
    private AdvisingGUI gui;
    
    public OOP2Project() {
        CourseCatalog.setCatalog("src\\oop2project\\catalog.txt");
        this.catalog = CourseCatalog.getCatalog();
        this.recommender = new Recommender(DegreeProgram.getDegreeProgramAMajor());
        List<Course> coursesCompleted = new ArrayList<>();
        coursesCompleted.add(this.catalog.getCourseByCode("COMP1600"));
        this.recommender.setSemester(2);
        this.recommender.setCoursesCompleted(coursesCompleted);
        System.out.println(this.recommender.getRecommendations());
        this.gui = new AdvisingGUI();
        this.gui.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello World!");
        new OOP2Project();
    }
    
}
