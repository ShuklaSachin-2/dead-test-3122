package com.system.usecase;

import java.util.List;
import java.util.Scanner;

import com.system.dao.BidderDao;
import com.system.dao.BidderDaoImpl;

import com.system.model.BidderBean;
import com.system.utility.Administrator;

public class AdminViewAllBids {

	
	public static void viewAllBidsOfATender() {
		
		Scanner sc= new Scanner(System.in);
		String tid = sc.next();
		List<BidderBean> bids =null;
		
		
		BidderDao dao =new BidderDaoImpl();
		bids=dao.getAllBidsOfaTender(tid);
		
		bids.forEach(s->System.out.println(s));
		
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
