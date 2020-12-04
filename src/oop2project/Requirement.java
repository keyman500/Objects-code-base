package oop2project;

import java.util.List;
import java.util.Set;

/**
 * An interface to model a requirement
 * Used in a Composite Pattern to model how different requirements have sub requirements.
 * @author Dion Recai
 */
public interface Requirement {

    /**
     *
     * @param coursesCompleted
     * @return if the list of courses fulfills this requirement
     */
    public boolean isFulfilledBy(List<Course> coursesCompleted);
    
    /**
     * 
     * @param coursesCompleted
     * @return the number of credits from the requirement that the courses fulfill.
     */
    public int getCreditsFulfilled(List<Course> coursesCompleted);

    /**
     *
     * @param coursesCompleted
     * @return the missing sub requirements as a requirement object
     */
    public Requirement getMissingComponents(List<Course> coursesCompleted);

    /**
     * Add a sub requirement to the requirement object
     * @param requirement
     * @return true if successful or false if not
     */
    public boolean addSubRequirement(Requirement requirement);
    
    /**
     * 
     * @param coursesCompleted
     * @return a set of the missing courses which are compulsory to meet this requirement
     */
    public Set<Course> getMissingCompulsoryCourses(List<Course> coursesCompleted);
    
    /**
     * 
     * @param coursesCompleted
     * @return a set of the missing courses which are can optionally be used to meet this requirement
     */
    public Set<Course> getMissingOptionalCourses(List<Course> coursesCompleted);
}
