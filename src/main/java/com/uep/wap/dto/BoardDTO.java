package com.uep.wap.dto;

public class BoardDTO {
    private String title;
    private String description;
    private int ownerID;
    private String categoryName;
    private int photoID;
    private String username;

    public String getUsername() {
        return username;
    }

    public int getPhotoID() {
        return photoID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }



}
