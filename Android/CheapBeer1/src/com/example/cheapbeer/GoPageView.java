package com.example.cheapbeer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
 
public class GoPageView extends Fragment {
 int radius=0,conversion;
 TextView dist,distlbl;
 Button km,Miles;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.go, container, false);
       
		SeekBar seek = (SeekBar) rootView.findViewById(R.id.seekBar1);
		distlbl=(TextView)rootView.findViewById(R.id.TextView01);
		 dist=(TextView)rootView.findViewById(R.id.textView2);
		 km=(Button)rootView.findViewById(R.id.button1);
		 Miles=(Button)rootView.findViewById(R.id.button2);
		 
    	seek.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar arg0, int progressvalue,
					boolean fromUser) {
				// TODO Auto-generated method stub
				radius=progressvalue;
				dist.setText(""+radius);
				km.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						
						dist.setText(""+radius);
						Bundle bundle = new Bundle();
						bundle.putInt("radius", radius);//you can use putInt or putBoolean etc
						setArguments(bundle);
					}
					
				});
				
				
				Miles.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View arg0) {
						conversion=(radius*1000);
						dist.setText(""+conversion);
					}
					
				});
				
				
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
         
        return rootView;
    }
}
