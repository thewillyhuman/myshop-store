package com.myshop.store.controller;

import java.util.List;
import java.util.Map;
import java.sql.Date;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.myshop.model.customer.Address;
import com.myshop.model.customer.Company;
import com.myshop.model.customer.CreditCards;
import com.myshop.model.customer.IndividualCustomer;
import com.myshop.model.user.User;

public class UsersController {

	private Sql2o sql2o = new Sql2o("jdbc:mysql://myshop.cvgrlnux4cbv.eu-west-1.rds.amazonaws.com:3306/myshop", "myshop-app", "'m:9AU7n");	
	
	public IndividualCustomer getCustomerData(String username, char[] cs){
		String complexSql = "SELECT * FROM myshop.user U, myshop.individual_customer IC, myshop.address A, myshop.credit_cards CC WHERE "
				+ "U.username = :user AND U.password = :pass AND U.user_id = IC.user_id AND IC.customer_id = A.client_id AND IC.customer_id = CC.owner_id";
				
		List<Map<String,Object>> map;
		
		 try (Connection con = sql2o.open()) {
			 map = con.createQuery(complexSql).addParameter("user", username)
			            .addParameter("pass", cs)
			            .executeAndFetchTable().asList();
		 }
		 
		 IndividualCustomer ic = new IndividualCustomer();
		 for(Map<String,Object> m : map){
			 ic.setName((String)m.get("name"));
			 ic.setSurname((String) m.get("surname"));
			 Address a = new Address();
			 a.setStreet((String) m.get("street"));
			 a.setCity((String) m.get("city"));
			 a.setState((String) m.get("state"));
			 a.setCip_code((String) m.get("cip_code"));
			 ic.setAddress(a);
			 CreditCards cc = new CreditCards();
			 cc.setCreditCardNumber((int) m.get("credit_card_number"));
			 cc.setCreditCardExDate((Date) m.get("credit_card_ex_date"));
			 ic.setCreditCard(cc);
			 User user = new User((int)m.get("user_id"),(String)m.get("username"),(String) m.get("password"));
			 ic.setUser(user);
		 }
		 return ic;
	}
	
	public Company getCompany(String username, char[] ds){
		String complexSql = "SELECT * FROM myshop.user U, myshop.company C WHERE "+ 
		                    "U.username = :user AND U.password = :pass "
						  + "AND U.user_id = C.user_id";
				
		List<Map<String,Object>> map;
		
		 try (Connection con = sql2o.open()) {
			 map = con.createQuery(complexSql).addParameter("user", username)
			            .addParameter("pass", String.valueOf(ds))
			            .executeAndFetchTable().asList();
		 }
		 
		 Company c = new Company();
		 for(Map<String,Object> m : map){
			 c.setID((int) m.get("company_id"));
			 c.setName((String) m.get("name"));
			 User u = new User((int)m.get("user_id"), (String)m.get("username"),(String)m.get("password"));
			 c.setUser(u);
		 }
		 
		 return c;
	}
	
}