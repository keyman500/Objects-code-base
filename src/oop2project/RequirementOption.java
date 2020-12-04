package oop2project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A requirement which with sub-requirements which are optional
 * Only a specific number of credits from the sub-requirements must be fulfilled to meet this requirement
 * @author Dion Recai
 */
public class RequirementOption implements Requirement {
    private int requiredCredits;
    private List<Requirement> options;
    
    /**
     * Construct a RequirementOption
     * @param credits the number of credits required to meet this requirement
     */
    public RequirementOption(int credits) {
        this.requiredCredits = credits;
        this.options = new ArrayList<>();
    }

    /**
     * Checks if the requirement is fulfilled by checking if the number of credits matches the required number
     * @param coursesCompleted
     * @return 
     */
    @Override
    public boolean isFulfilledBy(List<Course> coursesCompleted) {
        return this.getCreditsFulfilled(coursesCompleted) == this.requiredCredits;
    }

    /**
     * Get the number of credits from sub-requirements that are fulfilled
     * Up to a maximum being the required number of credits needed to meet this requirement
     * @param coursesCompleted
     * @return 
     */
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

    /**
     * Get the missing sub-requirements as a RequirementOption
     * which contains the number of credits missing
     * and the options which could be used ti make up those missing credits
     * @param coursesCompleted
     * @return 
     */
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

    /**
     * Add another optional sub-requirement
     * @param requirement
     * @return true
     */
    @Override
    public boolean addSubRequirement(Requirement requirement) {
        this.options.add(requirement);
        return true;
    }
    
    /**
     * Since this class models optional sub-requirement there ar no compulsory courses
     * @param coursesCompleted
     * @return an empty set
     */
    @Override
    public Set<Course> getMissingCompulsoryCourses(List<Course> coursesCompleted) {
        return new HashSet<>();
    }

    /**
     * Get all the courses which are part of pone of the optional sub-requirements
     * @param coursesCompleted
     * @return 
     */
    @Override
    public Set<Course> getMissingOptionalCourses(List<Course> coursesCompleted) {
        Set<Course> courses = new HashSet<>();
        for (Requirement requirement : this.options) {
            courses.addAll(requirement.getMissingCompulsoryCourses(coursesCompleted));
            courses.addAll(requirement.getMissingOptionalCourses(coursesCompleted));
        }
        return courses;
    }
}
