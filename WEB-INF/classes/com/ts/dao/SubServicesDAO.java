package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ts.dbutility.DBConnection;
import com.ts.dto.SubServices;


public class SubServicesDAO {
	
		public SubServices getSubService(int ssId) {
			System.out.println(ssId);
			PreparedStatement pst = null;
			ResultSet rst = null;
			SubServices subservice = new SubServices();;
			final String SELECT_QUERY = "select sId,ssName from subservices where ssId = ?";
			try(Connection con = DBConnection.getConnection();){
				pst = con.prepareStatement(SELECT_QUERY);
				pst.setInt(1, ssId);
				//System.out.println(pst);
				rst = pst.executeQuery();
			
				if(rst.next()){
					subservice.setServiceId(rst.getInt(1));
					subservice.setSubServiceName(rst.getString(2));
					System.out.println(subservice);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//System.out.println(sId);
			return subservice;
		}
}

	
