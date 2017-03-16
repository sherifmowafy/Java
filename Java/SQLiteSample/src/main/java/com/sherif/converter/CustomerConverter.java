package com.sherif.converter;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
	
	public List<CustomerDTO> toCustomerDTOList(List<Customer> customerList){
		return modelMapper.map(customerList, new TypeToken<List<CustomerDTO>>(){}.getType());
	}
	
	public Customer toCustomer(CustomerDTO customerDTO){
		return modelMapper.map(customerDTO, Customer.class);
	}
	
}
