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
    DegreeProgram p;
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

    /**
     * Test of getName method, of class DegreeProgram.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        DegreeProgram instance = this.p;
        instance.getDegreeProgramCSMajor(this.catalog);
        String expResult = "Major in Computer Science";
        String result = instance.getName();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of getDegreeProgramCSMajor method, of class DegreeProgram.
     */
    @Test
    public void testGetDegreeProgramCSMajor() {
        System.out.println("getDegreeProgramCSMajor");
        CourseCatalog catalog = null;
        DegreeProgram expResult = null;
        DegreeProgram result = DegreeProgram.getDegreeProgramCSMajor(catalog);
        assertEquals(expResult, result);

    }

    /**
     * Test of getDegreeProgramITMajor method, of class DegreeProgram.
     */
    @Test
    public void testGetDegreeProgramITMajor() {
        System.out.println("getDegreeProgramITMajor");
        CourseCatalog catalog = null;
        DegreeProgram expResult = null;
        DegreeProgram result = DegreeProgram.getDegreeProgramITMajor(catalog);
        assertEquals(expResult, result);
  
    }

    /**
     * Test of getDegreeProgramAMajor method, of class DegreeProgram.
     */
    @Test
    public void testGetDegreeProgramAMajor() {
        System.out.println("getDegreeProgramAMajor");
        CourseCatalog catalog = null;
        DegreeProgram expResult = null;
        DegreeProgram result = DegreeProgram.getDegreeProgramAMajor(catalog);
        assertEquals(expResult, result);

    }
    
}
