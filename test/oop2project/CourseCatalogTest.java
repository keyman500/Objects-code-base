/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class CourseCatalogTest {
    CourseCatalog c;
    Course course;
    Map<String, Course> courses ;
    
    public CourseCatalogTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        int[] semesters = new int[]{1};
        this.courses = new HashMap<String, Course>();
        this.course= new Course("COMP1601","Programing 1",3,1,semesters);
        this.courses.put("COMP1601",course);
        this.c  = new CourseCatalog(this.courses);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllCourses method, of class CourseCatalog.
     */
    @Test
    public void testGetAllCourses() {
        System.out.println("getAllCourses");
        CourseCatalog instance = this.c;
        List<Course> expResult = new ArrayList<>(this.courses.values());
        List<Course> result = instance.getAllCourses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of getCourseByCode method, of class CourseCatalog.
     */
    @Test
    public void testGetCourseByCode() {
        System.out.println("getCourseByCode");
        String courseCode = "COMP1601";
        CourseCatalog instance = this.c;
        Course expResult = this.course;
        Course result = instance.getCourseByCode(courseCode);
        assertEquals(expResult, result);
   
    }
    
}
