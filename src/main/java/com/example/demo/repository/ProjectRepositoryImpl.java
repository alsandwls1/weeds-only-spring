package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Project;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository{

	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public int insert(Project project) {
		return projectRepository.insert(project);
	}

	@Override
	public int delete(String domain) {
		return projectRepository.delete(domain);
	}

	@Override
	public List<Project> selectAll() {
		return projectRepository.selectAll();
	}

	@Override
	public List<Project> selectName(String p_name) {
		return projectRepository.selectName(p_name);
	}
	
	@Override
	public Project searchDomain(String p_domain){
		return projectRepository.searchDomain(p_domain);
	}

}
