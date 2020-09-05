package com.davidide.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseCRUD extends BaseSQL {
	//VIEW One Position
	static void readOnePositionDbUserTable(int id) throws SQLException {
		System.out.println("- " + "readDbUserTable");
		
		Connection dbConnection = null;
		Statement statement = null;
		String selectTableSQL = "SELECT "+ id +", USERNAME from DBUSER";
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			// выбираем данные с БД
			ResultSet rs = statement.executeQuery(selectTableSQL);

			// И если что то было получено то цикл while сработает   
			while (rs.next()) {
				String userid = rs.getString("USER_ID");
				String username = rs.getString("USERNAME");

				System.out.println("userid : " + userid);
				System.out.println("username : " + username);
			}
		} catch (SQLException e) {
			System.out.println("!-- " + e.getMessage());
		}	
	}
	
	
	static void deleteDbUserTable() throws SQLException{
		System.out.println("- " + "deleteDbUserTable");
		
		Connection dbConnection = null;
		Statement statement = null;
		String deleteTableSQL = "DROP TABLE `javadatabase`.`dbuser`";
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			// выбираем данные с БД
			statement.execute(deleteTableSQL);
			System.out.println("-- База успешно удалена");
			

		} catch (SQLException e) {
			System.out.println("!-- " + e.getMessage());
		}
	}
//	DELETE
//	DELETE FROM dbuser WHERE USER_ID = ‘ введенное значение’;
}	
