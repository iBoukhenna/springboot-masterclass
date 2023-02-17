package com.dzcode.springboot.masterclass.cdi;

import jakarta.inject.Named;

@Named
public class SomeCdiDao {

    public int[] getData() {
        return new int[] {5, 89, 100};
    }
}
