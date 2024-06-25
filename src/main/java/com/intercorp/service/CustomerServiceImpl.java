package com.intercorp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intercorp.entity.Customer;
import com.intercorp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
   
	@Autowired
    private CustomerRepository repository;
    
	@Transactional
	@Override
    public Customer saveCliente(Customer customer) {
		try {
	        return repository.save(customer);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
    }

	@Transactional(readOnly = true)
	@Override
    public List<Customer> getAllClientes() {
		try {
			return repository.findAll();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}        
    }

	@Transactional(readOnly = true)
	@Override
    public double getPromedioEdad() {
		try {
			List<Customer> clientes = repository.findAll();
	        return clientes.stream().mapToInt(Customer::getAge).average().orElse(0);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
        
    }

	@Transactional(readOnly = true)
	@Override
    public double getDesviacionEstandarEdad() {
		try {
			List<Customer> customers = repository.findAll();
	        double promedio = getPromedioEdad();
	        return Math.sqrt(customers.stream()
	                .mapToDouble(customer -> Math.pow(customer.getAge() - promedio, 2))
	                .average()
	                .orElse(0));
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
        
    }
		
}
