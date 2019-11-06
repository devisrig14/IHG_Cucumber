package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnect {
	private final static String DB_URL = "jdbc:oracle:thin:@hpvm31.usfood.com:1521:ECOMQA";
	private final static String USER = "ecomuser";
	private final static String PASS = "oer0vw92n";
	private static Connection conn = null;

	private DBConnect() {
	}

	public static void main(String[] args) {
		String query = "Update ec_dist_vndr_spcl set ACTV_IND = 'Y' where EC_DISTBR_ID=2240 and prch_from_vndr=130169";
		dbConnection(query);
	}

	public static void dbConnection(String Query) {
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			int x= stmt.executeUpdate(Query);
			System.out.println("Updated::"+x);

		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			try {
				//
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception se) {
				se.printStackTrace();
			}
		}
		System.out.println("All done ");
	}
}
