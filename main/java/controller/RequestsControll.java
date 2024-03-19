package blood.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import blood.dao.Requestdao;
import blood.dto.Requests;

@RestController
public class RequestsControll {
	@Autowired
	Requestdao requestdao;
	
	

	@RequestMapping("active")
	public ModelAndView chngStatusAct(@RequestParam int request_id, @RequestParam String status) {
		Requests requests = new Requests();
		requests=requestdao.fetchOne(request_id);
		requests.setStatus(status);
		
		 LocalDateTime currentDateTime = LocalDateTime.now();
	        
	        // Define the format pattern
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm");
	        
	        // Format the LocalDateTime
	        String formattedDateTime = currentDateTime.format(formatter);
		requests.setDateofComplition(formattedDateTime);
		List<Requests> allrequests=requestdao.fetchall();
		ModelAndView andView= new ModelAndView();
		andView.addObject("requests",allrequests);
		andView.setViewName("managerhome.jsp");
		return andView;
	}
	
	@RequestMapping("reasonchng")
	public ModelAndView chngReason(@RequestParam int request_id, @RequestParam String reason) {
		Requests requests = new Requests();
		requests=requestdao.fetchOne(request_id);
		requests.setReason(reason);
		
		 LocalDateTime currentDateTime = LocalDateTime.now();
	        
	        // Define the format pattern
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm");
	        
	        // Format the LocalDateTime
	        String formattedDateTime = currentDateTime.format(formatter);
		requests.setDateofComplition(formattedDateTime);
		List<Requests> allrequests=requestdao.fetchall();
		ModelAndView andView= new ModelAndView();
		andView.addObject("requests",allrequests);
		andView.setViewName("managerhome.jsp");
		return andView;
	}
	

	
}
