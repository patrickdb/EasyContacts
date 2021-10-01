package com.ec.apis.easycontacts.controllers;

import com.ec.apis.easycontacts.domain.Group;
import com.ec.apis.easycontacts.domain.GroupMember;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {

    static GroupMember testMember;
    static Group testGroup;

    @GetMapping("groups")
    public Group allGroups()
    {
        return new Group();
    }

    @GetMapping("groups/{group_id}")
    public Group getGroupByID(@PathVariable String group_id)
    {
        return new Group(group_id);
    }

    @GetMapping("groups/{group_id}/members")
    public GroupMember getMemberByGroup(@PathVariable String group_id,
                                  @RequestParam(value = "name", defaultValue = "dummy person") String gn)
    {
        testMember = new GroupMember(gn);
        return testMember;
    }

    @PostMapping("groups/{group_id}/members")
    public void getAllMembersByGroup()
    {
        testMember = new GroupMember("dummdyDoo");
    }
}
