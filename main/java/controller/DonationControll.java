package blood.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import blood.dao.Donationdao;
import blood.dto.Donations;

@RestController
public class DonationControll {
	@Autowired
	Donationdao donationdao;
	
	@RequestMapping("fetch_all_donations")
	@ResponseBody
	public ModelAndView fetchAllDonations(HttpSession session) {
		List<Donations> donations= donationdao.fetchAll();
		ModelAndView andView= new ModelAndView();
		andView.addObject("donations",donations);
		andView.setViewName("checkdonations.jsp");
		return andView;
		
	}
	
	@RequestMapping("check_donation")
	@ResponseBody
	public ModelAndView fetchOneDonation(@RequestParam int donation_id) {
		Donations donation= donationdao.fetchone(donation_id);
		ModelAndView andView= new ModelAndView();
		andView.addObject("donation",donation);
		andView.setViewName("donationapplication.jsp");
		return andView;
		
	}

	@PostMapping("donation_status_chng")
	public ModelAndView changeStatus(@RequestParam int donation_id, @RequestParam String status) {
		
		Donations donation=donationdao.fetchone(donation_id); 
		donation.setStatus(status);
		donation.setDate_of_complt(LocalDateTime.now().withNano(0).withSecond(0));
		donationdao.update(donation);
		 donation= donationdao.fetchone(donation_id);
			ModelAndView andView= new ModelAndView();
			andView.addObject("donation",donation);
			andView.setViewName("donationapplication.jsp");
			return andView;
	}
	
	@PostMapping("donation_reason_chng")
	public ModelAndView changeReason(@RequestParam int donation_id, @RequestParam String reason) {
		
		Donations donation=donationdao.fetchone(donation_id); 
		donation.setReason(reason);
		donationdao.update(donation);
		
		 donation= donationdao.fetchone(donation_id);
			ModelAndView andView= new ModelAndView();
			andView.addObject("donation",donation);
			andView.setViewName("donationapplication.jsp");
			return andView;
	}
	
	@PostMapping("set_blood_amount")
	public ModelAndView setDonationAmount(@RequestParam int donation_id, @RequestParam String blood_amount) {
		
		Donations donation=donationdao.fetchone(donation_id); 
		donation.setBlood_amount(blood_amount);
		donationdao.update(donation);
		 donation= donationdao.fetchone(donation_id);
		ModelAndView andView= new ModelAndView();
		andView.addObject("donation",donation);
		andView.setViewName("donationapplication.jsp");
		return andView;
	}
}
