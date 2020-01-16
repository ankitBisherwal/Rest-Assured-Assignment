package Helper;

import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class helper {

	public static int help(String request, String url) throws JSONException
	{
		if(request.contentEquals("GET"))
		{
			return GET(url);
		}
		else if(request.contentEquals("POST"))
		{
			return POST(url);
		} 
		else if(request.contentEquals("PUT"))
		{
			return PUT(url);
		}
		else
			return DELETE(url); 
		
	}

	public static int GET(String url) {
		Response res = RestAssured.get(url);
		int actualResponseCode = res.getStatusCode();
		return actualResponseCode;
		
	}

	public static int POST(String url) throws JSONException {
		RequestSpecification req = RestAssured.given();
		req.header("content_Type", "application/json");
		JSONObject reqParams = new JSONObject();
		 reqParams.put("FirstName", "Ankit"); 
		 reqParams.put("LastName", "Bisherwal");
		 
		 req.body(reqParams.toString());
		 Response res = req.post(url);
		 int actual = res.getStatusCode();
		 return actual;
		
	} 

	public static int PUT(String url) throws JSONException{
		RequestSpecification req = RestAssured.given();
		JSONObject jobj = new JSONObject();
		int id=15410;
		jobj.put("userId","1");
		jobj.put("title","abcdef");
		jobj.put("body","hgfdsa");
		Response res = req.put(url+"/update/"+id);
		int actual = res.getStatusCode();
		return actual;
		
	}

	public static int DELETE(String url) {
		int id = 15410;
		RequestSpecification req = RestAssured.given();
		Response res = req.delete(url+"/delete/"+id);
		int actual = res.getStatusCode();
		return actual;
		
	}
    
	
}
