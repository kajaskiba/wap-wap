package com.uep.wap.model;

import javax.persistence.*;

@Entity
public class Interaction {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "interaction_id")
    private int interactionID;


    public int getInteractionID() {
        return interactionID;
    }

    public void setInteractionID(int interaction_id) {
        this.interactionID = interaction_id;
    }

    public int getTargetID() {
        return targetID;
    }

    public void setTargetID(int target_id) {
        this.targetID = target_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public Interaction() {

    }


    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photos;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;
    @Column(name = "target_id")
    private int targetID;
    @Column(name = "type")
    private String type;
    @Column(name = "timestamp")
    private int timestamp;


}
