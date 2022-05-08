package com.pcd.jwt.controller;

import com.pcd.jwt.entity.CenterCourses;
import com.pcd.jwt.entity.Courses;
import com.pcd.jwt.repository.CenterCourseRepository;
import com.pcd.jwt.service.CenterCourseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.text.ParseException;

@RestController
@CrossOrigin

public class CenterCourseController {
    private final CenterCourseService centerCourseService;
    @Autowired
    ServletContext context;

    @Autowired
    private CenterCourseRepository centerCourseRepository;

    @Autowired
    public CenterCourseController(CenterCourseService centerCourseService) {
        this.centerCourseService = centerCourseService;
    }
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/addCenterCourses")
    public CenterCourses addC(@RequestParam("price")Long price, @RequestParam("city")String city,
                        @RequestParam("phoneNumber")int phoneNumber, @RequestParam("courseName") String courseName,
                        @RequestParam("category") String category, @RequestParam("description") String description,
                        @RequestParam("formerName") String formerName, @RequestParam("centerEmail") String centerEmail,
                        @RequestParam("centerName") String centerName, MultipartHttpServletRequest request) throws IOException, ParseException {
        CenterCourses centerCourses = new CenterCourses();
        centerCourses.setPrice(price);
        centerCourses.setCourseName(courseName);
        centerCourses.setCategory(category);
        centerCourses.setDescription(description);
        centerCourses.setCenterEmail(centerEmail);
        centerCourses.setFormerName(formerName);
        centerCourses.setCity(city);
        centerCourses.setPhoneNumber(phoneNumber);

        centerCourses.setCenterName(centerName);

        return centerCourseService.create(centerCourses);
    }
}
