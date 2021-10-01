package com.ec.apis.easycontacts.controllers;

import com.ec.apis.easycontacts.domain.Group;
import com.ec.apis.easycontacts.domain.GroupMember;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    static GroupMember testMember;
    static Group testGroup;

    @GetMapping("groups")
    public Group groups()
    {
        return new Group();
    }

    @GetMapping("members")
    public GroupMember members(@RequestParam(value = "name", defaultValue = "dummy person") String gn)
    {
        testMember = new GroupMember(gn);
        return testMember;
    }

    @PostMapping("members")
    public void members()
    {
        testMember = new GroupMember("dummdyDoo");
    }
}
