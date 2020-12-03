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
    private CourseCatalog catalog;
    private Recommender recommender;
    private AdvisingGUI gui;
    
    public OOP2Project(String filePath) {
        CatalogReader reader;
        try {
            reader = new CatalogReader(new Scanner(new File(filePath)));
        } catch (FileNotFoundException error) {
            return;
        }
        this.catalog = new CourseCatalog(reader.readAndGetCourses());
        this.catalog.getAllCourses().forEach(c -> System.out.println(c.getCodeAndTitle()));
        this.recommender = new Recommender(DegreeProgram.getDegreeProgramAMajor(this.catalog));
        List<Course> coursesCompleted = new ArrayList<>();
        coursesCompleted.add(this.catalog.getCourseByCode("COMP1600"));
        coursesCompleted.add(this.catalog.getCourseByCode("COMP1601"));
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
        new OOP2Project("src\\oop2project\\catalog.txt");
    }
    
}
