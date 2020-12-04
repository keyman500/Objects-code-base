package oop2project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 *
 * @author Dion Recai
 */
public class Recommender {
    private DegreeProgram degree;
    private int semester;
    private List<Course> coursesCompleted;
    
    /**
     *
     * @param degree
     */
    public Recommender(DegreeProgram degree) {
        this.degree = degree;
        this.semester = 1;
        this.coursesCompleted = new ArrayList<>();
    }
    
    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public void setCoursesCompleted(List<Course> courses) {
        this.coursesCompleted = courses;
    }
    
    /**
     *
     * @return
     */
    public String getRecommendations() {
        //this.coursesCompleted.forEach(c -> System.out.println(c.getCodeAndTitle()));
        Requirement missingRequirements = this.degree.getMissingComponents(this.coursesCompleted);
        List<Course> missingCourses = new ArrayList<>(missingRequirements.getMissingCompulsoryCourses(this.coursesCompleted));
        List<Course> missingOptionalCourses = new ArrayList<>(missingRequirements.getMissingOptionalCourses(this.coursesCompleted));
        Collections.sort(missingCourses, new CoursesLevelComparator());
        Collections.sort(missingOptionalCourses, new CoursesLevelComparator());
        //missingCourses.forEach(c -> System.out.println(c.getCodeAndTitle()));
        missingOptionalCourses.forEach(c -> System.out.println(c.getCodeAndTitle()));
        int i = 0;
        while (missingCourses.size() < 10 && i < missingOptionalCourses.size()) {
            if (!missingCourses.contains(missingOptionalCourses.get(i))) {
                missingCourses.add(missingOptionalCourses.get(i));
            }
            i++;
        }
        //missingCourses.forEach(c -> System.out.println(c.getCodeAndTitle()));
        String results = missingCourses.stream()
                .filter(course -> course.isAvailableIn(this.semester))
                .filter(course -> course.hasFulfilledPrerequisites(this.coursesCompleted))
                .limit(10)
                .map(course -> course.getCodeAndTitle() + "\n")
                .reduce("", (a, b) -> a+b);
        return results;
    }
}
