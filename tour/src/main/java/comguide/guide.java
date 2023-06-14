package comguide;

public class guide {
	private String Id;
	private String name;
	private String img;
	private  String description;
	private String location;
	private String contact;
	public guide(String id, String name, String img, String description, String location, String contact) {
		super();
		Id = id;
		this.name = name;
		this.img = img;
		this.description = description;
		this.location = location;
		this.contact = contact;
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
	public String getContact() {
		return contact;
	}
	
	
}
