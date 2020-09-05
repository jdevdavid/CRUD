package com.davidide.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.davidide.libs.Sysout;

//В этом классе лежат методы по работе с БД через SQL
public class BaseSQL {
//	static final String DB_DRIVER = "\"org.postgresql.Driver\"";
//  static final String DB_CONNECTION = "jdbc:postgresql://127.0.0.1:5432/JavaDataBase";

	static final String DB_DRIVER = "\"com.mysql.jdbc.Driver\"";
	static final String DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/JavaDataBase";
	static final String DB_USER = "postgres";
	static final String DB_PASSWORD = "1";

	// This method to connect in Database
	protected static Connection getDBConnection() {
		System.out.println("- Testing connection to PostgreSQL JDBC");
		Connection dbConnection = null;

		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("- " + e.getMessage());
		}
		
		System.out.println("- PostgreSQL JDBC Driver successfully connected");

		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println("- " + e.getMessage());
		}

		return dbConnection;
	}

	//create Table
	static void createDbUserTable() throws SQLException {
		System.out.println("- " + "createDbUserTable");
		Connection dbConnection = null;
		Statement statement = null;
//		AUTO_INCREMENT
//		IDENTITY(1,1)
		
//		String createTableSQL = "CREATE TABLE DBUSER(USER_ID VARCHAR(5) PRIMARY KEY  NOT NULL, "
		String createTableSQL = "CREATE TABLE DBUSER(USER_ID int AUTO_INCREMENT NOT NULL, "
				+ "USERNAME VARCHAR(20) NOT NULL, " + "PASSWORD VARCHAR(20), PRIMARY KEY (USER_ID)"
//				+ "CREATED_BY VARCHAR(20) NOT NULL"
//				+ "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) "
				+ ")";
		System.out.println(createTableSQL);
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			// выполнить SQL запрос
			statement.execute(createTableSQL);
			System.out.println("-- " + "Table \"dbuser\" is created!");

		} catch (SQLException e) {
			System.out.println("!-- " + e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}

	}

	//  CREATE record
	static void createRecordInTable(String loginString, String passwordString) throws SQLException {
		System.out.println("- " + "insertDbUserTable");

		Connection dbConnection = null;
		Statement statement = null;

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			// выполнить SQL запрос
			String insertTableSQL = "INSERT INTO DBUSER" + "(USERNAME, PASSWORD) " + "VALUES"
					+ "('" + loginString + "','" + passwordString + "')";
			System.out.println(insertTableSQL);
			statement.executeUpdate(insertTableSQL);
			System.out.println("-- Record create successful");	

		} catch (SQLException e) {
			System.out.println("!-- " + e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}

	static void readDbUserTable() throws SQLException {
		System.out.println("- " + "readDbUserTable");

		Connection dbConnection = null;
		Statement statement = null;
		String selectTableSQL = "SELECT USER_ID, USERNAME, PASSWORD from DBUSER";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			// выбираем данные с БД
			ResultSet rs = statement.executeQuery(selectTableSQL);

			// И если что то было получено то цикл while сработает
			while (rs.next()) {
				String userid = rs.getString("USER_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");

				System.out.print("userid : " + userid);
				System.out.print("   username : " + username);
				System.out.println("   password : " + password);
			}
		} catch (SQLException e) {
			System.out.println("!-- " + e.getMessage());
		}
	}
	//  VIEW ALL THE Table
	static void viewRecordInTable(String id) throws SQLException {
		System.out.println("- " + "readDbUserTable");

		Connection dbConnection = null;
		Statement statement = null;
		String selectTableSQL = "SELECT USER_ID, USERNAME, PASSWORD from DBUSER WHERE USER_ID = "+  id +"";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			// выбираем данные с БД
			ResultSet rs = statement.executeQuery(selectTableSQL);

			// И если что то было получено то цикл while сработает
//			while (rs.next()) {
				String userid = rs.getString("USER_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");

				System.out.print("userid : " + userid);
				System.out.print("   username : " + username);
				System.out.println("   password : " + password);
//			}
		} catch (SQLException e) {
			System.out.println("!-- " + e.getMessage());
		}
	}

	static void updateRecordInTable(String id, String loginString, String passwordString) throws SQLException {
			System.out.println("- " + "readDbUserTable");

			Connection dbConnection = null;
			Statement statement = null;
			String selectTableSQL = "UPDATE USER_ID, USERNAME, PASSWORD from DBUSER WHERE USER_ID = "+  id +"";
//			UPDATE DBUSER SET USERNAME = 'mkyong_new' WHERE USER_ID = 1
			try {
				dbConnection = getDBConnection();
				statement = dbConnection.createStatement();

				// выбираем данные с БД
				ResultSet rs = statement.executeQuery(selectTableSQL);

				// И если что то было получено то цикл while сработает
//				while (rs.next()) {
					String userid = rs.getString("USER_ID");
					String username = rs.getString("USERNAME");
					String password = rs.getString("PASSWORD");

					System.out.print("userid : " + userid);
					System.out.print("   username : " + username);
					System.out.println("   password : " + password);
//				}
			} catch (SQLException e) {
				System.out.println("!-- " + e.getMessage());
			}
		}

//		
	
	static void autoFillTable() throws SQLException {
		System.out.println("- " + "autoFillTable");

		Connection dbConnection = null;
		Statement statement = null;

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			int i = 0;
			do {
				i++;
				// выполнить SQL запрос
				String insertTableSQL = "INSERT INTO DBUSER" + "(USER_ID, USERNAME, PASSWORD) " + "VALUES"
//									+ "("+ String.valueOf(i) + ",'mkyong','123467')";
						+ "(" + i + ",'mkyong','123467')";
				System.out.println(insertTableSQL);

				statement.executeUpdate(insertTableSQL);
			} while (i < 10);

			System.out.println("-- Данные успешно обновлены");

		} catch (SQLException e) {
			System.out.println("!-- " + e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}

	}

	static void deleteAllRecordsFromTable() {
		System.out.println("- " + "deleteDbUserTable");

		Connection dbConnection = null;
		Statement statement = null;

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			// Очищаем таблицу
//			String deleteTableSQL = "DELETE * FROM 'DBUSER';";
			String deleteTableSQL = "TRUNCATE `javadatabase`.`dbuser`";
			statement.execute(deleteTableSQL);
			System.out.println("-- Таблица очищена.");

		} catch (SQLException e) {
			System.out.println("!-- " + e.getMessage());
		}
	}

}
