package com.jirina.p2pchat.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {
    public User() {
    }

    @Id
    @GeneratedValue
    long id;
    String username;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name ="message_dbID")
    List<Message> messages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String username) {
        this.username = username;
    }
}
