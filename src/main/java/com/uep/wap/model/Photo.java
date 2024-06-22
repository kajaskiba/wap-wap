package com.uep.wap.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private int photoID;
    @Column(name = "image_url")
    private String imageURL;
    public Photo(){

    }

    @ManyToMany
    @JoinTable(name = "photo_board", joinColumns = @JoinColumn(name = "photo_id"), inverseJoinColumns = @JoinColumn(name = "board_id"))
    private List<Board> boards;

    @ManyToMany
    @JoinTable(name = "photo_category", joinColumns = @JoinColumn(name = "photo_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;
    @ManyToMany
    @JoinTable(name = "photo_location", joinColumns = @JoinColumn(name = "photo_id"), inverseJoinColumns = @JoinColumn(name = "location_id"))
    private List<Location> locations;
    @ManyToMany
    @JoinTable(name = "photo_tag", joinColumns = @JoinColumn(name = "photo_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;
    @OneToMany
    @JoinTable(name = "photo_interactio ", joinColumns = @JoinColumn(name = "photo_id"), inverseJoinColumns = @JoinColumn(name = "interaction_id"))
    private List<Interaction> interactions;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    public int getPhotoID() {
        return photoID;
    }
    @Column(name = "upload_date")
    private int upload_date;
    @Column(name = "likes_count")
    private int likes_count;
    @Column(name = "comments_count")
    private int comments_count;
    @Column(name = "description")
    private String description;

    public void setPhotoID(int photo_id) {
        this.photoID = photo_id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String image_url) {
        this.imageURL = image_url;
    }

    public int getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(int upload_date) {
        this.upload_date = upload_date;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





}
