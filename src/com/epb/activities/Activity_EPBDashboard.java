package com.epb.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.epb.R;

public class Activity_EPBDashboard extends Activity_Base implements OnClickListener{

	private Button btnRxOrders;
	private Button btnAddPoints;
	private Button btnCheckPoints;
	private Button btnPendingAppointments;
	private Button btnNewConfirmedAppointments;
	private Button btnPharmacyPortal;
	
	public static final int REQUEST_ADD_POINTS= 1;
	public static final int REQUEST_CHECK_POINTS= 2;
	public static final int REQUEST_PENDING_APPOINTMENTS= 3;
	public static final int REQUEST_NEW_CONFIRMED_APPOINTMENTS= 4;
	public static final int REQUEST_ECOMM_RX_ORDERS= 5;
	public static final int REQUEST_PHARMACY_PORTAL= 6;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_epb_dashboard);
		init();
	}


	private void init() {
		// TODO Auto-generated method stub
		btnRxOrders = (Button)findViewById(R.id.button_dashboard_ecomm);
		btnAddPoints = (Button)findViewById(R.id.button_dashboard_add_points);
		btnCheckPoints = (Button)findViewById(R.id.button_dashboard_check_points);
		btnPendingAppointments = (Button)findViewById(R.id.button_dashboard_pending_appointments);
		btnNewConfirmedAppointments = (Button)findViewById(R.id.button_dashboard_new_confirmed_appointments);
		btnPharmacyPortal = (Button)findViewById(R.id.button_dashboard_pharmacy_control);
		
		btnRxOrders.setOnClickListener(this);
		btnAddPoints.setOnClickListener(this);
		btnCheckPoints.setOnClickListener(this);
		btnPendingAppointments.setOnClickListener(this);
		btnNewConfirmedAppointments.setOnClickListener(this);
		btnPharmacyPortal.setOnClickListener(this);
		
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


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d("onClick", "===============");
		switch (v.getId()) {
		case R.id.button_dashboard_add_points:
			Intent i1 = new Intent(this, Activity_AddPointsMain.class);
			startActivityForResult(i1, REQUEST_ADD_POINTS);
			break;
		case R.id.button_dashboard_check_points:
			Intent i2 = new Intent(this, Activity_CheckPointsMain.class);
			startActivityForResult(i2, REQUEST_CHECK_POINTS);
			break;
		case R.id.button_dashboard_pending_appointments:
			Intent i3 = new Intent(this, Activity_PendingAppointmentsMain.class);
			startActivityForResult(i3, REQUEST_PENDING_APPOINTMENTS);
			break;
		case R.id.button_dashboard_new_confirmed_appointments:
			Intent i4 = new Intent(this, Activity_NewConfirmedAppointmentsMain.class);
			startActivityForResult(i4, REQUEST_NEW_CONFIRMED_APPOINTMENTS);
			break;
		case R.id.button_dashboard_ecomm:
			Intent i5 = new Intent(this, Activity_eCommRXOrdersMain.class);
			startActivityForResult(i5, REQUEST_ECOMM_RX_ORDERS);
			break;
		case R.id.button_dashboard_pharmacy_control:
			Intent i6 = new Intent(this, Activity_PharmacyPortalMain.class);
			startActivityForResult(i6, REQUEST_PHARMACY_PORTAL);
			break;
		default:
			break;
		}
	}
}
