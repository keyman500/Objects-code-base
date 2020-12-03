package oop2project;

/**
 *
 * @author Dion Recai
 */
public class DegreeProgram extends RequirementList {
    private static DegreeProgram CS_MAJOR;
    private static DegreeProgram IT_MAJOR;
    private String name;
    
    private DegreeProgram(String name) {
        super();
        this.name = name;
    }
    
    public static DegreeProgram getDegreeProgramCSMajor() {
        if (CS_MAJOR == null) {
            CS_MAJOR = new DegreeProgram("Major in Computer Science");
            String requiredCourses[] = {
                "COMP1600", "COMP1601", "COMP1602", "COMP1603", "COMP2601",
                "COMP1602", "COMP2605", "COMP2611", "COMP2603", "COMP2604"
            };
            for (String code : requiredCourses)
                CS_MAJOR.addSubRequirement(CourseCatalog.getCatalog().getCourseByCode(code));
            String electiveCourses[] = {
                "COMP3602", "COMP3603", "COMP3605", "COMP3606", "COMP3607",
                "COMP3613", "INFO2605", "INFO3600", "INFO3605", "MATH2250",
                "COMP2602", "COMP3601", "COMP3609", "COMP3610", "COMP3611",
                "INFO2602", "INFO2604", "INFO3604", "INFO3606", "INFO3607",
                "INFO3608", "INFO3609", "INFO3610"
            };
            Requirement electives = new RequirementOption(12);
            for (String code : electiveCourses)
                electives.addSubRequirement(CourseCatalog.getCatalog().getCourseByCode(code));
            CS_MAJOR.addSubRequirement(electives);
        }
        return CS_MAJOR;
    }
    
    public static DegreeProgram getDegreeProgramITMajor() {
        return null;
    }
}
