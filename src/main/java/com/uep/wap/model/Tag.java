package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private int tagID;
    @Column(name = "name")
    private String name;

    public Tag(){

    }
    @ManyToMany(mappedBy = "tags")
    private List<Photo> photos;
    public int getTagID() {
        return tagID;
    }

    public void setTagID(int tag_id) {
        this.tagID = tag_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
