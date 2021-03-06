package com.sherif.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sherif.converter.CustomerConverter;
import com.sherif.dto.CustomerDTO;
import com.sherif.entity.Customer;
import com.sherif.service.CustomerService;



@Controller
@RequestMapping("/customers")
public class CustomerController {

	final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerConverter customerConverter;

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView get(@RequestParam(name="page", defaultValue="1" ) Integer page){
		
		logger.error("Error In Customer Controller Test ");
		
		//Get Current logged-in user 
		//System.out.println( SecurityContextHolder.getContext().getAuthentication().getName() );
		ModelAndView mv = new  ModelAndView("customerList");
		List<Customer> customerList = customerService.getAll(page);
		List<CustomerDTO> customerDTOList = customerConverter.toCustomerDTOList(customerList);
		System.out.println(customerService.getPagesCount());
		mv.addObject("customers", customerDTOList);
		return mv;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable long id){
		ModelAndView mv = new  ModelAndView("customerDetails");
		Customer customer = customerService.get(id);
		CustomerDTO customerDTO = customerConverter.toCustomerDTO(customer);
		mv.addObject("customer", customerDTO);
		return mv;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(@RequestBody CustomerDTO customerDTO){
		ModelAndView mv = new  ModelAndView("customerList");
		Customer customer = customerConverter.toCustomer(customerDTO);
		customer = customerService.save(customer);
		mv.addObject("customer", customerConverter.toCustomerDTO(customer));
		return mv;
	}

	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView edit(@RequestBody CustomerDTO customerDTO){
		ModelAndView mv = new  ModelAndView("customerList");
		Customer customer = customerConverter.toCustomer(customerDTO);
		customer = customerService.edit(customer);
		mv.addObject("customer", customerConverter.toCustomerDTO(customer));
		return mv;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable long id){
		ModelAndView mv = new  ModelAndView("customerList");
		customerService.delete(id);
		return mv;
	}
	
	

}
