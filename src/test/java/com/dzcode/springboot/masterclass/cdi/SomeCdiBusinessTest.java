package com.dzcode.springboot.masterclass.cdi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {

    @InjectMocks
    SomeCdiBusiness someCdiBusiness;

    @Mock
    SomeCdiDao someCdiDaoMock;

    @Test
    public void testBasicSenario() {
        Mockito.when(someCdiDaoMock.getData()).thenReturn(new int[] {2, 4});
        int actualResult = someCdiBusiness.findGreatest();
        assertEquals(4, actualResult);
    }

    @Test
    public void testBasicSenario_withEmptyArray() {
        Mockito.when(someCdiDaoMock.getData()).thenReturn(new int[] {});
        int actualResult = someCdiBusiness.findGreatest();
        assertEquals(Integer.MIN_VALUE, actualResult);
    }

    @Test
    public void testBasicSenario_withEqualsValues() {
        Mockito.when(someCdiDaoMock.getData()).thenReturn(new int[] {2, 2});
        int actualResult = someCdiBusiness.findGreatest();
        assertEquals(2, actualResult);
    }

}
