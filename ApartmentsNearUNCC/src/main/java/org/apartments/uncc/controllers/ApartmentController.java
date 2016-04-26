/**
 * 
 */
package org.apartments.uncc.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apartments.uncc.delegate.ApartmentDetailsDelegate;
import org.apartments.uncc.delegate.ApartmentListDelegate;
import org.apartments.uncc.delegate.MailDelegate;
import org.apartments.uncc.delegate.OwnerDelegate;
import org.apartments.uncc.utilities.impl.SendEmailUtilityImpl;
import org.apartments.uncc.viewBeans.ApartmentDetailsBean;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.TenantBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Pritam
 *
 */
@Controller
@SessionAttributes({"aptId","aptDetails","myTenants","imagePath"})
public class ApartmentController {
	private static final Logger logger = LoggerFactory.getLogger(ApartmentController.class);
	@Autowired
	private ApartmentListDelegate apartmentListDelegate;
	@Autowired
	private ApartmentDetailsDelegate apartmentDetailsDelegate;
	@Autowired
	private SendEmailUtilityImpl sendEmailUtilityImpl;
	@Autowired
	private MailDelegate mailDelegate;
	@Autowired
	private OwnerDelegate ownerDelegate;
	
	@RequestMapping(value="/addApartment", method = RequestMethod.GET)
	public ModelAndView newAptPage(HttpServletRequest request, HttpServletResponse response)
	{
		//HttpServletRequest request, HttpServletResponse response, , @RequestParam(value="otp", required=false) String otp,
		ModelAndView model= new ModelAndView("addNewApt");
		ApartmentDetailsBean aptDetails=new ApartmentDetailsBean();
		request.setAttribute("newApartment", aptDetails);
		TenantBean tenant=new TenantBean();
		request.setAttribute("newTenant", tenant);
		return model;
		
	}
	
	@RequestMapping(value="/addNewApartment", method = RequestMethod.POST)
	public ModelAndView addNewApartment(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("newApartment")ApartmentDetailsBean newApartment)
	{
		
		//readonly="readonly" 
		ModelAndView model= new ModelAndView("addNewApt");
		HttpSession session=request.getSession();
		UserDetailsBean user=(UserDetailsBean) session.getAttribute("user");
		//ApartmentDetailsBean aptDetails=new ApartmentDetailsBean();
		TenantBean tenant=new TenantBean();
		request.setAttribute("newApartment", newApartment);
		request.setAttribute("newTenant", tenant);
		System.out.println("Date is - "+newApartment.getDate()+"\nRent is - "+newApartment.getRent()+"\nflooring is "+newApartment.getFlooring());
		int id=ownerDelegate.getNewApartmentId(newApartment,user.getUsername());
		System.out.println("Id is --"+id);
		//System.out.println("Date is - "+newApartment.getDate()+"\nRent is - "+newApartment.getRent()+"\nflooring is "+newApartment.getFlooring());
		model.addObject("aptId", id);
		request.setAttribute("successInAddApt", "Your apartment has been added succesfully!!");
		return model;
	}
	
	@RequestMapping(value="/saveImages", method= RequestMethod.POST)
	public ModelAndView saveImages(HttpServletRequest request, HttpServletResponse response, @RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files)
	{
		//if (files.length != names.length)
			//return "Mandatory information missing";
		ModelAndView model= new ModelAndView("addNewApt");
		HttpSession session=request.getSession();
		System.out.println("--aptId is -- "+session.getAttribute("aptId"));
		String aptId=((Integer) session.getAttribute("aptId")).toString();
		ownerDelegate.uploadFile(aptId,names,files);
		ApartmentDetailsBean aptDetails=new ApartmentDetailsBean();
		request.setAttribute("newApartment", aptDetails);
		TenantBean tenant=new TenantBean();
		//request.setAttribute("newApartment", newApartment);
		request.setAttribute("newTenant", tenant);
		request.setAttribute("saveImageSuccess", "Images Uploaded Successfully!!");
		//return message;
		return model;
	}
	
	@RequestMapping(value="/addNewTenant", method= RequestMethod.POST)
	public ModelAndView addNewTenant(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("newTenant")TenantBean newTenant)
	{
		ModelAndView model= new ModelAndView("addNewApt");
		HttpSession session=request.getSession();
		System.out.println("--aptId is -- "+session.getAttribute("aptId"));
		String aptId=((Integer) session.getAttribute("aptId")).toString();
		ownerDelegate.addTenant(aptId,newTenant);
		ApartmentDetailsBean aptDetails=new ApartmentDetailsBean();
		request.setAttribute("newApartment", aptDetails);
		TenantBean tenant=new TenantBean();
		//request.setAttribute("newApartment", newApartment);
		request.setAttribute("newTenant", tenant);
		request.setAttribute("successInAddTenant", "Tenant Details added Successfully!!");
		//return message;
		return model;
	}
	
	
	@RequestMapping(value="/myAptDetails", method=RequestMethod.GET)
	public ModelAndView apartmentDetails(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="id", required=false) String id)
	{
		ModelAndView model= new ModelAndView("editApartmentDetails");
		HttpSession session=request.getSession();
		@SuppressWarnings("unchecked")
		List<ApartmentDetailsBean> myApartments=(List<ApartmentDetailsBean>) session.getAttribute("myApartments");
		ApartmentDetailsBean aptBean=new ApartmentDetailsBean();
		System.out.println("my apt id is "+id+myApartments);
		aptBean.setApartmentId(Integer.parseInt(id));
		int index=myApartments.indexOf(aptBean);
		aptBean=myApartments.get(index);
		System.out.println("Availability Date is - "+aptBean.getAvailablityFrom().toString());
		aptBean.setDate(aptBean.getAvailablityFrom().toString());
		request.setAttribute("aptDetails",aptBean);
		session.setAttribute("aptDetails", aptBean);
		String imagePath=ownerDelegate.getImagePath(Integer.parseInt(id));
		List<TenantBean> tenants=ownerDelegate.getTenants(Integer.parseInt(id));
		session.setAttribute("myTenants", tenants);
		session.setAttribute("imagePath", imagePath);
		session.setAttribute("aptId", id);
		logger.info("path is "+imagePath);
		return model;
	}
	
	@RequestMapping(value="/saveImage", method= RequestMethod.POST)
	public ModelAndView saveImage(HttpServletRequest request, HttpServletResponse response, @RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files)
	{
		//if (files.length != names.length)
			//return "Mandatory information missing";
		ModelAndView model= new ModelAndView("editApartmentDetails");
		HttpSession session=request.getSession();
		System.out.println("--aptId is -- "+session.getAttribute("aptId"));
		String aptId=(String) session.getAttribute("aptId");
		ownerDelegate.uploadFile(aptId,names,files);
		ApartmentDetailsBean aptDetails=(ApartmentDetailsBean) session.getAttribute("aptDetails");
		request.setAttribute("newApartment", aptDetails);
		//TenantBean tenant=(TenantBean) 
		//request.setAttribute("newApartment", newApartment);
		//request.setAttribute("aptDetails", tenant);
		request.setAttribute("saveImageSuccess", "Images Uploaded Successfully!!");
		//return message;
		return model;
	}
	
	@RequestMapping(value="/updateTenant", method=RequestMethod.POST)
	public ModelAndView updateTenants(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView model= new ModelAndView("editApartmentDetails");
		HttpSession session=request.getSession();
		System.out.println("--aptId is -- "+session.getAttribute("aptId"));
		String aptId=(String) session.getAttribute("aptId");
		TenantBean tenantUpdated=new TenantBean();
		tenantUpdated.setTage(Integer.parseInt(request.getParameter("age")));
		tenantUpdated.setNationality(request.getParameter("Nationality"));
		tenantUpdated.settEmail(request.getParameter("email"));
		tenantUpdated.setTgender(request.getParameter("tgender"));
		tenantUpdated.setTfirstName(request.getParameter("fName"));
		tenantUpdated.setTlastName(request.getParameter("lName"));
		ownerDelegate.updateTenant(Integer.parseInt(request.getParameter("tenId")),tenantUpdated);
		ApartmentDetailsBean aptDetails=(ApartmentDetailsBean) session.getAttribute("aptDetails");
		request.setAttribute("newApartment", aptDetails);
		//TenantBean tenant=(TenantBean) 
		//request.setAttribute("newApartment", newApartment);
		//request.setAttribute("aptDetails", tenant);
		request.setAttribute("updateTenantSuccess", "Tenant Uploaded Successfully!!");
		//return message;
		return model;
	}
	
}
