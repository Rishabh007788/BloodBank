package blood.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import blood.dao.Donationdao;
import blood.dao.Requestdao;
import blood.dto.Donations;
import blood.dto.Requests;

@Controller
public class ManagerControll {
	
	@Autowired
	Requests requests;
	
	@Autowired
	Requestdao requestdao;
	
	@Autowired
	Donationdao donationdao;
	
	
	@RequestMapping("manager_login")
	@ResponseBody
	public ModelAndView login(@RequestParam String userid, @RequestParam String password) {
		
		ModelAndView andView = new ModelAndView();
		if (userid.equals("Bloodbankmgr")&&password.equals("Bloodbankmgr123")) {
			
			andView.setViewName("managerhome.jsp");
		} else {
			andView.addObject("msg", "invalid userid or password");
			andView.setViewName("managerlogin.jsp");
		}
		return andView;
	}
	
	@RequestMapping("fetch_all_requests")
	@ResponseBody
	public ModelAndView fetchAllRequests(HttpSession session) {
		List<Requests> allrequests=requestdao.fetchall();
		ModelAndView andView= new ModelAndView();
		andView.addObject("requests",allrequests);
		andView.setViewName("checkrequests.jsp");
		return andView;
		
	}
	

}


