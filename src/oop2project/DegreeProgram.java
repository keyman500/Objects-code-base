package oop2project;

/**
 *
 * @author Dion Recai
 */
public class DegreeProgram extends RequirementList {
    private static DegreeProgram CS_MAJOR;
    private static DegreeProgram IT_MAJOR;
    private static DegreeProgram A_MAJOR;
    private String name;
    
    private DegreeProgram(String name) {
        super();
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public static DegreeProgram getDegreeProgramCSMajor(CourseCatalog catalog) {
        if (CS_MAJOR == null) {
            CS_MAJOR = new DegreeProgram("Major in Computer Science");
            String requiredCourses[] = {
                "COMP1600", "COMP1601", "COMP1602", "COMP1603", "COMP2601",
                "COMP2602", "COMP2605", "COMP2611", "COMP2603", "COMP2604"
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
    
    public static DegreeProgram getDegreeProgramITMajor(CourseCatalog catalog) {
        if (IT_MAJOR == null) {
            IT_MAJOR = new DegreeProgram("Major in Computer Science");
            String requiredCourses[] = {
                "INFO1600", "COMP1601", "COMP1602", "INFO1601", "INFO2601",
                "INFO2602", "COMP2605", "INFO2600", "INFO2603", "INFO2604"
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
    
    public static DegreeProgram getDegreeProgramAMajor(CourseCatalog catalog) {
        if (A_MAJOR == null) {
            A_MAJOR = new DegreeProgram("Test Major");
            String requiredCourses[] = {
                "COMP1600", "COMP1601"
            };
            for (String code : requiredCourses) {
                Course course = catalog.getCourseByCode(code);
                A_MAJOR.addSubRequirement(course);
            }
            String electiveCourses[] = {
                "COMP1602", "COMP1603"
            };
            Requirement electives = new RequirementOption(3);
            for (String code : electiveCourses) {
                Course course = catalog.getCourseByCode(code);
                electives.addSubRequirement(course);
            }
            A_MAJOR.addSubRequirement(electives);
        }
        return A_MAJOR;
    }
}
