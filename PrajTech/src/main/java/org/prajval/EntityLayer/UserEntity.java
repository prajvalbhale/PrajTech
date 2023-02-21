package org.prajval.EntityLayer;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userentity")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private int UserID;

	@Column(name = "userrole")
	private String UserRole;

	@Column(name = "firstname")
	private String UserFirstName;

	@Column(name = "lastname")
	private String UserLastName;

	@Column(name = "mobileno")
	private String UserMobileNo;

	@Column(name = "mailid", unique = true)
	private String UserMailID;

	@Column(name = "collegename")
	private String CollegeName;

	@Column(name = "collegepin")
	private String CollegePin;

	@Column(name = "regno")
	private String RegisterNo;

	@Column(name = "idcard")
	private String CollegeIDCard;

	// private String Password;
	@Column(name = "conpass")
	private String ConfirmPassword;

	@Column(name = "enb")
	private Boolean enabled;

	public UserEntity(int userID, String userRole, String userFirstName, String userLastName, String userMobileNo,
			String userMailID, String collegeName, String collegePin, String registerNo, String collegeIDCard,
			String confirmPassword, Boolean enabled, Set<ProjectEntity> projectsEntities) {
		super();
		UserID = userID;
		UserRole = userRole;
		UserFirstName = userFirstName;
		UserLastName = userLastName;
		UserMobileNo = userMobileNo;
		UserMailID = userMailID;
		CollegeName = collegeName;
		CollegePin = collegePin;
		RegisterNo = registerNo;
		CollegeIDCard = collegeIDCard;
		ConfirmPassword = confirmPassword;
		this.enabled = enabled;
	}

	public int getUserID() {
		return UserID;
	}


	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getUserRole() {
		return UserRole;
	}

	public void setUserRole(String userRole) {
		UserRole = userRole;
	}

	public String getUserFirstName() {
		return UserFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		UserFirstName = userFirstName;
	}

	public String getUserLastName() {
		return UserLastName;
	}

	public void setUserLastName(String userLastName) {
		UserLastName = userLastName;
	}

	public String getUserMobileNo() {
		return UserMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		UserMobileNo = userMobileNo;
	}

	public String getUserMailID() {
		return UserMailID;
	}

	public void setUserMailID(String userMailID) {
		UserMailID = userMailID;
	}

	public String getCollegeName() {
		return CollegeName;
	}

	public void setCollegeName(String collegeName) {
		CollegeName = collegeName;
	}

	public String getCollegePin() {
		return CollegePin;
	}

	public void setCollegePin(String collegePin) {
		CollegePin = collegePin;
	}

	public String getRegisterNo() {
		return RegisterNo;
	}

	public void setRegisterNo(String registerNo) {
		RegisterNo = registerNo;
	}

	public String getCollegeIDCard() {
		return CollegeIDCard;
	}

	public void setCollegeIDCard(String collegeIDCard) {
		CollegeIDCard = collegeIDCard;
	}

	public String getConfirmPassword() {
		return ConfirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public UserEntity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserEntity [UserID=" + UserID + ", UserRole=" + UserRole + ", UserFirstName=" + UserFirstName
				+ ", UserLastName=" + UserLastName + ", UserMobileNo=" + UserMobileNo + ", UserMailID=" + UserMailID
				+ ", CollegeName=" + CollegeName + ", CollegePin=" + CollegePin + ", RegisterNo=" + RegisterNo
				+ ", CollegeIDCard=" + CollegeIDCard + ", ConfirmPassword=" + ConfirmPassword + ", enabled=" + enabled + "]";
	}
}