package com.dangth.bhxh.model.location;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "commune")
public class Commune {
    @Id
    private String idcommune;
    private String idprovince;
    private String commune;
}
