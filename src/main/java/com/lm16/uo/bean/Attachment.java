package com.lm16.uo.bean;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Attachment {

    @Id
    private String id;
    private String userId;
    private String fileName;
}
