package oop2project;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Dion Recai
 */
public class Course implements Requirement {

    @Override
    public boolean isFulfilledBy(List<Course> coursesCompleted) {
    	return coursesCompleted.contains(this);
    }

    @Override
    public List<Requirement> getMissingComponents(List<Course>) {
    	List<Requirement> missingCourses = new ArrayList<>();
    	if (!coursesCompleted.contains(this)) {
    		missingCourses.add(this);
    	}
    	return missingCourses;
    }
    
}
