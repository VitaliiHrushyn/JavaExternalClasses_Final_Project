package ua.training.repairagency.model.dao;

import org.apache.commons.dbcp.BasicDataSource;

import ua.training.repairagency.model.constants.DBconnection;

import java.util.ResourceBundle;

import javax.sql.DataSource;

public class ConnectionPoolHolder {
    
	private static volatile DataSource dataSource;
	private static final String DATA_BASE_BUNDLE_NAME = "database/db_connection";
	private static final ResourceBundle dataBaseBundle = ResourceBundle.getBundle(DATA_BASE_BUNDLE_NAME);
	
	public static DataSource getDataSource(){

        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ds.setDriverClassName(dataBaseBundle.getString(DBconnection.DRIVER_NAME));
                    ds.setUrl(dataBaseBundle.getString(DBconnection.URL));
                    ds.setUsername(dataBaseBundle.getString(DBconnection.USERNAME));
                    ds.setPassword(dataBaseBundle.getString(DBconnection.PASSWORD));
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }

}
