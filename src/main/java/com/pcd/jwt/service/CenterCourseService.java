package com.pcd.jwt.service;

import com.pcd.jwt.entity.CenterCourses;
import com.pcd.jwt.entity.Courses;
import com.pcd.jwt.repository.CenterCourseRepository;
import com.pcd.jwt.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.transaction.Transactional;
import java.io.IOException;
import java.text.ParseException;

@Service
@Transactional
public class CenterCourseService {
    private  final CenterCourseRepository centerCourseRepository;
    @Autowired
    public CenterCourseService(CenterCourseRepository centerCourseRepository) {
        this.centerCourseRepository = centerCourseRepository;
    }
    public CenterCourses create(CenterCourses centerCourses) {
        return centerCourseRepository.save(centerCourses);
    }




}
