package com.ec.apis.easycontacts.domain;

import java.util.List;

public class GroupMember {
    private String firstName;
    private String lastName;
    private boolean visible;

    private List<MemberParent> parents;
}