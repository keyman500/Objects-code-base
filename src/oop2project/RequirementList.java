package oop2project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A requirement which consists of a list of compulsory sub-requirements
 * @author Dion Recai
 */
public class RequirementList implements Requirement {
    private List<Requirement> subrequirements;
    
    /**
     * Construct a new RequirementList
     * 
     */
    public RequirementList() {
        this.subrequirements = new ArrayList<>();
    }

    /**
     * 
     * @param coursesCompleted
     * @return true if all the sub-requirements are fulfilled; false otherwise
     */
    @Override
    public boolean isFulfilledBy(List<Course> coursesCompleted) {
        return this.subrequirements.stream().allMatch(r -> r.isFulfilledBy(coursesCompleted));
    }
    
    /**
     * 
     * @param coursesCompleted
     * @return the number of credits from the sub-requirements that are fulfilled
     */
    @Override
    public int getCreditsFulfilled(List<Course> coursesCompleted) {
        return this.subrequirements.stream()
                .map(r -> r.getCreditsFulfilled(coursesCompleted))
                .reduce(0, (a, b) -> a + b);
    }

    /**
     * 
     * @param coursesCompleted
     * @return the sub-requirements that are not fulfilled packed into another RequirementList object
     */
    @Override
    public Requirement getMissingComponents(List<Course> coursesCompleted) {
        if (this.isFulfilledBy(coursesCompleted)) {
            return new NoRequirement();
        }
        Requirement missingRequirements = new RequirementList();
        this.subrequirements.forEach(r ->
                missingRequirements.addSubRequirement(
                        r.getMissingComponents(coursesCompleted)));
        return missingRequirements;
    }

    /**
     * Adds a sub-requirement
     * @param requirement
     * @return true
     */
    @Override
    public boolean addSubRequirement(Requirement requirement) {
        this.subrequirements.add(requirement);
        return true;
    }
    
    /**
     * 
     * @param coursesCompleted
     * @return a set of the missing courses which are compulsory to meet this requirement
     */
    @Override
    public Set<Course> getMissingCompulsoryCourses(List<Course> coursesCompleted) {
        Set<Course> courses = new HashSet<>();
        for (Requirement requirement : this.subrequirements) {
            courses.addAll(requirement.getMissingCompulsoryCourses(coursesCompleted));
        }
        return courses;
    }

    /**
     * 
     * @param coursesCompleted
     * @return  a set of the missing courses which are can optionally be used to meet this requirement
     */
    @Override
    public Set<Course> getMissingOptionalCourses(List<Course> coursesCompleted) {
        Set<Course> courses = new HashSet<>();
        for (Requirement requirement : this.subrequirements) {
            courses.addAll(requirement.getMissingOptionalCourses(coursesCompleted));
        }
        return courses;
    }
}
