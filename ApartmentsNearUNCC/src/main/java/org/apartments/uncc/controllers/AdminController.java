package org.apartments.uncc.controllers;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apartments.uncc.delegate.AdminDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AdminController {
	
	@Autowired
	private AdminDelegate adminDelegate;
	
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		return "adminLogin";
	}
	
	@RequestMapping(value="/adminApproval", method= RequestMethod.GET)
	public ModelAndView discussionForum(HttpServletRequest request, HttpServletResponse response)   
	{ 
		System.out.println("Controller Called");
		try {
			//apartment=apt.aparmentAll();
			List<String> ownerEmail=adminDelegate.getListOfOwner();	
			request.setAttribute("ownerEmails", ownerEmail);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView model= new ModelAndView("admin");
		return model;
	}

}
