package com.pcd.jwt.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(schema = "Courses")
public class Courses {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CourseName;
    private String description;
    private double price;
    private String category;
    private String formerName;
    private String city;
    private  int phoneNumber;
    @Email

    private  String formerEmail;
    @Lob
    private byte[] picture;

    public Courses(String courseName, String description, double price, String category, byte[] picture,String formerName,String formerEmail) {
        CourseName = courseName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.picture = picture;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Courses() {
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        this.CourseName = courseName;
    }

    public String getFormerName() {
        return formerName;
    }

    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }

    public String getFormerEmail() {
        return formerEmail;
    }

    public void setFormerEmail(String formerEmail) {
        this.formerEmail = formerEmail;
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
