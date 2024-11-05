package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class UserHandler {

	public static boolean signIn(String user, String password) {
		
		try {
			CallableStatement cs = DbConnector.getConnection().prepareCall("{call loginCheck(?,?,?)}");
			cs.setString(0, user);
			cs.setString(1, password);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.execute();
			
			//if is 1 then there is an account that matches the credentials
			if (cs.getInt(2) == 1) {
				return true;
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
		
		return false;
	}
	
	public static boolean createAccount(String user, String password, boolean isAdmin) {
		try {
			Connection conn = DbConnector.getConnection();
			CallableStatement cs;
			
			if (isAdmin) {
				cs = conn.prepareCall("{call newAdmin(?,?)}");
			}
			else {
				cs = conn.prepareCall("call newUser(?,?)");
			}
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
