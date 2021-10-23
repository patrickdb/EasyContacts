package com.ec.apis.easycontacts;

import com.ec.apis.easycontacts.domain.Member;
import com.ec.apis.easycontacts.services.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MemberServiceTests {

    @Test
    public void WhenAddingNewMember_ThenMemberCanBeFound()
    {
        MemberService ms = new MemberService();
        ms.add(new Member("MyFirstName"));

        Member foundMember = ms.findByFirstName("MyFirstName");

        assertThat(foundMember.getFirstName()).isNotNull();
        assertThat(foundMember.getFirstName()).isEqualTo("MyFirstName");
    }

    @Test
    public void When_AddingTwoNonIdenticalMembers_Then_NumberOfMembersIsOne()
    {
        MemberService ms = new MemberService();
        ms.add(new Member("Marloes"));
        ms.add(new Member("Patrick"));

        ArrayList<Member> allMembers = ms.retrieveAllMembers();
        assertThat(allMembers.size()).isEqualTo(2);
    }

    @Test
    public void When_AddingTwoIdenticalMembers_Then_NumberOfMembersIsOne()
    {
        MemberService ms = new MemberService();
        ms.add(new Member("Marloes"));
        ms.add(new Member("Marloes"));

        ArrayList<Member> allMembers = ms.retrieveAllMembers();
        assertThat(allMembers.size()).isEqualTo(1);
    }
}
