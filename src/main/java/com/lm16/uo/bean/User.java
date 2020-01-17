package com.lm16.uo.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name="to_user")
public class User implements Serializable {

    @Id
    private String id;

    private String name;

    private String pwd;

}
