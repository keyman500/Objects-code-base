package oop2project;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * An empty sentinel Requirement class
 * @author Dion Recai
 */
public class NoRequirement implements Requirement {

    /**
     * Trivially fulfilled
     * @param coursesCompleted
     * @return
     */
    @Override
    public boolean isFulfilledBy(List<Course> coursesCompleted) {
        return true;
    }

    /**
     * No credits are awarded
     * @param coursesCompleted
     * @return
     */
    @Override
    public int getCreditsFulfilled(List<Course> coursesCompleted) {
        return 0;
    }

    /**
     * There are no missing components
     * @param coursesCompleted
     * @return 
     */
    @Override
    public Requirement getMissingComponents(List<Course> coursesCompleted) {
        return this;
    }

    /**
     * Cannot add a subrequirement
     * @param requirement
     * @return
     */
    @Override
    public boolean addSubRequirement(Requirement requirement) {
        return false;
    }
    
    /**
     * 
     * There are no missing courses
     * @param coursesCompleted
     * @return 
     */
    @Override
    public Set<Course> getMissingCompulsoryCourses(List<Course> coursesCompleted) {
        return new HashSet<>();
    }

    /**
     * 
     * There are no missing courses
     * @param coursesCompleted
     * @return 
     */
    @Override
    public Set<Course> getMissingOptionalCourses(List<Course> coursesCompleted) {
        return new HashSet<>();
    }
    
}
