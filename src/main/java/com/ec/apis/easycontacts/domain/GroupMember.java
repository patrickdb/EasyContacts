package com.ec.apis.easycontacts.domain;

import java.util.List;

public class GroupMember {
    private String firstName;
    private String lastName;
    private boolean visible;

    //private List<MemberParent> parents;

    public GroupMember(String inputFirstName) {
        firstName = inputFirstName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() { return lastName; }
    public boolean getVisible() { return  visible; }
}
