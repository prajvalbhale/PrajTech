package org.prajval.RepositoryLayer;

import org.prajval.EntityLayer.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {

	@Query("SELECT u FROM AdminEntity u WHERE u.AdminMail = :AdminMail AND u.Password = :Password")
	public AdminEntity findByUsernameAndPassword(@Param("AdminMail") String AdminMail, @Param("Password") String Password);

}
