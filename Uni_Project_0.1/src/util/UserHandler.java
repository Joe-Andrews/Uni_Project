package util;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class UserHandler {

	public static boolean signIn(String user, String password) {
		
		try {
			CallableStatement cs = DbConnector.getConnection().prepareCall("{call sign in procedure ? ?}");
			cs.setString(0, user);
			cs.setString(1, password);
			cs.execute();
			
			return true;
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
		
		return false;
	}
	
	public static boolean createAccount(String user, String password) {
		try {
			CallableStatement cs = DbConnector.getConnection().prepareCall("{call create account procedure ? ?}");
			cs.setString(0, user);
			cs.setString(1, password);
			cs.execute();
			
			return true;
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
		
		return false;
	}
	
}
