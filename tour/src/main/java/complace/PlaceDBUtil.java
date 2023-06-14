package complace;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaceDBUtil {
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	// add data 
	public static boolean insertPlace(String name,String description, String img,String location ) {
		
		boolean isSuccess=false;
		
		try {
			System.out.println(img);
			conn = DBConnect.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into place(Name,Description,Images,Location) values('"+name+"','"+description+"','"+img+"','"+location+"') ";
			int rs = stmt.executeUpdate(sql);
			System.out.println(sql);
			if (rs>0) {
				isSuccess=true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return isSuccess;
		
	}
	
//	update data
	
	public static boolean updatePlace(String id,String name,String description, String img,String location ) {
		
		boolean isSuccess=false;
		String name1 = null; 
		String description1= null;
		String img1= null;
		String location1= null;
		try {
			
			conn = DBConnect.getConnection();
			stmt = conn.createStatement();
			
			String sql ="select * from place where PlaceId="+id;
			rs= stmt.executeQuery(sql);
			
			if (rs.next()) {
				
				int Id =rs.getInt(1);
				 name1 =rs.getString(2);
				 description1 =rs.getString(3);
				 img1 =rs.getString(4);
				 location1 =rs.getString(5);
			
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
		}
			 System.out.println(name);
			String sql1 = "UPDATE place SET Name = '"+name+"', `Description` = '"+description+"', `Images` = '"+img+"', `Location` = '"+location+"' WHERE (`PlaceId` = '"+id+"'); ";
			
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

public static boolean deletePlace(String id ) {
		
			boolean isSuccess=false;
			
			try {
				
				conn = DBConnect.getConnection();
				stmt = conn.createStatement();
				String sql = "delete from place where PlaceId="+id;
				int rs = stmt.executeUpdate(sql);
				System.out.println(rs);
				if (rs>0) {
					isSuccess=true;
				} 
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return isSuccess;
		
	}
	
	//show data
	
	
public static List <Place> Show() {

	ArrayList <Place> plsa = new ArrayList<Place>();

	try {

		conn = DBConnect.getConnection();
		stmt = conn.createStatement();
		String sql = "select * from place ";
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			String Id = rs.getString(1);
			String name = rs.getString(2);
			String description = rs.getString(3);
			String img = rs.getString(4);
			String location = rs.getString(5);

			Place pl=new Place(Id,name,img,description,location);
			
			plsa.add(pl);
		
			//pl.displa();
		}
		
		
//		System.out.println(plsa);

	} catch (Exception e) {

	}

	return plsa;
}
	
	
	
}
