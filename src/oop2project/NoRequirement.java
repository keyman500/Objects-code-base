package oop2project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dion Recai
 */
public class NoRequirement implements Requirement {

    @Override
    public boolean isFulfilledBy(List<Course> coursesCompleted) {
        return true;
    }

    @Override
    public int getCreditsFulfilled(List<Course> coursesCompleted) {
        return 0;
    }

    @Override
    public List<Requirement> getMissingComponents(List<Course> coursesCompleted) {
        return new ArrayList<>();
    }

    @Override
    public boolean addSubRequirement(Requirement requirement) {
        return false;
    }
    
}
