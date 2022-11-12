package com.system.usecase;

import java.util.List;
import java.util.Scanner;

import com.system.dao.TenderDao;
import com.system.dao.TenderDaoImpl;
import com.system.dao.VendorDaoImpl;
import com.system.exception.tenderException;
import com.system.model.TenderBean;
import com.system.utility.Administrator;

public class ViewAllTenderbyvendor {

	
	public static void viewAllTender() {
		
			
			
			TenderDao dao= new TenderDaoImpl();
			List<TenderBean> vnd=dao.getAllTenders();
			System.out.println("All tenders name");
			System.out.println("=========================");
			vnd.forEach(s-> System.out.println(s));
			
			System.out.println("Enter 9 to go back to previous page");
			Scanner sc= new Scanner(System.in);
			int key = sc.nextInt();
			switch (key) {
			case 9:
				VendorAction.vendorMethods();
				break;

			default:
				break;
			}
			
			
		}
		
	
}
