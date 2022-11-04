package com.san.gtest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.san.gtest.entity.Product;

@Service
public interface ProductService {

	public String insertproduct(Product product) throws Exception;

	public List<Product> getAllProducts() throws Exception;

	public Product getProductByProductCode(int productCode) throws Exception;

	public Product getProductByProductName(String productName) throws Exception;

	public List<Product> getProductByCategory(String category) throws Exception;

	public List<Product> getAllProductsByCategoryAndPriceAndUserRating(String category, int price, float userRating)throws Exception;

	public List<Product> getAllProductByDealerName(String dealerName) throws Exception;

	public List<Product> getAllProductByCategoryAndPriceRangeAndDealerName(String category, int price1,int price2,String dealerName) throws Exception;

	

}
