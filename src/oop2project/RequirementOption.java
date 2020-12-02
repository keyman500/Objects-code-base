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
    public List<Requirement> getMissingComponents(List<Course> coursesCompleted) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addSubRequirement(Requirement requirement) {
        this.options.add(requirement);
        return true;
    }
    
}
