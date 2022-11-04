package com.san.gtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.gtest.entity.Product;
import com.san.gtest.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() throws Exception {
	
		List<Product> allProducts = productRepository.findAll();
		return allProducts;
	}

	@Override
	public String insertproduct(Product product) throws Exception {
		
		Product savedProduct = productRepository.save(product);
		if(savedProduct != null)
		{
			return "Product Saved" +savedProduct.getProductCode()+"Product Name - "+savedProduct.getProductName();
		}
		else return null;
	}

	@Override
	public Product getProductByProductCode(int productCode) throws Exception {
		
		return productRepository.getProductByProductCode(productCode);
	}

	@Override
	public Product getProductByProductName(String productName) throws Exception {
	
		return productRepository.getProductByProductName(productName);
	}

	@Override
	public List<Product> getProductByCategory(String category) throws Exception {
		
		return productRepository.getProductByCategory(category);
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPriceAndUserRating(String category, int price, float userRating)
			throws Exception {
		
		return productRepository.getAllProductsByCategoryAndPriceAndUserRating(category, price, userRating);
	}

	@Override
	public List<Product> getAllProductByDealerName(String dealerName) throws Exception {
		
		return productRepository.getAllProductByDealerName(dealerName);
	}

	@Override
	public List<Product> getAllProductByCategoryAndPriceRangeAndDealerName(String category, int price1,int price2,String dealerName) throws Exception {
		
		return productRepository.getAllProductByCategoryAndPriceRangeAndDealerName(category, price1,price2, dealerName);
	
	}
	
	

}
