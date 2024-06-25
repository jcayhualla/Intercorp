package com.intercorp.service;

import java.util.List;

import com.intercorp.entity.Customer;

public interface CustomerService {
	
	Customer saveCliente(Customer customer);
	List<Customer> getAllClientes();
	double getPromedioEdad();
	double getDesviacionEstandarEdad();
	
}
