package com.system.usecase;

import java.util.Scanner;

import com.system.dao.BidderDao;
import com.system.dao.BidderDaoImpl;

public class PlaceABidByVendor {

	
	public static void placeBid() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter VendorId");
		String vid=sc.next();
		System.out.println("Enter tenderId");
		String tid =sc.next();
		System.out.println("Enter bid amount");
		
		String bidamount=sc.next();
		System.out.println("Enter bid deadline in 'yyyy-mm-dd' format");
		String bd=sc.next();
		
		
		
		
		BidderDao dao =new BidderDaoImpl();
		
		String result = dao.bidTender(tid, vid, bidamount, bd);
		System.out.println(result);
		
	}
}
