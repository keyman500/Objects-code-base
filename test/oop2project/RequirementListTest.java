/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2project;

import java.util.ArrayList;
import java.util.Arrays;
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
public class RequirementListTest {
    RequirementList reqList;
    Course c1;
    Course c2;
    Course c3;
    public RequirementListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.reqList = new RequirementList();
        this.c1 = new Course("COMP1601","Programing 1",3,1, new int[] {1, 2, 3});
        this.c2 = new Course("COMP1600", "Intro to Computing", 3, 1, new int[]{1});
        this.c3 = new Course("COMP1602", "Programming 2", 3, 1, new int[]{1, 2});
        this.reqList.addSubRequirement(c1);
        this.reqList.addSubRequirement(c2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIsFulfilledBy() {
        assertTrue(this.reqList.isFulfilledBy(Arrays.asList(c1, c2)));
        assertFalse(this.reqList.isFulfilledBy(Arrays.asList(c1)));
    }
    
    @Test
    public void testGetCreditsFulfilled() {
        assertEquals(6, this.reqList.getCreditsFulfilled(Arrays.asList(c1, c2)));
        assertEquals(3, this.reqList.getCreditsFulfilled(Arrays.asList(c1)));
    }

    @Test
    public void testGetMissingComponents() {
        assertTrue(
            this.reqList.getMissingComponents(Arrays.asList(c1))
                .isFulfilledBy(Arrays.asList(c2)));

    }

    @Test
    public void testAddSubRequirement() {
        assertTrue(this.reqList.addSubRequirement(c3));
        assertFalse(this.reqList.isFulfilledBy(Arrays.asList(c1, c2)));
        assertTrue(this.reqList.isFulfilledBy(Arrays.asList(c1, c2, c3)));
    }
    
    @Test
    public void testGetMissingCompulsoryCourses() {
        Set<Course> s = this.reqList.getMissingCompulsoryCourses(Arrays.asList());
        assertTrue(s.contains(c1));
        assertTrue(s.contains(c2));
        assertFalse(s.contains(c3));
    }

    @Test
    public void tesGetMissingOptionalCourses() {
        Set<Course> s = this.reqList.getMissingOptionalCourses(Arrays.asList());
        assertFalse(s.contains(c1));
        assertFalse(s.contains(c2));
        assertFalse(s.contains(c3));
    }
}
