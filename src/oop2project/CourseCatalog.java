package oop2project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A store of all the courses available
 * @author Dion Recai
 */
public class CourseCatalog {
    private Map<String, Course> courses;
    
    /**
     *
     * @param courses
     */
    public CourseCatalog(Map<String, Course> courses) {
        this.courses = courses;
    }
    
    /**
     * 
     * @return List of all courses
     */
    public List<Course> getAllCourses() {
        return new ArrayList<>(this.courses.values());
    }
    
    /**
     * Get a Course object from its code
     * @param courseCode
     * @return 
     */
    public Course getCourseByCode(String courseCode) {
        return this.courses.get(courseCode);
    }
}
