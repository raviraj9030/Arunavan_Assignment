package com.caseStudy.assignment2;

import java.util.List;

import com.caseStudy.model.CandidateReport;
import com.caseStudy.service.CandidateService;
import com.caseStudy.service.CandidateServiceImpl;

public class Assignment2 {

	private static CandidateService service = new CandidateServiceImpl();

	public static void main(String[] args) throws Exception {
		
		CandidateReport cdr =  new CandidateReport();
		cdr.setCandidateId(10);
		cdr.setCandidateName("Rahul");
		cdr.setMark1(89);
		cdr.setMark2(71);
		cdr.setMark3(77);
		cdr.setGrade("B");
		cdr.setResult('P');
		
		System.out.println(service.addCandidate(cdr));
		
		List<CandidateReport> cdrList = service.getGradesForAllCandidates();
		for(CandidateReport temp : cdrList) {
			System.out.println("CandidateID \t Result");
			System.out.println(temp.getCandidateId() +"\t\t "+ service.calculateGrade(temp));
		}
	}
}
