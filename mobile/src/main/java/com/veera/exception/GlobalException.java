package com.veera.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView exceptionhandle() {

		ModelAndView mv = new ModelAndView("erro");
		mv.addObject("errorTitle", "This is not constructed");
		mv.addObject("title", "404 Error Page");
		mv.addObject("errorDescription", "This page is not available ");
		return mv;
	}

	@ExceptionHandler(productNotFoundException.class)
	public ModelAndView productNotfoundexception() {
		ModelAndView mv = new ModelAndView("erro");
		mv.addObject("errorTitle", "Product not available!");
		mv.addObject("errorDescription", "The product you are looking for is not available right now!");
		mv.addObject("title", "Product Unavailable");
		return mv;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception er) {
		
		/* only for debugging application */
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		er.printStackTrace(pw);
		
		ModelAndView mv = new ModelAndView("erro");
		mv.addObject("errorTitle", "contact the administrator forther resolution comment!");
		mv.addObject("errorDescription", sw.toString());
		mv.addObject("title", "invalide");
		return mv;
	}
	
	
	
	
}
