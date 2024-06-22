package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userID;
    @Column(name = "username")
    private String username;
    @Column(name = "gender")
    private String gender;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "profile_picture")
    private String profilePicture;
    @Column(name = "bio")
    private String bio;
    @Column(name = "role")
    private String role;



    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Interaction> interactions;
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Photo> photos;
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Board> boards;

    public User() {

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int user_id) {
        this.userID = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profile_picture) {
        this.profilePicture = profile_picture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
