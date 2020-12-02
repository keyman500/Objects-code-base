package oop2project;

import java.util.List;

/**
 *
 * @author Dion Recai
 */
public interface Requirement {
    public boolean isFulfilledBy(List<Course> coursesCompleted);
    public int getCreditsFulfilled(List<Course> coursesCompleted);
    public List<Requirement> getMissingComponents(List<Course> coursesCompleted);
    public boolean addSubRequirement(Requirement requirement);
}
