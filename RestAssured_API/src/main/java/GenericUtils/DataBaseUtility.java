package GenericUtils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * This class contains generic method to access DataBase Connection
 * @throws Throwable
 */
public class DataBaseUtility {
	Connection con = null;
	ResultSet result = null;
	Driver driverRef;
	
	public void connectToDB() throws Throwable {
		
		DriverManager.registerDriver(driverRef);
		DriverManager.getConnection(IpathConstants.dbURL, IpathConstants.dbUSERNAME, IpathConstants.dbPASSWORD);
		}
		public void closeDB() throws Throwable {
			con.close();
		}
		public String executeQueryAndGetData(String Query, int ColoumnIndex, String ExpData) throws SQLException {
			Boolean flag = false;
			result = con.createStatement().executeQuery(Query);
			while(result.next())
			{
			String ActData = result.getString(ColoumnIndex);
			if(ActData.equalsIgnoreCase(ExpData))
			{
				flag = true;
				break;
			}
			}
			if (flag) {
				System.out.println(ExpData + " data verified successfully");
			return ExpData;
			}
			else
			{
				System.out.println(ExpData + " data is not verified successfully");
			}
			return ExpData;
			
		}
}