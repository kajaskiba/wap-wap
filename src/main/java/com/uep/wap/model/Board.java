package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "board_id")
    private int boardID;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "owner_id")
    private int ownerID;

    @ManyToMany
    @JoinTable(name = "board_category", joinColumns = @JoinColumn(name = "board_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ManyToMany(mappedBy = "boards")
    private List<Photo> photos;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    public int getBoardID() {
        return boardID;
    }

    public Board(){

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setBoardID(int board_id) {
        this.boardID = board_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwnerID(int owner_id) {
        this.ownerID = owner_id;
    }

    //jak stworze dto
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public void setUsers(User users) {
        this.users = users;
    }


}
