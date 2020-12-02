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
    public List<Requirement> getMissingComponents(List<Course> coursesCompleted) {
        List<Requirement> missingComponents = new ArrayList<>();
        this.subrequirements.forEach(req -> {
            missingComponents.addAll(req.getMissingComponents(coursesCompleted));
        });
        return missingComponents;
    }

    @Override
    public boolean addSubRequirement(Requirement requirement) {
        this.subrequirements.add(requirement);
        return true;
    }
}
