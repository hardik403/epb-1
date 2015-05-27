package com.epb.activities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.epb.R;
import com.epb.utils.Constants;

public class Activity_eCommRXOrdersMain extends Activity_Base {

	private String strResponseGetOrderDetails= "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ecomm_rx_orders);
		
		if(isOnline()){
			new GetOrderDetailsTask().execute();
		}else{
			Toast.makeText(this, "Network not available. Please, check your internet connection.", Toast.LENGTH_SHORT).show();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity__epbmain, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public class GetOrderDetailsTask extends AsyncTask<Void, String, Boolean> {

		ProgressDialog pd = null;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd = ProgressDialog.show(Activity_eCommRXOrdersMain.this, null, "Loading...	",
					true, false);
		}

		@Override
		protected Boolean doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			String bodyString = "<SOAP-ENV:Body> " 
							  + "<ns1:GetOrderDetails>"
					          + "<ns1:orderId>" +1 + "</ns1:orderId>"
					          + "<ns1:macId>" + Constants.macID+ "</ns1:macId>"
					          + "</ns1:GetOrderDetails>" 
							  + "</SOAP-ENV:Body>";

			
			Log.i("bodyString",bodyString);
			String SOAPRequestXML = Constants.SOAPRequestXMLHeader + bodyString
					+ Constants.SOAPRequestXMLEnd;
			String resp = CallWebService("GetOrderDetails", SOAPRequestXML);
			if (resp != null) {
				strResponseGetOrderDetails = resp;
			}
			return true;
		}

		@Override
		protected void onPostExecute(Boolean result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (pd.isShowing()) {
				pd.dismiss();
			}
			
			Log.i("Response GetOrderDetails",strResponseGetOrderDetails);
			
			
		}
	}
}
