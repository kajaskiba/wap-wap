package com.uep.wap.dto;

public class PhotoDTO {
    private int photoID;
    private String imageURL;
    private int uploadDate;
    private int likesCount;
    private int commentsCount;
    private String description;

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(int uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
