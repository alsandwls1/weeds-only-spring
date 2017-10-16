package com.example.demo.repository2;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Project;

//@Mapper
public interface ProjectRepository2 {

	public void insert(Project project);
	public void delete(String domain);
	
	public List<Project> selectAll();
//	public int count();
	public List<Project> selectName(String p_name);
	
//	public Project searchDomain(String p_domain);
	
}
