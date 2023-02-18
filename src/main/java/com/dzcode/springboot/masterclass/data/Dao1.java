package com.dzcode.springboot.masterclass.data;

import com.dzcode.springboot.masterclass.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

    @TrackTime
    public String retrieveSomething() {
        return "Dao1";
    }
}
