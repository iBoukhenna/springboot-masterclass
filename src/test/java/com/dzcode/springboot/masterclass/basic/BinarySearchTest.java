package com.dzcode.springboot.masterclass.basic;

import com.dzcode.springboot.masterclass.SpringbootMasterclassApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringbootMasterclassApplication.class)
public class BinarySearchTest {

    @Autowired
    BinarySearchImpl binarySearch;

    @Test
    public void testBasicSenario() {
        int actualResult = binarySearch.binarySearch(new int[] {}, 5);
        assertEquals(0, actualResult);
    }
}
