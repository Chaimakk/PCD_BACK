package com.pcd.jwt.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class CenterCourses {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String courseName;
    private String centerName;
    @Email
    private String centerEmail;
    private String description;
    private double price;
    private String category;
    private String formerName;
    private String city;
    private  int phoneNumber;

    public CenterCourses(Long id, String courseName, String centerName, String centerEmail, String description, double price, String category, String formerName, String city, int phoneNumber) {
        this.id = id;
        this.courseName = courseName;
        this.centerName = centerName;
        this.centerEmail = centerEmail;
        this.description = description;
        this.price = price;
        this.category = category;
        this.formerName = formerName;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }
    public CenterCourses(){};
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterEmail() {
        return centerEmail;
    }

    public void setCenterEmail(String centerEmail) {
        this.centerEmail = centerEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFormerName() {
        return formerName;
    }

    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
