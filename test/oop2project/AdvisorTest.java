/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2project;

import java.util.List;
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
public class AdvisorTest {
    Advisor a;
    public AdvisorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Advisor a = new Advisor("src\\oop2project\\catalog.txt");
      
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDegrees method, of class Advisor.
     */
    @Test
    public void testGetDegrees() {
        System.out.println("getDegrees");
        Advisor instance = this.a;
        List<DegreeProgram> expResult = null;
        List<DegreeProgram> result = instance.getDegrees();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setDegree method, of class Advisor.
     */
    @Test
    public void testSetDegree() {
        System.out.println("setDegree");
        DegreeProgram degree = null;
        Advisor instance = null;
        instance.setDegree(degree);
 
    }

    /**
     * Test of setSemester method, of class Advisor.
     */
    @Test
    public void testSetSemester() {
        System.out.println("setSemester");
        int semester = 0;
        Advisor instance = null;
        instance.setSemester(semester);
     
    }

    /**
     * Test of getCourses method, of class Advisor.
     */
    @Test
    public void testGetCourses() {
        System.out.println("getCourses");
        Advisor instance = null;
        List<Course> expResult = null;
        List<Course> result = instance.getCourses();
        assertEquals(expResult, result);
  
    }

    /**
     * Test of setCoursesDone method, of class Advisor.
     */
    @Test
    public void testSetCoursesDone() {
        System.out.println("setCoursesDone");
        List<Course> courses = null;
        Advisor instance = null;
        instance.setCoursesDone(courses);
   
    }

    /**
     * Test of getRecommendation method, of class Advisor.
     */
    @Test
    public void testGetRecommendation() {
        System.out.println("getRecommendation");
        Advisor instance = null;
        String expResult = "";
        String result = instance.getRecommendation();
        assertEquals(expResult, result);

    }
    
}
