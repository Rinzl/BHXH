package com.dangth.bhxh.model.location;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "city")
public class City {
    @Id
    private String idcity;
    private String city;
}
