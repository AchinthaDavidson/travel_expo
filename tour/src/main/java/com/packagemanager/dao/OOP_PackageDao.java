package com.packagemanager.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.packagemanager.bean.OOP_Package;

public class OOP_PackageDao {

	// sql credntiols--------------------------------------------------------------------------------------------------

	private String jdbcURL = "jdbc:mysql://localhost:3306/travel?allowPublicKeyRetrieval=true&useSSL=FALSE";
	private String jdbcUsername ="root";
	private String jdbcPassword = "1234";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";

	//sql quries--------------------------------------------------------------------------------------------------
	private static final String Insert_Package_SQL = "Insert into package" + "(name,locations,cost,ptype)  VALUES" + "(?,?,?,0);";
	//private static final String Select_All_SQL = "select * from package;";
	private static final String Select_Package_BY_ID_SQL = "select id,name,locations,cost,ptype from package where id=?;";
	private static final String Delete_Package_SQL = "delete from package where id=?;";
	private static final String Update_Package_SQL = "update package set name=?, locations=? where id=?;";
	private static final String Update_Package_Cost_SQL = "update package set cost = ? where cost = 0 and id like ?;";
	private static final String Get_Packge_Which_Created_BY_User = "select * from package p, cuspak cp where cp.pakid = p.id and cp.cusid like ? or p.ptype = 1 group by p.id;";
	private static final String Get_Customer_ID_From_DB = "select CustomerId from customer where Email= ? and Password= ?;";
	private static final String Get_Package_ID_From_Name = "select * from package where name like ? and locations like ?;";
	private static final String Insert_PakID_AND_CusID_TO_CusPak = "insert into cuspak values(?,?);";


	private static ResultSet rs = null;

	public String getJdbcURL() {
		return jdbcURL;
	}


	public String getJdbcUsername() {
		return jdbcUsername;
	}


	public String getJdbcPassword() {
		return jdbcPassword;
	}


	public String getJdbcDriver() {
		return jdbcDriver;
	}


	public OOP_PackageDao() {
		super();
	}



	//sql connection establishment methods --------------------------------------------------------------------------------------------------
	protected Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);

			//error handlin method
		}catch(SQLException exp){

			exp.printStackTrace();

		}catch (ClassNotFoundException exp){

			exp.printStackTrace();
		}

		return conn;
	}

	//get a package id according to its name from db  getPackageIDUsingName
	public  int GetCustomerID(String email,String password) throws SQLException {

		int cusID = 0;

		//get connection
		try(Connection conn = getConnection();

				//statement with connection object
				PreparedStatement preparedStatement = conn.prepareStatement(Get_Customer_ID_From_DB);){

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			//execute query
			ResultSet rs = preparedStatement.executeQuery();

			//process resultset obj
			rs.next() ;
			cusID = rs.getInt("CustomerId");


			//error handling	
		}catch(SQLException e) {

			printSQLException(e);
		}


		return cusID;
	}


	public int GetPackageID(String name, String locations) throws SQLException {
		
		 int packageID=0;

		//get connection
		try(Connection conn = getConnection();

				//statement with connection object
				PreparedStatement preparedStatement = conn.prepareStatement(Get_Package_ID_From_Name);){

			System.out.println("1");
			preparedStatement.setString(1, name );
			preparedStatement.setString(2, locations);

			System.out.println("2");
			//execute query
			ResultSet rs = preparedStatement.executeQuery();

			//process resultset obj
			System.out.println("3");
			System.out.println(preparedStatement);
			while(rs.next()) {
				
				packageID = rs.getInt("id");
				
			}


			//error handling	
		}catch(SQLException e) {

			printSQLException(e);
		}


		return packageID;
	}

	// method to update package customer table
	public void updateCusPakTable(int cusid,int pakid)throws SQLException {



		if (cusid >= 0 && pakid >= 0) {

			try(Connection conn2 = getConnection();
					PreparedStatement preparedStatement = conn2.prepareStatement(Insert_PakID_AND_CusID_TO_CusPak);){

				preparedStatement.setInt(1,cusid);
				preparedStatement.setInt(2,pakid);

				//execute query
				preparedStatement.executeUpdate();

				System.out.println(preparedStatement);

			}
			catch(SQLException exp) {

				printSQLException(exp);


			}
		}

	}

	// new packge insert method 2 ----------------------------------------------------------------------------

	public int insertPackageMethod2(OOP_Package pkg,String name,String locations) throws SQLException {
		
		int packageID =  0;

		try(Connection conn = getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(Insert_Package_SQL)){
			preparedStatement.setString(1, pkg.getName());
			preparedStatement.setString(2, pkg.getLocations());
			preparedStatement.setInt(3, pkg.getCost());
	
			preparedStatement.executeUpdate();

			int cost = pkg.getCost();
			String anythingS = "%";

			if (cost == 0) {

				List<String> locationsList = Arrays.asList(pkg.getLocations().split(","));
				int numOfLocs = locationsList.size();
				cost = cost + numOfLocs * 500;

				try(Connection conn1 = getConnection();

						PreparedStatement preparedStatement1 = conn.prepareStatement(Update_Package_Cost_SQL)){
					preparedStatement1.setInt(1, cost );
					preparedStatement1.setString(2, anythingS );
					preparedStatement1.executeUpdate();
				}
				
				
				try(Connection conn1 = getConnection();

						//statement with connection object
						PreparedStatement preparedStatement1 = conn1.prepareStatement(Get_Package_ID_From_Name);){

					preparedStatement1.setString(1, name );
					preparedStatement1.setString(2, locations);

				
					//execute query
					ResultSet rs = preparedStatement1.executeQuery();

					//process resultset obj
					
					while(rs.next()) {
						
						packageID = rs.getInt("id");
						
					}
					
				}
				

			}
				
				
			//error handling			
		}catch(SQLException exp) {

			printSQLException(exp);

		}

		return packageID;
	}


// ultimate method to list packages and assign cost ---------------------------------------------------

	public List<OOP_Package> selectAllPackagesAccordingToCustomerWithCostUpdater(String Email,String Password){

		int cusID = 0;
		
		List<OOP_Package> pkg = new ArrayList<>();
		//get connection

		try(Connection conn = getConnection();

				//statement with connection object
				PreparedStatement preparedStatement = conn.prepareStatement(Get_Customer_ID_From_DB);){

			preparedStatement.setString(1, Email);
			preparedStatement.setString(2, Password);

			System.out.println("package dao prpstat " + preparedStatement);
			
			//execute query
			ResultSet rs = preparedStatement.executeQuery();

			//process resultset obj
			rs.next() ;
			cusID = rs.getInt("CustomerId");

			if (cusID > 0) {

				try(Connection conn1 = getConnection();

						//statement with connection object
						PreparedStatement preparedStatement1 = conn1.prepareStatement(Get_Packge_Which_Created_BY_User);){
				
						preparedStatement1.setInt(1,cusID);
						
						System.out.println("package dao prpstat 1  " + preparedStatement1);
					
					//execute query
						ResultSet rs1 = preparedStatement1.executeQuery();

					//process resultset obj
					while(rs1.next()) {

						int id = rs1.getInt("id");
						String name = rs1.getString("name");
						String locations  = rs1.getString("locations");
						int cost = rs1.getInt("cost");
						int ptype = rs1.getInt("ptype");
						int cusid = rs1.getInt("cusid");
						int pakid = rs1.getInt("pakid");
						pkg.add(new OOP_Package(id,name,locations,cost,ptype));	
						
						
						
						//SUB METHOD TO GET CAL AND INSERT COST TO PACKAGE TABLE
						if (cost == 0) {

							List<String> locationsList = Arrays.asList(locations.split(","));
							int numOfLocs = locationsList.size();
							cost = cost + numOfLocs * 500;

							PreparedStatement preparedStatement2 = conn1.prepareStatement(Update_Package_Cost_SQL);

							System.out.println("package dao prpstat 2 " + preparedStatement2);

							preparedStatement1.setInt(1, cost );
							preparedStatement1.setInt(2, pakid );			
							preparedStatement1.executeUpdate();
							
							}

						}

					}

				}	
						
			//error handling	
		}catch(SQLException e) {

			printSQLException(e);
		}

		return pkg;
	}





	// select packges which created by customer grp by vuster

	public List<OOP_Package> selectAllPackagesAccordingToCustomer(String Email,String Password){

		int cusID = 0;

		List<OOP_Package> pkg = new ArrayList<>();
		//get connection

		try(Connection conn = getConnection();

				//statement with connection object
				PreparedStatement preparedStatement = conn.prepareStatement(Get_Customer_ID_From_DB);){

			preparedStatement.setString(1, Email);
			preparedStatement.setString(2, Password);

			//execute query
			ResultSet rs = preparedStatement.executeQuery();

			//process resultset obj
			rs.next() ;
			cusID = rs.getInt("CustomerId");

			if (cusID > 0) {

				try(Connection conn1 = getConnection();

						//statement with connection object
						PreparedStatement preparedStatement1 = conn1.prepareStatement(Get_Packge_Which_Created_BY_User);){
				
						preparedStatement1.setInt(1,cusID);
					
					//execute query
						ResultSet rs1 = preparedStatement1.executeQuery();

					//process resultset obj
					while(rs1.next()) {

						int id = rs1.getInt("id");
						String name = rs1.getString("name");
						String locations  = rs1.getString("locations");
						int cost = rs1.getInt("cost");
						int ptype = rs1.getInt("ptype");
						int cusid = rs1.getInt("cusid");
						int pakid = rs1.getInt("pakid");
						
						System.out.println("This is cusid in linbe 313 "+ cusid);
						
						if (cusid == cusID) {
							
							pkg.add(new OOP_Package(id,name,locations,cost,ptype));	

						}

					}


				}	}			
			//error handling	
		}catch(SQLException e) {

			printSQLException(e);
		}

		return pkg;
	}




	//cost updater method when listing and inserting-----------------------------------------------------------------------------------------------
	public List<OOP_Package> costUpdater(int customerID){

		List<OOP_Package> pkg = new ArrayList<>();
		//get connection
		try(Connection conn = getConnection();

				//statement with connection object
				PreparedStatement preparedStatement = conn.prepareStatement(Get_Packge_Which_Created_BY_User);){
				preparedStatement.setInt(1, customerID);
			//execute query
			ResultSet rs = preparedStatement.executeQuery();

			//process resultset obj
			while(rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				String locations  = rs.getString("locations");
				int cost = rs.getInt("cost");
				int ptype = rs.getInt("ptype");

				pkg.add(new OOP_Package(id,name,locations,cost,ptype));	

				String anythingS = "%";


				//SUB METHOD TO GET CAL AND INSERT COST TO PACKAGE TABLE
				if (cost == 0) {

					List<String> locationsList = Arrays.asList(locations.split(","));
					int numOfLocs = locationsList.size();
					cost = cost + numOfLocs * 500;

					try(Connection conn1 = getConnection();

							PreparedStatement preparedStatement1 = conn.prepareStatement(Update_Package_Cost_SQL)){
						preparedStatement1.setInt(1, cost );
						preparedStatement1.setString(2, anythingS );
						preparedStatement1.executeUpdate();
					}

				}

			}

			//error handling	
		}catch(SQLException e) {

			printSQLException(e);
		}

		return pkg;
	}



	//update user method -------------------------------------------------------------------------------------------------

	public boolean updatePackage(OOP_Package pkg){

		boolean rowUpdtd = false;

		//update package set name=?, locations=? where id=?;
		//connection
		try(Connection conn = getConnection();
				//statement with conn object
				PreparedStatement statementDone = conn.prepareStatement(Update_Package_SQL);){

		
			
			//set statement
			statementDone.setString(1, pkg.getName());
			statementDone.setString(2, pkg.getLocations());
			statementDone.setInt(3, pkg.getId());

			
			System.out.println("This is update statement " + statementDone);
			//getting boolean output
			rowUpdtd  = statementDone.executeUpdate() > 0;

			//error handling	
		}catch(SQLException e) {

			printSQLException(e);
		}

		return rowUpdtd ;
	}


	//delete user method--------------------------------------------------------------------------------------------------

	public boolean deletePackage(int id) throws SQLException{

		boolean rowDeleted = false;

		//connetion n stst obj
		try(Connection conn = getConnection();
				PreparedStatement statt = conn.prepareStatement(Delete_Package_SQL);){

			//execute usts and get boolean result
			statt.setInt(1, id);
			rowDeleted = statt.executeUpdate() > 0;

		}

		return rowDeleted;

	}

	//select package by id method --------------------------------------------------------------------------------------------------

	public OOP_Package selectPackage(int id) {

		OOP_Package pkg = null;

		//get connection
		try (Connection conn = getConnection();
				//statement with connection object
				PreparedStatement preparedStatement = conn.prepareStatement(Select_Package_BY_ID_SQL);){

			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);

			//execute query
			ResultSet rs = preparedStatement.executeQuery();

			//process result set objs
			while(rs.next()) {
				
								
				int id1 = rs.getInt("id");
				
				String name = rs.getString("name");
			
				
				String locations  = rs.getString("locations");
				

				pkg = new OOP_Package(id1,name,locations);
				
			

			}

			//error handling				
		}catch(SQLException e) {

			printSQLException(e);
		}

		System.out.println(pkg.getId() + pkg.getName() + pkg.getLocations());
		
		return pkg;		
	}


	//SQL Exception print methods--------------------------------------------------------------------------------------------------

	private void printSQLException(SQLException ex) {
		for(Throwable e: ex) {
			if(e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQL State : " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message   : " + ((SQLException) e).getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause : "+t);
					t = t.getCause();					
				}
			}
		}
	}



	
	
}

