package oop2project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Dion Recai
 */
public class Recommender {
    private DegreeProgram degree;
    private int semester;
    private List<Course> coursesCompleted;
    
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
    
    public String getRecommendations() {
        Requirement missingRequirements = this.degree.getMissingComponents(this.coursesCompleted);
        List<Course> missingCourses = missingRequirements.getCompulsoryCourses();
        List<Course> missingOptionalCourses = missingRequirements.getOptionalCourses();
        Collections.sort(missingCourses, new CoursesLevelComparator());
        Collections.sort(missingOptionalCourses, new CoursesLevelComparator());
        int i = 0;
        while (missingCourses.size() < 6 && i < missingOptionalCourses.size()) {
            missingCourses.add(missingOptionalCourses.get(i));
        }
        String results = "Recommended Courses For You:\n"
                + missingCourses.stream().limit(6)
                        .filter(course -> course.isAvailableIn(this.semester))
                        .map(course -> course.getCodeAndTitle() + "\n")
                        .reduce("", (a, b) -> String.join(a, b));
        return results;
    }
}
