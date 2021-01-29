package dto;

public class HumanDto {
	String pAndb;
	String name;
	String age;
	String height;
	
	public HumanDto() {
		this( "", "", "", "");
	}
	
	public HumanDto(String pAndb, String name, String age, String height) {

		this.pAndb = pAndb;
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	
	public String getpAndb() {
		return pAndb;
	}

	public void setpAndb(String pAndb) {
		this.pAndb = pAndb;
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

	@Override
	public String toString() {
		return "HumanDto [number=" + pAndb + ", name=" + name + ", age=" + age + ", height=" + height + "]";
	}
	
	
}
