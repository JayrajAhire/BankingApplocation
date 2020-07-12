package com.app.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.model.Response;

@Service
public class CustomerServiceImple implements ICustomerService {

	@Autowired
	ICustomerDao dao;

	/*
	 * @Override public Customer updateCustomer(Customer customer) { return
	 * dao.updateCustomer(customer); }
	 */

	/*
	 * @Override public String deleteCustomer(long accountNumber) { return
	 * dao.deleteCustomer(accountNumber); }
	 */

	/*
	 * @Override public List<Customer> getallCustomer() { return
	 * dao.getallCustomer(); }
	 */

	@Override
	public Response addCustomer(HttpSession session, Customer customer) {
		return dao.addCustomer(session,customer);
	}



	@Override
	public Response getCustomer(HttpSession session, long accountNumber) {
		return dao.getCustomer(session, accountNumber);
	}

	@Override
	public Response updateCustomer(HttpSession session, Customer customer) {
		return dao.updateCustomer(session, customer);
	}

	@Override
	public Response deleteCustomer(HttpSession session, long accountNumber) {
		return dao.deleteCustomer(session, accountNumber);
	}



	@Override
	public Response getallCustomer(HttpSession session) {
		return dao.getallCustomer(session);
	}

}
