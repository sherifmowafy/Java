package com.sherif.modelvalidtor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class HoppyValidator implements ConstraintValidator<ValidHoppy, String> {

	private ValidHoppy validHoppy;
	
	@Override
	public void initialize(ValidHoppy validHoppy) {
		this.validHoppy = validHoppy;
	}

	@Override
	public boolean isValid(String hoppy, ConstraintValidatorContext ctx) {
		if(!StringUtils.isEmpty(hoppy)){
			return hoppy.matches(validHoppy.value());
		}
		return true;
	}

}
