package com.sherif.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalErrorHandler {
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler( value = { NullPointerException.class, IOException.class } )
	public ModelAndView nullPointerExceptionHandler(Exception e){
		ModelAndView mv = new ModelAndView("error/nullpointer");
		mv.addObject("e", e);
		return mv ;
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public ErrorInfo errorHandler(HttpServletRequest req, Exception e){
		ErrorInfo ei = new ErrorInfo(req.getRequestURL().toString(), e);
		return ei;
	}
	
	public class ErrorInfo {
	    public final String url;
	    public final String ex;

	    public ErrorInfo(String url, Exception ex) {
	        this.url = url;
	        this.ex = ex.getLocalizedMessage();
	    }
	}

}
