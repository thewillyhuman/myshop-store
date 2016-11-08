package com.myshop.store.controller;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.myshop.model.product.Product;

public class PaymentsController {

	private Sql2o sql2o = new Sql2o("jdbc:mysql://myshop.cvgrlnux4cbv.eu-west-1.rds.amazonaws.com:3306/myshop", "myshop-app",
			"'m:9AU7n");

	public List<Product> payCreditCard(int category, int subcategory){
		String insertCustomer = "insert into customer VALUES ( )";
		String selectLastId = "SELECT LAST_INSERT_ID";
		String insertIndividual = "SELECT * FROM myshop.product WHERE category_id = :cat AND subcategory_id = :subcat";
		String insertAddress = "SELECT * FROM myshop.product WHERE category_id = :cat AND subcategory_id = :subcat";
		String insertCredit = "SELECT * FROM myshop.product WHERE category_id = :cat AND subcategory_id = :subcat";
		String selectPaymentsType = "SELECT * FROM myshop.payment_type";
		String insertPayment = "SELECT * FROM myshop.product WHERE category_id = :cat AND subcategory_id = :subcat";
		
		//primero meter el customer
		//luego el individual customer con el id del customer introducido
		//luego va el address con el id del individual customer metido
		//luego la tarjeta de cr¨¦dito con el id del individual customer en el owner_id
		//luego va el payment tras leer los paymentTypes y seleccionar el de la tarjeta. Estar¨¢ en recibido
		//luego se mete el order con el id del customer en customer_id y con el id del payment en payment_id
		//luego se crean los order items con el id de la order creada antes
		 try (Connection con = sql2o.open()) {
			 return con.createQuery(insertCustomer).addParameter("cat", category)
			            .addParameter("subcat", subcategory)
			            .addColumnMapping("product_id","ID").addColumnMapping("company_price","companyPrice").throwOnMappingFailure(false).executeAndFetch(Product.class);
		 }
	}
	/**
	 * Add to de database the customer information, the order and de payment method
	 * @param category
	 * @param subcategory
	 * @return
	 */
	public List<Product> payBankTransfer(int category, int subcategory){
		String complexSql = "SELECT * FROM myshop.product WHERE category_id = :cat AND subcategory_id = :subcat";
		
		
		//primero meter el customer
				//luego el individual customer con el id del customer introducido
				//luego va el address con el id del individual customer metido
				//luego va el payment tras leer los paymentTypes y seleccionar el de la tarjeta. Sin recibir
				//luego se mete el order con el id del customer en customer_id y con el id del payment en payment_id
				//luego se crean los order items con el id de la order creada antes
		 try (Connection con = sql2o.open()) {
			 return con.createQuery(complexSql).addParameter("cat", category)
			            .addParameter("subcat", subcategory)
			            .addColumnMapping("product_id","ID").addColumnMapping("company_price","companyPrice").throwOnMappingFailure(false).executeAndFetch(Product.class);
		 }
	}

}
