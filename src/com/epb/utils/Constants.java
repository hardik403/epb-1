package com.epb.utils;

import com.epb.DBHandler;
import com.epb.models.Model_WebOrdersMain;

public class Constants {
	
	public static String ServiceURL = "http://www.digitalhealthcarenetwork.tv/DHNPharmcyAppWebservice/PharmacyAppServices.asmx";

	public static String SOAPRequestXMLHeader = "<?xml version='1.0' encoding='utf-8'?>" +
	 		"<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
	 		"xmlns:ns1=\"http://tempuri.org/\">" ;
	public static String SOAPRequestXMLEnd = "</SOAP-ENV:Envelope>";
	
	public static Model_WebOrdersMain webOrderMain;
	
	public static String macID = "";
	
	//t_Orders
	public static String T_ORDERS = "t_Orders";
	public static String T_ORDERS_SEARCH_DATE = "SearchDate";
	public static String T_ORDERS_ORDER_STATUS = "OrderStatus";
	public static String T_ORDERS_POST_CODE = "PostCode";
	public static String T_ORDERS_CITY = "City";
	public static String T_ORDERS_ADDRESS1 = "Address1";
	public static String T_ORDERS_ADDRESS2 = "Address2";
	public static String T_ORDERS_ID = "_id";
	public static String T_ORDERS_ORDER_ID = "OrderID";
	public static String T_ORDERS_CUSTOMER_ID = "CustomerID";
	public static String T_ORDERS_CUSTOMER_NAME = "CustomerName";
	public static String T_ORDERS_DATE = "Date";
	
	
	public static DBHandler db = null;
	
	
	
}
