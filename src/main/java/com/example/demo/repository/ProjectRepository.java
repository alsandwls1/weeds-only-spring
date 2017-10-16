package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Project;

@Mapper
public interface ProjectRepository {

	public int insert(Project project);
	public int delete(String domain);
	
	public List<Project> selectAll();
//	public int count();
	public List<Project> selectName(String p_name);
	
	public Project searchDomain(String p_domain);
	
}
