package customer;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.packagemanager.bean.OOP_Package;

import complace.DBConnect;


public class CustomerDButil {

	//variables
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stat = null;
	private static ResultSet rs = null;



	//get details from database to check
	public static List <Customer> getCustomer(String Email){

		ArrayList <Customer> Customer = new ArrayList<Customer>();

		try 

		{


			con = DBConnect.getConnection();
			stat = con.createStatement();
			String sql = "select * from customer where Email='"+Email+"'" ;
			rs = stat.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String pass = rs.getString(5);

				Customer cus = new Customer(id , name , email , phone , pass);
				Customer.add(cus);				
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return Customer ;
	}
	

	//  email validate and int return method------------------------------------------------------------------------------------------------

	public static  int validateEmailInt(String Email , String password) {

		int v_value = 0; 
		int rowCount = 0;


		String a1 = "Admin@guide.com" ;
		String a2 = "package@guide.com" ;
		String a3 = "hotel@guide.com" ;

		String p1 = "111" ;
		String p2 = "222" ;
		String p3 = "333" ;

		try {

			con = DBConnect.getConnection();

			stat = con.createStatement();
			String sql = "select * from customer where Email='"+Email+"' and Password='"+password+"'";

			rs = stat.executeQuery(sql);

			while(rs.next()) {

				rowCount +=1;
			//	System.out.println("this is row Count " + rowCount );

				String return_email = rs.getString("Email");
				String return_pass = rs.getString("Password");

				if((return_email.equals(a1))){

					v_value = 5;

					if(return_pass.equals(p1)) {

						v_value = 10;
					}


				}else if((return_email.equals(a2))){

					v_value = 5;

					if(return_pass.equals(p2)) {

						v_value = 10;
					}

				}else if((return_email.equals(a3))){

					v_value = 5;

					if(return_pass.equals(p3)) {

						v_value = 10;
					}

				}else if (rowCount == 1 && v_value == 0) {

					v_value = 5;
				}

			}


		}catch(Exception e){
			e.printStackTrace();
		}

		return v_value ;


	}


	//insert data to database-q
	public static boolean InsertCustomer(String name , String email , String phone , String password) {

		boolean isSuccess = false;

		try {
			con = DBConnect.getConnection();
			stat = con.createStatement();
			String sql = "Insert into customer values (0 , '"+name+"' , '"+email+"', '"+phone+"', '"+password+"')";
			int rs = stat.executeUpdate(sql);

			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return isSuccess ;
	}

	//update data in database
	public static boolean Updatecustomer(String id ,String name , String email , String phone , String password) {

		boolean isSuccess = false;

		try {
			con = DBConnect.getConnection();
			stat = con.createStatement();
			String sql = "update customer set Name='"+name+"',Email='"+email+"',Phone='"+phone+"',Password='"+password+"' "+" where CustomerId='"+id+"'";
			int rs = stat.executeUpdate(sql);

			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}

		}catch(Exception ve){
			ve.printStackTrace();
		}

		return isSuccess ;
	}

	//data display
	public static List <Customer> getCustomerDetails(int id){

		

		ArrayList<Customer> cusde = new ArrayList<Customer>();

		try {
			con = DBConnect.getConnection();
			stat = con.createStatement();
			String sql = "select * from customer where CustomerId='"+id+"'";
			rs = stat.executeQuery(sql);

			while(rs.next()) {
				int iD = rs.getInt(1);
				String Name = rs.getString(2);
				String Email = rs.getString(3);
				String Phone = rs.getString(4);
				String password = rs.getString(5);

				Customer c = new Customer(iD , Name , Email , Phone, password);
				cusde.add(c);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return cusde;
	}

	//delete data in database
	public static boolean Deletecustomer(int id) {


		try {
			con = DBConnect.getConnection();
			stat = con.createStatement();
			String sql = "delete from customer where CustomerId='"+id+"'";
			int rd = stat.executeUpdate(sql);

			if(rd > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	//display data
	public static List <Customer> displaycustomerdetails(String id ,String name , String email , String phone , String password){

		ArrayList<Customer> cusd = new ArrayList<Customer>();

		try {
			con = DBConnect.getConnection();
			stat = con.createStatement();
			String sql = "select * from customer ";
			rs = stat.executeQuery(sql);

			while(rs.next()) {
				int iD = rs.getInt(1);
				String Name = rs.getString(2);
				String Email = rs.getString(3);
				String Phone = rs.getString(4);
				String password1 = rs.getString(5);

				Customer c = new Customer(iD , Name , Email , Phone, password1);
				cusd.add(c);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return cusd;
	}

	public static List <Customer> dicustomerdetails(String email){

		ArrayList<Customer> cusd = new ArrayList<Customer>();

		try {
			con = DBConnect.getConnection();
			stat = con.createStatement();
			String sql = "select * from customer where Email='"+email+"'";
			rs = stat.executeQuery(sql);

			while(rs.next()) {
				int iD = rs.getInt(1);
				String Name = rs.getString(2);
				String Email = rs.getString(3);
				String Phone = rs.getString(4);
				String password1 = rs.getString(5);
				System.out.println();

				Customer c = new Customer(iD , Name , Email , Phone, password1);
				cusd.add(c);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return cusd;
	}

}
