package com.system.usecase;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import com.system.dao.VendorDao;
import com.system.dao.VendorDaoImpl;
import com.system.exception.VendorException;
import com.system.model.VendorBean;
import com.system.utility.Administrator;



public class AdminViewAllVendors {

public static void   viewAllVendors(){
	
	
	VendorDao dao= new VendorDaoImpl();
	try {
		List<VendorBean> vnd=dao.getAllVendors();
		System.out.println("All vendors name");
		System.out.println("=========================");
		vnd.forEach(s-> System.out.println(s));
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter 9 to go back to previous page");
		int key = sc.nextInt();
		switch (key) {
		case 9:
			Administrator.adminMethods();
			break;

		default:
			break;
		}
	} catch (VendorException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
	
	
}
