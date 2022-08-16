package com.caseStudy.service;

import java.util.List;

import com.caseStudy.dao.CandidateDAO;
import com.caseStudy.model.CandidateReport;

public class CandidateServiceImpl implements CandidateService{

	private CandidateDAO dao = new CandidateDAO();

	
	@Override
	public String calculateGrade(CandidateReport candidateReport) {
		if("F".equals(candidateReport.getResult())) 
			return "NA";
		else {
			double avg = ((candidateReport.getMark1() + candidateReport.getMark2() + candidateReport.getMark3())/3)*100;
			String grade = "";
			if(avg >= 85) grade = "A";
			else if(avg >= 75  || avg < 85) grade =  "B";
			else if(avg < 75) grade =  "C";
			return grade;
		}
	}

	@Override
	public List<CandidateReport> getGradesForAllCandidates() {
		return dao.findAll();
	}

	@Override
	public String addCandidate(CandidateReport candidate) throws Exception {
		if (candidate.getMark1() < 50 || candidate.getMark2() < 50
				|| candidate.getMark3() < 50 && ("P".equals(candidate.getResult())))
			throw new Exception("Result should be 'F' (Fail) if student scores less than 50 in any one subject");
		return dao.addCandidate(candidate);
	}

}