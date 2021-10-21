package com.ec.apis.easycontacts.controllers;

import com.ec.apis.easycontacts.domain.Member;
import com.ec.apis.easycontacts.services.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @PostMapping("/Members")
    public void CreateNewMemberRecord(@RequestBody Member newMember)
    {
        MemberService ms = new MemberService();
        ms.create(newMember);
    }

    @GetMapping("/Members/{member_id}")
    public Member retrieveMemberByID(@PathVariable long member_id)
    {
        MemberService ms = new MemberService();
        ms.create(new Member("Test"));
        return ms.findByFirstName("Test");
    }
}
