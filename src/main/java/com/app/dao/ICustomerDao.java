package com.app.dao;

import javax.servlet.http.HttpSession;

import com.app.model.Customer;
import com.app.model.Response;

public interface ICustomerDao {
		
	public Response getCustomer(HttpSession session, long accountNumber);
	
	public Response updateCustomer(HttpSession session, Customer customer);
		
	public Response deleteCustomer(HttpSession session, long accountNumber);

	public Response addCustomer(HttpSession session, Customer customer);

	public Response getallCustomer(HttpSession session);


}



