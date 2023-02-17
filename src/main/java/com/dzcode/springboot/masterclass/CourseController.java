package com.dzcode.springboot.masterclass;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn AWS", "Learn AWS"),
                new Course(2, "Learn DevOps", "Learn DevOps"),
                new Course(3, "Learn Azure", "Learn Azure")
        );
    }

}
