package com.jirina.p2pchat.models;

import com.sun.jmx.snmp.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Message {
    @Id
    long dbId;
    String username;
    String text;
    Timestamp sendTime;
    int id;

    public Message(String username, String text) {
        this.username = username;
        this.text = text;
        this.sendTime = new Timestamp(System.currentTimeMillis());
        this.id=(int)(Math.random()*8999999 +1000000);
    }


}
