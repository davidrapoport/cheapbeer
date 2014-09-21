package com.example.cheapbeer;

import com.example.cheapbeer.adapter.TabsPages;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements TabListener {
	private ViewPager viewPager;
    private TabsPages mAdapter;
	private ActionBar bar;
	Tab tab1,tab2,tab3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new TabsPages(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        
		bar=getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		tab1 = bar.newTab();
	    tab1.setText("GO");
	    tab1.setTabListener(this);
	    bar.addTab(tab1);
	    
	    tab2 = bar.newTab();
	    tab2.setText("Map");
	    tab2.setTabListener(this);
	    bar.addTab(tab2);
	    
	    tab3 = bar.newTab();
	    tab3.setText("List");
	    tab3.setTabListener(this);
	   bar.addTab(tab3);
	   
	   
	   viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
		   
           @Override
           public void onPageSelected(int position) {
               // on changing the page
               // make respected tab selected
               bar.setSelectedNavigationItem(position);
           }

           @Override
           public void onPageScrolled(int arg0, float arg1, int arg2) {
           }

           @Override
           public void onPageScrollStateChanged(int arg0) {
           }
       });
	   

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		 viewPager.setCurrentItem(tab.getPosition());
		if(tab.equals(tab1)){
		
			

			// TODO Auto-generated method stub
			LocationManager locationManager =(LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
			// Define a listener that responds to location updates
			LocationListener locationListener = new LocationListener() {
			    public void onLocationChanged(Location location) {
			      // Called when a new location is found by the network location provider.
			     // makeUseOfNewLocation(location);
			    }

			    public void onStatusChanged(String provider, int status, Bundle extras) {
			    	
			    
			    }

			    public void onProviderEnabled(String provider) {}

			    public void onProviderDisabled(String provider) {}
			  };

			// Register the listener with the Location Manager to receive location updates
			locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
			 Toast.makeText(this, "change:" + tab.getPosition(), Toast.LENGTH_SHORT).show();
		}
		
		
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
}
