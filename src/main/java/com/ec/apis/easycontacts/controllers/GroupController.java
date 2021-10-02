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
    public GroupMember getAllMemberInGroup(@PathVariable String group_id,
                                  @RequestParam(value = "name", defaultValue = "all dymmy persons") String gn)
    {
        testMember = new GroupMember(gn);
        return testMember;
    }

    @GetMapping("groups/{group_id}/members/{member_id}")
    public GroupMember getMemberInGroupByID(@PathVariable String group_id,
                                            @PathVariable long member_id,
                                            @RequestParam(value = "name", defaultValue = "dummy person") String gn)
    {
        testMember = new GroupMember(Long.toString(member_id));
        return testMember;
    }

    @PostMapping("groups/{group_id}/members")
    public void getAllMembersByGroup()
    {
        testMember = new GroupMember("dummdyDoo");
    }
}
