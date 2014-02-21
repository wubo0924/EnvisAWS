package com.envis.webservice.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

import org.json.JSONArray;
import org.json.JSONObject;

import com.envis.webservice.common.DataFormat;
import com.envis.webservice.database.DBManager;
import com.envis.webservice.database.DatabaseBridge;
import com.envis.webservice.database.IDBManager;

/**
 * 
 * @ClassName: DataProvider
 * 
 * @Description: Interface service for Android
 * 
 * @author: wubo.neusoft@gmail.com
 * 
 * @date: 2013-10-01 15:03:42
 */

public class DataProvider implements IDataProvider {

	private DatabaseBridge bridge;
	private DBManager dbm;
	private Connection conn;

	public DataProvider() {
		this.bridge = DatabaseBridge.getInstance();
		dbm = new DBManager();
		// conn = bridge.getConnectionRMIT();
		// this.conn = this.bridge.getConnectionAWS();
		conn = bridge.getConnectionMYSQL();
	}

	
	public boolean addSensor(String[] sensorInfos) {
		if (sensorInfos.length != 8)
			return false;
		boolean exist = dbm.sensorIDExisted(sensorInfos[0]);
		if (exist) {
			return false;
		} else {
			PreparedStatement ps;
			int flag = 0;
			String sql = "insert into sensor values(?,?,?,?,?,?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, sensorInfos[0]);
				ps.setInt(2, Integer.parseInt(sensorInfos[1]));
				ps.setString(3, sensorInfos[2]);
				ps.setString(4, sensorInfos[3]);
				ps.setString(5, sensorInfos[4]);
				ps.setString(6, sensorInfos[5]);
				ps.setString(7, sensorInfos[6]);
				ps.setString(8, sensorInfos[7]);
				flag = ps.executeUpdate();
				conn.close();
				// System.out.println("===="+flag);
			} catch (SQLException e) {
				System.out.println("======" + e.getMessage());
			} catch (Exception e) {
				System.out.println("======" + e.getMessage());
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("======" + e.getMessage());
				}
			}
			if (flag != 0)
				return true;
			else
				return false;
		}
	}

	public boolean editSensor(String[] sensorInfos) {
		if (sensorInfos.length != 8)
			return false;
		boolean exist = dbm.sensorIDExisted(sensorInfos[0]);
		if (exist) {
			return false;
		} else {
			PreparedStatement ps;
			int flag = 0;
			String sql = "update sensor set sensortype=?,name=?,brand=?,sensorstate=?,notes=?,max_value=?,min_value=? where id=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(sensorInfos[1]));
				ps.setString(2, sensorInfos[2]);
				ps.setString(3, sensorInfos[3]);
				ps.setString(4, sensorInfos[4]);
				ps.setString(5, sensorInfos[5]);
				ps.setString(6, sensorInfos[6]);
				ps.setString(7, sensorInfos[7]);
				ps.setString(8, sensorInfos[0]);
				flag = ps.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				System.out.println("======" + e.getMessage());
			} catch (Exception e) {
				System.out.println("======" + e.getMessage());
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (flag != 0)
				return true;
			else
				return false;
		}
	}

	public boolean addSets(String[] setInfos) {
		if (setInfos.length != 5)
			return false;
		boolean exist = false;
		exist = dbm.setIDExisted(setInfos[0]);
		if (exist) {
			return false;
		} else {
			PreparedStatement ps;
			int flag = 0;
			String sql = "insert into sensor_set values(?,?,?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, setInfos[0]);
				ps.setString(2, setInfos[1]);
				ps.setString(3, setInfos[2]);
				ps.setString(4, setInfos[3]);
				ps.setString(5, setInfos[4]);
				flag = ps.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				System.out.println("======" + e.getMessage());
			} catch (Exception e) {
				System.out.println("======" + e.getMessage());
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("======" + e.getMessage());
				}
			}
			if (flag != 0)
				return true;
			else
				return false;
		}
	}

	public boolean editSets(String[] setInfos) {
		if (setInfos.length != 5)
			return false;
		boolean exist = dbm.setIDExisted(setInfos[0]);
		if (exist) {
			return false;
		} else {
			PreparedStatement ps;
			int flag = 0;
			String sql = "update sensor_set set name=?,longitude=?,latitude=?,notes=? where id=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, setInfos[1]);
				ps.setString(2, setInfos[2]);
				ps.setString(3, setInfos[3]);
				ps.setString(4, setInfos[4]);
				ps.setString(5, setInfos[0]);
				flag = ps.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				System.out.println("======" + e.getMessage());
			} catch (Exception e) {
				System.out.println("======" + e.getMessage());
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("======" + e.getMessage());
				}
			}
			if (flag != 0)
				return true;
			else
				return false;
		}
	}

	public String getDataReadingBySensorID(String sensorID, int dataType) {
		JSONObject json = new JSONObject();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		JSONArray sensorInfo;
		PreparedStatement ps;
		String sql = "select * from sensor_reading where sensorid=?";
		int count = 0;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sensorID);
			rs = ps.executeQuery();
			if (dataType == DataFormat.JSON.getIndex()) {
				while (rs.next()) {
					sensorInfo = new JSONArray();
					sensorInfo.put(rs.getString(1));
					sensorInfo.put(df.format(rs.getTimestamp(2)));
					sensorInfo.put(rs.getString(3));
					count++;
					json.accumulate(Integer.toString(count), sensorInfo);
				}
				conn.close();
				return json.toString();
			} else if (dataType == DataFormat.CSV.getIndex()) {
				String csvdata = null;
				while (rs.next()) {
					csvdata.concat(rs.getString(1));
					csvdata.concat(";");
					csvdata.concat(df.format(rs.getTimestamp(2)));
					csvdata.concat(";");
					csvdata.concat(rs.getString(3));
					csvdata.concat(";");
				}
				conn.close();
				return csvdata.substring(0, csvdata.length() - 1);
			} else {
				conn.close();
				return null;
			}
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("======" + e.getMessage());
			}
		}

		return null;
	}

	public String getDataReadingBySensorType(String sensorType, int dataType) {

		JSONObject json = new JSONObject();
		JSONArray sensorInfo;
		PreparedStatement ps;
		int count = 0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "select * from sensor_reading where sensorid in (select id from sensor where sensor.sensortype=?)";
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sensorType);
			rs = ps.executeQuery();

			if (dataType == DataFormat.JSON.getIndex()) {

				while (rs.next()) {
					sensorInfo = new JSONArray();
					sensorInfo.put(rs.getString(1));
					sensorInfo.put(df.format(rs.getTimestamp(2)));
					sensorInfo.put(rs.getString(3));
					count++;
					json.accumulate(Integer.toString(count), sensorInfo);
				}
				conn.close();
				return json.toString();
			} else if (dataType == DataFormat.CSV.getIndex()) {
				String csvdata = null;
				while (rs.next()) {
					csvdata.concat(rs.getString(1));
					csvdata.concat(";");
					csvdata.concat(df.format(rs.getTimestamp(2)));
					csvdata.concat(";");
					csvdata.concat(rs.getString(3));
					csvdata.concat(";");
				}
				conn.close();
				return csvdata.substring(0, csvdata.length() - 1);
			} else {
				conn.close();
				return null;
			}
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("======" + e.getMessage());
			}
		}
		return null;

	}

	public String getDataReadingBySetID(String setID, int dataType) {

		JSONObject json = new JSONObject();
		JSONObject sensor;
		JSONArray sensorInfo;
		PreparedStatement ps;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "SELECT s2.sensorid,s2.readingtime,s2.readingdata FROM sensor_set_include_sensor s1,sensor_reading s2 WHERE s1.sensorid=s2.sensorid AND s1.sensor_set_id=?";
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, setID);
			rs = ps.executeQuery();

			if (dataType == DataFormat.JSON.getIndex()) {
				while (rs.next()) {
					sensor = new JSONObject();
					sensorInfo = new JSONArray();
					sensorInfo.put(df.format(rs.getTimestamp(2)));
					sensorInfo.put(rs.getString(3));
					sensor.put(rs.getString(1), sensorInfo);
					json.accumulate(setID, sensor);
				}
				conn.close();
				return json.toString();
			} else if (dataType == DataFormat.CSV.getIndex()) {
				String csvdata = null;
				while (rs.next()) {
					csvdata.concat(rs.getString(1));
					csvdata.concat(";");
					csvdata.concat(df.format(rs.getTimestamp(2)));
					csvdata.concat(";");
					csvdata.concat(rs.getString(3));
					csvdata.concat(";");
				}
				conn.close();
				return csvdata.substring(0, csvdata.length() - 1);
			} else {
				conn.close();
				return null;
			}

		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("======" + e.getMessage());
			}
		}
		return null;
	}
    
	/*
	 * add x,y,z columns into table
	 * @see com.envis.webservice.api.IDataProvider#associateSensorAndSet(java.lang.String, java.lang.String)
	 */
		
	@Override
	public boolean associateSensorAndSet(String[] dataInfos) {
		if(dataInfos.length != 5)
			return false;
		PreparedStatement ps;
		int flag = 0;
		String sql = "insert into sensor_set_include_sensor values(?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dataInfos[0]);
			ps.setString(2, dataInfos[1]);
			ps.setFloat(3, Float.parseFloat(dataInfos[2]));
			ps.setFloat(4, Float.parseFloat(dataInfos[3]));
			ps.setFloat(5, Float.parseFloat(dataInfos[4]));
			flag = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		} catch (Exception e) {
			System.out.println("======" + e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("======" + e.getMessage());
			}
		}

		if (flag != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean removeSensor(String sensorID) {
		String sql_sensor_reading = "delete from sensor_reading where sensorid='"
				+ sensorID + "'";
		String sql_sensor_set_include_sensor = "delete from sensor_set_include_sensor where sensorid='"
				+ sensorID + "'";
		String sql_sensor = "delete from sensor where id='" + sensorID + "'";
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql_sensor_reading);
			st.executeUpdate(sql_sensor_set_include_sensor);
			st.executeUpdate(sql_sensor);
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean addMap(String[] mapInfos) {
		if (mapInfos.length != 8)
			return false;
		boolean exist = dbm.mapIDExisted(mapInfos[0]);
		if (exist) {
			return false;
		} else {
			PreparedStatement ps;
			int flag = 0;
			String sql = "insert into map values(?,?,?,?,?,?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, mapInfos[0]);
				ps.setFloat(2, Float.parseFloat(mapInfos[1]));
				ps.setString(3, mapInfos[2]);
				ps.setString(4, mapInfos[3]);
				ps.setString(5, mapInfos[4]);
				ps.setString(6, mapInfos[5]);
				ps.setString(7, mapInfos[6]);
				ps.setString(8, mapInfos[7]);
				flag = ps.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				System.out.println("======" + e.getMessage());
			} catch (Exception e) {
				System.out.println("======" + e.getMessage());
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("======" + e.getMessage());
				}
			}
			if (flag != 0)
				return true;
			else
				return false;
		}
	}

	@Override
	public boolean editMap(String[] mapInfos) {
		boolean exist = dbm.mapIDExisted(mapInfos[0]);
		if (exist) {
			return false;
		} else {
			PreparedStatement ps;
			int flag = 0;
			String sql = "update map set z=?,longitude=?,latitude=?,name=?,notes=?,x=?,y=? where id=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setFloat(1, Float.parseFloat(mapInfos[1]));
				ps.setString(2, mapInfos[2]);
				ps.setString(3, mapInfos[3]);
				ps.setString(4, mapInfos[4]);
				ps.setString(5, mapInfos[5]);
				ps.setString(6, mapInfos[6]);
				ps.setString(7, mapInfos[7]);
				ps.setString(8, mapInfos[0]);
				flag = ps.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				System.out.println("======" + e.getMessage());
			} catch (Exception e) {
				System.out.println("======" + e.getMessage());
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("======" + e.getMessage());
				}
			}
			if (flag != 0)
				return true;
			else
				return false;
		}
	}

	@Override
	public boolean removeMap(String mapID) {
		String sql1 = "delete from sensor_set_id where mapid='" + mapID + "'";
		String sql2 = "delete from map where id='" + mapID + "'";
		Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}

		return false;
	}

	@Override
	public boolean removeSets(String setID) {
		String sql_sensor_set_include_sensor = "delete from sensor_set_include_sensor where sensor_set_id='"
				+ setID + "'";
		String sql_sensor_set = "delete from sensor_set where id='" + setID
				+ "'";
		Statement st;
		
		try {
			st = conn.createStatement();
			st.executeUpdate(sql_sensor_set_include_sensor);
			st.executeUpdate(sql_sensor_set);
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		return false;
	}

	@Override
	public String getSensorReadingByHisTime(String sensorID, String datefrom,
			String dateto, int dataType) {

		JSONObject json = null;
		JSONArray jarray = null;
		int count = 0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "SELECT * FROM sensor_reading WHERE sensorid = '"
				+ sensorID + "' AND readingtime BETWEEN '" + datefrom
				+ "' AND '" + dateto + "' order by readingtime asc";
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (dataType == DataFormat.JSON.getIndex()) {
				json = new JSONObject();

				while (rs.next()) {
					jarray = new JSONArray();
					jarray.put(rs.getString(1));
					jarray.put(df.format(rs.getTimestamp(2)));
					jarray.put(rs.getString(3));
					count++;
					json.accumulate(Integer.toString(count), jarray);
				}
				conn.close();
				return json.toString();

			} else if (dataType == DataFormat.CSV.getIndex()) {
				String csvdata = null;
				while (rs.next()) {
					csvdata.concat(rs.getString(1));
					csvdata.concat(";");
					csvdata.concat(df.format(rs.getTimestamp(2)));
					csvdata.concat(";");
					csvdata.concat(rs.getString(3));
					csvdata.concat(";");
				}
				conn.close();
				return csvdata.substring(0, csvdata.length() - 1);
			} else {
				conn.close();
				return null;
			}
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}

		return null;
	}

	@Override
	public String getSetReadingByHisTime(String setID, String datefrom,
			String dateto, int dataType) {
		JSONObject json = null;
		JSONArray jarray = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int count = 0;
		String sql = "SELECT * FROM sensor_reading WHERE readingtime BETWEEN '"
				+ datefrom
				+ "' AND '"
				+ dateto
				+ "' AND sensorid in (select sensorid from sensor_set_include_sensor where sensor_set_id='"
				+ setID + "')";
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (dataType == DataFormat.JSON.getIndex()) {
				json = new JSONObject();

				while (rs.next()) {
					jarray = new JSONArray();
					jarray.put(rs.getString(1));
					jarray.put(df.format(rs.getTimestamp(2)));
					jarray.put(rs.getString(3));

					count++;
					json.accumulate(Integer.toString(count), jarray);
				}
				conn.close();
				return json.toString();

			} else if (dataType == DataFormat.CSV.getIndex()) {
				String csvdata = null;
				while (rs.next()) {
					csvdata.concat(rs.getString(1));
					csvdata.concat(";");
					csvdata.concat(df.format(rs.getTimestamp(2)));
					csvdata.concat(";");
					csvdata.concat(rs.getString(3));
					csvdata.concat(";");
				}
				conn.close();
				return csvdata.substring(0, csvdata.length() - 1);
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		return null;
	}

	@Override
	public String getAllMap() {
		String sql = "select * from map";
		JSONObject json = new JSONObject();
		JSONArray jarray = null;
		int count = 0;
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				jarray = new JSONArray();
				jarray.put(rs.getString(1));
				jarray.put(rs.getFloat(2));
				jarray.put(rs.getString(3));
				jarray.put(rs.getString(4));
				jarray.put(rs.getString(5));
				jarray.put(rs.getString(6));
				jarray.put(rs.getString(7));
				jarray.put(rs.getString(8));
				count++;
				json.put(Integer.toString(count), jarray);
			}
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		return json.toString();
	}

	@Override
	public String getAllSensor() {
		String sql = "select * from sensor";
		JSONObject json = new JSONObject();
		JSONArray jarray = null;
		int count = 0;
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				jarray = new JSONArray();
				jarray.put(rs.getString(1));
				jarray.put(rs.getInt(2));
				jarray.put(rs.getString(3));
				jarray.put(rs.getString(4));
				jarray.put(rs.getString(5));
				jarray.put(rs.getString(6));
				jarray.put(rs.getString(7));
				jarray.put(rs.getString(8));
				count++;
				json.put(Integer.toString(count), jarray);
			}
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		return json.toString();
	}

	@Override
	public String getAllSet() {
		String sql = "select * from sensor_set";
		JSONObject json = new JSONObject();
		JSONArray jarray = null;
		int count = 0;
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				jarray = new JSONArray();
				jarray.put(rs.getString(1));
				jarray.put(rs.getString(2));
				jarray.put(rs.getString(3));
				jarray.put(rs.getString(4));
				jarray.put(rs.getString(5));
				count++;
				json.put(Integer.toString(count), jarray);
			}
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		return json.toString();
	}
/*
 * add x,y,z columns into table
 * @see com.envis.webservice.api.IDataProvider#getAllAssociationSetAndSensor()
 */
	@Override
	public String getAllAssociationSetAndSensor() {
		String sql = "select * from sensor_set_include_sensor";
		JSONObject json = new JSONObject();
		JSONArray jarray = null;
		int count = 0;
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				jarray = new JSONArray();
				jarray.put(rs.getString(1));
				jarray.put(rs.getString(2));
				jarray.put(rs.getFloat(3));
				jarray.put(rs.getFloat(4));
				jarray.put(rs.getFloat(5));
				count++;
				json.put(Integer.toString(count), jarray);
			}
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		return json.toString();
	}

	@Override
	public String getAllAssociationMapAndSet() {
		String sql = "select * from  map_has_sensor_set";
		JSONObject json = new JSONObject();
		JSONArray jarray = null;
		int count = 0;
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				jarray = new JSONArray();
				jarray.put(rs.getString(1));
				jarray.put(rs.getString(2));
				jarray.put(rs.getFloat(3));
				jarray.put(rs.getFloat(4));
				jarray.put(rs.getFloat(5));
				count++;
				json.put(Integer.toString(count), jarray);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		
		return json.toString();
	}

	@Override
	public String getSensorReadingByRealTime(String sensorID, int dataType) {
		JSONObject json = new JSONObject();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		PreparedStatement ps;
		String sql = "select * from sensor_reading where sensorid=? and readingtime in (SELECT max( readingtime ) FROM sensor_reading WHERE sensorid = ?)";
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sensorID);
			ps.setString(2, sensorID);
			rs = ps.executeQuery();
			if (dataType == DataFormat.JSON.getIndex()) {
				if (rs.next()) {
					json.put("SensorID", rs.getString(1));
					json.put("TimeStamp", df.format(rs.getTimestamp(2)));
					json.put("Reading", rs.getString(3));
				}
				conn.close();
				return json.toString();
			} else if (dataType == DataFormat.CSV.getIndex()) {
				String csvdata = null;
				if (rs.next()) {
					csvdata.concat(rs.getString(1));
					csvdata.concat(";");
					csvdata.concat(df.format(rs.getTimestamp(2)));
					csvdata.concat(";");
					csvdata.concat(rs.getString(3));
					csvdata.concat(";");
				}
				conn.close();
				return csvdata.substring(0, csvdata.length() - 1);
			} else {
				conn.close();
				return null;
			}
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("======" + e.getMessage());
			}
		}

		return null;
	}

	@Override
	public String getSetReadingByRealTime(String setID, int dataType) {
		JSONObject json = new JSONObject();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JSONArray jarray = null;
		int count = 0;
		
		String sql = "select sensorid from sensor_set_include_sensor where sensor_set_id='"
				+ setID + "'";
		Statement st = null;
		ResultSet rs = null;
		ResultSet temp = null;
		String sid = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				sid = rs.getString(1);
				sql = "select * from sensor_reading where sensorid='"
						+ sid
						+ "' and readingtime in (SELECT max( readingtime ) FROM sensor_reading WHERE sensorid = '"
						+ sid + "')";
				temp = st.executeQuery(sql);
				if(temp.next()){
					jarray = new JSONArray();
					jarray.put(temp.getString(1));
					jarray.put(df.format(temp.getTimestamp(2)));
					jarray.put(temp.getString(3));
					count++;
					json.accumulate(Integer.toString(count), jarray);
				}
			}
			conn.close();

		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		return jarray.toString();
	}

	@Override
	public boolean plotSetsOnMap(String[] setAndMapInfos) {
		if (setAndMapInfos.length != 5)
			return false;
		String sql = "insert into map_has_sensor_set values(?,?,?,?,?)";
		PreparedStatement ps = null;
		int flag = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, setAndMapInfos[0]);
			ps.setString(2, setAndMapInfos[1]);
			ps.setFloat(3, Float.parseFloat(setAndMapInfos[2]));
			ps.setFloat(4, Float.parseFloat(setAndMapInfos[3]));
			ps.setFloat(5, Float.parseFloat(setAndMapInfos[4]));
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		if (flag != 0)
			return true;
		else
			return false;

	}

	

	@Override
	public String generateSensorID() {
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		String temp = Integer.toString(tlr.nextInt(1000, 10000));
		temp = "ss" + temp;
		String sql = "SELECT id FROM sensor WHERE id='" + temp + "'";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			while (true) {
				rs = st.executeQuery(sql);
				if (rs.next()) {
					temp = Integer.toString(tlr.nextInt(1000, 10000));
					temp = "ss" + temp;
					sql = "SELECT id FROM sensor WHERE id='" + temp + "'";
					continue;
				} else {
					conn.close();
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		return temp;
	}

	@Override
	public String generateSetID() {
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		String temp = Integer.toString(tlr.nextInt(1000, 10000));
		temp = "st" + temp;
		String sql = "SELECT id FROM sensor_set WHERE id = '" + temp + "'";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			while (true) {
				rs = st.executeQuery(sql);
				if (rs.next()) {
					temp = Integer.toString(tlr.nextInt(1000, 10000));
					temp = "st" + temp;
					sql = "SELECT id FROM sensor_set WHERE id = '" + temp + "'";
					continue;
				} else {
					conn.close();
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		return temp;
	}

	@Override
	public boolean editSetsOnMap(String[] setAndMapInfos) {
		String sql = "update map_has_sensor_set set mapid=?,x=?,y=?,z=? where sensor_set_id=?";
		PreparedStatement ps = null;
		float flag=0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, setAndMapInfos[1]);
			ps.setFloat(2, Float.parseFloat(setAndMapInfos[2]));
			ps.setFloat(3, Float.parseFloat(setAndMapInfos[3]));
			ps.setFloat(4, Float.parseFloat(setAndMapInfos[4]));
			ps.setString(5, setAndMapInfos[0]);
			flag = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		if(flag != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean unplotSetsOnMap(String setID) {
		String sql = "delete from map_has_sensor_set where sensor_set_id='"+setID+"'";
		Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		return true;
	}

	@Override
	public String generateMapID() {
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		String temp = Integer.toString(tlr.nextInt(1000, 10000));
		temp = "mp" + temp;
		String sql = "SELECT id FROM map WHERE id = '" + temp + "'";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			while (true) {
				rs = st.executeQuery(sql);
				if (rs.next()) {
					temp = Integer.toString(tlr.nextInt(1000, 10000));
					temp = "st" + temp;
					sql = "SELECT id FROM map WHERE id = '" + temp + "'";
					continue;
				} else {
					conn.close();
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		return temp;
	}

	@Override
	public boolean editAssociationSensorAndSet(String[] dataInfos) {
		if(dataInfos.length != 5)
			return false;
		String sql = "update sensor_set_include_sensor set sensor_set_id=?,x=?,y=?,z=? where sensorid=?";
		int flag = 0;
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, dataInfos[1]);
			ps.setFloat(2, Float.parseFloat(dataInfos[2]));
			ps.setFloat(3, Float.parseFloat(dataInfos[3]));
			ps.setFloat(4, Float.parseFloat(dataInfos[4]));
			ps.setString(5, dataInfos[0]);
			flag = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println("======" + e.getMessage());
		}
		if(flag ==0)
			return false;
		else
			return true;
	}

	/*
	 * public static void main(String[] args){ JSONObject json = new
	 * JSONObject(); JSONArray jarray = new JSONArray(); jarray.put(1);
	 * jarray.put(2); json.put("1", jarray); JSONArray jarray1 = new
	 * JSONArray(); jarray1.put(11); jarray1.put(22); json.put("2", jarray1);
	 * JSONArray jarray2 = new JSONArray(); jarray2.put(111); jarray2.put(222);
	 * json.put("3", jarray2);
	 * 
	 * System.out.println(json.toString());
	 * 
	 * }
	 */

}
