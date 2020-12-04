package oop2project;

import java.util.List;

/**
 * Uses the Facade Pattern to hide the internals of the recommendation system.
 * @author Marc
 */
public interface AdvisorFacade {
    /**
     *
     * @return the list of degrees available.
     */
    public List<DegreeProgram> getDegrees();

    /**
     * Set the degree that you want a recommendation for.
     * @param degree
     */
    public void setDegree(DegreeProgram degree);
    
    /**
     * Set the semester that you want a recommendation for.
     * @param semester
     */
    public void setSemester(int semester);
    
    /**
     * 
     * @return a list of all the courses available.
     */
    public List<Course> getCourses();
    
    /**
     * Set the courses that you have completed to get a recommendation.
     * @param courses 
     */
    public void setCoursesDone(List<Course> courses);
    
    /**
     * 
     * @return a string presenting advice on what courses to pursue.
     */
    public String getRecommendation();
}
