package org.prajval.ServiceLayer;

import java.util.List;

import org.prajval.EntityLayer.UserEntity;
import org.prajval.RepositoryLayer.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	UserRepository userRepository;
	
	@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	
	/**/
	public UserEntity InsertUser(UserEntity u)
	{
		return userRepository.save(u);
	}
	
	public UserEntity findbymail(String mailid)
	{
		return userRepository.findUserByMail(mailid);
	}
	public UserEntity findbypass(String conpass)
	{
		return userRepository.findUserBypass(conpass);
	}
	
	public List<UserEntity> getUserList(){
		return userRepository.findAll();
	}
	
	public UserEntity findByUsernameAndPassword(String UserMailID, String ConfirmPassword) {
        return userRepository.findByUsernameAndPassword(UserMailID, ConfirmPassword);
    }
}
