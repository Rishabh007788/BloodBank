package blood.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import blood.dao.Donationdao;
import blood.dao.Requestdao;
import blood.dao.Userdao;
import blood.dto.Donations;
import blood.dto.Requests;
import blood.dto.UserDetails;

@Controller
public class UserControll {
	
	
	@Autowired
	UserDetails userDetails;
	
	@Autowired
	Userdao userdao;
	
	@Autowired
	Requestdao requestdao;
	
	@Autowired
	Donations donations;
	
	@Autowired
	Donationdao donationdao;
	
	@Autowired
	HttpSession session;

    @PostMapping("signup")
    @ResponseBody
    public ModelAndView handleSignupForm(
            @RequestParam String name,
            @RequestParam String mobile,
            @RequestParam String email,
            @RequestParam String gender,
            @RequestParam String dob,
            @RequestParam String city,
            @RequestParam String password) 
    {
    	ModelAndView andView = new ModelAndView();
    	userDetails.setCity(city);
    	userDetails.setDob(Date.valueOf(dob));
    	 userDetails.setEmail(email);
    	 userDetails.setGender(gender);
    	 userDetails.setMobile(mobile);
    	 userDetails.setName(name);
    	 userDetails.setPassword(password);
    	 userdao.save(userDetails);
    	 andView.addObject("msg", "account created succesfully");
    	 andView.setViewName("userlogin.jsp");
    	 
				return andView;
    }
    
    
    
    
    @RequestMapping("user_login")
    @ResponseBody
    public ModelAndView login(@RequestParam String email, @RequestParam String password) {
    	ModelAndView andView = new ModelAndView();
		UserDetails details=userdao.login(email);
		
		if (details!=null) {
			if (details.getPassword().equals(password)) {
				session.setAttribute("userDetails", details);
				andView.addObject("userdetails",details);
				
				andView.setViewName("userhome.jsp");
				
				return andView;
			} else {
				andView.addObject("msg","invalid email id or password");
				andView.setViewName("userlogin.jsp");
				return andView;
			}
		} else { 
			andView.addObject("msg","invalid email id or password");
			andView.setViewName("userlogin.jsp");
			return andView;
		}
	} 
    
    @RequestMapping("blood_request")
    @ResponseBody
    public ModelAndView request(@RequestParam String city, @RequestParam String blood_amount, @RequestParam String blood_group) 
    {
    	ModelAndView andView = new ModelAndView();
    	userDetails = (UserDetails) session.getAttribute("userDetails");
    	Requests requests=new Requests();
    	requests.setBlood_amount(blood_amount);
    	requests.setBlood_group(blood_group);
    	requests.setCity(city);      
    	requests.setDateofRequest(LocalDateTime.now().withNano(0));
    	requests.setUserDetails(userDetails);
    	requestdao.save(requests);
    	
    	//to set the data also in userdetails due to mapping
    	if (userDetails.getRequest()==null) {
			List<Requests> list=new ArrayList<Requests>();
			list.add(requests);
			userDetails.setRequest(list);
	    	userdao.update(userDetails);
		} else {
			List<Requests> list=userDetails.getRequest();
			list.add(requests);
			userDetails.setRequest(list);
	    	userdao.update(userDetails);
		} 
    	//return to home page;
    	userDetails=userdao.fetch(userDetails.getId());
    	// Redirect to user home page
       
        andView.addObject("reqmsg", "Your request has been successfully initiated. your request id is" + userDetails.getRequest().getLast().getRequest_id());
        andView.addObject("userDetails", userDetails);
        andView.setViewName("userhome.jsp");
        return andView;  	
	}
    
 //###################################################   
    
    @PostMapping("blood_donate")
    @ResponseBody
    public ModelAndView donate(@RequestParam String city,
    		@RequestParam String blood_group,
    		@RequestParam boolean medication,
    		@RequestParam boolean genetic_disorder,
    		@RequestParam String target_date) 
    {
    	ModelAndView andView = new ModelAndView();
    	userDetails = (UserDetails) session.getAttribute("userDetails");
    	Donations donations = new Donations();
		donations.setBlood_group(blood_group);
		donations.setCity(city);
		donations.setGenetic_disorder(genetic_disorder);
		donations.setMedication(medication);
		donations.setTarget_date(Date.valueOf(target_date));
		donations.setDate_of_apply(LocalDateTime.now().withNano(0).withSecond(0));
		donations.setUserDetails(userDetails);
		donationdao.save(donations);
		
		if (userDetails.getDonations()==null) {
			List<Donations> list=new ArrayList<Donations>();
			list.add(donations);
			userDetails.setDonations(list);		
		}
		else {
			List<Donations> list=userDetails.getDonations();
			list.add(donations);
			userDetails.setDonations(list);
		}	
		userdao.update(userDetails);	
		userDetails=userdao.fetch(userDetails.getId());
		session.setAttribute("userDetails", userDetails);
		andView.addObject("donmsg","thank you for your donation your donation-id is "+userDetails.getDonations().getLast().getDonation_id());
		andView.setViewName("userhome.jsp");
		return andView;		
	}
    
    //###########################################################

	
}


