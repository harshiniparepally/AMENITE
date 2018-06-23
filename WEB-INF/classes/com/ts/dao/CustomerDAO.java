package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ts.dbutility.DBConnection;
import com.ts.dto.Customer;

public class CustomerDAO {
	

	public int add(Customer customer){
		final String INSERT_QUERY="insert into user(custName,cPhone,cEmail,cUserName,cPassword,cAddress) values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, customer.getCustomerName());
			pst.setLong(2, customer.getPhone());
			pst.setString(3, customer.getEmail());
			pst.setString(4, customer.getUserName());
			pst.setString(5, customer.getPassword());
			pst.setString(6, customer.getAddress());
			//System.out.println(pst);
			status=pst.executeUpdate();
			//System.out.println(status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(status);
		return status;
	}
	
	
public Customer getCustomer(String cUserName,String cPassword){
	
	PreparedStatement pst = null;
	ResultSet rst = null;
	Customer customer=null;
final String SELECT_QUERY = "select * from user where cUserName = ? and cPassword = ?";
try(Connection con = DBConnection.getConnection();){
	
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setString(1, cUserName);
	pst.setString(2, cPassword);
	rst = pst.executeQuery();
	//System.out.println(pst);
	if(rst.next()){
		 customer=new Customer();
		 customer.setCustomerId(rst.getInt(1));
		 customer.setCustomerName(rst.getString(2));
		 customer.setPhone(rst.getLong(3));
		 customer.setEmail(rst.getString(4));		 
		 customer.setUserName(rst.getString(5));
		 customer.setPassword(rst.getString(6));
		 customer.setAddress(rst.getString(7));
	//System.out.println(customer);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return customer;
}


}