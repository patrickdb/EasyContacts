package com.ec.apis.easycontacts.domain;

import java.util.List;

public class Group {
    private String name;
    private List<GroupMember> members;

    public String getName() { return name; }
    public List<GroupMember> getMembers() { return members; }
}
