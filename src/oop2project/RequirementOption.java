package oop2project;

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
    }

    @Override
    public boolean isFulfilledBy(List<Course> coursesCompleted) {
        int creditsFulfilled = this.options.stream()
                .filter(r -> r.isFulfilledBy(coursesCompleted))
                .map(r -> r.getCreditsFulfilled(coursesCompleted))
                .reduce(0, (a, b) -> a + b);
        return creditsFulfilled > this.requiredCredits;
    }

    @Override
    public int getCreditsFulfilled(List<Course> coursesCompleted) {
        int creditsFulfilled = this.options.stream()
                .filter(r -> r.isFulfilledBy(coursesCompleted))
                .map(r -> r.getCreditsFulfilled(coursesCompleted))
                .reduce(0, (a, b) -> a + b);
        if (creditsFulfilled >= this.requiredCredits) {
            return this.requiredCredits;
        } else {
            return creditsFulfilled;
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
    
}
