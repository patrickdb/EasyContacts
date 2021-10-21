package com.ec.apis.easycontacts.domain;

import java.util.List;

public class Group {
    private String name;
    private List<Member> members;

    public Group() {
        name = "<empty>";
    }
    public Group(String group_id) {
        name = group_id;
    }

    public String getName() { return name; }
    public List<Member> getMembers() { return members; }
}
