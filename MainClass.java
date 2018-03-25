package com.sample;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import com.mysql.jdbc.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;


//import java.naming.spi.DirStateFactory.Result;
public class MainClass {

	public static void main(String[] args) {
		
		 Scanner in = new Scanner(System.in);
		 System.out.println("Choose number for control: ");
		 System.out.println("1 - all book;");
		 System.out.println("2 - add book;");
		 System.out.println("3 - remove book;");
		 System.out.println("4 - edit book");
		 int number1 = in.nextInt();
		 
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
			//System.out.println("Connection success");
			Statement stmt = conn.createStatement();
			
			if (number1 == 1){
			String query = "SELECT * FROM library_managing ORDER BY name_b";
			ResultSet rs = stmt.executeQuery(query);
			
			
			while (rs.next()) {
				System.out.println("Id book: "+rs.getString("id_book")+"  | Author:"+rs.getString("author")+" | Name: "+rs.getString("name_b"));
			}}
			if (number1 == 2){
				
				System.out.println("Write id");
				int id1_book = in.nextInt();
				 //System.out.println(id1_book);
				 
				System.out.println("Write name book");
				String name1 = in.nextLine();
			    System.out.println(name1);
				 
				System.out.println("Write name author");
				String author1 = in.nextLine();
				String query = "INSERT INTO library_managing SET id_book= "+"\""+ id1_book + "\""+" , author="+ "\""+ author1 + "\""+", name_b="+"\""+ name1 +"\""+"";
						
							
				stmt.executeUpdate(query);
							
				System.out.println("Add success");
					
						
		}
			if (number1 == 3){
				System.out.println("Please write id book");
				int id2_book = in.nextInt();
				String query = "DELETE FROM library_managing WHERE `id_book`="+"\""+ id2_book +"\""+"" ;
				
				stmt.executeUpdate(query);
				
				System.out.println("Delete success");
				
				
		}
			if(number1 == 4) {
				System.out.println("Please write id book");
				int id3_book = in.nextInt();
				
				System.out.println("Please write new name of book");
				String new_name = in.next();
				
				System.out.println("Please write new author of book");
				String new_author = in.next();
				String query = "UPDATE library_managing SET name_b="+"\""+ new_name +"\""+", author="+"\""+ new_author +"\""+" WHERE id_book="+"\""+ id3_book +"\""+"";
				
				stmt.executeUpdate(query);
				
				System.out.println("Edit success");
			}
			
		}
		catch (Exception e){
			System.err.println(e);
		}		
	}}


