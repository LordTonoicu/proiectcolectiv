package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory instance = new ConnectionFactory();
	private static Connection connection=null;
    @Override
	protected void finalize() throws Throwable {
		if(!connection.isClosed())
			connection.close();
		super.finalize();
	}
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
    private ConnectionFactory() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    private Connection createConnection() {
        try {
        	if(connection==null || connection.isClosed())
        	{
        		 String URL = "jdbc:mysql://"+System.getenv("OPENSHIFT_MYSQL_DB_HOST")+":"+System.getenv("OPENSHIFT_MYSQL_DB_PORT")+"/mydb";
        		 String USER = "adminzpwDCy9";
        		 String PASSWORD = "e-sVHJXFVThg";
        		 connection = DriverManager.getConnection(URL, USER, PASSWORD);
        	}
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }   
     
    public static Connection getConnection() {
        return instance.createConnection();
    }    
}
