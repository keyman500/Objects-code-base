package oop2project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dion Recai
 */
public class RequirementOption implements Requirement {
    private int requiredCredits;
    private List<Requirement> options;
    
    public RequirementOption(int credits) {
        this.requiredCredits = credits;
        this.options = new ArrayList<>();
    }

    @Override
    public boolean isFulfilledBy(List<Course> coursesCompleted) {
        return this.getCreditsFulfilled(coursesCompleted) == this.requiredCredits;
    }

    @Override
    public int getCreditsFulfilled(List<Course> coursesCompleted) {
        int fulfilledCredits = 0;
        for (Requirement requirement : this.options) {
            if (requirement.isFulfilledBy(coursesCompleted)) {
                fulfilledCredits += requirement.getCreditsFulfilled(coursesCompleted);
            }
        }
        if (fulfilledCredits >= this.requiredCredits) {
            return this.requiredCredits;
        } else {
            return fulfilledCredits;
        }
    }

    @Override
    public Requirement getMissingComponents(List<Course> coursesCompleted) {
        if (this.isFulfilledBy(coursesCompleted)) {
            return new NoRequirement();
        }
        int missingCredits = this.requiredCredits - this.getCreditsFulfilled(coursesCompleted);
        Requirement missingRequirements = new RequirementOption(missingCredits);
        this.options.stream()
                .filter(o -> !o.isFulfilledBy(coursesCompleted))
                .forEach(o -> missingRequirements.addSubRequirement(o));
        return missingRequirements;
    }

    @Override
    public boolean addSubRequirement(Requirement requirement) {
        this.options.add(requirement);
        return true;
    }
    
    @Override
    public List<Course> getCompulsoryCourses() {
        return new ArrayList<>();
    }

    @Override
    public List<Course> getOptionalCourses() {
        List<Course> courses = new ArrayList<>();
        for (Requirement requirement : this.options) {
            courses.addAll(requirement.getCompulsoryCourses());
            courses.addAll(requirement.getOptionalCourses());
        }
        return courses;
    }
}
