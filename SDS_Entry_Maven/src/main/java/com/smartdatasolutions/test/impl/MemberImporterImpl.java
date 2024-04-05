package com.smartdatasolutions.test.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

public class MemberImporterImpl implements MemberImporter {

    @Override
    public List<Member> importMembers(File inputFile) throws Exception {
        List<Member> members = new ArrayList<>();

        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                members.add(parseMember(line));
            }
        }

        return members;
    }

    private Member parseMember(String line) {
        String id = line.substring(0, 12).trim();
        String lastName = line.substring(12, 37).trim();
        String firstName = line.substring(37, 62).trim();
        String address = line.substring(62, 92).trim();
        String city = line.substring(92, 112).trim();
        String state = line.substring(112, 116).trim();
        String zip = line.substring(116).trim();

        Member member = new Member();
        member.setId(id);
        member.setLastName(lastName);
        member.setFirstName(firstName);
        member.setAddress(address);
        member.setCity(city);
        member.setState(state);
        member.setZip(zip);

        return member;
    }

}
