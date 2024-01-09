package vo;

public class PersonVO {
	private String name;
	private int age;

	public PersonVO() {
		System.out.println("--PersonVO의 생성자--");
	}
	public PersonVO(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("--PersonVO overloading 생성자--");
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("--setName() : " + name + "--");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
