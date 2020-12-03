package oop2project;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Dion Recai
 */
public class Course implements Requirement {
    private String courseCode;
    private String courseTitle;
    private int credits;
    private int level;
    private Requirement prerequisites;
    private int[] availableSemesters;

    public Course(String courseCode, String courseTitle, int credits, int level, int[] semesters) {
            this.courseCode = courseCode;
            this.courseTitle = courseTitle;
            this.credits = credits;
            this.level = level;
            this.availableSemesters = semesters;
            this.prerequisites = new RequirementList();
    }
    
    public String getCodeAndTitle() {
        return this.courseCode + " " + this.courseTitle;
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public boolean isAvailableIn(int semester) {
        for (int i = 0; i < this.availableSemesters.length; i++)
            if (this.availableSemesters[i] == semester)
                return true;
        return false;
    }

    @Override
    public boolean isFulfilledBy(List<Course> coursesCompleted) {
    	return coursesCompleted.contains(this);
    }

    @Override
    public int getCreditsFulfilled(List<Course> coursesCompleted) {
        if (this.isFulfilledBy(coursesCompleted)) {
            return this.credits;
        } else {
            return 0;
        }
    }
    
    @Override
    public Requirement getMissingComponents(List<Course> coursesCompleted) {
    	if (this.isFulfilledBy(coursesCompleted)) {
            return new NoRequirement();
    	} else {
            return this;
        }
    }

    @Override
    public boolean addSubRequirement(Requirement requirement) {
        return false;
    }
    
    @Override
    public List<Course> getCompulsoryCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(this);
        for (Course course : this.prerequisites.getCompulsoryCourses()) {
            courses.addAll(course.getCompulsoryCourses());
        }
        return courses;
    }
    
    @Override
    public List<Course> getOptionalCourses() {
        List<Course> courses = new ArrayList<>();
        for (Course course : this.prerequisites.getOptionalCourses()) {
            courses.addAll(course.getCompulsoryCourses());
            courses.addAll(course.getOptionalCourses());
        }
        return courses;
    }
    
    public void addPrerequisite(Requirement prerequisite) {
        this.prerequisites.addSubRequirement(prerequisite);
    }

    public boolean hasFulfilledPrerequisites(List<Course> coursesCompleted) {
    	return this.prerequisites.isFulfilledBy(coursesCompleted);
    }

    public Requirement getMissingPrerequisites(List<Course> coursesCompleted) {
    	return this.prerequisites.getMissingComponents(coursesCompleted);
    }

    @Override
    public boolean equals(Object o) {
  		if (o == this) {
            return true;
        }
        if (!(o instanceof Course)) {
            return false;
        }
        Course c = (Course) o;
        return this.courseCode.equals(c.courseCode);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.courseCode);
        return hash;
    }

}
