package oop2project;

import java.util.List;
import java.util.Set;

/**
 *
 * @author Dion Recai
 */
public interface Requirement {

    /**
     *
     * @param coursesCompleted
     * @return
     */
    public boolean isFulfilledBy(List<Course> coursesCompleted);
    public int getCreditsFulfilled(List<Course> coursesCompleted);

    /**
     *
     * @param coursesCompleted
     * @return
     */
    public Requirement getMissingComponents(List<Course> coursesCompleted);

    /**
     *
     * @param requirement
     * @return
     */
    public boolean addSubRequirement(Requirement requirement);
    public Set<Course> getMissingCompulsoryCourses(List<Course> coursesCompleted);
    public Set<Course> getMissingOptionalCourses(List<Course> coursesCompleted);
}
