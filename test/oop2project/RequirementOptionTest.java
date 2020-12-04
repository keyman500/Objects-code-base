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
public class RequirementOptionTest {
    RequirementOption reqOpt;
    Course c1;
    Course c2;
    Course c3;
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
        this.reqOpt = new RequirementOption(3);
        this.c1 = new Course("COMP1601","Programing 1",3,1, new int[] {1, 2, 3});
        this.c2 = new Course("COMP1600", "Intro to Computing", 3, 1, new int[]{1});
        this.c3 = new Course("COMP1602", "Programming 2", 3, 1, new int[]{1, 2});
        this.reqOpt.addSubRequirement(c1);
        this.reqOpt.addSubRequirement(c2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIsFulfilledBy() {
        assertTrue(this.reqOpt.isFulfilledBy(Arrays.asList(c1)));
        assertFalse(this.reqOpt.isFulfilledBy(Arrays.asList()));
    }
    
    @Test
    public void testGetCreditsFulfilled() {
        assertEquals(3, this.reqOpt.getCreditsFulfilled(Arrays.asList(c1, c2)));
        assertEquals(3, this.reqOpt.getCreditsFulfilled(Arrays.asList(c1)));
        assertEquals(0, this.reqOpt.getCreditsFulfilled(Arrays.asList()));
    }

    @Test
    public void testGetMissingComponents() {
        assertTrue(
            this.reqOpt.getMissingComponents(Arrays.asList(c1))
                .isFulfilledBy(Arrays.asList()));

    }

    @Test
    public void testAddSubRequirement() {
        assertFalse(this.reqOpt.isFulfilledBy(Arrays.asList(c3)));
        assertTrue(this.noReq.addSubRequirement(c3));
        assertTrue(this.reqOpt.isFulfilledBy(Arrays.asList(c3)));
    }
    
    @Test
    public void testGetMissingCompulsoryCourses() {
        Set<Course> s = this.reqOpt.getMissingCompulsoryCourses(Arrays.asList());
        assertFalse(s.contains(c1));
        assertFalse(s.contains(c2));
        assertFalse(s.contains(c3));
    }

    @Test
    public void tesGetMissingOptionalCourses() {
        Set<Course> s = this.reqOpt.getMissingOptionalCourses(Arrays.asList());
        assertTrue(s.contains(c1));
        assertTrue(s.contains(c2));
        assertFalse(s.contains(c3));
    }
}
