package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Customer;
import com.app.model.Login;
import com.app.model.Response;
import com.app.service.ICustomerService;

@RestController
public class CustomerController {

	@Autowired
	ICustomerService service;

	@RequestMapping("/")
	public String index() {
		return "Banking Application!";
	}

	// login ... userName : jay

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public Response login(@RequestBody Login login, HttpServletRequest request) {
		Response appResponse = new Response();
		HttpSession session = request.getSession(false);
		if (session != null) {
			// a session exists
			// user is already logged in
			session.setAttribute("loggedInUser", login.getUsername());
			appResponse.setMessage("login success");
		} else {
			// no session create session
			if ("jay".equals(login.getUsername())) {
				session = request.getSession();
				session.setAttribute("loggedInUser", login.getUsername());
				appResponse.setMessage("login success");
			} else {
				appResponse.setMessage("invalid username");
			}
		}
		return appResponse;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json")
	public Response logout(HttpServletRequest request) {
		Response appResponse = new Response();
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			appResponse.setMessage("logout success");
		}
		return appResponse;
	}

	// get

	@RequestMapping(value = "/customer/{accountNumber}", method = RequestMethod.GET, produces = "application/json")
	public Response getCustomer(@PathVariable("accountNumber") long accountNumber, HttpServletRequest request) {
		Response appResponse = new Response();
		HttpSession session = request.getSession(false);
		if (session != null) {
			// a session exists
			appResponse = service.getCustomer(session, accountNumber);
		} else {
			appResponse.setMessage("Unauthorised request");
		}
		return appResponse;
	}

	// add

	@RequestMapping(value = "/customer", method = RequestMethod.POST, consumes = "application/json")
	public Response addCustomer(@RequestBody Customer customer, HttpServletRequest request) {
		Response appResponse = new Response();
		HttpSession session = request.getSession(false);
		if (session != null) {
			appResponse = service.addCustomer(session, customer);
		} else {
			appResponse.setMessage("Unauthorised request");
		}
		return appResponse;
	}

	// update

	@RequestMapping(value = "/customer", method = RequestMethod.PUT, consumes = "application/json")
	public Response updateCustomer(@RequestBody Customer customer, HttpServletRequest request) {
		Response appResponse = new Response();
		HttpSession session = request.getSession(false);
		if (session != null) {
			appResponse = service.updateCustomer(session, customer);
		} else {
			appResponse.setMessage("Unauthorised request");
		}
		return appResponse;
	}

	// delete

	@RequestMapping(value = "/customer/{accountNumber}", method = RequestMethod.DELETE, produces = "application/json")
	public Response deleteCustomer(@PathVariable("accountNumber") long accountNumber, HttpServletRequest request) {
		Response appResponse = new Response();
		HttpSession session = request.getSession(false);
		if (session != null) {
			appResponse = service.deleteCustomer(session, accountNumber);
		} else {
			appResponse.setMessage("Unauthorised request");
		}
		return appResponse;
	}

	// getall

	@RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json")
	public Response getallCustomer(HttpServletRequest request) {
		Response appResponse = new Response();
		HttpSession session = request.getSession(false);
		if (session != null) {
			appResponse = service.getallCustomer(session);
		} else {
			appResponse.setMessage("Unauthorised request");
		}
		return appResponse;

	}

}
