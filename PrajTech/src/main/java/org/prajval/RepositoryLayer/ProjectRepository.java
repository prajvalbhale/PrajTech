package org.prajval.RepositoryLayer;

import org.prajval.EntityLayer.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long>{

	@Query("select u from ProjectEntity u where u.name=?1")
	public ProjectEntity findByName(@RequestParam("name") String name);
}
