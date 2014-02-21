package com.envis.webservice.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager implements IDBManager {
	private DatabaseBridge bridge;
	private Connection conn;

	public DBManager() {
		bridge = DatabaseBridge.getInstance();
		conn = bridge.getConnectionRMIT();
		//this.conn=this.bridge.getConnectionAWS();
		conn = bridge.getConnectionMYSQL();
	}
	@Override
	public boolean sensorIDExisted(String id) {
		Statement sta;
		ResultSet rs = null;
		String sql = "select * from sensor where id='" + id + "'";
		try {
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);
			conn.close();
            if(rs.next())
            	return true;
		} catch (SQLException e) {
			System.out.println("----" + e.getMessage());
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	@Override
	public boolean mapIDExisted(String id) {
		Statement sta;
		ResultSet rs = null;
		String sql = "select * from map where id='" + id + "'";
		try {
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);
			conn.close();
            if(rs.next())
            	return true;
		} catch (SQLException e) {
			System.out.println("----" + e.getMessage());
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	@Override
	public boolean setIDExisted(String id) {
		Statement sta;
		ResultSet rs =null;
		String sql = "select * from sensor_set where id='"+id+"'";
		try{
			sta = conn.createStatement();
			rs=sta.executeQuery(sql);
			conn.close();
			if(rs.next()){
				return true;
			}
		}catch (SQLException e){
			System.out.println("======"+e.getMessage());
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}


	
}
