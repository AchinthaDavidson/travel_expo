package comguide;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import complace.DBConnect;
import complace.Place;

public class guideDBUtil {
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	// add data 
	public static boolean insertguide(String name,String description, String img,String location ,String contact) {
		
		boolean isSuccess=false;
		
		try {
			System.out.println(img);
			conn = DBConnect.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into guide values(0,'"+name+"','"+location+"','"+contact+"','"+description+"','"+img+"') ";
			int rs = stmt.executeUpdate(sql);
			
			if (rs>0) {
				isSuccess=true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return isSuccess;
		
	}
	
//	update data
	
	public static boolean updateGuide(String id,String name,String description, String img,String location,String contact ) {
		
		boolean isSuccess=false;
		String name1 = null; 
		String description1= null;
		String img1= null;
		String location1= null;
		String contact1=null;
		
		try {
			
			conn = DBConnect.getConnection();
			stmt = conn.createStatement();
			
			String sql ="select * from guide where GuideId="+id;
			rs= stmt.executeQuery(sql);
			
			if (rs.next()) {
				
				int Id =rs.getInt(1);
				 name1 =rs.getString(2);
				 description1 =rs.getString(5);
				 img1 =rs.getString(6);
				 location1 =rs.getString(3);
				 contact1=rs.getString(4);
			}
			if(name=="") {
				name=name1;
			}
			if(description=="") {
				description=description1;
			}
			if(img=="") {
				img=img1;
			}
			if(location=="") {
				location=location1;
			}
			if(contact=="") {
				contact=contact1;
			}
			 
			String sql1 = "UPDATE guide SET Name = '"+name+"', `Description` = '"+description+"', `Image` = '"+img+"', `Location` = '"+location+"',Contact='"+contact+"' WHERE (`GuideId` = '"+id+"'); ";
			
			int rs = stmt.executeUpdate(sql1);
			
			if (rs>0) {
				isSuccess=true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return isSuccess;
		
	}
	
	
	//delete data

public static boolean deleteguide(String id ) {
		
			boolean isSuccess=false;
			
			try {
				
				conn = DBConnect.getConnection();
				stmt = conn.createStatement();
				String sql = "delete from guide where GuideId="+id;
				int rs = stmt.executeUpdate(sql);
				
				if (rs>0) {
					isSuccess=true;
				} 
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return isSuccess;
		
	}
	
	//show data

public static List <guide> Show() {

ArrayList <guide> plsa = new ArrayList<guide>();

try {

	conn = DBConnect.getConnection();
	stmt = conn.createStatement();
	String sql = "select * from guides ";
	rs = stmt.executeQuery(sql);

	while (rs.next()) {
		String Id = rs.getString(1);
		String name = rs.getString(2);
		String description = rs.getString(5);
		String img = rs.getString(6);
		String location = rs.getString(3);
		String contact = rs.getString(4);

		guide pl=new guide(Id,name,img,description,location,contact);
		
		plsa.add(pl);
	
		//pl.displa();
	}
	
	
//	System.out.println(plsa);

} catch (Exception e) {

}

return plsa;
}
	
	
}
