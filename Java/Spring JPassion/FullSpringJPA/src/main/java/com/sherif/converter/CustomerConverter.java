package com.sherif.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sherif.dto.CustomerDTO;
import com.sherif.entity.Customer;

@Component
public class CustomerConverter {

	
	@Autowired
	private ModelMapper modelMapper;
	
	public CustomerDTO toCustomerDTO(Customer customer){
		return modelMapper.map(customer, CustomerDTO.class);
	}
	
}
