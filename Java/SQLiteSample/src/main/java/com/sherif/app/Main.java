package com.sherif.app;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		
		Connection c = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      File f = new File("db");
	      System.out.println(f.mkdir());
	      System.out.println(f.getAbsolutePath());
	      c = DriverManager.getConnection("jdbc:sqlite:db/test.db");
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");

	}

}
