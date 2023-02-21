package org.prajval.EntityLayer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="adminentity")
public class AdminEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int AdminID;
	
	@Column(name = "adminname")
	private String AdminMail;
	
	@Column(name = "adminpass")
	private String Password;
	
	@Column(name = "role")
	private String Role;
	
	@Column(name = "enb")
	private Boolean enabled;

	@Override
	public String toString() {
		return "AdminEntity [AdminID=" + AdminID + ", AdminMail=" + AdminMail + ", Password=" + Password + ", Role="
				+ Role + ", enabled=" + enabled + "]";
	}

	public AdminEntity(int adminID, String adminMail, String password, String role, Boolean enabled) {
		super();
		AdminID = adminID;
		AdminMail = adminMail;
		Password = password;
		Role = role;
		this.enabled = enabled;
	}

	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
