package com.system.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.masai.model.Vendor;
//import com.masai.model.Vendor;
import com.system.exception.VendorException;
import com.system.model.VendorBean;
import com.system.utility.DBUtil;

public class VendorDaoImpl implements VendorDao {
	
	@Override
	public String registerVendor(VendorBean vendor) {
		
		String status = "Registration Failed!!";
		
		
		
		PreparedStatement pst = null;
		
		PreparedStatement ps = null;
		
		try(Connection con = DBUtil.provideConnection()) {
			
			pst = con.prepareStatement("select * from vendor where vemail=?");
		
			pst.setString(1, vendor.getEmail());
			ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			
			status = "Registration Declined!Email Id already Registered";
		}
		else{
		
			try {
			
				ps = con.prepareStatement("insert into vendor values(?,?,?,?,?,?,?)");
				
				ps.setString(1, vendor.getId());
				ps.setString(2, vendor.getPassword());
				ps.setString(3, vendor.getName());
				ps.setString(4, vendor.getMobile());
				ps.setString(5, vendor.getEmail());
				ps.setString(6, vendor.getCompany());
				ps.setString(7, vendor.getAddress());
				
				int k = ps.executeUpdate();
				
				if(k>0) //update successful
					status = "Registration Successful. Your Vendor id: "+vendor.getId()+" Thanks For Registration";
			}
				
			catch(SQLException e){
				e.printStackTrace();
				status = "Error: "+e.getMessage();
			}
			
		}
	}
	catch(SQLException e){
		e.printStackTrace();
		status = "Error: "+ e.getErrorCode()+" : "+e.getMessage();
	}

	
	return status;

}

	@Override
	public List<VendorBean> getAllVendors() {

		List<VendorBean> vendorList = new ArrayList<VendorBean>();
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("select * from vendor");
			rs = ps.executeQuery();
			
			while(rs.next()){
				VendorBean vendor=new VendorBean();
				vendor.setId(rs.getString("vid"));
				vendor.setName(rs.getString("vname"));
				vendor.setMobile(rs.getString("vmob"));
				vendor.setEmail(rs.getString("vemail"));
				vendor.setCompany(rs.getString("company"));
				vendor.setAddress(rs.getString("address"));
				vendor.setPassword(rs.getString("password"));
				vendorList.add(vendor);
//				vendorList.add(vendor);
//				System.out.println(vendorList);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return vendorList;
	}

	@Override
	public boolean validatePassword(String vid, String password) {
		boolean flag=false;
		Connection conn = DBUtil.provideConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("select * from vendor where vid=? and password=?");
			
			pst.setString(1, vid);
			pst.setString(2, password);
			
			rs = pst.executeQuery();
			
			if(rs.next())
				flag = true;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return flag;
	}

	@Override
	public String updateProfile(VendorBean vendor) {
		
		String status = "Account Updation Failed";
		
		String vendorId = vendor.getId();
		String password = vendor.getPassword();
		
		VendorDao dao = new VendorDaoImpl();
		
		if(!dao.validatePassword(vendorId, password)){
			
			status = status + " You Have Entered Wrong Password!";
			
			return status;
		}
		
		Connection con  = DBUtil.provideConnection();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("update vendor set vname=?,vmob=?,vemail=?,company=?,address=? where vid=?");
			
			ps.setString(1,vendor.getName());
			ps.setString(2,vendor.getMobile());
			ps.setString(3, vendor.getEmail());
			ps.setString(4, vendor.getCompany());
			ps.setString(5, vendor.getAddress());
			ps.setString(6, vendor.getId());
			
			int x = ps.executeUpdate();
			
			if(x>0){
				status = "Account Updated Successfully!";
			}

			
		} catch (SQLException e) {
			
			status = "Error: "+e.getMessage();
			
			e.printStackTrace();
		}
		
		
		return status;
		
	}

	@Override
	public String changePassword(String vendorId, String oldPassword, String newPassword) {
		
		String status = "Password Updation failed!";
		
		
		VendorDao dao = new VendorDaoImpl();
		
		if(!dao.validatePassword(vendorId, oldPassword)){
			
			status = status + " You Have Enetered Wrong Old Password!";
			
			return status;
		}
		
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		try {
			
			ps = con.prepareStatement("update vendor set password = ? where vid=?");
			
			ps.setString(1, newPassword);
			ps.setString(2, vendorId);
			
			int x = ps.executeUpdate();
			
			if(x>0)
				status = "Password Updated Successfully!";
			
		} 
		catch (SQLException e) {
			
			status = status + " Error: " +e.getMessage();
			
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public VendorBean getVendorDataById(String vendorId) {

		VendorBean vendor = null;
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("select * from vendor where vid=?");
			
			ps.setString(1, vendorId);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				vendor = new VendorBean(rs.getString("vid"),rs.getString("vname"), rs.getString("vmob"), rs.getString("vemail"), rs.getString("address"), rs.getString("company"), rs.getString("password"));
			
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
//		finally{
//			
//			DBUtil.closeConnection(con);
//			
//			DBUtil.closeConnection(rs);
//			
//			DBUtil.closeConnection(ps);
//		}
		
		return vendor;
	}
	
//	======================
	
	@Override
	public VendorBean LoginVendor(String username, String password) throws VendorException {
		String message = "login unsuccessful";
		VendorBean vendor=null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps4 = conn.prepareStatement("select * from vendor where vname=? AND password=?");
			
			ps4.setString(1, username);
			ps4.setString(2, password);
			
			ResultSet rs =ps4.executeQuery();
			if(rs.next()) {
				String r = rs.getString("vid");
				String n = rs.getString("vname");
				String p = rs.getString("password");
				String mob=rs.getString("vmob");
				String em = rs.getString("vemail");
				String c = rs.getString("company");
				String add = rs.getString("address");
						
				vendor=new VendorBean(r, n, p, mob, em, c, add);
			}else {
				throw new VendorException("invalid username or password");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return vendor;
		

	}
	
}
