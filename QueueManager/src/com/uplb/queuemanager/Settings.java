package com.uplb.queuemanager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class Settings extends Activity {
	private EditText password, name, contact, address;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		password = (EditText)this.findViewById(R.id.profile_password);
		name = (EditText)this.findViewById(R.id.profile_name);
		contact = (EditText)this.findViewById(R.id.profile_phone);
		address = (EditText)this.findViewById(R.id.profile_address);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

	public void save_method(View view){
		
		DatabaseAdapter databaseAdapter = new DatabaseAdapter(getApplicationContext());
		databaseAdapter.open();
		databaseAdapter.insertUser(address.getText().toString(), password.getText().toString(), name.getText().toString(), contact.getText().toString());
		databaseAdapter.close();
		finish();
	}
}
