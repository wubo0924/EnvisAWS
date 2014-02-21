package com.envis.webservice.common;


public enum DBOperation {
	SIDEXIST("exist", 1), DBFAIL("fail", 2);  
     
    private String name;  
    private int index;  
     
    private DBOperation(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
    
    public static String getName(int index) {  
    	for (DBOperation db : DBOperation.values()) {  
            if (db.getIndex() == index) {  
                return db.name;  
            }  
        }  
        return null;  
    }  
    
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getIndex() {  
        return index;  
    }  
    public void setIndex(int index) {  
        this.index = index;  
    }  
}
