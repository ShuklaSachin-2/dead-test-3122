
package com.system.utility;

import java.util.*;

import com.system.dao.*;
import com.system.usecase.LoginVendor;
import com.system.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("welcom");
		System.out.println("press 1 for admin");
		System.out.println("press 2 for vendor");
		
		int x = sc.nextInt();
		switch (x) {
		case 1:System.out.println("you press 1");
		Administrator.call();
		
			
			break;
		case 2:System.out.println("you press 2");
		System.out.println("Enter Vendor  username");
		String u= sc.next();
		System.out.println("Enter Vendor password");
		String p= sc.next();
		LoginVendor.LoginVendor(u, p);
		
			
			break;
			
		

		default:
			break;
		}
	}
	
}
