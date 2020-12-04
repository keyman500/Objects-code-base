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
 * @author Marc
 */
public class Advisor implements AdvisorFacade{
    CourseCatalog catalog;
    Recommender recommender;
    DegreeProgram d;
    
    Advisor(){
      CatalogReader reader;
        try {
            reader = new CatalogReader(new Scanner(new File(filePath)));
        } catch (FileNotFoundException error) {
            return;
        }
        this.catalog = new CourseCatalog(reader.readAndGetCourses());
  
    }
    
    public List<DegreeProgram> getDegrees(){
    ArrayList<DegreeProgram> degrees = new ArrayList<DegreeProgram>(); 
degrees.add(d.getDegreeProgramCSMajor(this.catalog));
degrees.add(d.getDegreeProgramITMajor(this.catalog));
return degrees;
}
  
	public void setDegree(DegreeProgram degree){
            this.recommender = new Recommender(degree);
        }
	public void setSemester(int semester){
            this.recommender.setSemester(semester);
        }
	public List<Course> getCourses(){
        }
	public void setCoursesDone(List<Course> courses){
            this.recommender.setCoursesCompleted(courses);
        }
	public String getRecommendation(){
            return this.recommender.getRecommendations();
        }
    
}
