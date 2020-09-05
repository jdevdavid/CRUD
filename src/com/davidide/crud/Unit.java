package com.davidide.crud;
import java.lang.reflect.Method;
import java.util.Date;

import com.davidide.libs.Sysout;

public class Unit {
	static void start() {
		System.out.println("Start");		
	}
	
	private static String getCurrentTimeStamp() { 
		Date today = new Date(); 
		return dateFormat.format(today.getTime()); 
	}
	
	static void unit1() {
		Sysout.pr1("Hi");
		Sysout.pr2("Hi");
		Sysout.pr3("Hi");
		
		int x=3;
		int n = x+2;
//		System.out.println(n);
	}
	
	void db() {
//		Connection dbConnection = Base.getDBConnection();
//		
//		if (dbConnection != null) {
//			System.out.println("You successfully connected to database now");
//		} else {
//			System.out.println("Failed to make connection to database");
//		}
	}
}
