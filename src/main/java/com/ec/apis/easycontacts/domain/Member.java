package com.ec.apis.easycontacts.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Each group has members.
 * Within the school context, these are pupils for which only first and last name is relevant
 * and if they record should be visible in the class list that can be generated
 * by the groupAdmin
 *
 * Private details like adresses, e-mail, phone numbers are linked tot the MemberContacts (parents of the pupils)
 *
 */
public class Member {

    // Using features of the Lombok library
    // https://projectlombok.org/features/GetterSetter

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String firstName;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String lastName;

    @Getter
    @Setter
    private boolean visible;

    private List<MemberContacts> parents;

    public Member(String inputFirstName) {
        firstName = inputFirstName;
    }

}
