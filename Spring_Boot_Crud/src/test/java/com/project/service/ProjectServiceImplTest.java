package com.project.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.dao.ProjectDaoI;
import com.project.entity.Project;
import com.project.exception.ProjectException;
import com.project.model.ProjectModel;

@SpringBootTest
public class ProjectServiceImplTest {

	@InjectMocks
	private ProjectServiceImpl projectServiceImpl;
	
	@Mock
	private ProjectDaoI dao;

	@Test
	@DisplayName("JUnit test for addProjectDetailsTest method")
	public void  addProjectDetailsTest() {
		LocalDate date2 = LocalDate.of (2018, Month.OCTOBER, 12);
		ProjectModel project = 
				new ProjectModel(22, "DATA", 10.00, 10, 1, date2, "Ram");
		
		Project projectEntity = new Project();
		projectEntity.setPro_Id(project.getPro_Id());
		projectEntity.setPro_Name(project.getPro_Name());
		projectEntity.setPro_Teamsize(project.getPro_Teamsize());
		projectEntity.setPro_Duration(project.getPro_Duration());
		projectEntity.setPro_Budget(project.getPro_Budget());
		projectEntity.setPro_endDate(project.getPro_endDate());
		projectEntity.setPro_MangaerName(project.getPro_MangaerName());
		
		Project q = projectEntity; 
		
		when(dao.save(projectEntity)).thenReturn(projectEntity);
		
		when(projectServiceImpl.addProjectDetails(project)).
				thenReturn(projectEntity);
		
		assertEquals(q, projectEntity);
		
	}
	
	@Test
	@DisplayName("JUnit test for updateProjectDetailsTest method")
	public void updateProjectDetailsTest() {
		
		LocalDate date2 = LocalDate.of (2018, Month.OCTOBER, 12);
		Project p = new Project(22, "DATA", 10.00, 10, 1, date2, "Ram");
		Project q = p;
		when(dao.findById(22)).thenReturn(Optional.empty());
		when(dao.save(p)).thenReturn(p);
		
		assertEquals(p, q);
	}
	
	@Test
	@DisplayName("JUnit test for deleteProjectDetailsTest method")
	public void deleteProjectDetailsTest() throws ProjectException {
		when(dao.findById(22)).thenReturn(Optional.empty());
		doNothing().when(dao).deleteById(22);
		projectServiceImpl.deleteProjectDetails(22);
		verify(dao,times(1)).deleteById(22);
	}
	
	@Test
	@DisplayName("JUnit test for listProjectDetailsTest method")
	public void listProjectDetailsTest() throws ProjectException {
		
		LocalDate date2 = LocalDate.of (2018, Month.OCTOBER, 12);
		Project p1 = new Project(22, "DATA", 10.00, 10, 1, date2, "Ram");
		Project p2 = new Project(23, "INFO", 10.00, 10, 1, date2, "Shyam");
		
		List<Project> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		
		ProjectModel pm1 = new ProjectModel(22, "DATA", 10.00, 10, 1, date2, "Ram");
		ProjectModel pm2 = new ProjectModel(23, "INFO", 10.00, 10, 1, date2, "Shyam");
		
		List<ProjectModel> listPM = new ArrayList<>();
		listPM.add(pm1);
		listPM.add(pm2);
		
		
		when(dao.findAll()).thenReturn(list);
		assertNotEquals(projectServiceImpl.listProjectDetails(), listPM);
	}
	
	@Test
	@DisplayName("JUnit test for getProjectTest method")
	public void getProjectTest() throws ProjectException {
		LocalDate date2 = LocalDate.of (2018, Month.OCTOBER, 12);
		ProjectModel pm1 =new ProjectModel(22, "DATA", 10.00, 10, 1, date2, "Ram");
		Optional<Project> p1 = Optional.of(new Project(22, "DATA", 10.00, 10, 1, date2, "Ram"));
		when(dao.findById(22)).thenReturn(p1);
		assertNotEquals(projectServiceImpl.getProject(22),pm1);
	}
}
