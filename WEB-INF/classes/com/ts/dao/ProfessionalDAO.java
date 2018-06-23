package com.ts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ts.dbutility.DBConnection;
import com.ts.dto.Professional;


public class ProfessionalDAO {
		public int add(Professional professional){
			final String INSERT_QUERY="insert into professional(proName,pPhone,pEmail,pUserName,pPassword,sId) values(?,?,?,?,?,?)";
			PreparedStatement pst = null;
			
			int status=0;
			
			try(Connection con=DBConnection.getConnection();) {
				
				pst=con.prepareStatement(INSERT_QUERY);
				pst.setString(1, professional.getProName());
				pst.setLong(2, professional.getProPhone());
				pst.setString(3, professional.getProEmail());
				pst.setString(4, professional.getProUserName());
				pst.setString(5, professional.getProPassword());
				pst.setInt(6, professional.getProSId());
				
				status=pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(status);
			return status;
		}



	public Professional getProfessionalLogin(String pUserName,String pPassword){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Professional professional=null;
	final String SELECT_QUERY = "select * from professional where pUserName = ? and pPassword = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, pUserName);
		pst.setString(2, pPassword);
		rst = pst.executeQuery();
		//System.out.println(pst);
		if(rst.next()){
			professional=new Professional();
			professional.setProId(rst.getInt(1));
			professional.setProName(rst.getString(2));
			professional.setProPhone(rst.getLong(3));
			professional.setProEmail(rst.getString(4));		 
			professional.setProUserName(rst.getString(5));
			professional.setProPassword(rst.getString(6));
			professional.setProSId(rst.getInt(7));
			
		System.out.println(professional);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return professional;
	}
	public Professional getProfessional(int sId){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Professional professional=null;
	final String SELECT_QUERY = "select proId,proName,pPhone from (select * from  professional ORDER BY numberOfServices) professional where sId=? LIMIT 0,1;";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setInt(1, sId);
		
		rst = pst.executeQuery();
		//System.out.println(pst);
		if(rst.next()){
			professional=new Professional();
			professional.setProId(rst.getInt(1));
			professional.setProName(rst.getString(2));
			professional.setProPhone(rst.getLong(3));
			//professional.setProEmail(rst.getString(3));		 
			//professional.setProUserName(rst.getString(5));
			//professional.setProPassword(rst.getString(6));
			
		//System.out.println(professional);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return professional;
	}
	public void updateNOS(Professional pro) {
		int nos = getNOS(pro.getProId());
		nos = nos+1;
		PreparedStatement pst = null;
		int x = 0;
		final String UPDATE_QUERY = "update professional set numberOfServices = ? where proId=?";
		try(Connection con = DBConnection.getConnection();){
			pst = con.prepareStatement(UPDATE_QUERY);
			pst.setInt(2,pro.getProId());
			pst.setInt(1, nos);
			x = pst.executeUpdate();
			System.out.println(nos);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int getNOS(int proId) {
		int numServices=0;
		PreparedStatement pst = null;
		ResultSet rst = null;
		final String SELECT_QUERY = "select numberOfServices from professional where proId=?";
		try(Connection con = DBConnection.getConnection();){
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setInt(1, proId);
			
			rst = pst.executeQuery();
			//System.out.println(pst);
			if(rst.next()){
				numServices = rst.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return numServices;
	}
}
