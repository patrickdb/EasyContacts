package com.ec.apis.easycontacts.controllers;

import com.ec.apis.easycontacts.domain.Member;
import com.ec.apis.easycontacts.services.MemberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    MemberService ms = new MemberService();

    @PostMapping("/Members")
    public void CreateNewMemberRecord(@RequestBody Member newMember)
    {
       ms.create(newMember);
    }

    @GetMapping("/Members/{member_id}")
    public Member retrieveMemberByID(@PathVariable long member_id)
    {
        return ms.findByFirstName(Long.toString(member_id));
    }
}
