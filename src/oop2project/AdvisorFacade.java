package oop2project;

import java.util.List;

/**
 *
 * @author Dion Recai
 */
public interface AdvisorFacade {
	public List<DegreeProgram> getDegrees();
	public void setDegree(DegreeProgram degree);
	public void setSemester(int semester);
	public List<Course> getCourses();
	public void setCoursesDone(List<Course> courses);
	public String getRecommendation();
}
