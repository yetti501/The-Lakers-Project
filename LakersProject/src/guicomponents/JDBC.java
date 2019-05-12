import java.sql.*;

public class JDBC {
	public static void JDBCSource() throws SQLException, ClassNotFoundException {
		
		try {
			// create our mysql database connection
		    String myDriver = "org.gjt.mm.mysql.Driver";
		    String myUrl = "jdbc:mysql://localhost/ProjectDBSource";
		    Class.forName(myDriver);
		    Connection conn = DriverManager.getConnection(myUrl, "root", "");
		      
		    // our SQL SELECT query. 
		    // if you only need a few columns, specify them by name instead of using "*"
		    String query = "SELECT * FROM users";
	
		    // create the java statement
		    Statement st = conn.createStatement();
		    
		    // execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(query);
			
		    while(rs.next()) {
		    	String projectName = rs.getString("name");
		    	int timeStart = rs.getInt("timeStart");
		    	int timeEnd = rs.getInt("timeEnd");
		    	String timeUnits = rs.getString("timeUnits");
		    	String difficulty = rs.getString("difficulty");
		    	String tools = rs.getString("tools");
		    	String materials = rs.getString("materials");
		    	String instructions = rs.getString("instructions");
	
		    	System.out.format("NAME: %s, \n"
		    			+ "START TIME: %d \n"
		    			+ "END TIME: %d \n"
		    			+ "TIME UNITS: %s \n"
		    			+ "DIFFICULTY: %s \n"
		    			+ "TOOLS: %d \n"
		    			+ "MATERIALS: %s \n"
		    			+ "INSTRUCTIONS: %s \n", projectName, timeStart, timeEnd, timeUnits, difficulty, tools, materials, instructions);
		    	
		    }
		    st.close();
		}
		catch (Exception e) {
			System.err.println("Got an Exception! ");
			System.err.println(e.getMessage());
		}
	}
}
