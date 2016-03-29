package org.apartments.uncc.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apartments.uncc.delegate.LoginDelegate;
import org.apartments.uncc.delegate.RegistrationDelegate;
import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.RegistrationBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	 
	@Autowired
	private LoginDelegate loginDelegate;
	@Autowired
	private RegistrationDelegate registrationDelegate;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		LoginBean loginBean=new LoginBean();
		RegistrationBean registrationBean = new RegistrationBean();
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("loginBean", loginBean);
		model.addAttribute("registrationBean", registrationBean);
		return "home";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean)
	{
		ModelAndView model= null;
		try
		{
				boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
				if(isValidUser)
				{
						System.out.println("User Login Successful");
						request.setAttribute("loggedInUser", loginBean.getUsername());
						model = new ModelAndView("welcome");
				}
				else
				{
						model = new ModelAndView("home");
						request.setAttribute("loginErrorMessage", "Invalid credentials!!");
				}

		}
		catch(Exception e)
		{
				e.printStackTrace();
		}

		return model;
		
	}
	
	@RequestMapping(value="/register.do", method = RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("registrationBean")RegistrationBean registrationBean)
	{
		ModelAndView model= null;
		try
		{
				boolean isValidRegistration = registrationDelegate.isValidRegistration(registrationBean);
				if(isValidRegistration)
				{
						System.out.println("User Registration Successful");
						request.setAttribute("loggedInUser", registrationBean.getFname());
						model = new ModelAndView("welcome");
				}
				

		}
		catch(InvalidEmailIdException ieie)
		{
			LoginBean loginBean=new LoginBean();
			//RegistrationBean registrationBean = new RegistrationBean();
			model = new ModelAndView("home");
			//model.addAttribute("serverTime", formattedDate );
			request.setAttribute("loginBean", loginBean);
			
			request.setAttribute("registrationErrorMessage", ieie.getMessage()+registrationBean.getEmail());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return model;
		
	}
	

	 

	 @RequestMapping(value = "/apartmentList", method = RequestMethod.GET)

	 public ModelAndView getaparments(HttpServletRequest request, HttpServletResponse response) {

	 System.out.println("Controller Called");

	 //List<ApartmentDaoImpl> apartment=new ArrayList<ApartmentDaoImpl>();

	 ModelAndView model = new ModelAndView("apartment");



	 return model;

	 }

	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView model= new ModelAndView("welcome");

		return model;
		
	}

	
	
}
