package blood.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Requests {
	@Id
	@SequenceGenerator(initialValue = 1001, allocationSize = 1,sequenceName ="request_id" ,name = "request_id")
	@GeneratedValue(generator="request_id")
	int request_id;
	String city;
	String blood_group;
	String blood_amount;
	LocalDateTime dateofRequest;
	String status;
	String dateofComplition;
	String reason;
	@ManyToOne
	UserDetails userDetails;
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
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
	public String getBlood_amount() {
		return blood_amount;
	}
	public void setBlood_amount(String blood_amount) {
		this.blood_amount = blood_amount;
	}
	public LocalDateTime getDateofRequest() {
		return dateofRequest;
	}
	public void setDateofRequest(LocalDateTime localDateTime) {
		this.dateofRequest = localDateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDateofComplition() {
		return dateofComplition;
	}
	public void setDateofComplition(String dateofComplition) {
		this.dateofComplition = dateofComplition;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
