package com.ec.apis.easycontacts.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Adress {

    @Id
    private int id;

    private String adressLine;
    private String city;
    private String country;

}
