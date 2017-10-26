package jz.mongodb.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jz.mongodb.demo.model.Customer;
import jz.mongodb.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	public Customer save(Customer customer) {
		return repository.save(customer);
	}
	
	public Customer get(String id) {
		return repository.findOne(id);
	}
	
	public List<Customer> getAll() {
		return repository.findAll();
	}

}