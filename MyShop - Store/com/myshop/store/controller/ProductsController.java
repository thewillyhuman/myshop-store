package com.myshop.store.controller;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.myshop.model.product.Product;


public class ProductsController {

	public List<Product> getAll(int category, int subcategory){
		Sql2o sql2o = new Sql2o("jdbc:mysql://myshop.cvgrlnux4cbv.eu-west-1.rds.amazonaws.com:3306/myshop", "myshop-app", "'m:9AU7n");
		String complexSql = "SELECT * FROM myshop.product WHERE category_id = :cat AND subcategory_id = :subcat";
		
		 try (Connection con = sql2o.open()) {
			 return con.createQuery(complexSql).addParameter("cat", category)
			            .addParameter("subcat", subcategory)
			            .addColumnMapping("product_id","ID").throwOnMappingFailure(false).executeAndFetch(Product.class);
		 }
		
	}
	
	public List<Product> getAllWithDiscount(int category, int subcategory){
		Sql2o sql2o = new Sql2o("jdbc:mysql://myshop.cvgrlnux4cbv.eu-west-1.rds.amazonaws.com:3306/myshop", "myshop-app", "'m:9AU7n");
		String complexSql = "SELECT * FROM myshop.product WHERE category_id = :cat AND subcategory_id = :subcat";
		
		List<Product> p;
		 try (Connection con = sql2o.open()) {
			 p= con.createQuery(complexSql).addParameter("cat", category)
			            .addParameter("subcat", subcategory)
			            .addColumnMapping("product_id","ID").throwOnMappingFailure(false).executeAndFetch(Product.class);
		}
		for(Product producto : p){
			producto.setPrice(producto.getPrice()*0.9);
		}
		return p;
	}
}
