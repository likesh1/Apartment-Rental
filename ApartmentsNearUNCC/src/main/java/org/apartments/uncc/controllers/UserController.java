/**
 * 
 */
package org.apartments.uncc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Pritam
 *
 */
@Controller
public class UserController {
	
	@RequestMapping(value="/logout.do", method= RequestMethod.GET)
	public String logout(HttpServletRequest request)    
	{ 
		HttpSession session=request.getSession();
		System.out.println("Session is : "+ session.getAttribute("user"));
		session.invalidate();
		//System.out.println("Session is : "+ session.getAttribute("user"));
		return "redirect:/";
	}

}
