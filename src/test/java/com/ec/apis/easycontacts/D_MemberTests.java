package com.ec.apis.easycontacts;

import com.ec.apis.easycontacts.domain.Member;
import com.ec.apis.easycontacts.domain.MemberRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class D_MemberTests {

    Member _member = new Member();

    @BeforeEach
    public void setupForEachTest()
    {
        _member = new Member();
    }

    @Test
    public void When_CreatingMemberWithNoParametersProvided_Then_FieldsShouldDefault()
    {
        assertThat(_member.getFirstName()).isEqualTo("<none>");
        assertThat(_member.getLastName()).isEqualTo("<none>");
        assertThat(_member.isVisible()).isFalse();
        assertThat(_member.getRole()).isEqualTo(MemberRole.None);
        assertThat(_member.getContactData()).isNull();
    }

    @Test
    public void NumberOfContactPersonsIsFour()
    {
        int maxNumberOfContactPersons = _member.getMaxContactPersons();
        assertThat(_member.getContactPersons().length).isEqualTo(maxNumberOfContactPersons);
    }

    @Test
    public void When_AddingOneContactPerson_Then_PersonDataCanBeReadFromIdx0()
    {
        Member contact = new Member("Parent 1");

        _member.addContact(contact);
        assertThat(_member.getContactPersons()[0].getFirstName()).isEqualTo("Parent 1");
    }

    @Test
    public void When_AddingFourContactPerson_Then_LastPersonAddedIsOnMaxIdxMin1()
    {
        // Add maximum number of contact persons to a member
        for (int idx = 1; idx<=_member.getMaxContactPersons(); idx++) {
            Member contact = new Member("Parent " + idx);

            _member.addContact(contact);
        }

        int maxNumberOfContactPersons = _member.getMaxContactPersons();

        assertThat(_member.getContactPersons()[maxNumberOfContactPersons-1].getFirstName())
                .isEqualTo("Parent " + maxNumberOfContactPersons);
    }
}
