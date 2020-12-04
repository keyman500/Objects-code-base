package oop2project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Implements the AdvisorFacade interface.
 * Uses a CourseCatalog and a Recommender to implement the methods.
 * @author Marc
 */
public class Advisor implements AdvisorFacade {
    CourseCatalog catalog;
    Recommender recommender;
    
    /**
     * Construct an Advisor instance using the list of courses data found in the file
     * specified by the parameter
     * @param filePath path to the file containing the course data
     */
    Advisor(String filePath) {
      CatalogReader reader;
        try {
            reader = new CatalogReader(new Scanner(new File(filePath)));
        } catch (FileNotFoundException error) {
            return;
        }
        this.catalog = new CourseCatalog(reader.readAndGetCourses());
        this.recommender = new Recommender(DegreeProgram.getDegreeProgramCSMajor(this.catalog));
  
    }
    /**
     * 
     * @return a list of DegreeProgram available
     */
    @Override
    public List<DegreeProgram> getDegrees(){
        ArrayList<DegreeProgram> degrees = new ArrayList<>(); 
        degrees.add(DegreeProgram.getDegreeProgramCSMajor(this.catalog));
        degrees.add(DegreeProgram.getDegreeProgramITMajor(this.catalog));
        return degrees;
    }
  
    /**
     * Set the degree you would like to be advised on.
     * @param degree
     */
    @Override
    public void setDegree(DegreeProgram degree){
        this.recommender.setDegree(degree);
    }
    
    /**
     * Set the semester you would like to be advised on.
     * @param semester 
     */
    @Override
    public void setSemester(int semester){
        this.recommender.setSemester(semester);
    }
    
    /**
     * 
     * @return a list a of all available courses.
     */
    @Override
    public List<Course> getCourses(){
        return this.catalog.getAllCourses();
    }
    
    /**
     * Set the courses that you have already completed.
     * @param courses 
     */
    @Override
    public void setCoursesDone(List<Course> courses){
        this.recommender.setCoursesCompleted(courses);
    }
    
    /**
     * 
     * @return a string providing information on courses to choose.
     */
    @Override
    public String getRecommendation(){
        return this.recommender.getRecommendations();
    }
    
}
