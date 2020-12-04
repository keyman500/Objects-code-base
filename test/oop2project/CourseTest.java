/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marc
 */
public class CourseTest {
    int[] semesters;
    Course c;
    public CourseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.semesters = new int[]{1};
        this.c = new Course("COMP1601","Programing 1",3,1,semesters);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCodeAndTitle method, of class Course.
     */
    @Test
    public void testGetCodeAndTitle() {
        System.out.println("getCodeAndTitle");
        Course instance = this.c;
        String expResult = "COMP1601 Programing 1";
        String result = instance.getCodeAndTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getLevel method, of class Course.
     */
    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        Course instance = this.c;
        int expResult = 1;
        int result = instance.getLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isAvailableIn method, of class Course.
     */
    @Test
    public void testIsAvailableIn() {
        System.out.println("isAvailableIn");
        int semester = 1;
        Course instance = this.c;
        boolean expResult = true;
        boolean result = instance.isAvailableIn(semester);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isFulfilledBy method, of class Course.
     */
    @Test
    public void testIsFulfilledBy() {
        System.out.println("isFulfilledBy");
        List<Course> coursesCompleted = new ArrayList<Course>();
        coursesCompleted.add(this.c);
        Course instance = this.c;
        boolean expResult = true;
        boolean result = instance.isFulfilledBy(coursesCompleted);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCreditsFulfilled method, of class Course.
     */
    @Test
    public void testGetCreditsFulfilled() {
        System.out.println("getCreditsFulfilled");
        List<Course> coursesCompleted = new ArrayList<Course>();
        coursesCompleted.add(this.c);
        Course instance = this.c;
        int expResult = 3;
        int result = instance.getCreditsFulfilled(coursesCompleted);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getMissingComponents method, of class Course.
     */
    @Test
    public void testGetMissingComponents() {
        System.out.println("getMissingComponents");
        List<Course> coursesCompleted = new ArrayList<Course>();
        coursesCompleted.add(this.c);
        Course instance = this.c;
        Requirement result = instance.getMissingComponents(coursesCompleted);
        assertThat(result, instanceOf(NoRequirement.class));
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addSubRequirement method, of class Course.
     */
    @Test
    public void testAddSubRequirement() {
        System.out.println("addSubRequirement");
        Requirement requirement = null;
        Course instance = this.c;
        boolean expResult = false;
        boolean result = instance.addSubRequirement(requirement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getMissingCompulsoryCourses method, of class Course.
     */
    @Test
    public void testGetMissingCompulsoryCourses() {
        System.out.println("getMissingCompulsoryCourses");
        List<Course> coursesCompleted = new ArrayList<Course>();
        coursesCompleted.add(this.c);
        Course instance = this.c;
        Set<Course> expResult = new HashSet<>();;
        Set<Course> result = instance.getMissingCompulsoryCourses(coursesCompleted);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getMissingOptionalCourses method, of class Course.
     */
    @Test
    public void testGetMissingOptionalCourses() {
        System.out.println("getMissingOptionalCourses");
        List<Course> coursesCompleted = new ArrayList<Course>();
        coursesCompleted.add(this.c);
        Course instance = this.c;
        Set<Course> expResult = new HashSet<>();
        Set<Course> result = instance.getMissingOptionalCourses(coursesCompleted);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }



    /**
     * Test of hasFulfilledPrerequisites method, of class Course.
     */
    @Test
    public void testHasFulfilledPrerequisites() {
        System.out.println("hasFulfilledPrerequisites");
        List<Course> coursesCompleted = new ArrayList<Course>();
        coursesCompleted.add(this.c);
        Course instance = this.c;
        boolean expResult = true;
        boolean result = instance.hasFulfilledPrerequisites(coursesCompleted);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getMissingPrerequisites method, of class Course.
     */
    @Test
    public void testGetMissingPrerequisites() {
        System.out.println("getMissingPrerequisites");
        List<Course> coursesCompleted = new ArrayList<Course>();
        coursesCompleted.add(this.c);
        Course instance = this.c;
        Requirement result = instance.getMissingPrerequisites(coursesCompleted);
        assertThat(result, instanceOf(NoRequirement.class));
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of equals method, of class Course.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new Course("COMP1601","Programing 1",3,1,semesters);;
        Course instance = this.c;
        boolean expResult = true;
        boolean result = this.c.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of hashCode method, of class Course.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Course instance = this.c;
        int hash = 7;
        String code = this.c.getCodeAndTitle();
             if(code.contains(" ")){
        code= code.substring(0, code.indexOf(" ")); 
             }
        int expResult = 79 * hash + Objects.hashCode(code);
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }
 
}
