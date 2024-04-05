package com.smartdatasolutions.test.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

public class Main extends MemberFileConverter {

	
	 @Override
	    protected MemberExporter getMemberExporter() {
	        return new MemberExporterImpl();
	    }

	    @Override
	    protected MemberImporter getMemberImporter() {
	        return new MemberImporterImpl();
	    }

	    @Override
	    protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {
	   
	    	Set<Member> uniqueMembers = new HashSet<>(membersFromFile);
	        return new ArrayList<>(uniqueMembers);
	    }

	    @Override
	    protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {
	        Map<String, List<Member>> membersByState = new HashMap<>();

	        for (Member member : validMembers) {
	            String state = member.getState();

	            if (membersByState.containsKey(state)) {
	                membersByState.get(state).add(member);
	            } else {
	                List<Member> membersForState = new ArrayList<>();
	                membersForState.add(member);
	                membersByState.put(state, membersForState);
	            }
	        }

	        return membersByState;
	    }


	    public static void main(String[] args) {
	
	        try {
	            Main main = new Main();
	            File inputMemberFile = new File(".\\Members.txt");
	            String outputFilePath = "target/output"; 
	            String outputFileName = "outputFile.csv"; 
	            main.convert(inputMemberFile, outputFilePath, outputFileName);
	            System.out.println("program started");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	
}
