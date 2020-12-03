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
        System.out.println(courseCode);
        String courseName = this.scanner.nextLine().trim();
        System.out.println(courseName);
        int credits = this.scanner.nextInt();
        System.out.println(credits);
        int level = this.scanner.nextInt();
        System.out.println(level);
        int numSemesters = this.scanner.nextInt();
        System.out.println(numSemesters);
        int[] availableSemesters = new int[numSemesters];
        for (int i = 0; i < numSemesters; i++)
            availableSemesters[i] = this.scanner.nextInt();
        Course course = new Course(courseCode, courseName, credits, level, availableSemesters);
        this.courses.put(courseCode, course);
        int numPrereqs = this.scanner.nextInt();
        System.out.println(numPrereqs);
        this.numPrerequisites.put(course, numPrereqs);
        this.prerequisites.put(course, new ArrayList<>());
        if (numPrereqs > 0)
            for (String prerequisite : scanner.nextLine().trim().split(" "))
                prerequisites.get(course).add(prerequisite);
    }
    
    private void setPrerequisites(Course course) {
        Requirement prereqs = new RequirementOption(3 * this.numPrerequisites.get(course));
        for (String prereq : this.prerequisites.get(course)) {
            if (!this.courses.containsKey(prereq))
                System.out.println("XXXXXXXXXXXXXX");
            else
                prereqs.addSubRequirement(this.courses.get(prereq));
        }
        course.addPrerequisite(prereqs);
    }
}
