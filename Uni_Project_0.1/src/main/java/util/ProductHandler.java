package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

public class ProductHandler {

	
	public static ArrayList<Product> getProducts() throws SQLException {
		
		/* The below, run as a prepared statement */
		//String query = "SELECT * FROM Product";
		//ResultSet rs = DbConnector.runSqlPrepared(query);
		
		/* ... would do the same as calling this stored procedure via a callable statement */
		ResultSet rs = DbConnector.runSqlCallable("{call readFullProducts()}");
		return resultSetToProducts(rs);
		
	}
	
	public static ArrayList<Product> resultSetToProducts(ResultSet rs) throws SQLException{
		ArrayList<Product> products = new ArrayList<Product>();
		
		while(rs.next()){
			Product p;
			
			if (rs.getString("Type").equals("Tea")) {
				if (rs.getString("Medicinal") == null) {
					p = new Tea(
							rs.getInt("ID"),
							rs.getString("Name"),
							rs.getString("Supplier"),
							rs.getInt("PriceInPence"),
							rs.getString("BrewColour"),
							rs.getDouble("Caffeine")
						);
				}
				else {
					p = new Tea(
							rs.getInt("ID"),
							rs.getString("Name"),
							rs.getString("Supplier"),
							rs.getInt("PriceInPence"),
							rs.getString("BrewColour"),
							rs.getString("Medicinal")
						);
				}
				
						
			}
			else {
				p = new Coffee(
						rs.getInt("Id"),
						rs.getString("Name"),
						rs.getString("Description"),
						rs.getInt("PriceInPence"),
						rs.getDouble("Caffeine"),
						rs.getDouble("Recommend")
					);
			}
			
			
			
			products.add(p);		
		}
		return products;
	
	}
}
