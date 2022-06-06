package clasejdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainIMDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/myapp", "myapp", "myapp");
			LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("data.tsv"));
			
			String line = lineNumberReader.readLine();
			line = lineNumberReader.readLine();
			
			
			while(line != null) {
//				System.out.println(line);
				
				String[] valores = line.split("\\t");
				
				Statement instruccion = conexion.createStatement();
				
				
				String sql = String.format("INSERT INTO imdb (tconst, titleType, "
						+ "primaryTitle, originalTitle, isAdult, startYear, endYear, runtimeMinutes, genres)"
						+ " VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s')", valores[0], valores[1], 
						valores[2], valores[3], valores[4], valores[5], valores[6], valores[7], valores[8]);
				
				try {
					instruccion.executeUpdate(sql);
				} catch(SQLException e) {
					
				}			
				
				line = lineNumberReader.readLine();
			}		
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

}
