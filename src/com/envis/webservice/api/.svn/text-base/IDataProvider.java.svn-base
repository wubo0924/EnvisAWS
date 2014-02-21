package com.envis.webservice.api;

import java.util.Calendar;

public interface IDataProvider {
	/**
	 * 
	 *  Function: add new sensor into DB
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:34:13 pm
	 *  @param sensorInfos-- Length is 8
	 *  @return
	 */
	public boolean addSensor(String[] sensorInfos);
	/**
	 * 
	 *  Function: edit sensor data
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:36:24 pm
	 *  @param sensorInfos-- Length is 8
	 *  @return
	 */
	public boolean editSensor(String[] sensorInfos);
	/**
	 * 
	 *  Function: remove sensor from DB
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:37:15 pm
	 *  @param sensorID--sensor's ID
	 *  @return
	 */
	public boolean removeSensor(String sensorID);
	
	/**
	 * 
	 *  Function: add new map into DB
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:37:47 pm
	 *  @param mapInfos-- Length is 8
	 *  @return
	 */
	public boolean addMap(String[] mapInfos);
	/**
	 * 
	 *  Function: edit map data
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:38:24 pm
	 *  @param mapInfos-- Length is 8
	 *  @return
	 */
	public boolean editMap(String[] mapInfos);
	/**
	 * 
	 *  Function:remove map from DB, and at same time remove the association between map and set
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:38:39 pm
	 *  @param mapID-- map's ID
	 *  @return
	 */
	public boolean removeMap(String mapID);
	
	/**
	 * 
	 *  Function:add new sensor set into DB
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:39:54 pm
	 *  @param setInfos-- Length is5
	 *  @return
	 */
	public boolean addSets(String[] setInfos);
	/**
	 * 
	 *  Function:edit sensor set
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:40:46 pm
	 *  @param setInfos-- Length is
	 *  @return
	 */
	public boolean editSets(String[] setInfos);
	/**
	 * 
	 *  Function:remove sensor set from DB, and at same time remove association between sensor set and sensors
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:41:00 pm
	 *  @param setID-- sensor set's ID
	 *  @return
	 */
	public boolean removeSets(String setID);
	
	/**
	 * 
	 *  Function: put sensor set on map, and create association between sensor set and map
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:42:00 pm
	 *  @param setAndMapInfos-- length is 5
	 *  @return
	 */
	public boolean plotSetsOnMap(String[] setAndMapInfos);
	/**
	 * 
	 *  Function:edit association between sensor set and map
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:42:54 pm
	 *  @param setAndMapInfos-- length is 5
	 *  @return
	 */
	public boolean editSetsOnMap(String[] setAndMapInfos);
	/**
	 * 
	 *  Function:remove association between sensor sets and map
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:43:31 pm
	 *  @param setID-- sensor set's ID
	 *  @return
	 */
	public boolean unplotSetsOnMap(String setID);
	
	/**
	 * 
	 *  Function: retrieve sensor reading by sensor id
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:44:00 pm
	 *  @param sensorID-- sensor id
	 *  @param dataType-- 1.JSON 2.CSV
	 *  @return
	 */
	public String getDataReadingBySensorID(String sensorID, int dataType);
	/**
	 * 
	 *  Function:retrieve sensor reading by sensor type
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:45:33 pm
	 *  @param sensorType-- sensor type
	 *  @param dataType-- 1.JSON 2.CSV
	 *  @return
	 */
	public String getDataReadingBySensorType(String sensorType, int dataType);
	/**
	 * 
	 *  Function:retrieve sensor reading by set id
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:46:03 pm
	 *  @param setID-- sensor set id
	 *  @param dataType-- 1.JSON 2.CSV
	 *  @return
	 */
	public String getDataReadingBySetID(String setID, int dataType);
	
	/**
	 * 
	 *  Function:retrieve sensor reading by historical time
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:46:40 pm
	 *  @param sensorID-- sensor id
	 *  @param datefrom-- start date
	 *  @param dateto-- end date
	 *  @param dataType-- 1.JSON 2.CSV
	 *  @return
	 */
	public String getSensorReadingByHisTime(String sensorID,String datefrom,String dateto, int dataType);
	/**
	 * 
	 *  Function:retrieve sensor set reading by historical time
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:47:39 pm
	 *  @param setID-- sensor set id
	 *  @param datefrom-- start date
	 *  @param dateto-- end date
	 *  @param dataType-- 1.JSON 2.CSV
	 *  @return
	 */
	public String getSetReadingByHisTime(String setID,String datefrom,String dateto, int dataType);
    
	/**
	 * 
	 *  Function:retrieve sensor reading by real time
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:48:19 pm
	 *  @param sensorID-- sensor id
	 *  @param dataType-- 1.JSON 2.CSV
	 *  @return
	 */
	public String getSensorReadingByRealTime(String sensorID, int dataType);
	/**
	 * 
	 *  Function:retrieve sensor set reading by real time
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:48:46 pm
	 *  @param setID-- sensor set id
	 *  @param dataType-- 1.JSON 2.CSV
	 *  @return
	 */
	public String getSetReadingByRealTime(String setID, int dataType);

	/**
	 * 
	 *  Function:create association between sensors and set
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:49:24 pm
	 *  @param dataInfos-- length is 5
	 *  @return
	 */
	public boolean associateSensorAndSet(String[] dataInfos);
	/**
	 * 
	 *  Function:edit association between sensors and set
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:50:00 pm
	 *  @param dataInfos-- length is 5
	 *  @return
	 */
	public boolean editAssociationSensorAndSet(String[] dataInfos);
	
	/**
	 * 
	 *  Function: retrieve all elements in DB (maps, sensors,sets,associations)
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:50:22 pm
	 *  @return
	 */
	public String getAllMap();
	public String getAllSensor();
	public String getAllSet();
	public String getAllAssociationSetAndSensor();
	public String getAllAssociationMapAndSet();
	
	/**
	 * 
	 *  Function: ID generator
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:50:53 pm
	 *  @return
	 */
	public String generateSensorID();
	public String generateSetID();
	public String generateMapID();
}

