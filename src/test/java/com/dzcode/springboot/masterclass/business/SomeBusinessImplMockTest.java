package com.dzcode.springboot.masterclass.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessImplMockTest {

    @Test
    void findTheGreatestFromAllDataTest() {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15,5});
        SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = someBusinessImpl.findTheGreatestFromAllData();
        assertEquals(25, result);
    }

    @Test
    void findTheGreatestFromAllDataTest_withOneValue() {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
        SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = someBusinessImpl.findTheGreatestFromAllData();
        assertEquals(35, result);
    }
}
