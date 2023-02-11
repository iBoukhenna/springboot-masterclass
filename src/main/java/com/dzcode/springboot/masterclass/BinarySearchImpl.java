package com.dzcode.springboot.masterclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

    @Autowired
    private SortAlgorithm quickSortAlgorithm;

    public int binarySearch(int[] numbers, int numberToSearchFor) {
        int[] sortedNumbers = quickSortAlgorithm.sort(numbers);
        System.out.println("the algorithm used is : " + quickSortAlgorithm);
        return 0;
    }
}
