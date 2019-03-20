package com.veera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.veera.back.daointer.DaoInter;
import com.veera.back.daointer.ProductDAO;
import com.veera.back.dto.Catagory;
import com.veera.back.dto.Product;

@Controller
@RequestMapping(value="/manage")
public class ManagementController {
	
	@Autowired
	private DaoInter category;
	
	@Autowired
	private ProductDAO product;
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageproducts(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Product Management");
		mv.addObject("userClickMangeProudcts",true);
		Product nproudct=new Product();
		nproudct.setSupplierId(1);
		nproudct.setActive(true);
		mv.addObject("product",nproudct);
		return mv;
	}

	@ModelAttribute("catagories")
	public List<Catagory> getCategories(){
	
		return category.list()  ; 

	}
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductsubmittion(@ModelAttribute("product") Product product1){
		
		product.add(product1);
		
		return "redirect:/manage/products";
		
		
	}
	
	
	
	
}
