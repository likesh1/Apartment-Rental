package org.apartments.uncc.controllers;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apartments.uncc.delegate.ApartmentDetailsDelegate;
import org.apartments.uncc.delegate.ApartmentListDelegate;
import org.apartments.uncc.delegate.LoginDelegate;
import org.apartments.uncc.delegate.MailDelegate;
import org.apartments.uncc.delegate.RegistrationDelegate;
import org.apartments.uncc.exceptions.InvalidCredentialsException;
import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.utilities.impl.SendEmailUtilityImpl;
import org.apartments.uncc.viewBeans.ApartmentDetailsBean;
import org.apartments.uncc.viewBeans.FilterBean;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.MailBean;
import org.apartments.uncc.viewBeans.RegistrationBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"user","apartmentDetails","ownerDetails","tenantDetails","reviews","imageList"})
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	 
	@Autowired
	private LoginDelegate loginDelegate;
	@Autowired
	private RegistrationDelegate registrationDelegate;
	@Autowired
	private ApartmentListDelegate apartmentListDelegate;
	@Autowired
	private ApartmentDetailsDelegate apartmentDetailsDelegate;
	@Autowired
	private SendEmailUtilityImpl sendEmailUtilityImpl;
	@Autowired
	private MailDelegate mailDelegate;
	
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
		model.addAttribute("isSignupError",false);
		return "home";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean)
	{
		ModelAndView model= null;
			UserDetailsBean validUser;
			try {
				validUser = loginDelegate.isValidUser(loginBean);
				System.out.println("Id: "+validUser.getUsername()+" Role:"+validUser.getUserRole()+" Name:"+validUser.getfName());
				System.out.println("User Login Successful");
				request.setAttribute("loggedInUser", loginBean.getUsername());
				if(validUser.getUserRole().equals("student"))
					model = new ModelAndView("welcomeStudent");
				else
					model = new ModelAndView("welcomeOwner");
				model.addObject("user", validUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidCredentialsException e) {
				// TODO Auto-generated catch block
				RegistrationBean registrationBean = new RegistrationBean();
				//RegistrationBean registrationBean = new RegistrationBean();
				//model = new ModelAndView("home");
				//model.addAttribute("serverTime", formattedDate );
				request.setAttribute("registrationBean", registrationBean);
					model = new ModelAndView("home");
					request.setAttribute("loginErrorMessage", e.getMessage());
					request.setAttribute("isSignupError",false);
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
						UserDetailsBean userDetails=new UserDetailsBean();
						userDetails.setVerificationCode(registrationDelegate.getVerificationCode());
						System.out.println("Verification code is : "+userDetails.getVerificationCode());
						userDetails.setfName(registrationBean.getFname());
						userDetails.setUsername(registrationBean.getEmail());
						userDetails.setUserRole(registrationBean.getUserRole());
						registrationDelegate.sendVerificationMail(userDetails);
						//sendEmailUtilityImpl.sendEmail();
						System.out.println("User Registration Successful");
						//request.setAttribute("userDetails", userDetails);
						model = new ModelAndView("verification");
						model.addObject("user", userDetails);
				}
				

		}
		catch(InvalidEmailIdException ieie)
		{
			LoginBean loginBean=new LoginBean();
			//RegistrationBean registrationBean = new RegistrationBean();
			model = new ModelAndView("home");
			//model.addAttribute("serverTime", formattedDate );
			request.setAttribute("loginBean", loginBean);
			request.setAttribute("isSignupError",true);
			request.setAttribute("registrationErrorMessage", ieie.getMessage()+registrationBean.getEmail());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return model;
		
	}
	

	 

	@RequestMapping(value = "/apartmentList", method = RequestMethod.GET)

	public ModelAndView getaparments(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="Location", required=false) String location, HttpSession session) {

		System.out.println("Controller Called"+location);


		//ApartmentDaoImpl apt=new ApartmentDaoImpl();
		try {
			//apartment=apt.aparmentAll();
			List<ApartmentDetailsBean> apartment=apartmentListDelegate.getApartmentList(location);
			System.out.println("The apartment details"+apartment);
			request.setAttribute("apartmentList", apartment);

			session.setAttribute("apartmentsActualList", apartment);

			FilterBean filters=new FilterBean();

			List<String> rentValues = new ArrayList<String>();
			rentValues.add("$200 - $300");
			rentValues.add("$300 - $400");
			rentValues.add("$400 - $500");
			rentValues.add("above $500");

			List<String> roomValues = new ArrayList<String>();
			roomValues.add("1");
			roomValues.add("2");
			roomValues.add("3");
			roomValues.add("4");

			List<String> bathroomValues = new ArrayList<String>();
			bathroomValues.add("Attached");
			bathroomValues.add("Common");

			List<String> floor = new ArrayList<String>();
			floor.add("Carpet");
			floor.add("Wooden");

			request.setAttribute("filterBean", filters);
			request.setAttribute("rentValues", rentValues);
			request.setAttribute("roomValues", roomValues);
			request.setAttribute("bathroomValues", bathroomValues);
			request.setAttribute("floorValues", floor);	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView model = new ModelAndView("apartment");
		return model;

	}
	
	@RequestMapping(value = "/apartmentDetails", method = RequestMethod.GET)

	 public ModelAndView getaparmentDetails(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id", required=false) String id) {

	 System.out.println("apartmentDetailsController Called"+id);

	 
	 //apartment=apt.aparmentAll();
	 MailBean mailBean=new MailBean();
	 Map apartment=apartmentDetailsDelegate.getApartmentDetails(id);
	 System.out.println("The apartment details"+apartment);
	
	 ModelAndView model = new ModelAndView("apartmentDetails");
	 model.addObject("apartmentDetails", apartment.get("ApartmentDetails"));
	 model.addObject("ownerDetails", apartment.get("OwnerDetails"));
	 model.addObject("tenantDetails", apartment.get("TenantDetails"));
	 model.addObject("reviews", apartment.get("ReviewAndRatings"));
	 model.addObject("imageList",apartment.get("images"));
	 model.addObject("MailBean", mailBean);


	 return model;

	 }
	
	@RequestMapping(value="/sendmail.do", method = RequestMethod.POST)
	public ModelAndView usermail(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("MailBean")MailBean mailBean)
	{
		ModelAndView model= null;
		try
		{
			//HttpSession session=request.getSession();
			
					//System.out.println("---Tada----"+session.getAttribute("ownerDetails"));
					 
						mailBean.setMailbody(mailBean.getMailbody());
						mailBean.setTo(mailBean.getTo());
						System.out.println("MSG : "+request.getParameter("mailbody"));
						System.out.println("InsideMailMapping!");
						mailDelegate.sendEnquiryMail(mailBean);
						System.out.println("InsideMailMapping2!");
						//request.setAttribute("userDetails", userDetails);
						model = new ModelAndView("apartmentDetails");
						
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return model ;
		
	}

	@RequestMapping(value="/validateUser", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response,@ModelAttribute(value="user") UserDetailsBean userDetails)
	{
		//HttpServletRequest request, HttpServletResponse response, , @RequestParam(value="otp", required=false) String otp,
		ModelAndView model= new ModelAndView("verification");
		System.out.println("OTP is : "+request.getParameter("otp")+"\nSession OTP is: "+userDetails.getVerificationCode());
		int userOtp=Integer.parseInt(request.getParameter("otp"));
		if(userOtp==(userDetails.getVerificationCode()))
		{	
			loginDelegate.activateAccount(userDetails.getUsername());
			if(userDetails.getUserRole().equals("student"))
				model= new ModelAndView("welcomeStudent");
			else
				model = new ModelAndView("welcomeOwner");
			System.out.println("OTP Matches");
		}
		return model;
		
	}
	
	@RequestMapping(value="/welcomeGuest", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView welcomeGuest(HttpServletRequest request, HttpServletResponse response)
	{
		//HttpServletRequest request, HttpServletResponse response, , @RequestParam(value="otp", required=false) String otp,
		ModelAndView model= new ModelAndView("welcomeGuest");
			
		return model;
		
	}

	@RequestMapping(value="/passwordRecovery.do" , method ={ RequestMethod.GET, RequestMethod.POST})
	public ModelAndView recoverPassword(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView model= new ModelAndView("passwordrecovery");
		if(request.getParameter("email")==null)
		{
			request.setAttribute("isValidEmail", false);
			request.setAttribute("isCorrectOtp", false);
		}
		else if(request.getParameter("otp")==null)
		{
			if(!(request.getParameter("email")==null))
				request.setAttribute("isValidEmail",true);
			request.setAttribute("isCorrectOtp", false);
		}
		else if((request.getParameter("otp")).length()>0)
		{
			request.setAttribute("isCorrectOtp", true);
			request.setAttribute("isValidEmail", true);
			
		}
		else if((request.getParameter("email")).length()>0)
		{
			request.setAttribute("isValidEmail", true);
		}
		return model;
	}
	
	@RequestMapping(value="/filterApts", method = RequestMethod.POST)
	public ModelAndView executeFilter(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("filterBean")FilterBean filterBean)
	{
		ModelAndView model= null;		

		List<String> rentValues = new ArrayList<String>();
		rentValues.add("$200 - $300");
		rentValues.add("$300 - $400");
		rentValues.add("$400 - $500");
		rentValues.add("above $500");

		List<Integer> roomValues = new ArrayList<Integer>();
		roomValues.add(1);
		roomValues.add(2);
		roomValues.add(3);
		roomValues.add(4);

		List<String> bathroomValues = new ArrayList<String>();
		bathroomValues.add("Attached");
		bathroomValues.add("Common");

		List<String> floor = new ArrayList<String>();
		floor.add("Carpet");
		floor.add("Wooden");

		request.setAttribute("rentValues", rentValues);
		request.setAttribute("roomValues", roomValues);
		request.setAttribute("bathroomValues", bathroomValues);
		request.setAttribute("floorValues", floor);

		System.out.println("khyati");
		HttpSession session=request.getSession();
		@SuppressWarnings("unchecked")
		List<ApartmentDetailsBean> apartments=(List<ApartmentDetailsBean>) session.getAttribute("apartmentsActualList");
		List<ApartmentDetailsBean> filteredApts= new ArrayList<ApartmentDetailsBean>();
		for (int i=0; i<apartments.size();i++)
		{
			System.out.println(apartments.get(i).getDoorNo());
			if(!(filterBean.getRoomFilter()==null))
			{
				System.out.println("---First----");
				if (filterBean.getRoomFilter().contains(apartments.get(i).getno_of_rooms()))
				{
					if(!(filterBean.getBathFilter()==null))
					{
						if (filterBean.getBathFilter().contains(apartments.get(i).getType_bathroom()))
						{
							if(!(filterBean.getFloorFilter()==null))
							{
								if (filterBean.getFloorFilter().contains(apartments.get(i).getFlooring()))
								{
									filteredApts.add(apartments.get(i));
								}
							}
							else
								filteredApts.add(apartments.get(i));
						}
					}
					else
						filteredApts.add(apartments.get(i));
				}
			}
			else if(!(filterBean.getBathFilter()==null))
			{
				System.out.println("---Second----");
				if (filterBean.getBathFilter().contains(apartments.get(i).getType_bathroom()))
				{
					if(!(filterBean.getFloorFilter()==null))
					{
						if (filterBean.getFloorFilter().contains(apartments.get(i).getFlooring()))
						{
							filteredApts.add(apartments.get(i));
						}
					}
					else
						filteredApts.add(apartments.get(i));
				}
				
			}
			else if(!(filterBean.getFloorFilter()==null))
			{
				System.out.println("---Third----");
				if (filterBean.getFloorFilter().contains(apartments.get(i).getFlooring()))
				{
					filteredApts.add(apartments.get(i));
				}
			}
			else{filteredApts=apartments;}
		}

		request.setAttribute("apartmentList", filteredApts);
		model=new ModelAndView("apartment");
		return model;
		
	}
	
}
