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
public class NoRequirementTest {
    NoRequirement noReq;
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
        this.noReq = new NoRequirement();
        this.c1 = new Course("COMP1601","Programing 1",3,1, new int[] {1, 2, 3});
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIsFulfilledBy() {
        assertTrue(this.noReq.isFulfilledBy(Arrays.toList(new Course[] {c1})));
        assertTrue(this.noReq.isFulfilledBy(Arrays.toList(new Course[] {})));
    }
    
    @Test
    public void testGetCreditsFulfilled() {
        assertEquals(0, this.noReq.getCreditsFulfilled(Arrays.toList(new Course[] {c1, c2})));
        assertEquals(0, this.noReq.getCreditsFulfilled(Arrays.toList(new Course[] {c1})));
        assertEquals(0, this.noReq.getCreditsFulfilled(Arrays.toList(new Course[] {})));
    }

    @Test
    public void testGetMissingComponents() {
        assertTrue(
            this.noReq.getMissingComponents(Arrays.toList(new Course[] {}))
                .isFulfilledBy(Arrays.toList(new Course[] {})));

    }

    @Test
    public void testAddSubRequirement() {
        assertFalse(this.noReq.addSubRequirement(c3));
    }
    
    @Test
    public void testGetMissingCompulsoryCourses() {
        Set<Course> s = this.noReq.getMissingCompulsoryCourses(Arrays.toList(new Course[] {}));
        assertFalse(s.contains(c1));
        assertFalse(s.contains(c2));
        assertFalse(s.contains(c3));
    }

    @Test
    public void tesGetMissingOptionalCourses() {
        Set<Course> s = this.noReq.getMissingOptionalCourses(Arrays.toList(new Course[] {}));
        assertFalse(s.contains(c1));
        assertFalse(s.contains(c2));
        assertFalse(s.contains(c3));
    }
}
