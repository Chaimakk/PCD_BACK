package com.pcd.jwt.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.List;

@Entity
public class User {


 // @GeneratedValue(generator = "uuid")
 // @GenericGenerator(name = "uuid", strategy = "uuid2")
  //  private String id;
   @Id

   @Column(unique = true)
    private String userName;
    private String userFullName;
    @Column(unique = true)
    private  String userEmail;
    private String userPassword;
    private String userAddress;
    private String userBirthday;
    private String userGender;
    private  int userTelephoneNumber;
    private  int userPostalCode;
    private String userCity;
    private String userCountry;
    @ElementCollection
   private  List<String> userCategory;
    private String userLevel;
    private String userDomain;

    private String userDescription;
    private String userExperience;
    @Column(unique = true)
    private String centerName;
    private  String centerDirectorName;



    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getUserTelephoneNumber() {
        return userTelephoneNumber;
    }

    public void setUserTelephoneNumber(int userTelephoneNumber) {
        this.userTelephoneNumber = userTelephoneNumber;
    }

    public int getUserPostalCode() {
        return userPostalCode;
    }

    public void setUserPostalCode(int userPostalCode) {
        this.userPostalCode = userPostalCode;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserDomain() {
        return userDomain;
    }

    public void setUserDomain(String userDomain) {
        this.userDomain = userDomain;
    }


    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getUserExperience() {
        return userExperience;
    }

    public void setUserExperience(String userExperience) {
        this.userExperience = userExperience;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterDirectorName() {
        return centerDirectorName;
    }

    public void setCenterDirectorName(String centerDirectorName) {
        this.centerDirectorName = centerDirectorName;
    }

    public List<String> getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(List<String> userCategory) {
        this.userCategory = userCategory;
    }
}
