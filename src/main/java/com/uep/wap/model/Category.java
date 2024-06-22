package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryID;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Board> boards;

    @ManyToMany(mappedBy = "categories")
    private List<Photo> photos;


    public int getCategoryID() {
        return categoryID;
    }

    public Category(){

    }

    public void setCategoryID(int category_id) {
        this.categoryID = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
