package com.uplb.queuemanager;

import java.util.Calendar;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends Activity {
	private TextView date,qstatus;
	private Button close_queue;
	private DatabaseAdapter databaseAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		date=(TextView)this.findViewById(R.id.date);
		qstatus=(TextView)this.findViewById(R.id.queue_count);
		close_queue=(Button)this.findViewById(R.id.close_queue);
		
		
		//Date current = new Date();
		final Calendar c = Calendar.getInstance();
	    int yy = c.get(Calendar.YEAR);
	    int mm = c.get(Calendar.MONTH);
	    int dd = c.get(Calendar.DAY_OF_MONTH);

	    // set current date into textview
	    date.setText(new StringBuilder()
	    			.append(mm+1).append("-")
	    			.append(dd).append("-").append(yy));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	public void queue_method(View view){
		databaseAdapter = new DatabaseAdapter(getApplicationContext());
        databaseAdapter.open();
        String text = Integer.toString(databaseAdapter.retrieveCustomerNumber());
		databaseAdapter.close();
		
		qstatus.setText(text+" people in queue");
		close_queue.setText("QUEUE");
		
		//pano pag wala pa laman yung database? (TOAST? or deretso padin?)
		Intent i=new Intent(HomeActivity.this, QueueActivity.class);
        startActivity(i);
		
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.about:
        	startActivity(new Intent(this, About.class));
        	return true;
        case R.id.help:
        	startActivity(new Intent(this, Help.class));
        	return true;
        case R.id.action_settings:
        	startActivity(new Intent(this, Settings.class));
        	return true;
        default:
        return super.onOptionsItemSelected(item);
       }
	}
	
}
