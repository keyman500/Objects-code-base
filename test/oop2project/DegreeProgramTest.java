/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
public class DegreeProgramTest {
    CourseCatalog catalog;
    
    public DegreeProgramTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String filePath ="src\\oop2project\\catalog.txt";
        CatalogReader reader;
        try {
            reader = new CatalogReader(new Scanner(new File(filePath)));
        } catch (FileNotFoundException error) {
            return;
        }
        this.catalog = new CourseCatalog(reader.readAndGetCourses());
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreation() {
        assertNotNull(DegreeProgram.getDegreeProgramCSMajor(this.catalog));
        assertNotNull(DegreeProgram.getDegreeProgramITMajor(this.catalog));
    }

    /**
     * Test of getName method, of class DegreeProgram.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals(DegreeProgram.getDegreeProgramCSMajor(this.catalog).getName(), "Major in Computer Science");
    
    }

    @Test
    public void testIsFulfilledBy() {
        assertTrue(DegreeProgram.getDegreeProgramCSMajor(this.catalog).isFulfilledBy(
            this.catalog.getAllCourses()));
    }

}
