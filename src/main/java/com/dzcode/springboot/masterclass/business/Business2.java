package com.dzcode.springboot.masterclass.business;

import com.dzcode.springboot.masterclass.aspect.TrackTime;
import com.dzcode.springboot.masterclass.data.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2 {

    @Autowired
    private Dao2 dao2;

    @TrackTime
    public String calculateSomething() {
        return dao2.retrieveSomething();
    }

}
