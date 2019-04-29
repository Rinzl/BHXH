package com.dangth.bhxh.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@Entity
@Table(name = "worker")
public class Worker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "gender")
    private Integer gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identity_card_id", nullable = false)
    private IdentityCard identityCard;

    @Column(name = "phone")
    private String phoneNumber;

    private String email;
    private String msbh;
    private Double salary;
    private Double pc;
    private Double ht;
    private Integer zone;
    private String workplace;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

}
