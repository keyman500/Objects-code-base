package oop2project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Provides recommendations
 * @author Marc
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
    
    /**
     * Set the semester on which you want to get recommendations for
     * @param semester 
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    /**
     * Set the courses you have completed
     * @param courses 
     */
    public void setCoursesCompleted(List<Course> courses) {
        this.coursesCompleted = courses;
    }
    
    /**
     * Set the degree you want to get recommendations for
     * @param degree 
     */
    public void setDegree(DegreeProgram degree) {
        this.degree = degree;
    }
    
    /**
     * Gets courses that you are still required to do and their prerequisites
     * Sorts them somewhat according to relevance
     * With compulsory courses given a higher priority
     * And courses of a lower level also given a higher priority
     * @return a string providing recommendations
     */
    public String getRecommendations() {
        Requirement missingRequirements = this.degree.getMissingComponents(this.coursesCompleted);
        List<Course> missingCourses = new ArrayList<>(missingRequirements.getMissingCompulsoryCourses(this.coursesCompleted));
        List<Course> missingOptionalCourses = new ArrayList<>(missingRequirements.getMissingOptionalCourses(this.coursesCompleted));
        Collections.sort(missingCourses, new CoursesLevelComparator());
        Collections.sort(missingOptionalCourses, new CoursesLevelComparator());
        int i = 0;
        while (missingCourses.size() < 10 && i < missingOptionalCourses.size()) {
            if (!missingCourses.contains(missingOptionalCourses.get(i))) {
                missingCourses.add(missingOptionalCourses.get(i));
            }
            i++;
        }
        String results = missingCourses.stream()
                .filter(course -> course.isAvailableIn(this.semester))
                .filter(course -> course.hasFulfilledPrerequisites(this.coursesCompleted))
                .limit(10)
                .map(course -> course.getCodeAndTitle() + "\n")
                .reduce("", (a, b) -> a+b);
        return results;
    }
}
