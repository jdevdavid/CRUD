package com.davidide.crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Functions {
	
	static void create() throws IOException, SQLException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Input Login");
		String strInputLogin = reader.readLine();
		System.out.println("Input Password");
		String strInputPassword = reader.readLine();
		BaseSQL.createRecordInTable(strInputLogin, strInputPassword);
		
	}
	
	static void view() throws IOException{
		System.out.println("Input ID for View");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String strInputForView = reader.readLine();
		
	}
	
	static void edit(){
		System.out.println("Input ID for Edit");
		
	}
	
	static void delete(){
		System.out.println("Input ID for Delete");
		
	}
	
}
