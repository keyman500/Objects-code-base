package oop2project;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author Dion Recai
 */
public class NoRequirement implements Requirement {

    @Override
    public boolean isFulfilledBy(List<Course> coursesCompleted) {
        return true;
    }

    @Override
    public int getCreditsFulfilled(List<Course> coursesCompleted) {
        return 0;
    }

    @Override
    public Requirement getMissingComponents(List<Course> coursesCompleted) {
        return this;
    }

    @Override
    public boolean addSubRequirement(Requirement requirement) {
        return false;
    }
    
    @Override
    public Set<Course> getMissingCompulsoryCourses(List<Course> coursesCompleted) {
        return new HashSet<>();
    }

    @Override
    public Set<Course> getMissingOptionalCourses(List<Course> coursesCompleted) {
        return new HashSet<>();
    }
    
}
