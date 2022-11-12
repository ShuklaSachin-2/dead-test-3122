package com.system.dao;

import java.util.List;

import com.system.exception.VendorException;
import com.system.model.VendorBean;

public interface VendorDao {

	
public String registerVendor(VendorBean vendor) ;
	
	public List<VendorBean> getAllVendors() throws VendorException;
	
	public boolean validatePassword(String vendorId,String password);
	
	public String updateProfile(VendorBean vendor);
	
	public String changePassword(String vendorId,String oldPassword,String newPassword);
	
	public VendorBean getVendorDataById(String vendorId);

	public VendorBean LoginVendor(String username, String password) throws VendorException;
}
