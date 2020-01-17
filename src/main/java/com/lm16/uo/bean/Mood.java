package com.lm16.uo.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="to_mood")
@Data
public class Mood implements Serializable {

    @Id
    private String id;

    private String content;

    private String userId;

    private Integer praiseNum;

    private Date publishTime;

}
