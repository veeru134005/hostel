package com.veera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.veera.back.daointer.DaoInter;
import com.veera.back.daointer.ProductDAO;
import com.veera.back.dto.Catagory;
import com.veera.back.dto.Product;
import com.veera.exception.productNotFoundException;

@Controller
public class Pagecontroller {

	@Autowired
	private DaoInter categoryDao;

	@Autowired
	private ProductDAO productDao;

	@RequestMapping(value = { "/", "/index", "/home" })
	public ModelAndView page() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		mv.addObject("catagories", categoryDao.list());
		System.out.println(categoryDao.list());
		mv.addObject("userClickHome", true);

		return mv;

	}

	@RequestMapping("/about")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);

		return mv;
	}

	@RequestMapping("/contact")
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "contact");
		mv.addObject("userClickContact", true);
		return mv;
	}

	/*
	 * 
	 * methods to load the products and based on category
	 */

	@RequestMapping("/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All the products");
		mv.addObject("catagories", categoryDao.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		// categoryDao to fetch a single category
		Catagory ca = null;
		ca = categoryDao.get(id);
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", ca.getName());
		// passing the list of categories
		mv.addObject("catagories", categoryDao.list());
		// passing the single category object
		mv.addObject("category1", ca);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	//Getting the single Proudct
	@RequestMapping("/show/{id}/product")
	public ModelAndView singlePage(@PathVariable int id) throws productNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		Product p = productDao.get(id);
        if(p==null)throw new productNotFoundException();
		// update the view count

		p.setViews(p.getViews() + 1);
		productDao.update(p);

		mv.addObject("title",p.getName());
		mv.addObject("product",p);
		mv.addObject("userClickShowProudct",true);
		
		return mv;
	}

}
