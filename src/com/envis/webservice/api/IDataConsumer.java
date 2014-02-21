package com.envis.webservice.api;

public interface IDataConsumer {
	/**
	 *  Function: store data into DB (currently used)
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:23:29 pm
	 *  @param data format is "id1;timestamp1(yyyy-mm-dd 24hh:mm:ss);reading1"
	 *  @return
	 */
	public boolean streamDataIn(String data);
	/**
	 *  Function: store data into DB (used for testing)
	 *
	 *  @author wubo.neusoft@gmail.com  DateTime 23/12/2013 3:23:29 pm
	 *  @param data format is "timestamp,id1,reading1,id2,reading2..."
	 *  @return
	 */
	public boolean customStream(String data);
	
}
