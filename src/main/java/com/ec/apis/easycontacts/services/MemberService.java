package com.ec.apis.easycontacts.services;

import com.ec.apis.easycontacts.domain.Member;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Scope("singleton")
public class MemberService {

    ArrayList<Member> allMembers = new ArrayList<>();

    private boolean memberWithSameFirstAndLastNameExist(Member memberToMatch)
    {
       return allMembers.stream()
                .filter(member ->
                        member.getFirstName().equals(memberToMatch.getFirstName()) &&
                        member.getLastName().equals(memberToMatch.getLastName()))
                .count() == 1;

    }

    public void add (Member newMember)
    {
        // Find if a "Matching" Member is present
        if (!memberWithSameFirstAndLastNameExist(newMember)) {
            // If not yet there, add to list
            allMembers.add(newMember);
        }
    }

    public Member findByFirstName(String firstNameToBeFound)
    {
        return allMembers.stream()
            .filter(member -> firstNameToBeFound.equals(member.getFirstName()))
            .findAny()
            .orElse(null);
    }

    public ArrayList<Member> retrieveAllMembers()
    {
        return allMembers;
    }
}
