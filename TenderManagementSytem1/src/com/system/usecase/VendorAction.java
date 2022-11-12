package com.system.usecase;

import java.util.Scanner;

public class VendorAction {

	public static void vendorMethods() {
		System.out.println("1.Press 1  to view all the current Tenders");
		System.out.println("2.Press 2 to place a bid against a tender");
		System.out.println("3.Press 3 to view status of a bid");
		System.out.println("4.Press 4 to view your own bid history");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		switch (choice) {
		case 1:
			System.out.println("You pressed 1");
			ViewAllTender.viewAllTender();
			break;
		case 2:
			System.out.println("You pressed 2");
			PlaceABidByVendor.placeBid();
			break;


		default:
			break;
		}
		
	}

}
