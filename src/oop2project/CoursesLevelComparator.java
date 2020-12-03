package oop2project;

import java.util.Comparator;

/**
 *
 * @author Dion Recai
 */
public class CoursesLevelComparator implements Comparator<Course> {
    @Override
    public int compare(Course c1, Course c2) {
        return c1.getLevel() - c2.getLevel();
    }
}
