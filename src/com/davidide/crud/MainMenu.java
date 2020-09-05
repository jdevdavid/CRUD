package com.davidide.crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class MainMenu {
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	//	static int selectorMainMenu;
	final static String MENU_STRING1 = "1. View all";
	final static String MENU_STRING2 = "2. CREATE record";
	final static String MENU_STRING3 = "3. READ record";
	final static String MENU_STRING4 = "4. EDIT record";
	final static String MENU_STRING5 = "5. DELETE record";
	final static String MENU_STRING6 = "6. Check DB connection";
	final static String MENU_STRING7 = "7. Create Table";
	final static String MENU_STRING8 = "8. Autocomplete Table";
	final static String MENU_STRING9 = "9. Erace Table";

		public static void callMenu() throws IOException, SQLException{
			System.out.println();
			System.out.println("Let's press number menu(key 1-9) of you want and press key Enter");

			System.out.println(MENU_STRING1);
			System.out.println(MENU_STRING2);
			System.out.println(MENU_STRING3);
			System.out.println(MENU_STRING4);
			System.out.println(MENU_STRING5);
			System.out.println(MENU_STRING6);
			System.out.println(MENU_STRING7);
			System.out.println(MENU_STRING8);
			System.out.println(MENU_STRING9);
			System.out.println();
			
//			Первый способ
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String selectorMainMenu = reader.readLine();
//			System.out.println(selectorMainMenu);
			
//			Второй способ
//			try {
//				int selectorMainMenuEncode = System.in.read();
//				char selectorMainMenu = (char) selectorMainMenuEncode;
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			switch (selectorMainMenu) {
			case "1":
				System.out.println(MENU_STRING1);
				BaseSQL.readDbUserTable();
				break;
			case "2":
				System.out.println(MENU_STRING2);
//				Тут будет функция CREATE
				Functions.create();
				break;
			case "3":
				System.out.println(MENU_STRING3);
//				Тут будет функция VIEW	
				Functions.view();
				break;
			case "4":
				System.out.println(MENU_STRING4);
//				EDIT
//				BaseSQL.insertDbUserTable();
				break;
			case "5":
				System.out.println(MENU_STRING5);
//				DELETE
				break;
			case "6":
				System.out.println(MENU_STRING6);
				BaseSQL.getDBConnection();
				break;
			case "7":
				System.out.println(MENU_STRING7);
				BaseSQL.createDbUserTable();
//				BaseCRUD.deleteDbUserTable();
				break;
			case "8":
				System.out.println(MENU_STRING8);
				//Функция автокомплита должна грузится из моей библиотеки
				BaseSQL.autoFillTable();
				break;
			case "9":
				System.out.println(MENU_STRING9);
//				Функция стирания библиотеки тоже
				BaseSQL.deleteAllRecordsFromTable();
				break;
			default:System.out.println("Value is incorrect");
			System.gc();
				break;
			}
			
			
		
		}
		
}
