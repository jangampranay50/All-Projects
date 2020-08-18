package com.cg.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.demo.entity.Product;
import com.cg.demo.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("show")
	public String showPage()
	{
		return "search";
	}
	
	@RequestMapping("dosearch")
	public String findProductId(@RequestParam("productId") int pid,Model model)
	{
		Product product = productService.findProductById(pid);
		String view = "";
		
		if(product == null)
		{
			view = "failure";
			model.addAttribute("pid",pid);
		}
		else
		{
			view="success";
			model.addAttribute("pname", product.getProductName());
			model.addAttribute("price", product.getPrice());
		}
		
		return view;
	}
	
}
