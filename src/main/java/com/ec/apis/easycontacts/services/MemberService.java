package com.ec.apis.easycontacts.services;

import com.ec.apis.easycontacts.domain.Member;

public class MemberService {

    Member dummyMember;

    public void create(Member newMember)
    {
        dummyMember = newMember;
    }

    public Member findByFirstName(String firstNameToBeFound)
    {
        return dummyMember;
    }
}
