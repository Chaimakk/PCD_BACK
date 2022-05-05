package com.pcd.jwt.controller;

import com.pcd.jwt.entity.Courses;
import com.pcd.jwt.repository.CourseRepository;
import com.pcd.jwt.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
public class CourseController {

    private final CourseService courseService ;

    private byte[] bytes;
    @Autowired
    ServletContext context;

    @Autowired
    private CourseRepository courseRepository ;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @PostMapping("/addCourses")
    public Courses addC(@RequestParam("price")Long price,@RequestParam("city")String city,@RequestParam("phoneNumber")int phoneNumber, @RequestParam("courseName") String courseName, @RequestParam("category") String category, @RequestParam("description") String description, @RequestParam("formerName") String formerName, @RequestParam("formerEmail") String formerEmail, @RequestParam("picture") MultipartFile file, MultipartHttpServletRequest request) throws IOException, ParseException {
        Courses food = new Courses();
        food.setPrice(price);
        food.setCourseName(courseName);
        food.setCategory(category);
        food.setDescription(description);
        food.setFormerEmail(formerEmail);
        food.setFormerName(formerName);
        food.setCity(city);
        food.setPhoneNumber(phoneNumber);
        byte[] picture = file.getBytes();
        food.setPicture(picture);
        log.info("The picture file has " + picture.length + " bytes");
        return courseService.create(food);
    }
    @GetMapping("/courses")
    public List<Courses> getAllC() {
        return courseService.read();
    }
    @GetMapping("/course/{id}")
    public java.util.Optional<Courses> getCourses(@PathVariable Long id) {
        return courseRepository.findById(id);
    }
    @GetMapping("/category/{category}")
    public List<Courses> getCourseByCategory(@PathVariable String category) {

        return courseRepository.findByCategory(category) ;
    }
    @GetMapping("/city/{city}")
    public List<Courses> getCourseByCity(@PathVariable String city ) {

        return courseRepository.findByCity(city) ;
    }
    @GetMapping("/email/{formerEmail}")
    public List<Courses> getCourseByEmail(@PathVariable String formerEmail) {

        return courseRepository.findCoursesByEmail(formerEmail) ;
    }
    @RequestMapping(value = "/delete-course/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        try {
            courseService.delete(id);
            return ResponseEntity.ok().body("delete done");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/update-course/{id}")
    public  ResponseEntity<Courses> updateCourses(@RequestBody Courses course) {
        Courses updateCourses = courseService.updateCourses(course);
        return new ResponseEntity<>(updateCourses, HttpStatus.OK);
    }
    @GetMapping("/courses/count")
    public Long getCourseCount() {
        return courseRepository.count();
    }



}
