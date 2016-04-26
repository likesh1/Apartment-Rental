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
import org.apartments.uncc.delegate.LoginDelegate;
import org.apartments.uncc.exceptions.InvalidCredentialsException;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.RegistrationBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AdminController {
	
	@Autowired
	private AdminDelegate adminDelegate;
	@Autowired
	private LoginDelegate loginDelegate;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		LoginBean loginBean=new LoginBean();
		model.addAttribute("loginBean", loginBean);
		
		return "adminLogin";
	}
	
	@RequestMapping(value="/admin.do", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean)
	{
		ModelAndView model= null;
			UserDetailsBean validUser;
			try {
				validUser = loginDelegate.isValidUser(loginBean);
				
				try {
					//apartment=apt.aparmentAll();
					List<String> ownerEmail=adminDelegate.getListOfOwner();
					System.out.println(ownerEmail.size());
					request.setAttribute("ownerEmails", ownerEmail);
					model = new ModelAndView("admin");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidCredentialsException e) {
				// TODO Auto-generated catch block
				//RegistrationBean registrationBean = new RegistrationBean();
				//RegistrationBean registrationBean = new RegistrationBean();
				//model = new ModelAndView("home");
				//model.addAttribute("serverTime", formattedDate );
				//request.setAttribute("registrationBean", registrationBean);
					model = new ModelAndView("adminLogin");
					request.setAttribute("loginErrorMessage", e.getMessage());
					//request.setAttribute("isSignupError",false);
			}	
		return model;
		
	}
	
	@RequestMapping(value="/sendEmail", method= RequestMethod.POST)
	public ModelAndView discussionForum(HttpServletRequest request, HttpServletResponse response)   
	{ 
		System.out.println("Controller Called");
		try {
			//apartment=apt.aparmentAll();
			List<String> ownerEmail=adminDelegate.getListOfOwner();
			int index=ownerEmail.indexOf(request.getParameter("hdnEmail"));
			ownerEmail.remove(index);			
			System.out.println(ownerEmail.size());
			request.getParameter("hdnEmail");
			boolean i=adminDelegate.makeOwnerActive(request.getParameter("hdnEmail"));
			System.out.println("sjdbfjsb"+i);
			System.out.println(request.getParameter("hdnEmail"));
			request.setAttribute("ownerEmails", ownerEmail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView model= new ModelAndView("admin");
		return model;
	}

}
