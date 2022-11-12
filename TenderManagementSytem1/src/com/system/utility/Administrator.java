package com.system.utility;

import java.util.Scanner;

import com.system.*;
import com.system.dao.*;
import com.system.usecase.AdminAssignTender;
import com.system.usecase.AdminCreateNewTender;
import com.system.usecase.AdminViewAllBids;
import com.system.usecase.AdminViewAllVendors;
import com.system.usecase.RegisterVendor;
import com.system.usecase.ViewAllTender;

public class Administrator {

	
	public static void call() {
		Scanner sca= new Scanner(System.in);
		System.out.println("enter admin username");
		
		String a = sca.next();
		System.out.println("enter admin password");
		String b = sca.next();
		boolean flagadmin= false;
		if(a.equals("admin") && b.equals("admin")) {
			System.out.println("login successful");
			flagadmin=true;
		}else {
			System.out.println("login failed");
		}
		
		if(flagadmin) {
			Administrator.adminMethods();
			
		}else {
			System.out.println("wrong credentials try again");
		}
		
		
		
	}
	
	public static void adminMethods() {
		System.out.println("Welcome to admin page");
		
		System.out.println("1. Press 1 to register new Vendor ");
		System.out.println("2. Press 2 to view all vendors ");
		System.out.println("3. Press 3 to create new Tender ");
		System.out.println("4. Press 4 to view all tenders ");
		System.out.println("5. Press 5 to view all the bids of a  Tender");
		System.out.println("6. Press 6 to Assign Tender to a Vendor ");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Your selected 1");
			
			RegisterVendor.registerVendor();
			
			break;
			
		case 2:
			System.out.println("Your selected 2");
			
			AdminViewAllVendors.viewAllVendors();
			
			
			break;
		case 3:
			System.out.println("Your selected 3");
			
			AdminCreateNewTender.createNewTender();
			
			
			break;
		
		case 4:
			System.out.println("Your selected 4");
			
			ViewAllTender.viewAllTender();
			
			
			break;
		case 5:
			System.out.println("Your selected 5");
			System.out.println("Enter tenderid");
//			String tenderid=in.next();
			AdminViewAllBids.viewAllBidsOfATender();;
			
			
			
			break;
			
		case 6:
			System.out.println("Your selected 6");
			
			AdminAssignTender.AdminAssignTender();
			
			
			break;
}
		
		
		
		
		
		
		
		
	}
}
