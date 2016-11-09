package com.myshop.store.controller;

import java.util.Date;
import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.myshop.model.customer.Address;
import com.myshop.model.customer.Company;
import com.myshop.model.customer.CreditCards;
import com.myshop.model.customer.IndividualCustomer;
import com.myshop.model.product.Product;

public class PaymentsController {

	private Sql2o sql2o = new Sql2o("jdbc:mysql://myshop.cvgrlnux4cbv.eu-west-1.rds.amazonaws.com:3306/myshop",
			"myshop-app", "'m:9AU7n");
	private String insertCustomer = "INSERT INTO myshop.customer VALUES ( )";
	private String insertIndividual = "insert into myshop.individual_customer (customer_id, name, surname) VALUES (:id, :name, :surname);";
	private String insertAddress = "insert into myshop.address VALUES (:id, :street, :city, :state, :cip)";
	private String insertCredit = "insert into myshop.credit_cards (owner_id, credit_card_number, credit_card_ex_date) VALUES (:id, :number, :date);";
	private String insertPayment = "insert into myshop.payments (payment_type_id, received) VALUES (:id , :boolean)";
	private String insertOrder = "insert into myshop.order (status_id, date_received, customer_id, payment_id) VALUES ( :idState , :date, :idCustomer, :idPayment)";
	private String insertItem = "insert into myshop.order_item (product_id, order_id, quantity) VALUES (:productID, :orderID, :quantity)";
	private String actualizarProducto = "update product set stock = stock - (select quantity from order_item where order_item_id = :orderId) where product_id = :id;";

	public void payCreditCard(IndividualCustomer ic, Address a, CreditCards cc, List<Product> productos,
			List<Integer> cantidades) {

		try (Connection con = sql2o.open()) {
			int customerID = con.createQuery(insertCustomer).executeUpdate().getKey(int.class);
			con.createQuery(insertIndividual).addParameter("id", customerID).addParameter("name", ic.getName())
					.addParameter("surname", ic.getSurname()).executeUpdate();
			con.createQuery(insertAddress).addParameter("id", customerID).addParameter("street", a.getStreet())
					.addParameter("city", a.getCity()).addParameter("state", a.getState()).addParameter("cip", a.getCip_code())
					.executeUpdate();
			con.createQuery(insertCredit).addParameter("id", customerID).addParameter("number", cc.getCreditCardNumber())
					.addParameter("date", cc.getCreditCardExDate()).executeUpdate();
			int paymentID = con.createQuery(insertPayment).addParameter("id", 1).addParameter("boolean", true)
					.executeUpdate().getKey(int.class);
			int orderID = con.createQuery(insertOrder).addParameter("idState", 2).addParameter("date", new Date())
					.addParameter("idCustomer", customerID).addParameter("idPayment", paymentID).executeUpdate()
					.getKey(int.class);
			for (int i = 0; i < productos.size(); i++) {
				int orderitemID = con.createQuery(insertItem).addParameter("productID", productos.get(i).getID())
						.addParameter("orderID", orderID).addParameter("quantity", cantidades.get(i)).executeUpdate().getKey(int.class);
				con.createQuery(actualizarProducto).addParameter("id", productos.get(i).getID()).addParameter("orderId", orderitemID).executeUpdate();
			}

		}
	}

	
	public void payBankTransfer(IndividualCustomer ic, Address a, List<Product> productos,
			List<Integer> cantidades) {

		try (Connection con = sql2o.open()) {
			int customerID = con.createQuery(insertCustomer).executeUpdate().getKey(int.class);
			con.createQuery(insertIndividual).addParameter("id", customerID).addParameter("name", ic.getName())
					.addParameter("surname", ic.getSurname()).executeUpdate();
			con.createQuery(insertAddress).addParameter("id", customerID).addParameter("street", a.getStreet())
					.addParameter("city", a.getCity()).addParameter("state", a.getState()).addParameter("cip", a.getCip_code())
					.executeUpdate();
			int paymentID = con.createQuery(insertPayment).addParameter("id", 2).addParameter("boolean", false)
					.executeUpdate().getKey(int.class);
			int orderID = con.createQuery(insertOrder).addParameter("idState", 1).addParameter("date", new Date())
					.addParameter("idCustomer", customerID).addParameter("idPayment", paymentID).executeUpdate()
					.getKey(int.class);
			for (int i = 0; i < productos.size(); i++) {
				int orderitemID = con.createQuery(insertItem).addParameter("productID", productos.get(i).getID())
						.addParameter("orderID", orderID).addParameter("quantity", cantidades.get(i)).executeUpdate().getKey(int.class);
				con.createQuery(actualizarProducto).addParameter("id", productos.get(i).getID()).addParameter("orderId", orderitemID).executeUpdate();
			}
		}
	}
	
	public void payCreditCardCompany(Company c,CreditCards cc, List<Product> productos,
			List<Integer> cantidades) {
		try (Connection con = sql2o.open()) {
			int paymentID = con.createQuery(insertPayment).addParameter("id", 1).addParameter("boolean", true)
					.executeUpdate().getKey(int.class);
			int orderID = con.createQuery(insertOrder).addParameter("idState", 2).addParameter("date", new Date())
					.addParameter("idCustomer", c.getID()).addParameter("idPayment", paymentID).executeUpdate()
					.getKey(int.class);
			for (int i = 0; i < productos.size(); i++) {
				int orderitemID = con.createQuery(insertItem).addParameter("productID", productos.get(i).getID())
						.addParameter("orderID", orderID).addParameter("quantity", cantidades.get(i)).executeUpdate().getKey(int.class);
				con.createQuery(actualizarProducto).addParameter("id", productos.get(i).getID()).addParameter("orderId", orderitemID).executeUpdate();
			}
		}
	}

	
	public void payBankTransferCompany(Company c,List<Product> productos,
			List<Integer> cantidades) {

		try (Connection con = sql2o.open()) {
			int paymentID = con.createQuery(insertPayment).addParameter("id", 2).addParameter("boolean", false)
					.executeUpdate().getKey(int.class);
			int orderID = con.createQuery(insertOrder).addParameter("idState", 1).addParameter("date", new Date())
					.addParameter("idCustomer", c.getID()).addParameter("idPayment", paymentID).executeUpdate()
					.getKey(int.class);
			for (int i = 0; i < productos.size(); i++) {
				int orderitemID = con.createQuery(insertItem).addParameter("productID", productos.get(i).getID())
						.addParameter("orderID", orderID).addParameter("quantity", cantidades.get(i)).executeUpdate().getKey(int.class);
				con.createQuery(actualizarProducto).addParameter("id", productos.get(i).getID()).addParameter("orderId", orderitemID).executeUpdate();
			}
		}
	}

}
