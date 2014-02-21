/**
 * 
 */
package com.envis.webservice.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.envis.webservice.database.DatabaseBridge;

/**

 * @ClassName: DataConsumer

 * @Description: Interface service for Arduino

 * @author: wubo.neusoft@gmail.com

 * @date: 2013-10-01 15:08:32


 */
public class DataConsumer implements IDataConsumer {

	private DatabaseBridge bridge;
	private Connection conn;
	
	public DataConsumer(){
		this.bridge = DatabaseBridge.getInstance();
		//this.conn = this.bridge.getConnectionRMIT();
		//this.conn=this.bridge.getConnectionAWS();
		this.conn = this.bridge.getConnectionMYSQL();
	}

	public boolean streamDataIn(String data) {
		if(data==null || data.equals(""))
			return false;
		
		
		String[] parameters=data.split(";");
		if(parameters.length != 3)
			return false;
		String id=parameters[0];
		StringTokenizer temp = new StringTokenizer(parameters[1],"|");
		String timestamp=temp.nextToken()+" "+temp.nextToken();
		String reading=parameters[2];
		//String sql ="insert into sensor_reading values('"+id+"',to_timestamp('"+timestamp+"','yyyy-mm-dd hh24:mi:ss'),'"+reading+"')";
		
		String sql = "insert into sensor_reading values('"+id+"',timestamp('"+timestamp+"','24:00:00'),'"+reading+"')";
		
		Statement st;
		int flag=0;
		try {
			st = conn.createStatement();
		    flag = st.executeUpdate(sql);
		    conn.commit();
		} catch (SQLException e) {
			System.out.println("======"+e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(flag==1)
			return true;
		else
			return false;
	}
	
	/*
	public String testParameters(String data){
		String sql;
		Statement sta=null;
		int flag=0;
	    try {
			sta = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] readings = data.split(",");
		String timestamp = readings[1];
		StringTokenizer temp = new StringTokenizer(readings[0],":");
		while(temp.hasMoreElements()){
			String tempreadingplusid = (String) temp.nextElement();
			//path = path.substring(0, path.length() - 5);
			String tempreading = tempreadingplusid.substring(0,tempreadingplusid.length() - 2);
			String sensorid = tempreadingplusid.substring(tempreadingplusid.length()-2); 
			
			sql = "insert into sensor_reading values('"+sensorid+"',timestamp('"+timestamp+"','24:00:00'),'"+tempreading+"')";
			try {
				flag = sta.executeUpdate(sql);
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		return data;
		
	}*/

	@Override
	public boolean customStream(String data) {
		String[] parameters = data.split(",");
		ArrayList ids = new ArrayList();
		ArrayList readings = new ArrayList();
		Statement st;
		
		int rows=0;
		
		if(parameters.length%2==0){
			return false;
		}else{
			String timestamp = parameters[0];
			String sql;
			for(int i=1;i<parameters.length;i+=2){
				ids.add(parameters[i]);
			}
			for(int j=2;j<parameters.length;j+=2){
				readings.add(parameters[j]);
			}
			try {
				st = conn.createStatement();
				for(int k=0;k<ids.size();k++){
					sql = "insert into sensor_reading values('"+ids.get(k)+"',timestamp('"+timestamp+"','24:00:00'),'"+readings.get(k)+"')";
					rows+=st.executeUpdate(sql);
				}
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				System.out.println("======"+e.getMessage());
			}
			
			if(rows==ids.size())
				return true;
			else
				return false;
		}
		
	}
	
}
