package customer;

public class Customer {
	
	//variable
	private int id ;
	private String Name ;
	private String Email ;
	private String Phone ;
	private String password ;
	
	//consuctor
	public Customer(int id, String name, String email, String phone, String password) {

		this.id = id;
		this.Name = name;
		this.Email = email;
		this.Phone = phone;
		this.password = password;
	}
	
	public Customer(String email, String password) {
		super();
		Email = email;
		this.password = password;
	}

	public Customer() {
		
	}
	
	//getters
	public int getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public String getEmail() {
		return Email;
	}

	public String getPhone() {
		return Phone;
	}

	public String getPassword() {
		return password;
	}
	
}
