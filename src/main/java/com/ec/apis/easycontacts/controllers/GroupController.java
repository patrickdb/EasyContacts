package com.ec.apis.easycontacts.controllers;

import com.ec.apis.easycontacts.domain.Group;
import com.ec.apis.easycontacts.domain.Member;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {

    // https://blog.testproject.io/2020/07/15/running-postman-tests-in-ci-using-newman/
    static Member testMember;
    static Group testGroup;

    @GetMapping("Groups")
    public Group allGroups()
    {
        return new Group();
    }

    @GetMapping("Groups/{group_id}")
    public Group getGroupByID(@PathVariable String group_id)
    {
        return new Group(group_id);
    }

    @GetMapping("Groups/{group_id}/Members")
    public Member getAllMemberInGroup(@PathVariable String group_id,
                                      @RequestParam(value = "name", defaultValue = "all dymmy persons") String gn)
    {
        testMember = new Member(gn);
        return testMember;
    }

    @GetMapping("Groups/{group_id}/Members/{member_id}")
    public Member getMemberInGroupByID(@PathVariable String group_id,
                                       @PathVariable long member_id,
                                       @RequestParam(value = "name", defaultValue = "dummy person") String gn)
    {
        testMember = new Member(Long.toString(member_id));
        return testMember;
    }

    @PostMapping("groups/{group_id}/members")
    public void getAllMembersByGroup()
    {
        testMember = new Member("dummdyDoo");
    }
}
