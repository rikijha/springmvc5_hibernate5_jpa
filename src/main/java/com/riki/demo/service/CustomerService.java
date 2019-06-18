package com.riki.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riki.demo.exception.ResourceNotFoundException;
import com.riki.demo.model.Customer;
import com.riki.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}
	
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}
	
	@Transactional
	public void deleteCustomer(int theId) {
		customerRepository.deleteById(theId);
	}
	
	@Transactional
	public Customer getCustomer(int id) throws ResourceNotFoundException {
		return customerRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}
}
