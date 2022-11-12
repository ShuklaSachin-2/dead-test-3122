package com.system.usecase;

import java.util.Scanner;

import com.system.dao.TenderDao;
import com.system.dao.TenderDaoImpl;
import com.system.utility.Administrator;

public class AdminAssignTender {

	
	public static void AdminAssignTender() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Tenderid to assign");
		String tid = sc.next();
		System.out.println("Enter VendorId to assign a Tender");
		String vid = sc.next();
		System.out.println("Enter bid id to assign to a tender");
		String bid = sc.next();
		
		
		
		
		TenderDao dao = new TenderDaoImpl();
		String result = dao.assignTender(tid, vid, bid);
		System.out.println(result);
		
		System.out.println("Enter 9 to go back to previous page");
		int key = sc.nextInt();
		switch (key) {
		case 9:
			Administrator.adminMethods();
			break;

		default:
			break;
		}
	}
}
