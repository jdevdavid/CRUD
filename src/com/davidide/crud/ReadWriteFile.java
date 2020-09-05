package com.davidide.crud;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile {
	
	public static void file() throws IOException {
	
	FileReader reader = new FileReader("src/file/text.txt");
	FileWriter writer = new FileWriter("src/file/text2.txt");
	 
	while (reader.ready()) {
	    int c = reader.read();
	    writer.write(c);
	}
	 
	reader.close();
	writer.close();
	}	
}
