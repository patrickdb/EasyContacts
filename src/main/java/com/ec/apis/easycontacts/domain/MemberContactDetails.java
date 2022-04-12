package com.ec.apis.easycontacts.domain;
import com.ec.apis.easycontacts.domain.Member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MemberContactDetails {
    @Id
    private int id;

    @Getter
    @Setter
    @OneToOne
    private Adress houseAdress;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String mobilePhone;
}
