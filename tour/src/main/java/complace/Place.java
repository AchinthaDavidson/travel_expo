package complace;





public class Place  {
	private String Id;
	private String name;
	private String img;
	private  String description;
	private String location;
	
	public Place(String id, String name, String img, String description,String location) {
	
		this.Id = id;
		this.name = name;
		this.img = img;
		this.description = description;
		this.location=location;
	}

	public String getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public String getImg() {
		return img;
	}

	public String getDescription() {
		return description;
	} 
	public String getLocation() {
		return location;
	} 
	public void displa() {
		System.out.println(Id + name + img);
	}
	
}
		
				
	

