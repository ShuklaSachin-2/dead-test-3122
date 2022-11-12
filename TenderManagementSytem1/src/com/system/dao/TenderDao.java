package com.system.dao;

import java.util.List;

import com.system.model.TenderBean;
import com.system.model.TenderStatusBean;

public interface TenderDao {

	
public List<TenderBean> getTenderDetails(String id);
	
	public List<TenderBean> getAllTenders();
	
	public String createTender(TenderBean tender);
	
	public boolean removeTender(String tid);
	
	public String updateTender(TenderBean tender);
	
	public TenderBean getTenderDataById(String tenderId);
	
	public String getTenderStatus(String tenderId);
	
	public String assignTender(String tenderId,String vendorId,String bidderId);
	
	public List<TenderStatusBean> getAllAssignedTenders();
}
