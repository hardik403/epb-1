package com.epb.models;

import java.util.List;

public class Model_WebOrdersMain {

	private String downloadDate;
	private List<Model_WebOrders> listOrderDetails;
	
	public String getDownloadDate() {
		return downloadDate;
	}
	public void setDownloadDate(String downloadDate) {
		this.downloadDate = downloadDate;
	}
	public List<Model_WebOrders> getListOrderDetails() {
		return listOrderDetails;
	}
	public void setListOrderDetails(List<Model_WebOrders> listOrderDetails) {
		this.listOrderDetails = listOrderDetails;
	}
	
	
}
