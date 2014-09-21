package com.example.cheapbeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import com.example.cheapbeer.R;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
 
public class MapPageView extends Fragment implements GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener,
LocationListener, android.location.LocationListener  {
 TextView dist;
 int i;
 DefaultHttpClient httpclient;
 HttpGet request;
 HttpResponse response;
 String currlog,currlat;
 String []longitude,latitude;
 LocationManager mLocationManager;
 LatLng myLoc;
 GoogleMap map ;
 
   
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.map, container, false);       
        
        // Getting Google Play availability status
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
        if(status!=ConnectionResult.SUCCESS){ // Google Play Services are not available
        	 
            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, getActivity(), requestCode);
            dialog.show();
 
        }else { // Google Play Services are available
 
        	map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            map.getUiSettings().setMyLocationButtonEnabled(true);
 
            // Getting LocationManager object from System Service LOCATION_SERVICE
            mLocationManager = (LocationManager)getActivity(). getSystemService(Context.LOCATION_SERVICE);
 
            // Creating a criteria object to retrieve provider
            Criteria criteria = new Criteria();
 
            // Getting the name of the best provider
            String provider = mLocationManager.getBestProvider(criteria, true);
 
            // Getting Current Location
            Location location = mLocationManager.getLastKnownLocation(provider);
 
            if(location!=null){
                onLocationChanged(location);
            }
        
        
            mLocationManager.requestLocationUpdates(provider, 20000, 0, this);
        }
        
        //Connect Server
        try{
        	httpclient=new DefaultHttpClient();
        	request=new HttpGet("http://129.97.250.153:5000/deps");
        	response=httpclient.execute(request);
        }catch(Exception e){
        	  	Log.i("Moze", "Don't see the server");
        	
        }          
       
        try {
        	
                  // json is UTF-8 by default
        	BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        	if(reader!=null){
        		 Toast.makeText(getActivity(),"From Server:Reader is empty",Toast.LENGTH_SHORT).show();
            	 Log.i("Moses","Am here before while");        		
        	} 
        		 Log.i("Moses","Am here after while");
            String line = "";
            while ((line = reader.readLine()) != null)
            {
            	 Log.i("Moses","Am here");
            	 
            	 JSONArray jsonArray = new JSONArray(line);
            	 
            	
                 for(int i=0;i<jsonArray.length();i++){                   
                    longitude[i] = jsonArray.getJSONObject(i).getString("long");
                    latitude[i] = jsonArray.getJSONObject(i).getString("lat");
                    
                    myLoc = new LatLng(Double.parseDouble(latitude[i]),Double.parseDouble(longitude[i]));
    	        	BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory
    	        	            .defaultMarker(BitmapDescriptorFactory.HUE_AZURE);
    	        	Marker marker = map.addMarker(new MarkerOptions().position(myLoc)
    	                    .icon(bitmapDescriptor).title(myLoc.toString()));
                     }
                }
            //result = sb.toString();  
            Log.i("MosesOutchea","I didnot enter while lop");
            
                      
        } catch (Exception e) { 
            // Oops
            Log.i("MosesOutchea","Exception");
        }       	
        
        
          return rootView;
        
        
    }

	

	@Override
	public void onLocationChanged(Location location) {
		
		 // Getting latitude of the current location
        double latitude = location.getLatitude();
 
        // Getting longitude of the current location
        double longitude = location.getLongitude();
 
        // Creating a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);
 
        // Showing the current location in Google Map
       map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
 
        // Zoom in the Google Map
      map.animateCamera(CameraUpdateFactory.zoomTo(15));
		
		 if (map != null){
				        	//mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
			 myLoc = new LatLng(location.getLatitude(),location.getLongitude());
	        	BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory
	        	            .defaultMarker(BitmapDescriptorFactory.HUE_AZURE);
	        	
	        Marker marker = map.addMarker(new MarkerOptions().position(myLoc)
	                    .icon(bitmapDescriptor).title(myLoc.toString()));
	        }
	        Log.i("Map","Am here finished map");
		
		
	}



	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onConnectionFailed(ConnectionResult result) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onConnected(Bundle connectionHint) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}




   
    
}

