package com.ec.apis.easycontacts.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
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
    private int MAX_CONTACT_PERSONS = 4;

    @Getter
    private String firstName = "<none>";

    @Getter
    private String lastName = "<none>";

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private boolean visible = false;

    @Getter
    @Setter
    private MemberRole role = MemberRole.None;

    // Members & Contact details can be added through Dependency Injection

    @Getter
    // Up to 4 contact members can be added, for each contact
    // In a school setting, these can be the parents
    private Member[] contactPersons = new Member[MAX_CONTACT_PERSONS];


    @Getter
    // Same MemberContactDetails can be shared between multiple members
    private MemberContactDetails contactData = null;

    @Getter
    @Setter
    // A contact person can be contact person of more members
    // e.g. parent of children in different class groups.
    private ArrayList<Member> contactPersonOf = new ArrayList<>();

    // When missing, JSON deserialization is not working (Needs c'tor with empty params)
    public Member() {
    }

    public Member(String inputFirstName)  {
        firstName = inputFirstName;
    }

    private int findIndexWithEmptyContactSlot() {
        int idx = 0;

        while (contactPersons[idx] != null)
            idx++;

        return idx;
    }

    public void addContact(Member parent) {
        int index = findIndexWithEmptyContactSlot();

        if (index < MAX_CONTACT_PERSONS) {
            contactPersons[index] = parent;
        }
    }

    public int getMaxContactPersons() {
        return MAX_CONTACT_PERSONS;
    }
}
