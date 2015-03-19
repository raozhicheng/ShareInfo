package com.rzc.shareinfo.ui;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.rzc.shareinfo.R;
import com.rzc.shareinfo.R.layout;
import com.rzc.shareinfo.R.menu;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(){
        	public void run(){
        		connect(getUrl("http://www.baidu.com"));
        	}
        }.start();
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    
    public URL getUrl(String url){
    	URL mUrl =null;
		try {
			mUrl = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return mUrl;
    }
    
    public void connect(URL url){
    	HttpURLConnection con = null;
    	try {
			con = (HttpURLConnection)url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if(con!=null) {
    		String msg = null;
    		try {
				msg = con.getResponseMessage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Log.d("rzc",msg);
    	}
    }
    
}
