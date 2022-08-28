package com.project.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjectModel {

	private Integer pro_Id;
	private String pro_Name;
	private Double pro_Budget;
	private Integer pro_Teamsize;
	private Integer pro_Duration;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate pro_endDate;
	private String pro_MangaerName;
	public ProjectModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectModel(Integer pro_Id, String pro_Name, Double pro_Budget, Integer pro_Teamsize, Integer pro_Duration,
			LocalDate pro_endDate, String pro_MangaerName) {
		super();
		this.pro_Id = pro_Id;
		this.pro_Name = pro_Name;
		this.pro_Budget = pro_Budget;
		this.pro_Teamsize = pro_Teamsize;
		this.pro_Duration = pro_Duration;
		this.pro_endDate = pro_endDate;
		this.pro_MangaerName = pro_MangaerName;
	}
	public Integer getPro_Id() {
		return pro_Id;
	}
	public void setPro_Id(Integer pro_Id) {
		this.pro_Id = pro_Id;
	}
	public String getPro_Name() {
		return pro_Name;
	}
	public void setPro_Name(String pro_Name) {
		this.pro_Name = pro_Name;
	}
	public Double getPro_Budget() {
		return pro_Budget;
	}
	public void setPro_Budget(Double pro_Budget) {
		this.pro_Budget = pro_Budget;
	}
	public Integer getPro_Teamsize() {
		return pro_Teamsize;
	}
	public void setPro_Teamsize(Integer pro_Teamsize) {
		this.pro_Teamsize = pro_Teamsize;
	}
	public Integer getPro_Duration() {
		return pro_Duration;
	}
	public void setPro_Duration(Integer pro_Duration) {
		this.pro_Duration = pro_Duration;
	}
	public LocalDate getPro_endDate() {
		return pro_endDate;
	}
	public void setPro_endDate(LocalDate pro_endDate) {
		this.pro_endDate = pro_endDate;
	}
	public String getPro_MangaerName() {
		return pro_MangaerName;
	}
	public void setPro_MangaerName(String pro_MangaerName) {
		this.pro_MangaerName = pro_MangaerName;
	}
	@Override
	public String toString() {
		return "ProjectModel [pro_Id=" + pro_Id + ", pro_Name=" + pro_Name + ", pro_Budget=" + pro_Budget
				+ ", pro_Teamsize=" + pro_Teamsize + ", pro_Duration=" + pro_Duration + ", pro_endDate=" + pro_endDate
				+ ", pro_MangaerName=" + pro_MangaerName + "]";
	}
	
	
	
	
}
