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
    Course c1;
    Course c2;
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
        this.c1 = new Course("COMP1601","Programing 1",3,1,semesters);
        this.c2 = new Course("COMP0001","Intro to CS",3,1,semesters);
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
        Course instance = this.c1;
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
        Course instance = this.c1;
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
        Course instance = this.c1;
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
        assertTrue(this.c1.isFulfilledBy(Arrays.asList(this.c1)));
        assertFalse(this.c1.isFulfilledBy(Arrays.asList()));
        assertFalse(this.c1.isFulfilledBy(Arrays.asList(this.c2)));
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCreditsFulfilled method, of class Course.
     */
    @Test
    public void testGetCreditsFulfilled() {
        assertEquals(3, this.c1.isFulfilledBy(Arrays.asList(this.c1)));
        assertEquals(0, this.c1.isFulfilledBy(Arrays.asList()));
        assertEquals(0, this.c1.isFulfilledBy(Arrays.asList(this.c2)));
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getMissingComponents method, of class Course.
     */
    @Test
    public void testGetMissingComponents() {
        assertTrue(
            this.c1.getMissingComponents(Arrays.asList())
                .isFulfilledBy(Arrays.asList(this.c1)));
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addSubRequirement method, of class Course.
     */
    @Test
    public void testAddSubRequirement() {
        assertFalse(this.c1.addSubRequirement(this.c2));
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getMissingCompulsoryCourses method, of class Course.
     */
    @Test
    public void testGetMissingCompulsoryCourses() {
        Set<Course> s = this.c1.getMissingCompulsoryCourses(Arrays.asList());
        assertTrue(s.contains(c1));
        assertFalse(s.contains(c2));
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getMissingOptionalCourses method, of class Course.
     */
    @Test
    public void testGetMissingOptionalCourses() {
        Set<Course> s = this.c1.getMissingOptionalCourses(Arrays.asList());
        assertFalse(s.contains(c1));
        assertFalse(s.contains(c2));
        // TODO review the generated test code and remove the default call to fail.
        
    }



    /**
     * Test of hasFulfilledPrerequisites method, of class Course.
     */
    @Test
    public void testHasFulfilledPrerequisites() {
        assertTrue(this.c1.hasFulfilledPrerequisites(Arrays.asList()));
        this.c1.addPrerequisite(this.c2);
        assertFalse(this.c1.hasFulfilledPrerequisites(Arrays.asList()));
        assertTrue(this.c1.hasFulfilledPrerequisites(Arrays.asList(this.c2)));
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getMissingPrerequisites method, of class Course.
     */
    @Test
    public void testGetMissingPrerequisites() {
        assertTrue(
            this.c1.getMissingComponents(Arrays.asList(this.c1))
                .isFulfilledBy(Arrays.asList()));
        this.c1.addPrerequisite(this.c2);
        assertFalse(
            this.c1.getMissingComponents(Arrays.asList(this.c1))
                .isFulfilledBy(Arrays.asList()));
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of equals method, of class Course.
     */
    @Test
    public void testEquals() {
        assertFalse(this.c1.equals(this.c2));
        assertTrue(this.c1.equals(this.c1));
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of hashCode method, of class Course.
     */
    @Test
    public void testHashCode() {
        assertFalse(this.c1.hashCode() == this.c2.hashCode);
        assertTrue(this.c1.hashCode() == this.c1.hashCode);
    }
 
}
