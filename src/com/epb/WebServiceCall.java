package com.epb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;

import com.epb.utils.Constants;

public class WebServiceCall {
	
	public String postCall(Context context, String strMethodName, List<NameValuePair> listParams){
		String response = "";
		DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
	    HttpPost localHttpPost = new HttpPost(Constants.ServiceURL+"/"+strMethodName);
	    try {
			localHttpPost.setEntity(new UrlEncodedFormEntity(listParams));
			BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(
							localDefaultHttpClient.execute(localHttpPost).getEntity().getContent()));
		    
		    StringBuilder sb = new StringBuilder();
            sb.append(localBufferedReader.readLine() + "\n");
            String line = "0";
            while ((line = localBufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
            localBufferedReader.close();
            response = sb.toString(); 
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response ="";
			e.printStackTrace();
		} 
		return response;
	}

}
