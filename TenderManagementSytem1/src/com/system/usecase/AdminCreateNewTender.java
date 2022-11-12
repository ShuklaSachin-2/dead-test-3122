package com.system.usecase;

import java.util.Scanner;

import com.system.dao.TenderDao;
import com.system.dao.TenderDaoImpl;
import com.system.model.TenderBean;
import com.system.utility.Administrator;
import com.system.utility.IDUtil;

public class AdminCreateNewTender {

	public static void createNewTender() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("To create new Tender");
//		System.out.println("Enter Tender id");
		
		String id= IDUtil.generateTenderId();
		System.out.println("Enter Tender name");
		String name= sc.next();
		System.out.println("Enter Tender Type");
		String type = sc.next();
		System.out.println("Enter Tender Price");
		int price = sc.nextInt();
		System.out.println("Enter Tender Description");
		String desc = sc.next();
		System.out.println("Enter Tender Deadline in 'yyyy-dd-mm' format ");
		String deadline = sc.next();
		System.out.println("Enter Tender Location");
		String loc = sc.next();
		
		TenderBean tender=new TenderBean(id, name, type, price	, desc, deadline, loc);
		
		TenderDao tendao=new TenderDaoImpl();
		
		String result = tendao.createTender(tender);
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
