package oop2project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Dion Recai
 */
public class CatalogReader {
    private Scanner scanner;
    private Map<String, Course> courses;
    private Map<Course, List<String>> prerequisites;
    private Map<Course, Integer> numPrerequisites;
    
    /**
     *
     * @param scanner
     */
    public CatalogReader(Scanner scanner) {
        this.scanner = scanner;
        this.courses = new HashMap<>();
        this.prerequisites = new HashMap<>();
        this.numPrerequisites = new HashMap<>();
    }
    
    public Map<String, Course> readAndGetCourses() {
        while (this.scanner.hasNext())
            this.readOneCourse();
        for (Course course : prerequisites.keySet())
            this.setPrerequisites(course);
        return this.courses;
    }
    
    private void readOneCourse() {
        String courseCode = this.scanner.next();
        String courseName = this.scanner.nextLine().trim();
        int credits = this.scanner.nextInt();
        int level = this.scanner.nextInt();
        int numSemesters = this.scanner.nextInt();
        int[] availableSemesters = new int[numSemesters];
        for (int i = 0; i < numSemesters; i++)
            availableSemesters[i] = this.scanner.nextInt();
        Course course = new Course(courseCode, courseName, credits, level, availableSemesters);
        this.courses.put(courseCode, course);
        int numPrerequisiteCredits = this.scanner.nextInt();
        this.numPrerequisites.put(course, numPrerequisiteCredits);
        this.prerequisites.put(course, new ArrayList<>());
        if (numPrerequisiteCredits > 0)
            for (String prerequisite : scanner.nextLine().trim().split(" "))
                prerequisites.get(course).add(prerequisite);
    }
    
    private void setPrerequisites(Course course) {
        Requirement prereqs = new RequirementOption(this.numPrerequisites.get(course));
        for (String prereq : this.prerequisites.get(course)) {
            prereqs.addSubRequirement(this.courses.get(prereq));
        }
        course.addPrerequisite(prereqs);
    }
}
