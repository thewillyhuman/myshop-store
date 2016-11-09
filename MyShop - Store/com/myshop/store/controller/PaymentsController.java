package com.myshop.store.controller;


import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class PaymentsController {

	private Sql2o sql2o = new Sql2o("jdbc:mysql://myshop.cvgrlnux4cbv.eu-west-1.rds.amazonaws.com:3306/myshop", "myshop-app",
			"'m:9AU7n");
	private String insertCustomer = "INSERT INTO myShop.customer VALUES ( )";
	private String insertIndividual = "insert into myshop.individual_customer (customer_id, name, surname) VALUES (:id, :name, :surname);";
	private String insertAddress = "insert into myshop.address VALUES (:id, :street, :city, :state, :cip)";
	private String insertCredit = "insert into myshop.credit_cards (owner_id, credit_card_number, credit_card_ex_date) VALUES (:id, :number, :date);";
	private String insertPayment = "insert into myshop.payments (payment_type_id, received) VALUES (:id , :boolean)";
	private String insertOrder = "insert into myshop.order (status_id, date_received, customer_id,payment_id) VALUES ( 2 , :date, :idCustomer, :idPayment)";
	private String insertItem = "insert into myshop.order_item (product_id, order_id, quantity) VALUES (:productID, :orderID, :quantity)";

	public void payCreditCard(int category, int subcategory){
		

		 try (Connection con = sql2o.open()) {
			 int customerID = con.createQuery(insertCustomer).executeUpdate().getKey(int.class);
			 con.createQuery(insertIndividual).addParameter("id", customerID).addParameter("name", "name")
			 .addParameter("surname","surname").executeUpdate();
			 con.createQuery(insertAddress).addParameter("id", customerID).addParameter("street", "street")
			 .addParameter("city", "city").addParameter("state", "state").addParameter("cip", 123454).executeUpdate();
			 con.createQuery(insertCredit).addParameter("id", customerID).addParameter("number", 123456)
			 .addParameter("date", "2016-8-19").executeUpdate();
			 int paymentID = con.createQuery(insertPayment).addParameter("id", 1).addParameter("boolean", true).executeUpdate().getKey(int.class);
			 int orderID = con.createQuery(insertOrder).addParameter("date", "2016-8-19").addParameter("idCustomer", customerID)
			 .addParameter("idPayment", paymentID).executeUpdate().getKey(int.class);
			 //bucle para los orderitems
			 con.createQuery(insertItem).addParameter("productID", 1).addParameter("orderID", orderID)
			 .addParameter("quantity", 1).executeUpdate();
			 
		 }
	}
	/**
	 * Add to de database the customer information, the order and de payment method
	 * @param category
	 * @param subcategory
	 * @return
	 */
	public void payBankTransfer(int category, int subcategory){
		
		 try (Connection con = sql2o.open()) {
			 int customerID = con.createQuery(insertCustomer).executeUpdate().getKey(int.class);
			 con.createQuery(insertIndividual).addParameter("id", customerID).addParameter("name", "name")
			 .addParameter("surname","surname").executeUpdate();
			 con.createQuery(insertAddress).addParameter("id", customerID).addParameter("street", "street")
			 .addParameter("city", "city").addParameter("state", "state").addParameter("cip", 123454).executeUpdate();
			 int paymentID = con.createQuery(insertPayment).addParameter("id", 2).addParameter("boolean", false).executeUpdate().getKey(int.class);
			 int orderID = con.createQuery(insertOrder).addParameter("date", "2016-8-19").addParameter("idCustomer", customerID)
			 .addParameter("idPayment", paymentID).executeUpdate().getKey(int.class);
			 //bucle para los orderitems
			 con.createQuery(insertItem).addParameter("productID", 1).addParameter("orderID", orderID)
			 .addParameter("quantity", 1).executeUpdate();
		 }
	}

}
