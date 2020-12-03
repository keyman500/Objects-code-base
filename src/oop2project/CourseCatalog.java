package oop2project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Dion Recai
 */
public class CourseCatalog {
    private static CourseCatalog catalog;
    
    private Map<String, Course> courses;
    
    public static boolean setCatalog(String fileName) {
        if (catalog == null) {
            try {
                catalog = new CourseCatalog(fileName);
                return true;
            } catch (FileNotFoundException error) {
                catalog = null;
            }
        }
        return false;
    }
    
    public static CourseCatalog getCatalog() {
        return catalog;
    }
    
    private CourseCatalog(String fileName) throws FileNotFoundException {
        this.courses = new HashMap<>();
        this.readFileData(fileName);
    }
    
    public Course getCourseByCode(String courseCode) {
        return this.courses.get(courseCode);
    }
    
    private void readFileData(String fileName) throws FileNotFoundException {
        Map<Course, List<String>> prerequisites = new HashMap<>();
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String courseCode = scanner.next();
            String courseName = scanner.nextLine();
            int credits = scanner.nextInt();
            int level = scanner.nextInt();
            int numSemesters = scanner.nextInt();
            int numPrerequisites = scanner.nextInt();
            int[] availableSemesters = new int[numSemesters];
            for (int i = 0; i < numSemesters; i++)
                availableSemesters[i] = scanner.nextInt();
            Course course = new Course(courseCode, courseName, credits, level, availableSemesters);
            prerequisites.put(course, new ArrayList<>());
            for (int i = 0; i < numPrerequisites; i++)
                prerequisites.get(course).add(scanner.next());
        }
        for (Map.Entry<Course, List<String>> entry : prerequisites.entrySet()) {
            Course course = entry.getKey();
            for (String prerequisite : entry.getValue())
                if (this.courses.containsKey(prerequisite))
                    course.addPrerequisite(this.courses.get(prerequisite));
        }
    }
}
