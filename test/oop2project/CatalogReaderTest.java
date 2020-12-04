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
    CatalogReader reader;
    
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
        this.reader = new CatalogReader(new Scanner(new File("src\\oop2project\\catalog.txt")));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllCourses method, of class CourseCatalog.
     */
    @Test
    public void testReadAndGetCourses() {
        Map<String, Course> courses = this.reader.readAndGetCourses();
        assertNotNull(courses.get("COMP1600"));
        assertNotNull(courses.get("MATH2250"));
        // TODO review the generated test code and remove the default call to fail.
    
    }
}
