package com.davidide.crud;
import java.io.IOException;
import java.sql.SQLException;

import com.davidide.libs.Sysout;

public class Main {
	
	public static void main(String[] args) throws IOException, SQLException {
		Unit.start();
		
		while(true){
			MainMenu.callMenu();
		}
		/*		try {
			Base.createDbUserTable(); 
			Base.insertDbUserTable();
			Base.readDbUserTable();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	*/	
//		ReadWriteFile.file();

	}
}

