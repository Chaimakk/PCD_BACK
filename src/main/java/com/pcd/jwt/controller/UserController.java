package com.pcd.jwt.controller;

import com.pcd.jwt.entity.User;
import com.pcd.jwt.exception.ResourceNotFoundException;
import com.pcd.jwt.repository.UserRepository;
import com.pcd.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewStudent"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewStudent(user);
    }

    @PostMapping({"/registerNewFormer"})
    public User registerNewFormer(@RequestBody User former) {
        return userService.registerNewFormer(former);
    }

    @PostMapping({"/registerNewCenter"})
    public User registerNewCenter(@RequestBody User center) {
        return userService.registerNewCenter(center);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forStudent"})
    @PreAuthorize("hasRole('Student')")
    public String forUser(){
        return "This URL is only accessible to the student";
    }


    @GetMapping("/list")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/roles/{roleName}")
    public List<User> getUserByRole(@PathVariable String roleName){return  (List<User>) userRepository.findAll(roleName);}

    @GetMapping("/users/count/{roleName}")
    public Long getCountUser(@PathVariable String roleName) {
        return userRepository.CountUser(roleName);
    }



    @GetMapping("/user/{Id}")
    public java.util.Optional<User> getUser(@PathVariable String Id) {
        return userRepository.findById(Id);
    }

    @GetMapping("/userEmail/{userEmail}")
    public List<User> getUserByEmail(@PathVariable String userEmail) {

        return userRepository.findUserByEmail(userEmail) ;
    }
    @RequestMapping(value = "/delete-user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable(value = "id") String id) throws Exception {
        try {
            userService.delete(id);
            return ResponseEntity.ok().body("delete done");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/delete-userByEmail/{userEmail}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteByEmail(@PathVariable(value = "userEmail") String userEmail) throws Exception {
        try {
            userService.delete(userEmail);
            return ResponseEntity.ok().body("delete done");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/update/{UserId}")
    public User updateUser(@PathVariable String UserId, @Valid @RequestBody User userRequest) {
        return userRepository.findById(UserId).map(user -> {
            user.setUserName(userRequest.getUserName());
            user.setUserFullName(userRequest.getUserFullName());
            user.setUserEmail(userRequest.getUserEmail());
            user.setUserAddress(userRequest.getUserAddress());
            user.setUserPassword(userRequest.getUserPassword());
            user.setUserCountry(userRequest.getUserCountry());
            user.setUserTelephoneNumber(userRequest.getUserTelephoneNumber());
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("StudentId " + UserId + " not found"));
    }




    @PutMapping("/profile/{userEmail}")
    public User updateUserProfil(@PathVariable String userEmail, @Valid @RequestBody User userRequest) {
        return userRepository.findByEmail(userEmail).map(user -> {
            user.setUserFullName(userRequest.getUserFullName());
            user.setUserName(userRequest.getUserName());
            user.setUserEmail(userRequest.getUserEmail());
            user.setUserAddress(userRequest.getUserAddress());
            user.setUserGender(userRequest.getUserGender());
            user.setUserCity(userRequest.getUserCity());
            user.setUserTelephoneNumber(userRequest.getUserTelephoneNumber());

            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("ClientId " + userEmail + " not found"));
    }


}
