package com.system.usecase;

import java.sql.SQLException;
import java.util.Scanner;

import com.system.dao.VendorDao;
import com.system.dao.VendorDaoImpl;
import com.system.exception.VendorException;
import com.system.model.VendorBean;
import com.system.utility.Administrator;
import com.system.utility.IDUtil;



public class RegisterVendor {

	
public static void registerVendor()  {
		
		Scanner sc= new Scanner(System.in);
		
//		System.out.println("enter vendor id");
		String id =IDUtil.generateVendorId();
		System.out.println("enter name");
		String name =sc.next();
		
		System.out.println("enter password");
		String password =sc.next();
		
		System.out.println("enter mobile");
		String mob =sc.next();
		System.out.println("enter email");
		String email =sc.next();
		System.out.println("enter company");
		String company =sc.next();
		System.out.println("enter address");
		String address =sc.next();
		
		
		VendorBean vendor= new VendorBean(id, name, mob, email, address, company, password);
				
//		vendor.setVid(id);
//		vendor.setPassword(password);
//		vendor.setVname(name);
//		vendor.setVmob(mob);
//		vendor.setVemail(email);
//		vendor.setCompany(company);
//		vendor.setAddress(address);
		
		
		VendorDao dao= new VendorDaoImpl();
		
		try {
			String result = dao.registerVendor(vendor);
			
			System.out.println(result);
			System.out.println("enter 9 to go back to previous page");
			int key=sc.nextInt();
			switch (key) {
			case 9:
				Administrator.adminMethods();
				break;

			default:
				break;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
