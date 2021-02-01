package dto;

public class HumanDto {
	String position;
	String name;
	String age;
	String height;
	
	public HumanDto() {
		this( "", "", "", "");
	}
	
	public HumanDto(String position, String name, String age, String height) {

		this.position = position;
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	
	public String getPosition() {
		return position;
	}

	public void setpAndb(String position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	
	public String alldata() {
		return "";
	}
	@Override
	public String toString() {
		return "HumanDto [number=" + position + ", name=" + name + ", age=" + age + ", height=" + height + "]";
	}
	
	
}
