package oop2project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dion Recai
 */
public class RequirementList implements Requirement {
    private List<Requirement> subrequirements;
    
    public RequirementList() {
        this.subrequirements = new ArrayList<>();
    }

    @Override
    public boolean isFulfilledBy(List<Course> coursesCompleted) {
        return this.subrequirements.stream().allMatch(r -> r.isFulfilledBy(coursesCompleted));
    }
    
    @Override
    public int getCreditsFulfilled(List<Course> coursesCompleted) {
        return this.subrequirements.stream()
                .map(r -> r.getCreditsFulfilled(coursesCompleted))
                .reduce(0, (a, b) -> a + b);
    }

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

    @Override
    public boolean addSubRequirement(Requirement requirement) {
        this.subrequirements.add(requirement);
        return true;
    }
    
    @Override
    public List<Course> getCompulsoryCourses() {
        List<Course> courses = new ArrayList<>();
        for (Requirement requirement : this.subrequirements) {
            courses.addAll(requirement.getCompulsoryCourses());
        }
        return courses;
    }

    @Override
    public List<Course> getOptionalCourses() {
        List<Course> courses = new ArrayList<>();
        for (Requirement requirement : this.subrequirements) {
            courses.addAll(requirement.getOptionalCourses());
        }
        return courses;
    }
}
