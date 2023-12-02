package com.codeWithXForward.buyandsell.messages;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Message {
    @Id
    public String messageId;

    public String message;

}
