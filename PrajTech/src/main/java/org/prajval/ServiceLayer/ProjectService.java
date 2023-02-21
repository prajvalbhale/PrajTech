package org.prajval.ServiceLayer;

import java.util.List;

import org.prajval.EntityLayer.ProjectEntity;
import org.prajval.RepositoryLayer.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	private ProjectRepository projectRepository;

	@Autowired
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	// this will insert project
	public ProjectEntity insertProject(ProjectEntity projectEntity) {
		return projectRepository.save(projectEntity);
	}

	public List<ProjectEntity> getAll() {
		return projectRepository.findAll();
	}

	public ProjectEntity getProjectById(long id) {
		return projectRepository.findById(id).orElse(null);
	}
}