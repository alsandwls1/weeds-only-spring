package com.example.demo.repository2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Member;
import com.example.demo.domain.Project;

@Repository
public class ProjectRepositoryImpl2 implements ProjectRepository2{

	List<Project> projects = new ArrayList<Project>();
	{
		projects.add(new Project("aa", "a", "1001"));
		projects.add(new Project("bb", "b", "1001"));
		projects.add(new Project("cc", "c", "1003"));
		projects.add(new Project("dd", "d", "1004"));
	}
	
//	@Autowired
//	private ProjectRepository2 projectRepository;
	
	@Override
	public void insert(Project project) {
		projects.add(project);
	}

	@Override
	public void delete(String domain) {
		projects.remove(0);
	}

	@Override
	public List<Project> selectAll() {
		return projects;
	}

	@Override
	public List<Project> selectName(String p_name) {
		List<Project> p = new ArrayList<Project>();
		
		for (int i = 0; i < projects.size(); i++) {
//			System.out.println("for # project = "+projects.get(i).getP_name());
			if (projects.get(i).getP_name().equals(p_name)) {
				p.add(projects.get(i));
			}				
		}
		System.out.println("p= "+p);
		return p;
	}
	
//	@Override
//	public Project searchDomain(String p_domain){
//		return projectRepository.searchDomain(p_domain);
//	}

}
