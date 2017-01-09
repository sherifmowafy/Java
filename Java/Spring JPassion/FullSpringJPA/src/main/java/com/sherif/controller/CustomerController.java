package com.sherif.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sherif.converter.CustomerConverter;
import com.sherif.dto.CustomerDTO;
import com.sherif.entity.Customer;
import com.sherif.service.CustomerService;



@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView getCustomer(@PathVariable long id){
		ModelAndView mv = new  ModelAndView("addcustomer");
		Customer customer = customerService.get(id);
		CustomerDTO customerDTO = customerConverter.toCustomerDTO(customer);
		mv.addObject("customer", customerDTO);
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView addCustomer(Customer customer){
		ModelAndView mv = new  ModelAndView("add");
		
		return mv;
	}

}
