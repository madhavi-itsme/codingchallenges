package CodingChannenges.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class FirstApi {
	
	public static int getTotalGoals(String team, int year) throws IOException, ScriptException{
		final String Endpoint="https://jsonmock.hackerrank.com/api/football_matches";
		
		int totalGoalsAtHome=getPageTotalGoals(String.format(Endpoint + "?team1=%s&year=%d", URLEncoder.encode(team, "UTF-8"), year), "team1",1);
		
		int totalGoalsAtVisiting=getPageTotalGoals(String.format(Endpoint + "?team2=%s&year=%d", URLEncoder.encode(team, "UTF-8"), year), "team2",1);

		return totalGoalsAtHome + totalGoalsAtVisiting;
	}

	private static int getPageTotalGoals(String request, String team, int page) throws IOException, ScriptException {
		URL url= new URL(request + "&page=" +page);
		
		HttpURLConnection httpUrlConnection= (HttpURLConnection) url.openConnection();
		httpUrlConnection.setRequestMethod("GET");
		httpUrlConnection.setConnectTimeout(5000);
		httpUrlConnection.setReadTimeout(5000);
		httpUrlConnection.addRequestProperty("Content-Type", "application/json");

        int status= httpUrlConnection.getResponseCode();
        
        InputStream in=(status < 200 || status > 299) ? httpUrlConnection.getErrorStream() : httpUrlConnection.getInputStream();
        
        BufferedReader br=new BufferedReader(new InputStreamReader(in));
        
        String responseLine;
        
        StringBuffer responseContent = new StringBuffer();
        
        while((responseLine = br.readLine()) != null)
        	  responseContent.append(responseLine);
        
        br.close();
        httpUrlConnection.disconnect();
        
        ScriptEngineManager  manager=new ScriptEngineManager();
        
        ScriptEngine engine=manager.getEngineByName("javascript");
        
        String script="var obj= JSON.parse('" + responseContent.toString() + "');";
        
        script += "var total_pages = obj.total_pages;";
        
        script+="var total_goals = obj.data.reduce(function(accumulator, current) { return accumulator + parseInt(current."+team + "goals);} , 0);";
        
        engine.eval(script);
        
        if(engine.get("total_pages") == null)
        	throw new RuntimeException("connot retrieve data from server.");
        
        int totalPages=(int) engine.get("total_pages");
        int totalGoals=(int) Double.parseDouble(engine.get("total_goals").toString());
        
        return (page < totalPages) ? getPageTotalGoals(request,team,page+1) : totalGoals;
  	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
