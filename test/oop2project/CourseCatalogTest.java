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
    CourseCatalog catalog;
    Course c1;
    Course c2;
    Course c3;
    
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
        Map<String, Course> courses = new HashMap<String, Course>();
        this.c1 = new Course("COMP1601","Programing 1",3,1,semesters);
        this.c2 = new Course("COMP1602","Programing 2",3,1,semesters);
        this.c3 = new Course("COMP1603","Programing 3",3,1,semesters);
        courses.put("COMP1601",this.c1);
        courses.put("COMP1601",this.c2);
        this.catalog  = new CourseCatalog(courses);
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
        assertTrue(this.catalog.getAllCourses().contains(this.c1));
        assertTrue(this.catalog.getAllCourses().contains(this.c2));
        assertFalse(this.catalog.getAllCourses().contains(this.c3));
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of getCourseByCode method, of class CourseCatalog.
     */
    @Test
    public void testGetCourseByCode() {
        System.out.println("getCourseByCode");
        assertTrue(this.catalog.getCourseByCode("COMP1601").equals(this.c1));
        assertFalse(this.catalog.getCourseByCode("COMP1603").equals(this.c3));
    }
    
}
