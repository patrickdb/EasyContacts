package com.ec.apis.easycontacts;

import com.ec.apis.easycontacts.domain.Member;
import com.ec.apis.easycontacts.services.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MemberServiceTests {

    @Test
    public void WhenAddingNewMember_ThenMemberCanBeFound()
    {
        MemberService ms = new MemberService();
        ms.create(new Member("MyFirstName"));

        Member foundMember = ms.findByFirstName("MyFirstName");

        assertThat(foundMember.getFirstName()).isNotNull();
        assertThat(foundMember.getFirstName()).isEqualTo("MyFirstName");
    }
}
