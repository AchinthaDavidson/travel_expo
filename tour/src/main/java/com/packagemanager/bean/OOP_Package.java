package com.packagemanager.bean;

public class OOP_Package {
	
	private int id;
	private String name;
	private String locations;
	private int cost;
	private int ptype;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocations() {
		return locations;
	}
	public void setLocations(String locations) {
		this.locations = locations;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getPtype() {
		return ptype;
	}
	public void setPtype(int ptype) {
		this.ptype = ptype;
	}
	public OOP_Package(int id, String name, String locations, int cost, int ptype) {
		super();
		this.id = id;
		this.name = name;
		this.locations = locations;
		this.cost = cost;
		this.ptype = ptype;
	}
	public OOP_Package(String name, String locations, int cost, int ptype) {
		super();
		this.name = name;
		this.locations = locations;
		this.cost = cost;
		this.ptype = ptype;
	}
	public OOP_Package(String name, String locations, int cost) {
		super();
		this.name = name;
		this.locations = locations;
		this.cost = cost;
	}
	public OOP_Package(String name, String locations) {
		super();
		this.name = name;
		this.locations = locations;
	}
	public OOP_Package(int id, String name, String locations) {
		super();
		this.id = id;
		this.name = name;
		this.locations = locations;
	}
	
	public void detailsPrinter() {
		
		System.out.println("This is details printer in Package Class");
		System.out.println(this.id);
		System.out.println(this.name);
		System.out.println(this.locations);
		System.out.println(this.cost);
		System.out.println(this.ptype);
		
		System.out.println("End of details printer in Package Class");
		
		
	}


	
	
	

}
