package com.project.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.ProjectException;
import com.project.model.ProjectModel;
import com.project.service.ProjectServiceI;

@RestController
@RequestMapping(value = "/ct")
public class ProjectRestController {

	@Autowired
	private Environment environment;

	@Autowired
	private ProjectServiceI service;

	@GetMapping(value = "/projects")
	public ResponseEntity<List<ProjectModel>> getAllProjectsDetails() throws ProjectException {
		List<ProjectModel> projectList = service.listProjectDetails();
		return new ResponseEntity<>(projectList, HttpStatus.OK);
	}

	@PostMapping("/addProject")
	public ResponseEntity<String> addProjectDetails(@RequestBody ProjectModel projectDetails) {
		service.addProjectDetails(projectDetails);
		return new ResponseEntity<String>("Product successfully added", HttpStatus.CREATED);

	}

	@PutMapping(value = "/updateProject/{projectId}")
	public ResponseEntity<String> updateProjectDetails(@PathVariable Integer projectId,
			@RequestBody ProjectModel projectModel) throws ProjectException {
		if (service.isProjectExist(projectId)) {
			service.updateProjectDetails(projectId, projectModel);
			String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		}
		String failMsg = environment.getProperty("Service.PROJECT_NOT_FOUND");
		return new ResponseEntity<>(failMsg, HttpStatus.NOT_FOUND);

	}

	@DeleteMapping(value = "/deleteProject/{projectId}")
	public ResponseEntity<String> deleteProject(@PathVariable Integer projectId) throws ProjectException {
		if (service.isProjectExist(projectId)) {
			service.deleteProjectDetails(projectId);
			String successMessage = environment.getProperty("API.DELETE_SUCCESS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		}
		String failMsg = environment.getProperty("Service.PROJECT_NOT_FOUND");
		return new ResponseEntity<>(failMsg, HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/getProject/{projectId}")
	public ResponseEntity<ProjectModel> getProject(@PathVariable Integer projectId) throws ProjectException {
		if (service.isProjectExist(projectId)) {
			ProjectModel projectModel = service.getProject(projectId);
			return new ResponseEntity<>(projectModel, HttpStatus.OK);
		}
		ProjectModel projectModel = null;
		return new ResponseEntity<>(projectModel, HttpStatus.NOT_FOUND);
	}

}
