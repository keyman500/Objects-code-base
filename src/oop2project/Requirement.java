package oop2project;

import java.util.List;
import java.util.Set;

/**
 *
 * @author Dion Recai
 */
public interface Requirement {
    public boolean isFulfilledBy(List<Course> coursesCompleted);
    public int getCreditsFulfilled(List<Course> coursesCompleted);
    public Requirement getMissingComponents(List<Course> coursesCompleted);
    public boolean addSubRequirement(Requirement requirement);
    public Set<Course> getMissingCompulsoryCourses(List<Course> coursesCompleted);
    public Set<Course> getMissingOptionalCourses(List<Course> coursesCompleted);
}
