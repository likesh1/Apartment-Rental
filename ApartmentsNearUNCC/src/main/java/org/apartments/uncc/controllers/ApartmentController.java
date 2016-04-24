/**
 * 
 */
package org.apartments.uncc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apartments.uncc.delegate.ApartmentDetailsDelegate;
import org.apartments.uncc.delegate.ApartmentListDelegate;
import org.apartments.uncc.delegate.MailDelegate;
import org.apartments.uncc.utilities.impl.SendEmailUtilityImpl;
import org.apartments.uncc.viewBeans.ApartmentDetailsBean;
import org.apartments.uncc.viewBeans.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Pritam
 *
 */
@Controller
public class ApartmentController {

	@Autowired
	private ApartmentListDelegate apartmentListDelegate;
	@Autowired
	private ApartmentDetailsDelegate apartmentDetailsDelegate;
	@Autowired
	private SendEmailUtilityImpl sendEmailUtilityImpl;
	@Autowired
	private MailDelegate mailDelegate;
	
	@RequestMapping(value="/addApartment", method = RequestMethod.GET)
	public ModelAndView newAptPage(HttpServletRequest request, HttpServletResponse response)
	{
		//HttpServletRequest request, HttpServletResponse response, , @RequestParam(value="otp", required=false) String otp,
		ModelAndView model= new ModelAndView("addNewApt");
		ApartmentDetailsBean aptDetails=new ApartmentDetailsBean();
		request.setAttribute("newApartment", aptDetails);
		return model;
		
	}
	
	@RequestMapping(value="/addNewApartment", method = RequestMethod.POST)
	public ModelAndView addNewApartment(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("newApartment")ApartmentDetailsBean newApartment)
	{
		ModelAndView model= new ModelAndView("addNewApt");
		ApartmentDetailsBean aptDetails=new ApartmentDetailsBean();
		request.setAttribute("newApartment", aptDetails);
		System.out.println("Deposit is - "+newApartment.getDepositAmt()+"\nRent is - "+newApartment.getRent()+"\nflooring is "+newApartment.getFlooring());
		return model;
	}
	
}
