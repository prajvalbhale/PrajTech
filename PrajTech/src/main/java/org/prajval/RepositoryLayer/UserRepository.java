package org.prajval.RepositoryLayer;

import org.prajval.EntityLayer.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	@Query("select u from UserEntity u where u.UserMailID=:UserMailID")
	public UserEntity getUserByMail(@Param("UserMailID") String UserMailID);
	
	@Query("select u from UserEntity u where u.UserMailID=?1")
	public UserEntity findUserByMail(String UserMailID);
	
	@Query("select u from UserEntity u where u.ConfirmPassword=?1")
	public UserEntity findUserBypass(String ConfirmPassword);
	
	@Query("SELECT u FROM UserEntity u WHERE u.UserMailID = :UserMailID AND u.ConfirmPassword = :ConfirmPassword")
	public UserEntity findByUsernameAndPassword(@Param("UserMailID") String UserMailID, @Param("ConfirmPassword") String ConfirmPassword);
}
