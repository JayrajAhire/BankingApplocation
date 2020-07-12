package com.app.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.app.model.Customer;
import com.app.model.Response;

public interface ICustomerService {
	
	public Response getCustomer(HttpSession session, long accountNumber);
	
	public Response updateCustomer(HttpSession session, Customer customer);

	public Response deleteCustomer(HttpSession session, long accountNumber);

	public Response getallCustomer(HttpSession session);

	public Response addCustomer(HttpSession session, Customer customer);
}
