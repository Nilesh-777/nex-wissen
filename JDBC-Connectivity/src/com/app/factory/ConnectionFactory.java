package com.app.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	static Properties properties = new Properties();
	static {
		try {
			FileInputStream fis = new FileInputStream("db.properties");
			properties.load(fis);
			fis.close();
			// Class.forName(properties.getProperty("db.driver"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.user"),
				properties.getProperty("db.password"));

	}
}
