package com.san.gtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.san.gtest.entity.Product;
import com.san.gtest.service.ProductService;
@RestController
@RequestMapping("/products")
public class MyWebController {

	@Autowired
	ProductService productService;
	
	
	@PostMapping("/product")
	public String addProduct(@RequestBody Product product) {
		
		try {
			return productService.insertproduct(product);
		}catch (Exception e) {
			
			return "Contact to Service center (1526-789-963) or mail to :- center@gmail.com";
		}
		
		
		}
	
	@GetMapping("/productlist")
	public List<Product> getAllProducts(){
		
		try {
			List<Product>allExtractedProduct = productService.getAllProducts();
		
			return allExtractedProduct;
		
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
		return null;
	}
		
	@GetMapping("/productName/{searchProductName}")
	public Product p1(@PathVariable String searchProductName)throws Exception{
		
		
		return productService.getProductByProductName(searchProductName);
	}
	
	@GetMapping("/productCode/{searchProductCode}")
	public Product p2(@PathVariable int searchProductCode)throws Exception{
		
		
		return productService.getProductByProductCode(searchProductCode);
	}
	
	@GetMapping("/productCategory/{searchCategory}")
	public List<Product> p3(@PathVariable String searchCategory)throws Exception{
		
		
		return productService.getProductByCategory(searchCategory);
	}
	@GetMapping("/dealerName/{searchDealerName}")
	public List<Product> p4(@PathVariable String searchDealerName)throws Exception{
		
		
		return productService.getAllProductByDealerName(searchDealerName);
	}
	
	@GetMapping("/productbyCPD")
	public List<Product> p5(@RequestParam String category,@RequestParam int price1, @RequestParam int price2,@RequestParam String dealerName)throws Exception{
		
		return productService.getAllProductByCategoryAndPriceRangeAndDealerName(category, price1, price2, dealerName);
	}
	
	@GetMapping("/ProductbyCPU")
	public List<Product> p6(@RequestParam String category,@RequestParam int price,@RequestParam float userRating)throws Exception{
		
		return productService.getAllProductsByCategoryAndPriceAndUserRating(category, price, userRating);
		
	}
}
