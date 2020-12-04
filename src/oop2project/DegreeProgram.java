package oop2project;

/**
 * Represents a Degree Program entity
 * Also acts as a singleton with two instances
 * One instance for the CS Major Degree
 * And another for the IT Major Degree
 * Extends RequirementList since a DegreeProgram has a list of requirements
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
    
    /**
     *
     * @return the name of the program
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Get the CS Major Degree program
     * Initialize it if it has not already been
     * @param catalog
     * @return 
     */
    public static DegreeProgram getDegreeProgramCSMajor(CourseCatalog catalog) {
        if (CS_MAJOR == null) {
            CS_MAJOR = new DegreeProgram("Major in Computer Science");
            String requiredCourses[] = {
                "COMP1600", "COMP1601", "COMP1602", "COMP1603", "COMP2601",
                "COMP2602", "COMP2605", "COMP2611", "COMP2603", "COMP2604",
                "FOUN1101", "FOUN1105", "FOUN1301"
            };
            for (String code : requiredCourses)
                CS_MAJOR.addSubRequirement(catalog.getCourseByCode(code));
            String electiveCourses[] = {
                "COMP3602", "COMP3603", "COMP3605", "COMP3606", "COMP3607",
                "COMP3613", "INFO2605", "INFO3600", "INFO3605", "MATH2250",
                "COMP2606", "COMP3601", "COMP3609", "COMP3610", "COMP3611",
                "INFO2602", "INFO2604", "INFO3604", "INFO3606", "INFO3607",
                "INFO3608", "INFO3609", "INFO3610"
            };
            Requirement electives = new RequirementOption(12);
            for (String code : electiveCourses)
                electives.addSubRequirement(catalog.getCourseByCode(code));
            CS_MAJOR.addSubRequirement(electives);
        }
        return CS_MAJOR;
    }
    
    /**
     * 
     * Get the IT Major Degree program
     * Initialize it if it has not already been
     * @param catalog
     * @return 
     */
    public static DegreeProgram getDegreeProgramITMajor(CourseCatalog catalog) {
        if (IT_MAJOR == null) {
            IT_MAJOR = new DegreeProgram("Major in Computer Science");
            String requiredCourses[] = {
                "INFO1600", "COMP1601", "COMP1602", "INFO1601", "INFO2601",
                "INFO2602", "COMP2605", "INFO2600", "INFO2603", "INFO2604",
                "FOUN1101", "FOUN1105", "FOUN1301"
            };
            for (String code : requiredCourses)
                IT_MAJOR.addSubRequirement(catalog.getCourseByCode(code));
            String electiveCourses[] = {
                "COMP3605", "INFO2605", "INFO3605", "MATH2250", "COMP3610",
                "INFO3606", "INFO3607", "INFO3608", "INFO3609", "INFO3610"
            };
            Requirement electives = new RequirementOption(12);
            for (String code : electiveCourses)
                electives.addSubRequirement(catalog.getCourseByCode(code));
            IT_MAJOR.addSubRequirement(electives);
        }
        return IT_MAJOR;
    }
    
}
