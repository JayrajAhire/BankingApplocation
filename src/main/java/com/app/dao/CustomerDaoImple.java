package com.app.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.model.Customer;
import com.app.model.Response;

@Repository
public class CustomerDaoImple implements ICustomerDao {

	@Autowired
	private HttpSession httpSession;

	public static final Map<Long, Customer> custMap = new HashMap<Long, Customer>();

	@Override
	public Response getCustomer(HttpSession session, long accountNumber) {
		Response appResponse = new Response();
		List<Customer> list = (List<Customer>) session.getAttribute("customers");
		if (list != null) {
			for (Customer customer : list) {
				if (customer.getAccountNumber() == accountNumber) {
					appResponse.setData(customer);
					appResponse.setMessage("success");
					break;
				}
			}
		} else {
			appResponse.setData(null);
			appResponse.setMessage("No record found");
		}
		return appResponse;
	}

	@Override
	public Response addCustomer(HttpSession session, Customer customer) {
		Response appResponse = new Response();
		List<Customer> list = (List<Customer>) session.getAttribute("customers");
		if (list != null) {
			list.add(customer);
		} else {
			list = new ArrayList<Customer>();
			list.add(customer);
		}
		session.setAttribute("customers", list);
		appResponse.setMessage("success");

		return appResponse;
	}

	@Override
	public Response updateCustomer(HttpSession session, Customer customer) {
		Response appResponse = new Response();
		List<Customer> list = (List<Customer>) session.getAttribute("customers");
		for (Customer c : list) {
			if (c.getAccountNumber() == customer.getAccountNumber()) {
				c.setAccountBalance(customer.getAccountBalance());
				break;
			}
		}
		appResponse.setMessage("success");
		return appResponse;
	}

	@Override
	public Response deleteCustomer(HttpSession session, long accountNumber) {
		Response appResponse = new Response();
		List<Customer> list = (List<Customer>) session.getAttribute("customers");
		for (Customer c : list) {
			if (c.getAccountNumber() == accountNumber) {
				list.remove(c);
				break;
			}
		}
		session.setAttribute("customers", list);
		appResponse.setMessage("success");
		return appResponse;
	}

	@Override
	public Response getallCustomer(HttpSession session) {
		Response appResponse = new Response();
		List<Customer> list = (List<Customer>) session.getAttribute("customers");
		appResponse.setData(list);
		appResponse.setMessage("success");
		return appResponse;

	}
}
