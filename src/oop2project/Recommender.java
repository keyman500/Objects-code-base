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
        missingCourses.addAll(missingOptionalCourses.subList(0, 6-missingCourses.size()));
        String results = "Recommended Courses For You:\n";
        for (Course course : missingCourses.subList(0, 6))
            results += course.getCodeAndTitle() + "\n";
        return results;
    }
}
