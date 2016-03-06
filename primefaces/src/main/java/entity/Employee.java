package entity;

public class Employee {

	private Integer id;
	private String name;
	private Integer age;
	private String address;
	private float salary;	
	
	public Employee() {
		super();
	}

	public Employee(Integer id, String name, Integer age, String address, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
	}

// Getter	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public float getSalary() {
		return salary;
	}
	 
// Setter
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
}
