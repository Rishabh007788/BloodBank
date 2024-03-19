package blood.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Donations {
	@Id
	@SequenceGenerator(initialValue = 1001, allocationSize = 1,sequenceName ="donation_id" ,name = "donation_id")
	@GeneratedValue(generator="donation_id")
	int donation_id;
	String city;
	String blood_group;
	String blood_amount;

	boolean genetic_disorder;
	boolean medication;
	Date target_date;
	LocalDateTime date_of_apply;
	LocalDateTime date_of_complt;
	
	String status;
	String reason;
	@ManyToOne
	UserDetails userDetails;
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public int getDonation_id() {
		return donation_id;
	}
	public void setDonation_id(int donation_id) {
		this.donation_id = donation_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public boolean getGenetic_disorder() {
		return genetic_disorder;
	}
	public void setGenetic_disorder(boolean genetic_disorder) {
		this.genetic_disorder = genetic_disorder;
	}
	public boolean getMedication() {
		return medication;
	}
	public void setMedication(boolean medication) {
		this.medication = medication;
	}
	public Date getTarget_date() {
		return target_date;
	}
	public void setTarget_date(Date target_date) {
		this.target_date = target_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LocalDateTime getDate_of_apply() {
		return date_of_apply;
	}
	public void setDate_of_apply(LocalDateTime date_of_apply) {
		this.date_of_apply = date_of_apply;
	}
	public String getBlood_amount() {
		return blood_amount;
	}
	public void setBlood_amount(String blood_amount) {
		this.blood_amount = blood_amount;
	}
	public LocalDateTime getDate_of_complt() {
		return date_of_complt;
	}
	public void setDate_of_complt(LocalDateTime date_of_complt) {
		this.date_of_complt = date_of_complt;
	}
	

}
