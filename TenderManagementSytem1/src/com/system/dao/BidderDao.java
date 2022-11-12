package com.system.dao;

import java.util.List;

import com.system.model.BidderBean;

public interface BidderDao {
	  public String acceptBid(String applicationId,String tenderId,String vendorId);
		
		public String rejectBid(String applicationId);
		
		public String bidTender(String tenderId, String vendorId,String bidAmount,String deadline);
		
		public List<BidderBean> getAllBidsOfaTender(String tenderId);
		
		public List<BidderBean> getAllBidsOfaVendor(String vendorId);
}
