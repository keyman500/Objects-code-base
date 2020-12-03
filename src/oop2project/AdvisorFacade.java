package oop2project;

/**
 *
 * @author Dion Recai
 */
public interface AdvisorFacade {
	public List<DegreeProgram> getDegrees();
	public void setDegree(DegreeProgram degree);
	public void setSemester(int semester);
	public List<Course> getCourses();
	public setCoursesDone(List<Course>);
	public String getRecommendation();
}
