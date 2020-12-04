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
import java.util.steam.Collectors;
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
public class RecommenderTest {
    CourseCatalog catalog;
    Recommender rec;
    
    public RecommenderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.catalog = new Catalog(
                new CatalogReader(new Scanner(new File("src\\oop2project\\catalog.txt")))
                .readAndGetCourses())
        this.rec = new Recommender(DegreeProgram.getDegreeProgramCSMajor(this.catalog));
        this.rec.setSemester(2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllCourses method, of class CourseCatalog.
     */
    @Test
    public void testRecommendations() {
        this.rec.setCoursesCompleted(
            this.cataglog.getAllCourses().stream().filter(c -> c.getLevel() == 1)
            .collect(Collectors.toList()));
        assertTrue(Arrays.asList(this.rec.getRecommendations().split("\n")).stream()
            .map(s -> this.catalog.getCourseByCode(s.substring(0, 8)))
            .allMatch(c -> c.getLevel() > 1 && c.getSemester() == 2));
        // TODO review the generated test code and remove the default call to fail.
    
    }
}
