package com.myshop.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.myshop.model.customer.Address;
import com.myshop.model.customer.IndividualCustomer;
import com.myshop.model.product.Product;
import com.myshop.store.controller.PaymentsController;
import com.myshop.store.controller.UsersController;

public class PaymentsTest {

	private Sql2o sql2o = new Sql2o("jdbc:mysql://myshop.cvgrlnux4cbv.eu-west-1.rds.amazonaws.com:3306/myshop",
			"myshop-app", "'m:9AU7n");
	private PaymentsController pc = new PaymentsController();
	private UsersController uc = new UsersController();

	/**
	 * Método que compra el producto 10 con cantidad 1 con un cliente 
	 * no registrado y un cliente registrado (pedro)
	 */
	@Test
	public void PayRegisteredUnregisteredCustomerTest() {
		// Cliente sin registrar
		Address a = new Address().setCity("prueba1").setState("prueba1").setStreet("prueba1").setCip_code("00000");
		IndividualCustomer ic = new IndividualCustomer(0).setName("prueba1").setSurname("prueba1").setAddress(a);
		ArrayList<Product> ap = new ArrayList<Product>();
		try (Connection con = sql2o.open()) {
			ap = (ArrayList<Product>) con.createQuery("SELECT * FROM myshop.product WHERE product_id = 10")
					.addColumnMapping("product_id", "ID").throwOnMappingFailure(false).executeAndFetch(Product.class);
		}
		ArrayList<Integer> ac = new ArrayList<Integer>();
		ac.add(1);
		pc.payBankTransfer(ic, ic.getAddress(), ap, ac);
		// Cliente registrado
		ic = uc.getCustomerData("pedro", "pedro1".toCharArray());
		ap = new ArrayList<Product>();
		try (Connection con = sql2o.open()) {
			ap = (ArrayList<Product>) con.createQuery("SELECT * FROM myshop.product WHERE product_id = 10")
					.addColumnMapping("product_id", "ID").throwOnMappingFailure(false).executeAndFetch(Product.class);
		}
		ac = new ArrayList<Integer>();
		ac.add(1);
		pc.payBankTransfer(ic, ic.getAddress(), ap, ac);
	}

}
