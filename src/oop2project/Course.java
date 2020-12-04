package oop2project;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    
    /**
     *
     * @param semester
     * @return
     */
    public boolean isAvailableIn(int semester) {
        for (int i = 0; i < this.availableSemesters.length; i++)
            if (this.availableSemesters[i] == semester)
                return true;
        return false;
    }

    /**
     *
     * @param coursesCompleted
     * @return
     */
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
    
    /**
     *
     * @param coursesCompleted
     * @return
     */
    @Override
    public Requirement getMissingComponents(List<Course> coursesCompleted) {
    	if (this.isFulfilledBy(coursesCompleted)) {
            return new NoRequirement();
    	} else {
            return this;
        }
    }

    /**
     *
     * @param requirement
     * @return
     */
    @Override
    public boolean addSubRequirement(Requirement requirement) {
        return false;
    }
    
    @Override
    public Set<Course> getMissingCompulsoryCourses(List<Course> coursesCompleted) {
        Set<Course> courses = new HashSet<>();
        if (!this.isFulfilledBy(coursesCompleted)) {
            courses.add(this);
            courses.addAll(this.prerequisites.getMissingCompulsoryCourses(coursesCompleted));
        }
        return courses;
    }
    
    @Override
    public Set<Course> getMissingOptionalCourses(List<Course> coursesCompleted) {
        Set<Course> courses = new HashSet<>();
        if (!this.isFulfilledBy(coursesCompleted)) {
            courses.addAll(this.prerequisites.getMissingOptionalCourses(coursesCompleted));
        }
        return courses;
    }
    
    /**
     *
     * @param prerequisite
     */
    public void addPrerequisite(Requirement prerequisite) {
        this.prerequisites.addSubRequirement(prerequisite);
    }

    /**
     *
     * @param coursesCompleted
     * @return
     */
    public boolean hasFulfilledPrerequisites(List<Course> coursesCompleted) {
    	return this.prerequisites.isFulfilledBy(coursesCompleted);
    }

    public Requirement getMissingPrerequisites(List<Course> coursesCompleted) {
    	return this.prerequisites.getMissingComponents(coursesCompleted);
    }

    /**
     *
     * @param o
     * @return
     */
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
