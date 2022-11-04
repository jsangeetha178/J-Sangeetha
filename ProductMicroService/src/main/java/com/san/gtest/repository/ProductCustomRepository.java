package com.san.gtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.san.gtest.entity.Product;

@Repository
public interface ProductCustomRepository {


	//public List<Product> getAllProducts() throws Exception;

	public Product getProductByProductCode(int productCode) throws Exception;

	public Product getProductByProductName(String productName) throws Exception;

	public List<Product> getProductByCategory(String category) throws Exception;

	@Query("from Product where category = :category and price = :price and userRating = :userRating")
	public List<Product> getAllProductsByCategoryAndPriceAndUserRating(@Param("category")String category,@Param("price") int price, @Param("userRating")float userRating)throws Exception;

	public List<Product> getAllProductByDealerName(String dealerName) throws Exception;

	@Query("from Product where category = :category and price >= :price1 and price <= :price2 and dealerName =:dealerName")
	public List<Product> getAllProductByCategoryAndPriceRangeAndDealerName(@Param("category")String category ,@Param("price1")int price1,@Param("price2")int price2,@Param("dealerName")String dealerName) throws Exception;

}
