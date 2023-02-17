package com.dzcode.springboot.masterclass.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {

    @Mock
    private  DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl someBusinessImpl;

    @Test
    void findTheGreatestFromAllDataTest() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15,5});
        assertEquals(25, someBusinessImpl.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllDataTest_withOneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
        assertEquals(35, someBusinessImpl.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllDataTest_withEmptyArray() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, someBusinessImpl.findTheGreatestFromAllData());
    }
}
