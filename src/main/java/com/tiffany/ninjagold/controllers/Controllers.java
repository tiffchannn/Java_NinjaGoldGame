package com.tiffany.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllers {
	
	@RequestMapping("/gold")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(path="/goldCounter", method=RequestMethod.POST)
	public String goldCounter(@RequestParam(value="hidden") String hidden, HttpSession session) {
		
//		switch (hidden) {
//			case "farm": 
//			/// Do farm things
//			break;
//			case "cave":
//			break;
//			default:
//				// Does nothing
//		}
		
		String format = "EEEEE dd yyyy KK:mm aa";
		SimpleDateFormat dateFormat= new SimpleDateFormat(format);
		ArrayList<String> list = new ArrayList<String>();
		
		Integer goldCount = (Integer) session.getAttribute("goldCount");
		if (goldCount == null) {
			session.setAttribute("goldCount", 0);
		}
		
		if (hidden.equals("farm")) {
			Integer generateGold = ThreadLocalRandom.current().nextInt(10,21);
			String timeStamp = dateFormat.format(new Date());
			ArrayList<String> list = (ArrayList<String>) session.getAttribute("activityLog");
			list.add(0, "<p>You entered a farm and earned " +  goldCount+ " gold.(" + timeStamp + ")</p>");
			session.setAttribute("goldCount", (Integer) session.getAttribute("goldCount") + generateGold);
			session.setAttribute("activityList", list);
		}
		
		if (hidden.equals("cave")) {
			Integer generateGold = ThreadLocalRandom.current().nextInt(5,11);
			String timeStamp = dateFormat.format(new Date());
			ArrayList<String> list = (ArrayList<String>) session.getAttribute("activityLog");
			list.add(0, "<p>You entered a cave and earned " +  goldCount+ " gold.(" + timeStamp + ")</p>");
			session.setAttribute("goldCount", (Integer) session.getAttribute("goldCount") + generateGold);
			session.setAttribute("activityList", list);
		}
		
		if (hidden.equals("house")) {
			Integer generateGold = ThreadLocalRandom.current().nextInt(2,6);
			String timeStamp = dateFormat.format(new Date());
			ArrayList<String> list = (ArrayList<String>) session.getAttribute("activityLog");
			list.add(0, "<p>You entered a house and earned " +  goldCount+ " gold.(" + timeStamp + ")</p>");
			session.setAttribute("goldCount", (Integer) session.getAttribute("goldCount") + generateGold);
			session.setAttribute("activityList", list);
		}
		
		if (hidden.equals("casino")) {
			Integer generateGold = ThreadLocalRandom.current().nextInt(51);
			String timeStamp = dateFormat.format(new Date());
			ArrayList<String> list = (ArrayList<String>) session.getAttribute("activityLog");
			list.add(0, "<p>You entered a casino and earned " +  goldCount+ " gold.(" + timeStamp + ")</p>");
			session.setAttribute("goldCount", (Integer) session.getAttribute("goldCount") + generateGold);
			session.setAttribute("activityList", list);
		}
		
		System.out.println("Successfully submitted form!");
		return "redirect:/processGold";
	}
	
	@RequestMapping("/processGold")
	public String processGold(HttpSession session , Model model) {
		Integer goldCount = (Integer) session.getAttribute("goldCount");
		model.addAttribute("goldCount", goldCount);
		return "index.jsp";
	}
}
