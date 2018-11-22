package com.jirina.p2pchat.models;

import com.sun.jmx.snmp.Timestamp;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Message {
    public Message() {
    }

    @Id
    @GeneratedValue
    long dbId;

    String username;
    String text;
    Timestamp sendTime;
    int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_ID")
    User user;

    public Message(User user, String text) {
        this.user = user;
        this.text = text;
        this.sendTime = new Timestamp(System.currentTimeMillis());
        this.id = (int) (Math.random() * 8999999 + 1000000);
    }

    public long getDbId() {
        return dbId;
    }

    public void setDbId(long dbId) {
        this.dbId = dbId;
    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
