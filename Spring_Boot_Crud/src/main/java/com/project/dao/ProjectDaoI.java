package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.entity.Project;

public interface ProjectDaoI extends JpaRepository<Project, Integer>{

}
