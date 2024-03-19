package blood.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;


@Entity
@Component
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	 String name; 
     String mobile;
     String email;
     String gender;
     Date dob;
     String city;
     String password;
     @OneToMany
     List<Requests> request;
     @OneToMany
     List<Donations> donations;
     
	public List<Donations> getDonations() {
		return donations;
	}
	public void setDonations(List<Donations> donations) {
		this.donations = donations;
	}
	public List<Requests> getRequest() {
		return request;
	}
	public void setRequest(List<Requests> request) {
		this.request = request;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

