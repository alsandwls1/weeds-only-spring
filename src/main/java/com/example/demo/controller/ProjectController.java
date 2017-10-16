package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Project;
import com.example.demo.repository.ProjectRepository;

@RestController
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepository;

	List<Project> projectList = new ArrayList<>();

	@GetMapping("/projects")
	public Object get() {
		// System.out.println(projectRepository.selectAll());
		// return projectRepository.selectAll();
		return projectList;
	}

	@GetMapping("/projects/{p_name}")
	public Object get(@PathVariable String p_name) {
		// System.out.println(projectRepository.selectName(p_name));
		// return projectRepository.selectName(p_name);
		List<Project> p = new ArrayList<Project>();

		for (Project project : projectList) {
			if (project.getP_name().equals(p_name)) {
				System.out.println(project.getP_name());
				p.add(project);
			}
		}
		return p;
	}

	@PostMapping(value = { "/projects" }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String post(@RequestBody Project project) {
		try {
			// projectRepository.insert(project);
			projectList.add(project);
			System.out.println(projectList);
			return "1";
		} catch (Exception e) {
		}
		return "0";
	}

	@DeleteMapping("/projects/{domain}")
	public void delete(@PathVariable String domain) {
		// projectRepository.delete(domain);
		for (Project project : projectList) {
			if (project.getP_domain() == domain) {
				projectList.remove(project);
			}
		}
	}

}
