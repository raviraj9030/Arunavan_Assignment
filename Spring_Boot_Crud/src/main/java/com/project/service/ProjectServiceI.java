package com.project.service;

import java.util.List;

import com.project.entity.Project;
import com.project.exception.ProjectException;
import com.project.model.ProjectModel;

public interface ProjectServiceI {

	public Project addProjectDetails(ProjectModel project);
	public void updateProjectDetails(int ProjectId, ProjectModel projectModel) throws ProjectException;
	public void deleteProjectDetails(int projectId) throws ProjectException;
	public List<ProjectModel> listProjectDetails() throws ProjectException;
	public ProjectModel getProject(Integer ProjectId) throws ProjectException;
	public boolean isProjectExist(Integer projectId);
}
