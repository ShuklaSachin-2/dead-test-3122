package com.system.usecase;

import java.sql.SQLException;

import java.util.Scanner;


import com.system.dao.VendorDao;
import com.system.model.VendorBean;

public class LoginVendor {

	public static VendorBean LoginVendor(String username,String password){
		
		
		
		VendorBean vendor=null;
		VendorDao dao= new com.system.dao.VendorDaoImpl();
		
		try {
			vendor =dao.LoginVendor(username, password);
		} catch (com.system.exception.VendorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("welcome Vendor "+vendor.getName());
		VendorAction.vendorMethods();
		
		
		
		;
		return vendor;
		
	}
}
