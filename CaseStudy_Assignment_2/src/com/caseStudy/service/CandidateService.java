package com.caseStudy.service;

import java.util.List;

import com.caseStudy.model.CandidateReport;

public interface CandidateService {

	String calculateGrade(CandidateReport candidateReport);

	List<CandidateReport> getGradesForAllCandidates();

	String addCandidate(CandidateReport candidate) throws Exception;
}