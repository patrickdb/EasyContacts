package com.ec.apis.easycontacts.controllers;

import com.ec.apis.easycontacts.domain.GroupMember;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    static GroupMember testMember;

    @GetMapping("member")
    public GroupMember member(@RequestParam(value = "name", defaultValue = "dummy person") String gn)
    {
        testMember = new GroupMember(gn);
        return testMember;
    }

    @PostMapping("member")
    public void member()
    {
        testMember = new GroupMember("dummdyDoo");
    }

}
