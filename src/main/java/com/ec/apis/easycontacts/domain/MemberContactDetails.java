package com.ec.apis.easycontacts.domain;
import com.ec.apis.easycontacts.domain.Member;

import lombok.Getter;
import lombok.Setter;


public class MemberContactDetails {
    @Getter
    @Setter
    private Adress houseAdress;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String mobilePhone;
}
