package com.intercorp.controller;

import com.intercorp.entity.Customer;
import com.intercorp.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
    @Autowired
    private CustomerService customerService;

    @PostMapping("/creacliente")
    public ResponseEntity<Customer> saveCliente(@RequestBody Customer customer) {
    	try {
            return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveCliente(customer));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}        
    }

    @GetMapping("/kpideclientes")
    public ResponseEntity<Map<String, Double>> kpiDeClientes() {
    	try {
    		Map<String, Double> kpi = new HashMap<>();
            kpi.put("promedioEdad", customerService.getPromedioEdad());
            kpi.put("desviacionEstandarEdad", customerService.getDesviacionEstandarEdad());
            return ResponseEntity.status(HttpStatus.OK).body(kpi);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}        
    }

    @GetMapping("/listclientes")
    public ResponseEntity<List<Customer>> getAllClientes() {
    	try {
    		List<Customer> customers = customerService.getAllClientes();
    		return ResponseEntity.status(HttpStatus.OK).body(customers);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    }
	
}
