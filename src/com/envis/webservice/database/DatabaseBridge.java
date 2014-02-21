/**
 * 
 */
package com.envis.webservice.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**

 * @ClassName: DatabaseBridge

 * @Description: Database connection pool

 * @author: wubo.neusoft@gmail.com

 * @date: 2013-10-01 15:07:51


 */
public class DatabaseBridge {

	private static DatabaseBridge instance = null;

	String serverName;
	String sid;
	String port;
	String service;
	String driverClass;
	String userName;
	String password;

	private DatabaseBridge() {
	}

	
	public static DatabaseBridge getInstance() {
		if (instance == null)
			instance = new DatabaseBridge();
		return instance;
	}
	
	public Connection getConnectionAWS(){
		serverName = "envis.c1ejxzy27qh2.us-west-2.rds.amazonaws.com";
		sid = "ENVISDB";
		port = "1521";
		service = "jdbc:oracle:thin:";
		driverClass = "oracle.jdbc.driver.OracleDriver";
		userName = "envis_dbuser";
		password = "swissarmyknife";
		
		String uri = service + "@" + serverName + ":" + port + ":"
				+ sid;

		try {
			Class.forName(driverClass);
			Connection c = DriverManager.getConnection(uri, userName,
					password);
			return c;
		} catch (ClassNotFoundException e) {
			System.out.println("==="+e.getMessage());
		} catch (SQLException e) {
			System.out.println("==="+e.getMessage());
		}

		
		
		return null;
	}
	
	public Connection getConnectionRMIT(){
		serverName = "emu.cs.rmit.edu.au";
		sid = "GENERAL";
		port = "1521";
		service = "jdbc:oracle:thin:";
		driverClass = "oracle.jdbc.driver.OracleDriver";
		userName = "s3363780";
		password = "rmit0210";
		
		String uri = service + "@" + serverName + ":" + port + ":"
				+ sid;

		try {
			Class.forName(driverClass);
			Connection c = DriverManager.getConnection(uri, userName,
					password);
			return c;
		} catch (ClassNotFoundException e) {
			System.out.println("==="+e.getMessage());
		} catch (SQLException e) {
			System.out.println("==="+e.getMessage());
		}

		
		
		return null;
	}
	
	public Connection getConnectionMYSQL(){
		service = "jdbc:mysql://115.146.84.200:3306/envisDB";
		driverClass = "com.mysql.jdbc.Driver";
		userName = "envisdb";
		password = "envisdb";
		Connection c = null;
		try {
			Class.forName(driverClass);
			c = DriverManager.getConnection (service,userName,password);
		} catch (ClassNotFoundException e) {
			System.out.println("==="+e.getMessage());
		} catch (SQLException e) {
			System.out.println("==="+e.getMessage());
		}
		
		return c;
	}

	/**
	 * Processes the configuration file to attempt to connect to any databases
	 * listed Adapted from:
	 * http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
	 
	public Connection getConnectionFromXML() {

		// System.out.println("1======"+ System.getProperty("user.dir"));
		// System.out.println("2======"+this.getClass().getResource("/").getPath());

		File file = new File("config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Moves through any database elements and tries to connect to them in
		// order
		NodeList nList = doc.getElementsByTagName("database");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			serverName = null;
			sid = null;
			port = null;
			service = null;
			driverClass = null;
			userName = null;
			password = null;

			// Grabs the database element and processes it
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				try {
					serverName = eElement.getElementsByTagName("serverName")
							.item(0).getTextContent();
					sid = eElement.getElementsByTagName("sid").item(0)
							.getTextContent();
					port = eElement.getElementsByTagName("port").item(0)
							.getTextContent();
					service = eElement.getElementsByTagName("service").item(0)
							.getTextContent();
					driverClass = eElement.getElementsByTagName("driverClass")
							.item(0).getTextContent();
					userName = eElement.getElementsByTagName("userName")
							.item(0).getTextContent();
					password = eElement.getElementsByTagName("password")
							.item(0).getTextContent();

					String uri = service + "@" + serverName + ":" + port + ":"
							+ sid;

					Class.forName(driverClass);

					Connection c = DriverManager.getConnection(uri, userName,
							password);
					return c;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}

		}
		return null;

	}*/
}
