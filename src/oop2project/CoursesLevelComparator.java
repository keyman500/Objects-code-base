package oop2project;

import java.util.Comparator;

/**
 * Compare courses according to their level then by code and title
 * Used to pick best recommendations by choosing earlier level courses.
 * @author Marc
 */
public class CoursesLevelComparator implements Comparator<Course> {
    @Override
    public int compare(Course c1, Course c2) {
        int levelCmp = Integer.compare(c1.getLevel(), c2.getLevel());
        if (levelCmp != 0)
            return levelCmp;
        return c1.getCodeAndTitle().compareTo(c2.getCodeAndTitle());
    }
}
