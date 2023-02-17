package com.dzcode.springboot.masterclass.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessImplStubTest {

    @Test
    void findTheGreatestFromAllDataTest() {
        DataServiceStub dataServiceStub = new DataServiceStub();
        SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = someBusinessImpl.findTheGreatestFromAllData();
        assertEquals(25, result);
    }

    @Test
    void findTheGreatestFromAllDataTest_withOneValue() {
        DataServiceStub_withOneValue dataServiceStub = new DataServiceStub_withOneValue();
        SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = someBusinessImpl.findTheGreatestFromAllData();
        assertEquals(25, result);
    }
}

class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {25, 15, 5};
    }
}
class DataServiceStub_withOneValue implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {5};
    }
}