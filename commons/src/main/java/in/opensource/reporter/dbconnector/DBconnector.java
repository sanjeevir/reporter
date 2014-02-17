package in.opensource.reporter.dbconnector;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.Connection;
import java.sql.SQLException;

public class DBconnector {
	private static DBconnector dbConn = null;
	private ApplicationContext appContext = null;
	private DataSource dataSource = null;
	private JdbcTemplate jdbcTemplate = null;
	private static Logger logger=Logger.getLogger(DBconnector.class);
	
	static{
		if(dbConn == null)
			dbConn=new DBconnector();
	}
	public static DBconnector getInstance() {
		return dbConn;
	}
	public DBconnector() {
		appContext = new ClassPathXmlApplicationContext("Spring-Database.xml");
		dataSource = (DataSource) appContext.getBean("dataSource");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public Connection getConnection()
	{
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			logger.info("DB connection Created");
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Error in creating DB connection");
		}
		return connection;
	}
	public static void main(String args[])
	{
		DBconnector.getInstance().getConnection();
	}
}
