package com.envis.webservice.database;

public interface IDBManager {
	public boolean sensorIDExisted(String id);
	public boolean setIDExisted(String id);
    public boolean mapIDExisted(String id);
}
