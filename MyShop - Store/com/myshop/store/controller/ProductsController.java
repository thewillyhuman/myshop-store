package com.myshop.store.controller;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.myshop.model.product.Category;
import com.myshop.model.product.Product;


public class ProductsController {
	
	 private Sql2o sql2o = new Sql2o("jdbc:mysql://myshop.cvgrlnux4cbv.eu-west-1.rds.amazonaws.com:3306/myshop", "myshop-app", "'m:9AU7n");

	public List<Product> getAll(int category, int subcategory){
		String complexSql = "SELECT * FROM myshop.product WHERE category_id = :cat AND subcategory_id = :subcat AND stock>0";
		
		 try (Connection con = sql2o.open()) {
			 return con.createQuery(complexSql).addParameter("cat", category)
			            .addParameter("subcat", subcategory)
			            .addColumnMapping("product_id","ID").addColumnMapping("company_price","companyPrice").throwOnMappingFailure(false).executeAndFetch(Product.class);
		 }
	}
	
	public List<Product> getAll(){
		String complexSql = "SELECT * FROM myshop.product";
		
		 try (Connection con = sql2o.open()) {
			 return con.createQuery(complexSql).addColumnMapping("product_id","ID").throwOnMappingFailure(false).executeAndFetch(Product.class);
		 }
		
	}
	
	public List<Product> getAllView(){
		String complexSql = "SELECT * FROM myshop.full_products;";
		
		 try (Connection con = sql2o.open()) {
			 return con.createQuery(complexSql).addColumnMapping("product_id","ID").throwOnMappingFailure(false).executeAndFetch(Product.class);
		 }
		
	}
	public List<Category> getCategorysRoot(){
		String complexSql = "SELECT * FROM myshop.category where parent_id is NULL";
		
		 try (Connection con = sql2o.open()) {
			 return con.createQuery(complexSql).addColumnMapping("category_id","ID").throwOnMappingFailure(false).executeAndFetch(Category.class);
		 }
		
	}
	public List<Category> getCategorysChildren(String nombre){
		String complexSql = "SELECT * FROM myshop.category where parent_id = (SELECT category_id FROM myshop.category where name= :nom)";
		
		try (Connection con = sql2o.open()) {
			 return con.createQuery(complexSql).addParameter("nom", nombre).addColumnMapping("category_id","ID").
					 throwOnMappingFailure(false).executeAndFetch(Category.class);
		 }
		
	}
	public List<Product> getProductsByCategory(String nombre){
		String complexSql = "SELECT * FROM myshop.product where category_id =(SELECT category_id FROM myshop.category where name= :nom)";
		
		try (Connection con = sql2o.open()) {
			 return con.createQuery(complexSql).addParameter("nom", nombre).addColumnMapping("product_id","ID").
					 throwOnMappingFailure(false).executeAndFetch(Product.class);
		 }
		
	}
}
