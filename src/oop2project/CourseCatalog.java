package oop2project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dion Recai
 */
public class CourseCatalog {
    private Map<String, Course> courses;
    
    public CourseCatalog(Map<String, Course> courses) {
        this.courses = courses;
    }
    
    public List<Course> getAllCourses() {
        return new ArrayList<>(this.courses.values());
    }
    
    public Course getCourseByCode(String courseCode) {
        return this.courses.get(courseCode);
    }
}
