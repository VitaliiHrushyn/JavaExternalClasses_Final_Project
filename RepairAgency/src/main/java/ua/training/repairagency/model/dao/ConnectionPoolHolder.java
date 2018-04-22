package ua.training.repairagency.model.dao;

import org.apache.commons.dbcp.BasicDataSource;

import java.util.ResourceBundle;

import javax.sql.DataSource;

import static ua.training.repairagency.model.dao.ConnectionConstants.*;

public class ConnectionPoolHolder {
    
	private static volatile DataSource dataSource;
	private static final String DATA_BASE_BUNDLE_NAME = "db_connection";
	private static final ResourceBundle dataBaseBundle = ResourceBundle.getBundle(DATA_BASE_BUNDLE_NAME);
	
	public static DataSource getDataSource(){

        if (dataSource == null){
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
 //                   ds.setDriverClassName(dataBaseBundle.getString(DATA_BASE_DRIVER_NAME));
                    ds.setUrl(dataBaseBundle.getString(DATA_BASE_URL));
                    ds.setUsername(dataBaseBundle.getString(DATA_BASE_USERNAME));
                    ds.setPassword(dataBaseBundle.getString(DATA_BASE_PASSWORD));
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
