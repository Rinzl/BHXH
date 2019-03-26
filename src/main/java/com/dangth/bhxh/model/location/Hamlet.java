package com.dangth.bhxh.model.location;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "hamlet")
public class Hamlet {
    @Id
    private String idhamlet;
    private String idcommune;
    private String hamlet;
}
