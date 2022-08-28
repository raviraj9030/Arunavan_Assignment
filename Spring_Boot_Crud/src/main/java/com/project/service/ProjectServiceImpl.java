package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ProjectDaoI;
import com.project.entity.Project;
import com.project.exception.ProjectException;
import com.project.model.ProjectModel;

@Service
public class ProjectServiceImpl implements ProjectServiceI{
	
	@Autowired
	private ProjectDaoI dao;

	@Override
	public Project  addProjectDetails(ProjectModel project) {
		Project projectEntity = new Project();
		projectEntity.setPro_Id(project.getPro_Id());
		projectEntity.setPro_Name(project.getPro_Name());
		projectEntity.setPro_Teamsize(project.getPro_Teamsize());
		projectEntity.setPro_Duration(project.getPro_Duration());
		projectEntity.setPro_Budget(project.getPro_Budget());
		projectEntity.setPro_endDate(project.getPro_endDate());
		projectEntity.setPro_MangaerName(project.getPro_MangaerName());
		
		
		Project projectEntity2 = dao.save(projectEntity);
		return projectEntity2;
		
	}

	@Override
	public void updateProjectDetails(int ProjectId, ProjectModel projectModel) throws ProjectException {
		Optional<Project> proOptional = dao.findById(ProjectId);
		Project c = proOptional.get();
		//c.setEmailId(emailId);
		if(projectModel.getPro_Name() != null) {
			c.setPro_Name(projectModel.getPro_Name());
		}if(projectModel.getPro_Budget() != null) {
			c.setPro_Budget(projectModel.getPro_Budget());
		}if(projectModel.getPro_Duration() != null) {
			c.setPro_Duration(projectModel.getPro_Duration());
		}if(projectModel.getPro_endDate() != null) {
			c.setPro_endDate(projectModel.getPro_endDate());
		}if(projectModel.getPro_MangaerName() != null) {
			c.setPro_MangaerName(projectModel.getPro_MangaerName());
		}if(projectModel.getPro_Teamsize() != null) {
			c.setPro_Teamsize(projectModel.getPro_Teamsize());
		}
		Project save = dao.save(c);
	}

	@Override
	public void deleteProjectDetails(int ProjectId) throws ProjectException {
		dao.deleteById(ProjectId);
		
		
	}

	@Override
	public List<ProjectModel> listProjectDetails() throws ProjectException {
		Iterable<Project> projects = dao.findAll();
		List<ProjectModel> projects2 = new ArrayList<>();
		projects.forEach(p -> {
			ProjectModel pro = new ProjectModel();
			pro.setPro_Id(p.getPro_Id());
			pro.setPro_Name(p.getPro_Name());
			pro.setPro_Teamsize(p.getPro_Teamsize());
			pro.setPro_Duration(p.getPro_Duration());
			pro.setPro_endDate(p.getPro_endDate());
			pro.setPro_MangaerName(p.getPro_MangaerName());
			pro.setPro_Budget(p.getPro_Budget());
			projects2.add(pro);
		});
		if (projects2.isEmpty())
			throw new ProjectException("Service.CUSTOMERS_NOT_FOUND");
		return projects2;
	}

	@Override
	public ProjectModel getProject(Integer ProjectId) throws ProjectException {
		
		Optional<Project> optional = dao.findById(ProjectId);
		Project project = optional.get();
		
		ProjectModel projectModel2 = new ProjectModel();
		projectModel2.setPro_Id(project.getPro_Id());
		projectModel2.setPro_Name(project.getPro_Name());
		projectModel2.setPro_Teamsize(project.getPro_Teamsize());
		projectModel2.setPro_Duration(project.getPro_Duration());
		projectModel2.setPro_Budget(project.getPro_Budget());
		projectModel2.setPro_endDate(project.getPro_endDate());
		projectModel2.setPro_MangaerName(project.getPro_MangaerName());
		
		return projectModel2;
	}

	@Override
	public boolean isProjectExist(Integer projectId) {
		Optional<Project> p = dao.findById(projectId);
		if(p.isPresent()) {
			return true;
		}else {
			return false;
		}
	}

}
