package com.example.cheapbeer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.Text;

import com.example.cheapbeer.R;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
 
public class MapPageView extends Fragment {
 TextView dist;
 int i;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.map, container, false);
        
        GoogleMap map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.getUiSettings().setMyLocationButtonEnabled(false);
        
        if (map != null){}
        
        
        	
            
        
        
        
        
        
        /*Bundle bundle = this.getArguments();
        if(bundle != null){
            i = bundle.getInt("radius", 0);
        }
       // String strtext=getArguments().getString("radius");
       // String rad =getActivity().getIntent().getExtras().getString("radius");
        dist=(TextView)rootView.findViewById(R.id.text);
       dist.setText(i);
        */
          return rootView;
    }

    public List<Text> getTexts() throws IOException, JSONException {
        HttpGet get = new HttpGet(Constants.URL + "getpending/?user="+uid);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        if(response.getStatusLine().getStatusCode() != 200){
            System.out.println(response.getStatusLine().getReasonPhrase());
            return null;
        }
        HttpEntity entity = response.getEntity();
        String s = EntityUtils.toString(entity); //TODO empty string no good
        s = s.replaceAll("u'","'");
        s=s.replaceAll("u\"","\"");
        JSONArray jsonArray = new JSONArray(s);
        List<Text> texts = new ArrayList<Text>();
        for(int i=0;i<jsonArray.length();i++){
            Text t = new Text();
            t.address = jsonArray.getJSONObject(i).getString("sender");
            t.body = jsonArray.getJSONObject(i).getString("body");
            texts.add(t);
        }
        return texts;
    }
}

