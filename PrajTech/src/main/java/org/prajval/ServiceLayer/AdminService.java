package org.prajval.ServiceLayer;

import org.prajval.EntityLayer.AdminEntity;
import org.prajval.RepositoryLayer.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	private AdminRepository adminRepository;
	
	@Autowired
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	public AdminEntity findByUsernameAndPassword(String AdminMail, String Password) {
        return adminRepository.findByUsernameAndPassword(AdminMail, Password);
    }
	
	public AdminEntity makeAdmin(AdminEntity a) {
		return adminRepository.save(a);
	}
}
