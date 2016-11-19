package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SuppressWarnings("deprecation")
public class HttpClientDemo {
	 static Category cate[];
	private final String USER_AGENT = "Mozilla/5.0";
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	
	public HttpClientDemo() {
		super();
		// TODO Auto-generated constructor stub
	}


		// HTTP GET request
		public void sendGet() throws Exception {

			String url = "http://news-dinhphan.rhcloud.com/category";

			@SuppressWarnings("resource")
			HttpClient client = new DefaultHttpClient();
			URIBuilder builder = new URIBuilder();
			builder.setScheme("http").setHost("news-dinhphan.rhcloud.com/category/").setPath("");
			java.net.URI uri = builder.build();
			HttpGet request = new HttpGet(uri);

			// add request header
			request.addHeader("User-Agent", USER_AGENT);
			
			HttpResponse response = client.execute(request);

			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " +
	                       response.getStatusLine().getStatusCode());
			BufferedReader rd = new BufferedReader(
	                       new InputStreamReader(response.getEntity().getContent()));
			cate= gson.fromJson(rd, Category[].class);
			
			for(int i=0;i<cate.length;i++)
			System.out.println("Name "+cate[i].getDescription());

		}

		// HTTP POST request
		public void sendPost() throws Exception {

			String url = "http://news-dinhphan.rhcloud.com/category";

			@SuppressWarnings("resource")
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);
           // Category cate=new Category();
         //   cate.setName("test");
          //  cate.setDescription("d");
			// add header
			post.setHeader("User-Agent", USER_AGENT);
			StringEntity postingString = new StringEntity(gson.toJson(Liferay_Open.cata), "UTF-8");//gson.tojson() converts your pojo to json
			post.setEntity(postingString);
			post.setHeader("Content-type", "application/json");
			post.addHeader("charset", "UTF-8");
			HttpResponse response = client.execute(post);
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + post.getEntity());
			System.out.println("from controller to http :"+Liferay_Open.cata.getDescription());
			System.out.println("from controller to http :"+Liferay_Open.cata.getName());
			System.out.println("Response Code : " +response.getStatusLine().getStatusCode());
			BufferedReader rd = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			if (result.toString().equals("false")) Liferay_Open.isStatus=false;
			else Liferay_Open.isStatus=true;
			System.out.println(result.toString());

		}
		
		public void getCategoryById(int id) throws Exception {

			String url = "http://news-dinhphan.rhcloud.com/category/"+id;

			@SuppressWarnings("resource")
			HttpClient client = new DefaultHttpClient();
			URIBuilder builder = new URIBuilder();
			builder.setScheme("http").setHost("news-dinhphan.rhcloud.com/category/").setPath(""+id);
			java.net.URI uri = builder.build();
			HttpGet request = new HttpGet(uri);

			// add request header
			request.addHeader("User-Agent", USER_AGENT);
			
			HttpResponse response = client.execute(request);

			System.out.println("Response Code : " +
	                       response.getStatusLine().getStatusCode());
			BufferedReader rd = new BufferedReader(
	                       new InputStreamReader(response.getEntity().getContent()));
			cate= gson.fromJson(rd, Category[].class);
			
			for(int i=0;i<cate.length;i++)
			System.out.println("Name "+cate[i].getName()+",Description:"+cate[i].getDescription()+",Id:"+cate[i].getCategoryId());

		}
}
